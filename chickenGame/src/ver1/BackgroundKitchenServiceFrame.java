package ver1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundKitchenServiceFrame implements Runnable {

	private BufferedImage kitchenServiceImg;

	private Player player;

	public BackgroundKitchenServiceFrame(Player player) {
		this.player = player;
		try {
			kitchenServiceImg = ImageIO.read(new File("images/Map_kitService.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {

			try {

				Color leftColor = new Color(kitchenServiceImg.getRGB(player.getX() + 10, player.getY() + 40));
				int leftColorInt = kitchenServiceImg.getRGB(player.getX() + 10, player.getY() + 40);

				Color rightColor = new Color(
						kitchenServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40));
				int rightColorInt = kitchenServiceImg.getRGB(player.getX() + player.getWidth(), player.getY() + 40);

				int topColorInt = kitchenServiceImg.getRGB(player.getX() + 20, player.getY())
						+ kitchenServiceImg.getRGB(player.getX() + 55 - 20, player.getY());

				int bottomColorInt = kitchenServiceImg.getRGB(player.getX() + 20,
						player.getY() + player.getHeight() - 13)
						+ kitchenServiceImg.getRGB(player.getX() + 55 - 20, player.getY() + player.getHeight() - 13);

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

			} catch (Exception e) {
				System.out.println("백그라운드 키친 오류");
			}

			try {
				Thread.sleep(3);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end of while

	}

} // end of class