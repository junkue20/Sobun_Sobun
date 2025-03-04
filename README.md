# 소분소분

![소분소분-프로젝트-썸네일](https://github.com/junkue20/Sobun_Sobun/assets/122848687/e8788cad-8e26-43ff-b78e-cad7e1279c58)



## 🤔 “휴지 한 팩을 필요한 만큼만 살 순 없을까?”

 시대가 빠른 속도로 변화해 간다면, 소비자들의 소비문화 또한 빠르게 변화하기 마련입니다. 1인가구의 수가 증가함에 따라 많은 사람들이 혼자서 의식주를 해결하는 경우의 빈도수가 크게 증가했습니다. 

 하지만 1인 가구의 형태는 개인의 생활 형태에 따라 다양한 양상을 띄지만, 대부분의 쇼핑몰에는 미리 정해둔 수량과 틀 내에서만 이루어지고 있는 상황입니다. 

 이러한 상황 속에서 ‘소비자 개인이 원하는 물품을 원하는 만큼만 다른 사람들과 함께 공동 구매를 할 수 있게 해주는 서비스를 만들면 어떨까’라는 생각으로부터 프로젝트를 기획하여 만들게 되었습니다.

<br/>

## 🔗 Link

- http://3.35.230.1:8080/SOBUN/main

모든 페이지는 각각 암호와 비밀번호를 미리 기재해두었습니다.
원할한 사용을 위해서 세부 정보는 변경하지 말아주세요!

<br/>

## 🧩 기획 및 설계

**📝 [요구사항 정의서](https://www.notion.so/7c37279d100c4c8199697986fbaaabaa?pvs=21)**

**🧩 [ERD 다이어그램](https://www.notion.so/c4a083ca0aa144ce8142c45dabf13be8?pvs=21)**

🖼️ [**Figma 설계**](https://www.figma.com/community/file/1249928907922611034)

<br/>
<br/>

![image](https://github.com/junkue20/Sobun_Sobun/assets/122848687/51601385-d1f2-4273-a122-2c2fdd0625ab)


<br/>
<br/>

## 👨‍💻 담당 파트

### 🖥️ **프론트엔드**
- **로그인**
- **비밀번호 찾기**
- **회원가입**
- **홈화면**
    - 처음 사용자용 가이드 모달
    - 판매실적 유무에 따른 통계 표시
- **마이페이지**
    - 판매자 정보수정
    - 비밀번호 변경
    
<br/>

### **⚙ 백엔드**
- **RestAPI  설계**
- **회원가입, 로그인, 비밀번호 찾기 및 유효성 검사 기능 구현**
- **Session 방식 유저 인증**
- **이메일 인증번호 및 임시비밀번호 전송 기능 구현**

<br/>

[🔧 프로젝트 수행 상세정보](https://www.notion.so/junkue20/b69e6d3211774bfb9e8a48f1fbde786f?pvs=4)

<br/>

## ✨ 문제 해결사례

 판매자의 경우 비밀번호를 찾을 수 있는 수단은 등록된 이메일로 임시 비밀번호를 발급하여 전송하는 방법으로 진행되게 됩니다. 따라서 **가입시에 이메일이 실제 유효한 이메일인지 확인하는 과정은 필수적**입니다.

 이러한 부분에 있어 회원가입시 인증 코드를 생성하여 입력된 이메일 주소로 보내는 기능을 추가했지만, **인증번호를 확인하는 기능을 동작시에 계속해서 인증번호가 일치하지 않는다는 오류가 발생**하였습니다.

이를 해결하고자 **`@Slf4j` 어노테이션을 활용**하여 java의 **UUID**클래스로 랜덤 생성한 임시코드와 더불어 인증코드를 확인하는 메소드에 들어오게 되는 입력 난수값을 서로 대조하며 확인해보았습니다.

그 결과, **인증코드를 생성하고 불러오는 과정에서 인증 코드의 양쪽에 “ ” 큰따옴표가 붙게 된다는 사실을 파악**할 수 있었고, 이를 토대로 기존 임시코드에서 임의로 큰따옴표를 양쪽에서 제거하여 인증코드 확인 이슈를 해결할 수 있었습니다.

<br/>
<br/>

## ✨ 만족스러웠던 부분


> **내 인생 첫 프로젝트, 소분소분**

 2월 초부터 기초적인 웹 개발에 대한 지식들을 배우기 시작하여 학습한 내용들을 바탕으로 일궈낸 첫 프로젝트입니다.  여러 미니 프로젝트들의 시행착오를 거쳐 프로젝트를 새로 만들기를 반복하여 마침내 만들게 된 저에게 있어 매우 의미있는 프로젝트였습니다. 

 최종 결과물을 도출하기 전까지 조원들과 서로 지향하는 목표가 다르다보니 의견이 대립하기도 하였고, 개발 및 조별 회의까지 바쁜 일정을 소화하며 만들다 보니 프로젝트를 제작하는 중간마다 크고 작은 마찰이 생기기 마련이었지만, 각자 이상적인 프로젝트를 만들기 위한 방법의 차이를 인정하며 의견의 조율과 피드백을 수용하고 논의하며 의견의 차이를 좁혀나갔고, 마침내 소분소분이라는 프로젝트를 완성할 수 있게 되었습니다.

 다른조와 비교했을때 규모가 조금 더 컸던 프로젝트였기에 ‘작업물의 퀄리티를 떠나서 과연 기간안에 완성할순 있을까?’ 라는 걱정도 앞섰지만, 제작간에 서로 어렵거나 진행이 막히는 부분에서는 함께 협력하며 도움을 주었고, 쿠팡과 같은 타 쇼핑몰 사이트들을 비교해가며 외형적으로나 기능적으로 부족했던 부분들을 차례대로 채워나갔습니다.

 비록 현업에 나가서는 지금보다도 더 큰 어려움에 직면할 수도 있겠지만, 조원들과 한마음 한뜻이 되어 무언가를 이루어 냈다는 뿌듯함으로 말미암아 앞으로 문제가 발생하더라도 자신있게 부딪히고 해결해 나갈 용기를 얻을 수 있었던 좋은 경험이었습니다.

 <br/>
 <br/>

 ## 💭 앞으로 개선이 필요한 부분


> **하나의 프로젝트, 세가지의 결과물**

- 구매자, 판매자, 관리자의 모든 기능들이 하나의 프로젝트 내에 포함되어 있다보니 Security 방식을 이용하는데 있어 세션이 일정시간 이후 비워지게 되면 `판매자 페이지 → 구매자 페이지`로 이동이 되는 이슈가 발생했습니다.
    - 추후 다중 기능이 요구되는 프로젝트를 수행할 경우 개별 프로젝트화 하여 각각의 Security를 사용함이 필요함을 느꼈습니다.

> **반응형 웹을 구현하자**
> 

- 이번 프로젝트는 반응형 웹 페이지를 구현하는데 있어 다소 부족함이 느껴졌습니다. 현재 대부분의 웹 페이지들이 반응형으로 만들어지는데 비하여 소분소분 프로젝트의 경우 데스크탑 PC의 사용자에 포커싱이 맞춰지다 보니 모바일 사용자에 대한 부분을 간과했습니다.

<br/>
<br/>

## 🚀 느낀점 & 배울 수 있었던 점

- 이번 프로젝트를 바탕으로 **내가 어떤 개발을 하고싶은지에 대해서 좀 더 진지한 고민을 해볼 수 있었던 좋은 기회**라고 생각하며, 사용자를 위한 여러 UI를 직접 피그마로 설계하고 제작하며 적용하는 단계에서 **프론트엔드 작업에도 흥미를 느끼는 제 스스로를 발견**할 수 있었습니다.

- 특히 유저의 직접적인 사용과 밀접한 로그인, 회원가입, 비밀번호, 마이페이지 등의 기능 및 UI들을 직접 제작해보며 ‘판매자 입장에서 필요 or 불필요한 기능인가’에 대한 많은 고민을 하였고, **실제 서비스를 제공중인 쿠팡, G마켓, 11번가와 같은 판매 페이지들을 참고**, 아이디어를 얻어 이메일 인증기능의 추가와 더불어, 로그인 시 CapsLock의 상태 유무를 알려주는 기능과 같이 **세부적인 부분들에 대해서 디테일을 추가할 수 있었습니다**.

- 또한 개발자의 입장에서는 무심결에 넘어갈 수도 있는 부분들을 **주변 지인들과 강사님, 다른 팀원들에게 테스트를 부탁**하여 사용자의 입장에서 발생할 수 있는 문제점의 **피드백을 적극 수용**하였으며, 리팩토링 과정에서 차단 계정에 대한 유효성 검사 기능과 더불어, 페이지 UI 및 색감의 통일, 그리고 판매자 메인페이지 UI에 판매 물품 유무에 따른 통계 자료 표시 기능을 새롭게 추가하여 조금 더 **사용자 친화적인 페이지를 구현하였습니다.**

- 아울러 팀원들과 협력하여 정해진 기간의 압박 속에서도 서로 협력하고 소통하며 무사히 프로젝트를 완수하는 과정에서 Notion과 Github브랜치 기능을 적극적으로 활용하여 각자 수행한 부분들을 병합하는 과정에서 발생할 수 있는 여러가지 충돌 오류들을 배제할 수 있었으며, 마무리 단계에서는 회원가입 기능부터 물품 판매 후 판매 내역 조회 기능까지 오류없이 정상적으로 기능함을 확인하는 과정에 이르기까지 협동심과 커뮤니케이션 능력을 기를 수 있었던 좋은 경험이었습니다.
