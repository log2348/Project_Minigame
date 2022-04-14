package ver1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getRaw() {
		return raw;
	}

	public void setRaw(ImageIcon raw) {
		this.raw = raw;
	}

	public ImageIcon getPos1() {
		return pos1;
	}

	public void setPos1(ImageIcon pos1) {
		this.pos1 = pos1;
	}

	public ImageIcon getPos2() {
		return pos2;
	}

	public void setPos2(ImageIcon pos2) {
		this.pos2 = pos2;
	}

	public ImageIcon getSauce() {
		return sauce;
	}

	public void setSauce(ImageIcon sauce) {
		this.sauce = sauce;
	}

	public ImageIcon getSauceP() {
		return sauceP;
	}

	public void setSauceP(ImageIcon sauceP) {
		this.sauceP = sauceP;
	}

	public ImageIcon getOilP() {
		return oilP;
	}

	public void setOilP(ImageIcon oilP) {
		this.oilP = oilP;
	}

	public ImageIcon getPlate() {
		return plate;
	}

	public void setPlate(ImageIcon plate) {
		this.plate = plate;
	}

	public ImageIcon getBox1() {
		return box1;
	}

	public void setBox1(ImageIcon box1) {
		this.box1 = box1;
	}

	public ImageIcon getBox2() {
		return box2;
	}

	public void setBox2(ImageIcon box2) {
		this.box2 = box2;
	}

	public ImageIcon getBox3() {
		return box3;
	}

	public void setBox3(ImageIcon box3) {
		this.box3 = box3;
	}

	public ImageIcon getChickDummy1() {
		return chickDummy1;
	}

	public void setChickDummy1(ImageIcon chickDummy1) {
		this.chickDummy1 = chickDummy1;
	}

	public ImageIcon getChickDummy2() {
		return chickDummy2;
	}

	public void setChickDummy2(ImageIcon chickDummy2) {
		this.chickDummy2 = chickDummy2;
	}

	public ImageIcon getChickDummy3() {
		return chickDummy3;
	}

	public void setChickDummy3(ImageIcon chickDummy3) {
		this.chickDummy3 = chickDummy3;
	}

	public ImageIcon getChickP1() {
		return chickP1;
	}

	public void setChickP1(ImageIcon chickP1) {
		this.chickP1 = chickP1;
	}

	public ImageIcon getChickP2() {
		return chickP2;
	}

	public void setChickP2(ImageIcon chickP2) {
		this.chickP2 = chickP2;
	}

	public ImageIcon getChickP3() {
		return chickP3;
	}

	public void setChickP3(ImageIcon chickP3) {
		this.chickP3 = chickP3;
	}

	public ImageIcon getFrying1() {
		return frying1;
	}

	public void setFrying1(ImageIcon frying1) {
		this.frying1 = frying1;
	}

	public ImageIcon getFrying2() {
		return frying2;
	}

	public void setFrying2(ImageIcon frying2) {
		this.frying2 = frying2;
	}

	public ImageIcon getEmptyNet() {
		return emptyNet;
	}

	public void setEmptyNet(ImageIcon emptyNet) {
		this.emptyNet = emptyNet;
	}

	// 의존 주입 --> 생성자에 주입을 받는다
	public Chicken(Player player) {
		this.player = player;
		initObject();
		initSetting();
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
		
		setIcon(raw);
		setSize(40, 30);
		
		state = 0;
	}
}
