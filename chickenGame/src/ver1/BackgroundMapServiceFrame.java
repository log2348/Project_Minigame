package ver1;

//플레이어 만들 때!~!!!!!!
//객체 이곳저곳에서 
//만들x
//
//인스턴스주소값 1개여야함.
//싱글톤패턴으로 설계하기

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapServiceFrame implements Runnable {

	private BufferedImage serviceImg;
	private Player player;

	public BackgroundMapServiceFrame(Player player) {
		this.player = player;
		try {
			serviceImg = ImageIO.read(new File("images/Map_kitService.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of 생성자

	@Override
	public void run() { // class가 Runnable이라서 자동 override
		// 색상 확인
		while (true) { // 무한루프

			int pWidth = player.getWidth();
			int pHeight = player.getHeight();

			Color leftColor = new Color(serviceImg.getRGB(player.getX() + 10, player.getY() + 40));
			int leftColorInt = serviceImg.getRGB(player.getX() + 10, player.getY() + 40);

			Color rightColor = new Color(serviceImg.getRGB(player.getX() + pWidth, player.getY() + 40));
			int rightColorInt = serviceImg.getRGB(player.getX() + pWidth, player.getY() + 40);

			int topColorInt = serviceImg.getRGB(player.getX() + 20, player.getY())
					+ serviceImg.getRGB(player.getX() + 55 - 20, player.getY());

			int bottomColorInt = serviceImg.getRGB(player.getX() + 20, player.getY() + pHeight - 13)
					+ serviceImg.getRGB(player.getX() + 55 - 20, player.getY() + pHeight - 13);

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
				Thread.sleep(1);// thread가 길면.. check해야하는애가 기다리고 있어서 컬러값 check못하고 떨어짐
				// 캐릭터가 이동될 때 color값을 못찾는 경우가 있다.
				// 이동속도보다 더 빠르게 움직여야 해결 가능.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end of while

	} // end of run()

} // end of class
