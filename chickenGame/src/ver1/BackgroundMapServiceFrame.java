package ver1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BackgroundMapServiceFrame implements Runnable, ActionListener {
	
	private BackgroundMapFrame context;

	private BufferedImage kitchenServiceImg;
	private BufferedImage deliveryServiceImg;
	private Player player;

	public BackgroundMapServiceFrame(Player player) {
		this.player = player;

		try {
			kitchenServiceImg = ImageIO.read(new File("images/Map_kitService.jpg"));
			deliveryServiceImg = ImageIO.read(new File("images/Map_delService.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {	

		// 색상 확인
		while (true) {
			int pWidth = player.getWidth();
			int pHeight = player.getHeight();

			Color leftColor = new Color(kitchenServiceImg.getRGB(player.getX() + 10, player.getY() + 40));
			int leftColorInt = kitchenServiceImg.getRGB(player.getX() + 10, player.getY() + 40);

			Color rightColor = new Color(kitchenServiceImg.getRGB(player.getX() + pWidth, player.getY() + 40));
			int rightColorInt = kitchenServiceImg.getRGB(player.getX() + pWidth, player.getY() + 40);

			int topColorInt = kitchenServiceImg.getRGB(player.getX() + 20, player.getY())
					+ kitchenServiceImg.getRGB(player.getX() + 55 - 20, player.getY());

			int bottomColorInt = kitchenServiceImg.getRGB(player.getX() + 20, player.getY() + pHeight - 13)
					+ kitchenServiceImg.getRGB(player.getX() + 55 - 20, player.getY() + pHeight - 13);

			// 외벽 및 바닥충돌
			System.out.println("===========================");
			System.out.println(pWidth + "," + pHeight);
			System.out.println("leftColor: " + leftColor);
			System.out.println("leftColorInt: " + leftColorInt);
			System.out.println("rightColor: " + rightColor);
			System.out.println("rightColorInt: " + rightColorInt);

//			System.out.println("bottomColor: " + bottomColor);
			System.out.println("bottomColorInt: " + bottomColorInt);
//			System.out.println("topColor: " + topColor);
			System.out.println("topColorInt: " + topColorInt);

//			System.out.print("left Color : " + leftColor.getRed() + " ");
//			System.out.print("left Color : " + leftColor.getGreen()+ " ");
//			System.out.print("left Color : " + leftColor.getBlue()+ " ");

			if (leftColorInt != -1) {
				System.out.println("왼쪽벽에 충돌했어");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColorInt != -1) {
				System.out.println("오른쪽 벽에 충돌했어");
				player.setRightWallCrash(true);
				player.setRight(false);

			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			if (bottomColorInt != -2) { // 바닥흰색배경이 아니면

				System.out.println("바닥과 닿았어");
				player.setBottomCrash(true);

				player.setDown(false);
				player.setJumpDownInKit(false);

			} else if (topColorInt != -2) { // 천장흰색아니면
				System.out.println("천장과 닿았어");
				player.setTopCrash(true);
				player.setUp(false);
				player.setJumpUpInKit(false);

			} else {
				player.setTopCrash(false);
				player.setBottomCrash(false);
			}

			try {
				Thread.sleep(1);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end of while

	} // end of run()

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();

		if (context.changeDeliveryMapBtn == targetBtn) {
			System.out.println("신속배달");

		} else if (context.changeKitchenMapBtn == targetBtn) {
			System.out.println("주방으로");

		}

	}

} // end of class