## 치킨 배달 게임 프로젝트


제작 기간은 1주 정도이며 총 3명이 합작하여 만들었습니다.

#### 게임설명

 플레이어가 치킨집을 운영하며 직접 치킨을 조리하여 배달까지 하는 치킨집 경영 게임입니다.
 
 
 #### 주요 클래스 설명
 - Player
 - Moveable
 - BackgroundMapFrame
 - BackgroundKitchenMapFrame
 - BackgroundDeliveryMapFrame
 - Chicken
 - Sales



#### Player
- 사용자가 조작하는 플레이어
- JLabel 클래스 상속, Moveable 인터페이스 구현하여 플레이어 동작 정의
- 상, 하, 좌, 우로 이동할 수 있는 메소드 존재, 스레드 사용

```java
@Override
public void left() {
	System.out.println("left");
	playerWay = PlayerWay.LEFT;
	left = true;
	new Thread(new Runnable() {
		@Override
		public void run() {
			while (left) {
				setIcon(playerIconL);

				x -= SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}).start();
}
```


#### Moveable

#### BackgroundMapFrame

#### BackgroundKitchenMapFrame

#### Chicken
 
#### Sales
 
 
 
