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
			deliveryServiceImg = ImageIO.read(new File("images/Map_del.png"));
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
				int leftColorInt = deliveryServiceImg.getRGB(player.getX() + 10, player.getY() + 40);

				Color rightColor = new Color(
						deliveryServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40));
				int rightColorInt = deliveryServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40);

				int topColorInt = deliveryServiceImg.getRGB(player.getX() + 20, player.getY())
						+ deliveryServiceImg.getRGB(player.getX() + 55 - 20, player.getY());

				int bottomColorInt = deliveryServiceImg.getRGB(player.getX() + 20,
						player.getY() + player.getHeight() - 13)
						+ deliveryServiceImg.getRGB(player.getX() + 55 - 20, player.getY() + player.getHeight() - 13);

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

				if (bottomColorInt != -2) { // 바닥흰색배경 아니면

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

				
				// TODO 배달완료 코드

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
