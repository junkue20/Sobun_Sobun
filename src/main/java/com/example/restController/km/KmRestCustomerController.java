package com.example.restController.km;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerUser;
import com.example.dto.Purchase;
import com.example.dto.PurchaseOrder;
import com.example.dto.PurchaseStatus;
import com.example.service.km.KmCustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/api/customer")
@RequiredArgsConstructor
public class KmRestCustomerController {
    
    // 나중에 service 연결해주기
    // final KmCustomerMapper mapper;
    final KmCustomerService customerService;

    // 결제(찐) 성공하면 오는 컨트롤러
        // 여기서 공구 번호를 확인해서  (번호=0 => 공구 개설, 번호!=0 => 공구 참여)
        // 공구 참여면 주문, 공구현황만 추가해주고,
        // 공구 개설이면 공구, 주문, 공구현황 3개 추가 
        // 물품 수량도 -1해주기
    @PostMapping(value="/order.json")
    public Map<String, Object> insertPurchasePOST(@RequestBody PurchaseOrder purchaseOrder, 
                                            @AuthenticationPrincipal CustomerUser user) {
        
        Map<String, Object> retMap = new HashMap<>();
        
        try {
            log.info("rest 확인 => {}", purchaseOrder.toString());
            // PurchaseOrder(no=se4517, memId=null, purchaseNo=0, regdate=null, 
            //             totalPrice=30599, participant=3, storageNo=4, itemNo=11)

            long purchaseNo = purchaseOrder.getPurchaseNo();
            int ret1 = 0;

            // 공구 개설하기 (purchaseOrder.getPurchaseNo == 0) 
            if(purchaseNo == 0) {
                
                // 1. SEQ_PURCHASE_NO.NEXTVAL 가져오기
                purchaseNo = customerService.selectSeqPurchaseNo();
                log.info("rest에서 공구 개설 시 purchaseNo 확인 => {}", purchaseNo);

                // 2. purchase 데이터 추가
                    // no(1에서 가져온 값 넣어줌), participant, storageNo
                Purchase purchase = new Purchase();
                purchase.setNo(purchaseNo);
                purchase.setParticipant(purchaseOrder.getParticipant());
                purchase.setStorageNo(purchaseOrder.getStorageNo());

                log.info("rest에서 공구 개설 시 purchase 확인 => {}", purchase.toString());

                ret1 = customerService.insertOnePurchase(purchase);      

            }      

            // 여기부터는 개설, 참여 공통 부분

            // 3. purchaseOrder 데이터 추가
                // no, memId, totalPrice, purchaseNo(1에서 가져온 값 넣어줌)
            purchaseOrder.setMemId(user.getUsername());
            purchaseOrder.setPurchaseNo(purchaseNo);            
            int ret2= customerService.insertOnePurchaseOrder(purchaseOrder);

            // 4. purchaseStatus 데이터 추가
                // memId, itemNo, purchaseNo(1에서 가져온 값 넣어줌)
            PurchaseStatus purchaseStatus = new PurchaseStatus();
            purchaseStatus.setMemId(user.getUsername());
            purchaseStatus.setItemNo(purchaseOrder.getItemNo());
            purchaseStatus.setPurchaseNo(purchaseNo);
            int ret3 = customerService.insertOnePurchaseStatus(purchaseStatus);

            if(purchaseOrder.getPurchaseNo() == 0) { // 공구 개설
                log.info("공구개설 ret 확인 => {} {} {}",ret1, ret2, ret3);
            } else { // 공구 참여
                log.info("공구참여 ret 확인 => {} {}", ret2, ret3);
            }

              
            
            // 공구의 참여 인원 다 찼는지 체크 해주기
            int remaingPerson = customerService.countRemainingPerson(purchaseNo);
            log.info("rest remainingPerson => {}", remaingPerson);

            int ret4 = 0;
            int ret5 = 0;
            if ( remaingPerson == 0 ) {
                // 공구 참여중인 회원ID 목록 다 불러오기
                List<String> idList =  customerService.selectIdList(purchaseNo);
                log.info("rest idList => {}", idList.toString());

                // 공구 현황 일괄 insert
                List<PurchaseStatus> statusInsertList = new ArrayList<>();
                for(int i=0; i<idList.size(); i++) {
                    PurchaseStatus obj = new PurchaseStatus();
                    obj.setMemId(idList.get(i));
                    obj.setPurchaseNo(purchaseNo);
                    obj.setItemNo(purchaseOrder.getItemNo());
                    statusInsertList.add(obj);
                }
                ret4 = customerService.PurchaseStatusInsertBatch(statusInsertList);
                log.info("rest로 일괄 추가해야할 statusInsertList 확인하기 => {}", statusInsertList.toString());

                // item의 수량 -1 해주기
                ret5 = customerService.updateItemQuantity(purchaseOrder.getItemNo());
            }

            
            log.info("rest로 확인하기 => {}, {}", ret4, ret5);

            if( purchaseNo == 0 ) {
                if (ret1 == 1 && ret2 == 1 && ret3 == 1) {
                    retMap.put("result", 200);
                }
            } else if( purchaseNo != 0 ) {
                if (ret2 == 1 && ret3 == 1) {
                    if(remaingPerson != 0) {
                        retMap.put("result", 200);
                    } else {
                        if(ret4 > 0 && ret5 == 1) {
                            retMap.put("result", 200);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            retMap.put("result", -1);
        }
        return retMap;
    }
    
}
