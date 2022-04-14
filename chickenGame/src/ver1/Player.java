package ver1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel implements Moveable {

	// �쐞移섏긽�깭
	private int x;
	private int y;

	// �뵆�젅�씠�뼱�쓽 諛⑺뼢
	private PlayerWay playerWay;

	// ��吏곸엫 �긽�깭
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean jumpUp;
	private boolean jumpDown;

	// �뵆�젅�씠�뼱 �냽�룄 �긽�깭
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// 踰쎌뿉 異⑸룎�븳 �긽�깭
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// �씠誘몄� ���옣
	private ImageIcon kitPlayerF; // �궎移쒖뿉�꽌�쓽 �븵紐⑥뒿
	// �씪�떒 �뮘(Top)�쑝濡� 媛덈븧 �뮮硫대쭚怨� left/right紐⑥뒿�쑝濡� 媛�湲곕줈
	private ImageIcon kitPlayerL; // �궎移쒖뿉�꽌�쓽 �쇊履쎈え�뒿
	private ImageIcon kitPlayerR; // �궎移쒖뿉�꽌�쓽 �삤瑜몄そ紐⑥뒿

	private ImageIcon delPlayerL; // 諛곕떖留듭뿉�꽌�쓽 �쇊履쎈え�뒿
	private ImageIcon delPlayerR;// 諛곕떖留듭뿉�꽌�쓽 �삤瑜몄そ紐⑥뒿
	// 諛곕떖留듭뿉�꽌�뒗 �븵紐⑥뒿�뮮紐⑥뒿 �몮 �떎 �뾾�쓬

	// TODO �굹以묒뿉 媛앹껜�옉 �긽�샇�옉�슜�빐二쇰뒗 遺�遺� 援ы쁽�븘�슂�븷 �벏
	// �삁瑜쇰뱾�뼱 踰쎌뿉 異⑸룎�븳 �긽�깭

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}

	private void initObject() {
		
		
//		 Istead of Image img=new ImageIcon(this.getClass().getResource("/a1.png")).getImage();
//		 label_1.setIcon(new ImageIcon(img));
//		 
//		 why not label_1.setIcon(new ImageIcon(this.getClass().getResource("/a1.png"));
		
//		this.setIcon(delPlayerR);
//		
		kitPlayerF = new ImageIcon("images/LoopyKit_front.png");
		kitPlayerL = new ImageIcon("images/LoopyKit_left.png");
		kitPlayerR = new ImageIcon("images/LoopyKit_right.png");

		delPlayerL = new ImageIcon("images/LoopyDel_left.png");
		delPlayerR = new ImageIcon("images/LoopyKit_right.png");

	}

	private void initSetting() {
		x = 472;
		y = 300;

		left = false;
		right = false;
		up = false;
		down = false;
		jumpUp = false;
		jumpDown = false;

		leftWallCrash = false;
		rightWallCrash = false;

		playerWay = PlayerWay.RIGHT;
		setIcon(kitPlayerF);
		setSize(55, 80); // �궗�씠利� �넻�씪
		setLocation(x, y);
//		setBackground(new Color(0, 0, 0, 122));
//		setVisible(true);

	}

	private void initBackgroundPlayerService() {
		new Thread(new BackgroundMapServiceFrame(this)).start();
	}

	@Override
	public void left() {
		System.out.println("left");
		playerWay = PlayerWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					setIcon(kitPlayerL);
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println("right");
		playerWay = playerWay.RIGHT;
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (right) {
					setIcon(kitPlayerR);
					x = x + SPEED;
					setLocation(x, y);

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (up) {
					y = y - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					setIcon(kitPlayerF);
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}).start();

	}

	@Override
	public void jumpUp() {
		System.out.println("jumpUp");
		jumpUp = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 120 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				jumpUp = false;
				jumpDown();

			}
		}).start();

	}

	@Override
	public void jumpDown() {
		System.out.println("jumpDown");
		jumpDown = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (jumpDown) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				jumpDown = false;
			}
		}).start();

	}


} // end of class




////�냼�떞諛깆뾽肄붾뱶
//package chickenGame;
//
//import java.awt.Color;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//import lombok.Data;
//
//@Data
//public class Player_s extends JLabel implements Moveable_s {
//
//	// �쐞移섏긽�깭
//	private int x;
//	private int y;
//
//	// �뵆�젅�씠�뼱�쓽 諛⑺뼢
//	private PlayerWay_s playerWay;
//
//	// ��吏곸엫 �긽�깭
//	private boolean left;
//	private boolean right;
//	private boolean up;
//	private boolean down;
//	private boolean jumpUp;
//	private boolean jumpDown;
//
//	// �뵆�젅�씠�뼱 �냽�룄 �긽�깭
//	private final int SPEED = 4;
//	private final int JUMPSPEED = 2;
//
//	// 踰쎌뿉 異⑸룎�븳 �긽�깭
//	private boolean leftWallCrash;
//	private boolean rightWallCrash;
//
//	// �씠誘몄� ���옣
//	private ImageIcon kitPlayerF; // �궎移쒖뿉�꽌�쓽 �븵紐⑥뒿
//	// �씪�떒 �뮘(Top)�쑝濡� 媛덈븧 �뮮硫대쭚怨� left/right紐⑥뒿�쑝濡� 媛�湲곕줈
//	private ImageIcon kitPlayerL; // �궎移쒖뿉�꽌�쓽 �쇊履쎈え�뒿
//	private ImageIcon kitPlayerR; // �궎移쒖뿉�꽌�쓽 �삤瑜몄そ紐⑥뒿
//
//	private ImageIcon delPlayerL; // 諛곕떖留듭뿉�꽌�쓽 �쇊履쎈え�뒿
//	private ImageIcon delPlayerR;// 諛곕떖留듭뿉�꽌�쓽 �삤瑜몄そ紐⑥뒿
//	// 諛곕떖留듭뿉�꽌�뒗 �븵紐⑥뒿�뮮紐⑥뒿 �몮 �떎 �뾾�쓬
//
//	// TODO �굹以묒뿉 媛앹껜�옉 �긽�샇�옉�슜�빐二쇰뒗 遺�遺� 援ы쁽�븘�슂�븷 �벏
//	// �삁瑜쇰뱾�뼱 踰쎌뿉 異⑸룎�븳 �긽�깭
//
//	public Player_s() {
//		initObject();
//		initSetting();
//		initBackgroundPlayerService();
//	}
//
//	private void initObject() {
//		kitPlayerF = new ImageIcon("images/LoopyKit_front.png");
//		kitPlayerL = new ImageIcon("images/LoopyKit_left.png");
//		kitPlayerR = new ImageIcon("images/LoopyKit_right.png");
//
//		delPlayerL = new ImageIcon("images/LoopyDel_left.png");
//		delPlayerR = new ImageIcon("images/LoopyDel_right.png");
//
//	}
//
//	private void initSetting() {
//		x = 472;
//		y =680;
//
//		left = false;
//		right = false;
//		up = false;
//		down = false;
//		jumpUp = false;
//		jumpDown = false;
//
//		leftWallCrash = false;
//		rightWallCrash = false;
//
//		playerWay = PlayerWay_s.RIGHT;
//		setIcon(kitPlayerF);
//		setSize(55, 80); // �궗�씠利� �넻�씪
//		setLocation(x, y);
////		setBackground(new Color(0, 0, 0, 122));
////		setVisible(true);
//
//	}
//
//	private void initBackgroundPlayerService() {
//		new Thread(new BackgroundMapService_s(this)).start();
//	}
//
//	@Override
//	public void left() {
//		System.out.println("left");
//		playerWay = PlayerWay_s.LEFT;
//		left = true;
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (left) {
//					setIcon(kitPlayerL);
//					x = x - SPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//
//	@Override
//	public void right() {
//		System.out.println("right");
//		playerWay = playerWay.RIGHT;
//		right = true;
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//
//				while (right) {
//					setIcon(kitPlayerR);
//					x = x + SPEED;
//					setLocation(x, y);
//
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//		}).start();
//
//	}
//
//	@Override
//	public void up() {
//		System.out.println("up");
//		up = true;
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (up) {
//					y = y - SPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//				}
//			}
//		}).start();
//
//	}
//
//	@Override
//	public void down() {
//		System.out.println("down");
//		down = true;
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while (down) {
//					setIcon(kitPlayerF);
//					y = y + SPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//			}
//
//		}).start();
//
//	}
//
//	@Override
//	public void jumpUp() {
//		System.out.println("jumpUp");
//		jumpUp = true;
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 120 / JUMPSPEED; i++) {
//					y = y - JUMPSPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(5);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//
//				}
//				jumpUp = false;
//				jumpDown();
//
//			}
//		}).start();
//
//	}
//
//	@Override
//	public void jumpDown() {
//		System.out.println("jumpDown");
//		jumpDown = true;
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (jumpDown) {
//					y = y + JUMPSPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(3);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//				}
//				jumpDown = false;
//			}
//		}).start();
//
//	}
//
//
//} // end of class