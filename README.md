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
```java
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetBtn = (JButton) e.getSource();

		if (changeDeliveryMapBtn == targetBtn) {
			System.out.println("신속배달");
			setContentPane(deliveryMapImg);
			deliveryMapImg.add(player);
			deliveryMapImg.updateUI();

			deliveryMapImg.add(totalSalesLabel);
			deliveryMapImg.add(goalSalesLabel);
			deliveryMapImg.add(deliveryAddressLabel);

			player.backgroundDeliveryService.deliveryServiceOn = true;
			player.backgroundKitchenService.kitchenServiceOn = false;
			new Thread(player.backgroundDeliveryService).start();

		} else if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenMapImg);
			kitchenMapImg.add(player);
			kitchenMapImg.updateUI();

			kitchenMapImg.add(totalSalesLabel);
			kitchenMapImg.add(goalSalesLabel);
			kitchenMapImg.add(deliveryAddressLabel);

			player.backgroundKitchenService.kitchenServiceOn = true;
			player.backgroundDeliveryService.deliveryServiceOn = false;
			new Thread(player.backgroundKitchenService).start();

		} else if (startBtn == targetBtn) {
			setContentPane(kitchenMapImg);
		} else {
			System.out.println("버튼 오류");
		}

		setVisible(true);
		this.requestFocusInWindow();

	}

```
#### BackgroundKitchenMapFrame

#### BackgroundDeliveryMapFrame

#### Chicken
 
#### Sales
 
 
 
