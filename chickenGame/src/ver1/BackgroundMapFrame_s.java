

////<소담 테스트 코드>

package ver1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackgroundMapFrame_s extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BackgroundMapFrame_s() {
		initObject();
		initSetting();
		initListener();

		setVisible(true);
		setResizable(false);

	}

	private void initObject() {
//		backgroundMap = new JLabel(new ImageIcon("images/kit_initialState.png"));
//		setContentPane(backgroundMap);

		backgroundMap = new JLabel(new ImageIcon("images/Map_kitService.jpg"));
		setContentPane(backgroundMap);

		player = Player.getInstance();
		add(player);
		setContentPane(backgroundMap);


	}

	private void initSetting() {
		setTitle("C조의 치킨배달게임");
		setSize(1000, 900); // 원래 이미지 사이즈는 1000* 800임
		
		//player y좌표: 720
		setLayout(null); // CSS의 absolute개념. 좌표값으로 자유롭게 그릴 수 있다.

		setLocationRelativeTo(null);// JFrame윈도우 창의 가운데에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {


				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					
					System.out.println("---");
					System.out.println(e.getKeyCode());
					System.out.println("천장crash"+player.isTopCrash());
					System.out.println("바닥crash"+player.isBottomCrash());
					System.out.println("왼쪽crash"+player.isLeftWallCrash());
					System.out.println("오른쪽crash"+player.isRightWallCrash());
					
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isTopCrash()) {
						player.up();
					}
					break;

				case KeyEvent.VK_DOWN:
					if (!player.isDown() && !player.isBottomCrash()) {
						player.down();
					}
					break;
				case KeyEvent.VK_SPACE:
					if (!player.isJumpUpInKit() && !player.isJumpDownInKit()) {
					System.out.println("space 점프 in kit");
						player.jumpUpInKit();
					}

					break;

				case 71: // 상호작용 G키
					System.out.println("G 상호작용");
					break;
				default:
					break;

				} // end of switch
			} // end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;
				case KeyEvent.VK_SPACE:
					break;
				case 71: // G 상호작용
					break;
				default:
					break;
				}
			}

		}); // end of addKeyListener
	}

	public static void main(String[] args) {
		new BackgroundMapFrame_s();

	} // end of main
} // end of class