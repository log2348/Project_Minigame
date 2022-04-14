package ver1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundMapFrame extends JFrame implements ActionListener {
	// 배달 맵
	private JLabel deliveryMapImg;
	// 주방 맵
	private JLabel kitchenMapImg;
	// 이미지 파일명
	private String deliveryMapFileName = "images/deliveryMap.png";
	private String kitchenMapFileName = "images/kitchenMap.png";

	// 매출, 평점
	private ScorePanel scorePanel;

	private Sales sales;
	private Grade grade;

	private JButton changeDeliveryMapBtn;
	private JButton changeKitchenMapBtn;

	private JPanel deliveryMapPanel;
	private JPanel kitchenMapPanel;

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

		player = new Player();

		kitchenMapImg = new JLabel(new ImageIcon(kitchenMapFileName));
		deliveryMapImg = new JLabel(new ImageIcon(deliveryMapFileName));

		changeDeliveryMapBtn = new JButton("배달하기");
		changeKitchenMapBtn = new JButton("주방으로");

		changeDeliveryMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));
		changeKitchenMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));

		deliveryMapPanel = new JPanel();
		kitchenMapPanel = new JPanel();

		scorePanel = new ScorePanel();

		grade = new Grade();
		sales = new Sales();

	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);

		changeDeliveryMapBtn.setBounds(750, 700, 100, 40);
		changeKitchenMapBtn.setBounds(750, 700, 100, 40);

		kitchenMapImg.add(changeDeliveryMapBtn);
		deliveryMapImg.add(changeKitchenMapBtn);

		kitchenMapPanel.add(kitchenMapImg);
		deliveryMapPanel.add(deliveryMapImg);

		setContentPane(deliveryMapPanel);

		scorePanel.setSize(120, 70);
		scorePanel.setBounds(430, 30, 120, 100);

		kitchenMapImg.add(player);
		deliveryMapImg.add(player);

		deliveryMapImg.add(scorePanel);
		kitchenMapImg.add(scorePanel);

		setVisible(true);
		setResizable(false);
	}

	private class ScorePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			g.drawString(sales.toString(), 430, 30);
			g.drawString(grade.toString(), 430, 50);
		}
	}

	private void addEventListener() {

		changeDeliveryMapBtn.addActionListener(this);
		changeKitchenMapBtn.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				
				if (keyCode == KeyEvent.VK_UP) {
					System.out.println("111111111");

				} else if (keyCode == KeyEvent.VK_DOWN) {

				} else if (keyCode == KeyEvent.VK_LEFT) {
					player.left();
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					player.right();
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
			setContentPane(deliveryMapPanel);
			deliveryMapImg.add(player);
			deliveryMapImg.add(scorePanel);
		} else if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenMapPanel);
			kitchenMapImg.add(player);
			kitchenMapImg.add(scorePanel);
		}

		repaint();
		setVisible(true);
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new BackgroundMapFrame();
	}
}
