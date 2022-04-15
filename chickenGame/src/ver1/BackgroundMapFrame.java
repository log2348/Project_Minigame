package ver1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackgroundMapFrame extends JFrame implements ActionListener {
	// 배달 맵
	JLabel deliveryMapImg;
	// 주방 맵
	JLabel kitchenMapImg;
	// 이미지 파일명
	private String deliveryMapFileName = "images/Map_del.png";
	private String kitchenMapFileName = "images/Map_kit.jpg";

	public JButton changeDeliveryMapBtn;
	public JButton changeKitchenMapBtn;

	private Sales sales;

	private JLabel totalSalesLabel;
	private JLabel goalSalesLabel;

	private Player player;
	
	private ImageIcon kitPlayerF; 
	private ImageIcon kitPlayerL;
	private ImageIcon kitPlayerR;

	private ImageIcon delPlayerF;
	private ImageIcon delPlayerL;
	private ImageIcon delPlayerR;

	public BackgroundMapFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setTitle("치킨배달 게임");
		setSize(1000, 830);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		kitchenMapImg = new JLabel(new ImageIcon(kitchenMapFileName));
		deliveryMapImg = new JLabel(new ImageIcon(deliveryMapFileName));

		changeDeliveryMapBtn = new JButton("배달하기");
		changeKitchenMapBtn = new JButton("주방으로");

		changeDeliveryMapBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		changeKitchenMapBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		sales = new Sales();
		player = Player.getInstance();

		totalSalesLabel = new JLabel("총 매출 : " + sales.getTotalSales());
		goalSalesLabel = new JLabel("목표 매출 : " + sales.getRandomGoalSales());

		player.backgroundDeliveryService.deliveryServiceOn = false;
		player.backgroundKitchenService.kitchenServiceOn = true;
		
		kitPlayerF = new ImageIcon("images/LoopyKit_front.png");
		kitPlayerL = new ImageIcon("images/LoopyKit_left.png");
		kitPlayerR = new ImageIcon("images/LoopyKit_right.png");

		delPlayerF = new ImageIcon("images/LoopyDel_front.png");
		delPlayerL = new ImageIcon("images/LoopyDel_left.png");
		delPlayerR = new ImageIcon("images/LoopyDel_right.png");

	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);

		changeDeliveryMapBtn.setBounds(800, 650, 100, 40);
		changeKitchenMapBtn.setBounds(800, 650, 100, 40);

		kitchenMapImg.add(changeDeliveryMapBtn);
		deliveryMapImg.add(changeKitchenMapBtn);

		kitchenMapImg.add(totalSalesLabel);
		kitchenMapImg.add(goalSalesLabel);

		totalSalesLabel.setBounds(800, 700, 200, 50);

		goalSalesLabel.setBounds(800, 720, 200, 50);

		kitchenMapImg.add(player);

		setContentPane(kitchenMapImg);

		setVisible(true);
		setResizable(false);

	}

	private void addEventListener() {

		changeDeliveryMapBtn.addActionListener(this);
		changeKitchenMapBtn.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setIcon(player.getPlayerIconL());
					System.out.println(e.getKeyCode());
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;

				case KeyEvent.VK_RIGHT:
					player.setIcon(player.getPlayerIconR());
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
                    if (getContentPane() == kitchenMapImg) {
                        if (!player.isUp() && !player.isTopCrash()) {
                            player.up();
                        }
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (getContentPane() == kitchenMapImg) {
                        if (!player.isDown() && !player.isBottomCrash()) {
                            player.down();
                        }
                    }
                    break;

				case KeyEvent.VK_SPACE:
					if (getContentPane() == kitchenMapImg) {
						if (!player.isJumpUpInKit() && !player.isJumpDownInKit()) {
							System.out.println("space 점프 in kit");
							player.jumpUpInKit();
						}

					} else {
						if (!player.isJumpUpInDel() && !player.isJumpDownInDel()) {
							System.out.println("space 점프 in del");
							player.jumpUpInDel();
						}
					}
					break;
				case KeyEvent.VK_G: // 상호작용 G키
                    System.out.println("G 상호작용");
                    Chicken chicken = new Chicken(player);
                    add(chicken);
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
				
				}
			}
		});

		this.requestFocusInWindow();
	} // end of addEventListener

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

			player.setX(28);
			player.setY(690);
			player.setIcon(delPlayerR);
			player.setPlayerIconF(delPlayerF);
			player.setPlayerIconL(delPlayerL);
			player.setPlayerIconR(delPlayerR);

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

			player.setX(450);
			player.setY(700);
			player.setIcon(kitPlayerR);
			player.setPlayerIconF(kitPlayerF);
			player.setPlayerIconL(kitPlayerL);
			player.setPlayerIconR(kitPlayerR);
			
			player.backgroundKitchenService.kitchenServiceOn = true;
			player.backgroundDeliveryService.deliveryServiceOn = false;
			new Thread(player.backgroundKitchenService).start();
		}

		repaint();
		setVisible(true);
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new BackgroundMapFrame();
	}

}
