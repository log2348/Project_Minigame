package ver1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Chicken extends JLabel {

	// 의존성 컴포지션
	private Player player;

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어가 가진 상태
	private int state;
	
	private final int CHICKEN_PRICE = 19000;

	private ImageIcon raw; // 생닭
	private ImageIcon pos1; // 주문없음
	private ImageIcon pos2; // 주문들어옴
	private ImageIcon sauce; // 양념통
	private ImageIcon sauceP; // 양념방울
	private ImageIcon oilP; // 기름방울
	private ImageIcon plate; // 접시
	private ImageIcon box1; // 빈박스
	private ImageIcon box2; // 치킨담은 박스
	private ImageIcon box3; // 포장된 박스
	private ImageIcon chickDummy1; // 치킨반죽더미
	private ImageIcon chickDummy2; // 후라이드치킨더미
	private ImageIcon chickDummy3; // 양념치킨더미
	private ImageIcon chickP1; // 치킨반죽 1조각
	private ImageIcon chickP2; // 후라이드치킨 1조각
	private ImageIcon chickP3; // 양념치킨 1조각
	private ImageIcon frying1; // 튀겨지는 중
	private ImageIcon frying2; // 튀기기 완료
	private ImageIcon emptyNet; // 빈 튀김통

	

	// 의존 주입 --> 생성자에 주입을 받는다
	public Chicken(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}
	
	private void initObject() {
		raw = new ImageIcon("images/raw.png");
		pos1 = new ImageIcon("images/pos1.png");
		pos2 = new ImageIcon("images/pos2.png");
		sauce = new ImageIcon("images/sauce.png");
		sauceP = new ImageIcon("images/sauceP.png");
		oilP = new ImageIcon("images/oilP.png");
		plate = new ImageIcon("images/plate.png");
		box1 = new ImageIcon("images/box1.png");
		box2 = new ImageIcon("images/box2.png");
		box3 = new ImageIcon("images/box3.png");
		chickDummy1 = new ImageIcon("images/chickDummy1.png");
		chickDummy2 = new ImageIcon("images/chickDummy2.png");
		chickDummy3 = new ImageIcon("images/chickDummy3.png");
		chickP1 = new ImageIcon("images/chickP1.png");
		chickP2 = new ImageIcon("images/chickP2.png");
		chickP3 = new ImageIcon("images/chickP3.png");
		frying1 = new ImageIcon("images/frying1.png");
		frying2 = new ImageIcon("images/frying2.png");
		emptyNet = new ImageIcon("images/emptyNet.png");
	}
	
	private void initSetting() {
		left = false;
		right = false;
		up = false;
		down = false;
		
		x = player.getX();
		y = player.getY();
		
		
		
		state = 0;
	}
	
	private void initThread() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(player.getX() == 308 && player.getY() == 684) {
					setIcon(pos2);
					setSize(40, 30);
					System.out.println("주문을 받습니다");
				}else if(player.getX() == 780 && player.getY() == 644) {
					setIcon(raw);
					setSize(40, 30);
					System.out.println("냉장고에서 생닭을 꺼냅니다");
				}else if(player.getX() == 370 && player.getY() == 456) {
					setIcon(chickDummy1);
					setSize(40, 30);
					System.out.println("생닭을 반죽합니다");
				}else if(player.getX() == 370 && player.getY() == 296) {
					setIcon(frying1);
					setSize(40, 30);
					System.out.println("반죽을 튀깁니다");
				}else if(player.getX() == 370 && player.getY() == 128) {
					setIcon(frying2);
					setSize(40, 30);
					System.out.println("한 번 더 튀깁니다");
				}else if(player.getX() == 760 && player.getY() == 160) {
					setIcon(chickDummy3);
					setSize(40, 30);
					System.out.println("양념합니다");
				}else if(player.getX() == 760 && player.getY() == 352) {
					setIcon(box2);
					setSize(40, 30);
					System.out.println("포장합니다");
				}
			}
		}).start();
	}
	
	
}
