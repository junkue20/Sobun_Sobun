package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TotalgenderView;

@Repository
public interface TotalgenderViewRepository extends JpaRepository<TotalgenderView, String>{
    
    // 성별인원수 구하기
    long countByGender(String gender);

    // 사업자등록번호에 맞는 성별 인원수 구하기
    long countByGenderAndNo(String gender, String no);
}
