package ver1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundMapFrameLabel extends JFrame implements ActionListener {
	// 배달 맵
	private BufferedImage deliveryMapImg;
	// 주방 맵
	private BufferedImage kitchenMapImg;

	// 이미지 파일명
	private String deliveryMapFileName = "images/deliveryMap.png";
	private String kitchenMapFileName = "images/kitchenMap.png";

	private JButton changeDeliveryMapBtn;
	private JButton changeKitchenMapBtn;

	private Player player;

	private DeliveryPanel deliveryPanel;
	private KitchenPanel kitchenPanel;

	int pointX = 0;
	int pointY = 0;

	public BackgroundMapFrameLabel() {
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		setTitle("치킨집 타이쿤");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player = new Player();

		kitchenPanel = new KitchenPanel();
		deliveryPanel = new DeliveryPanel();

		try {
			kitchenMapImg = ImageIO.read(new File(kitchenMapFileName));
			deliveryMapImg = ImageIO.read(new File(deliveryMapFileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}

		changeDeliveryMapBtn = new JButton("배달하기");
		changeKitchenMapBtn = new JButton("주방으로");

		changeDeliveryMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));
		changeKitchenMapBtn.setFont(new Font("맑은고딕", Font.BOLD, 15));

		setVisible(true);
		setContentPane(kitchenPanel);
		setResizable(false);
		
		add(changeDeliveryMapBtn, BorderLayout.SOUTH);
		add(changeKitchenMapBtn, BorderLayout.SOUTH);
		add(player);

	}

	private void initSetting() {
		setLayout(null);
		changeDeliveryMapBtn.setBounds(750, 700, 100, 40);
		changeKitchenMapBtn.setBounds(750, 700, 100, 40);

	}

	private void initListener() {

		changeDeliveryMapBtn.addActionListener(this);
		changeKitchenMapBtn.addActionListener(this);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {

				} else if (keyCode == KeyEvent.VK_DOWN) {

				} else if (keyCode == KeyEvent.VK_LEFT) {
					player.left();
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					player.right();
				}

			}
		});

		this.requestFocusInWindow();

	}

	private class DeliveryPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(deliveryMapImg, 0, 0, 1000, 800, null);
		}

	}

	private class KitchenPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(kitchenMapImg, 0, 0, 1000, 800, null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");
			setContentPane(kitchenPanel);
			repaint();
			setVisible(true);

		} else if (changeDeliveryMapBtn == targetBtn) {
			System.out.println("신속배달");
			setContentPane(deliveryPanel);
			repaint();
			setVisible(true);
		}

	}

	public static void main(String[] args) {
		new BackgroundMapFrameLabel();
	}
}
