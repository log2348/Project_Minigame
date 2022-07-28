## :meat_on_bone: 치킨 배달 게임 프로젝트 :meat_on_bone:

제작 기간은 1주이며 총 3명이 합작하여 만들었습니다.

</br>

### 게임설명

 플레이어가 치킨집을 운영하며 직접 치킨을 조리하여 배달까지 하는 치킨집 경영 게임입니다.
 
 </br>
 
- 시작 화면
<img src="https://user-images.githubusercontent.com/96460131/181437203-8edc24bb-748a-4bc9-86d3-3df57c289118.png" width=60% height=60%/>

 </br>

- 주방 맵
  - 조리 순서에 맞게 조작해야 하며 순서를 지키지 않을시 치킨 아이콘이 생성되지 않습니다.

![ezgif com-gif-maker (4)](https://user-images.githubusercontent.com/96460131/181437428-1ee7ea10-a2d5-4b0e-81bc-e0c56afc7bea.gif)

 </br>

- 배달 맵
  - 게임 시작시 목표 매출과 배달할 집이 랜덤하게 주어지며, 목표 매출 달성시 게임이 종료됩니다.
  
![ezgif com-gif-maker (7)](https://user-images.githubusercontent.com/96460131/181437353-eb0abce8-fb48-48a6-884e-366fe66c331c.gif)

  </br>

### 주요 클래스 설명
 - [Player](#player)
 - [Moveable](#moveable)
 - [BackgroundMapFrame](#backgroundmapframe)
 - [BackgroundKitchenMapFrame](#backgroundkitchenmapframe)
 - [BackgroundDeliveryMapFrame](#backgrounddeliverymapframe)
 - [Chicken](#chicken)
 - [Sales](#sales)


### Player
- 사용자가 조작하는 플레이어
- JLabel 클래스, Moveable 인터페이스 구현하여 플레이어 동작 정의
- 상, 하, 좌, 우로 이동할 수 있는 메소드 존재, Thread 사용


### Moveable
- 플레이어와 치킨의 동작 정의를 위한 인터페이스


### BackgroundMapFrame
- JFrame 클래스, 게임이 실행되는 틀
- 키 이벤트 발생시 플레이어 동작 메소드 호출, 방향키로 동작하는 플레이어
- 버튼 클릭 이벤트로 맵 이동 


### BackgroundKitchenMapFrame
- 주방 맵에서 플레이어와 외벽, 바닥과의 충돌 검사하는 코드 작성


### BackgroundDeliveryMapFrame
- 배달 맵에서 플레이어와 외벽, 바닥과의 충돌 검사하는 코드 작성


### Chicken
 - JLabel 클래스, 치킨의 조리 단계에 따라 다른 치킨 이미지
 - Thread 사용하여 별도의 조작없이 정해진 위치에서 움직이는 이미지 구현
 
 
### Sales
 - JLabel 클래스, 게임이 시작하고 배달을 완료함에 따라 올라가는 매출
 - 목표 매출 달성시 매출 리셋됨
 
