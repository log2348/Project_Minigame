## 치킨 배달 게임 프로젝트


제작 기간은 1주이며 총 3명이 합작하여 만들었습니다.

### 게임설명

 플레이어가 치킨집을 운영하며 직접 치킨을 조리하여 배달까지 하는 치킨집 경영 게임입니다.
 
 
 ### 주요 클래스 설명
 - [Player](#player)
 - [Moveable](#moveable)
 - [BackgroundMapFrame](#backgroundmapframe)
 - [BackgroundKitchenMapFrame](#backgroundkitchenmapframe)
 - [BackgroundDeliveryMapFrame](#backgrounddeliverymapframe)
 - [Chicken](#chicken)
 - [Sales](#sales)



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

```java
public interface Moveable {
	void left();
	void right();
	
	default public void up() {};
	default public void down() {};
	
	default public void jumpUpInKit() {};
	default public void jumpDownInKit() {};
	
	default public void jumpUpInDel() {};
	default public void jumpDownInDel() {};
}
```

#### BackgroundMapFrame
- 게임이 실행되는 틀, JFrame 상속
- 키 이벤트 발생시 플레이어 동작 메소드 호출

#### BackgroundKitchenMapFrame
- 주방 맵에서 플레이어와 외벽, 바닥과의 충돌 검사하는 코드 작성

#### BackgroundDeliveryMapFrame
- 배달 맵에서 플레이어와 외벽, 바닥과의 충돌 검사하는 코드 작성

#### Chicken
 
#### Sales
 
 
