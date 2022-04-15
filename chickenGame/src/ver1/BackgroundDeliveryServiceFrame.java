package ver1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundDeliveryServiceFrame implements Runnable {

	private BufferedImage deliveryServiceImg;

	private Player player;

	boolean deliveryServiceOn;

	public BackgroundDeliveryServiceFrame(Player player) {
		this.player = player;
		deliveryServiceOn = true;
		try {
			deliveryServiceImg = ImageIO.read(new File("images/Map_delServiceRed.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (deliveryServiceOn) {
			System.out.println("딜리버리 백그라운드 진행중");
			try {
				Color leftColor = new Color(deliveryServiceImg.getRGB(player.getX() + 10, player.getY() + 40));
				Color rightColor = new Color(deliveryServiceImg.getRGB(player.getX(), player.getY() + 40));

				int bottomColor = deliveryServiceImg.getRGB(player.getX() + 10, player.getY() + 40)
						+ deliveryServiceImg.getRGB(player.getX(), player.getY() + 40);

				if (bottomColor != -2) {
					player.setDown(false);
				} else {
					if (!player.isJumpUpInDel() && !player.isDown()) {
						player.down();
					}
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
					System.out.println("왼쪽 벽 충돌");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 & rightColor.getBlue() == 0) {
					System.out.println("오른쪽 벽 충돌");
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}

			} catch (Exception e) {
				System.out.println("백그라운드 배달 맵 오류");
			}

			try {
				Thread.sleep(3);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end of while

	}

} // end of class
