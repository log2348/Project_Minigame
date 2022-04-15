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

public class BackgroundMapFrame extends JFrame implements ActionListener {
	// 배달 맵
	private JLabel deliveryMapImg;
	// 주방 맵
	private JLabel kitchenMapImg;
	// 이미지 파일명
	private String deliveryMapFileName = "images/Map_del.jpg";
	private String kitchenMapFileName = "images/Map_kit.jpg";

	public JButton changeDeliveryMapBtn;
	public JButton changeKitchenMapBtn;

	private Sales sales;

	private JLabel totalSalesLabel;
	private JLabel goalSalesLabel;

	private Player player;

	public BackgroundMapFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("치킨배달 게임");
		setSize(1000, 800);
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
		goalSalesLabel = new JLabel("목표 매출 : " + sales.getGoalSales());


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
		deliveryMapImg.add(totalSalesLabel);
		deliveryMapImg.add(goalSalesLabel);
		
		totalSalesLabel.setBounds(450, 5, 200, 50);
		
		goalSalesLabel.setBounds(450, 25, 200, 50);

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
					player.setIcon(player.getKitPlayerL());
					System.out.println("---");
					System.out.println(e.getKeyCode());
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					player.setIcon(player.getKitPlayerR());
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
					// 만약 kit이면 jumpUpInKit
					// del이면 jumpUpInDel
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
		} else if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenMapImg);
			kitchenMapImg.add(player);
			kitchenMapImg.updateUI();
		}

		repaint();
		setVisible(true);
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new BackgroundMapFrame();
	}

}
