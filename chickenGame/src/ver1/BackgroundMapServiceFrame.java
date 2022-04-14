package ver1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapServiceFrame implements Runnable{

	private BufferedImage image;
	private Player player;
	
	public BackgroundMapServiceFrame(Player player) {
		this.player = player;
		
		try {
			image  = ImageIO.read(new File("images/kitService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// 색상 확인
		while(true) {
			// 플레이어 왼쪽 색
			Color leftColor = new Color(image.getRGB(player.getX() + 5, player.getY() + 40));
			int leftColorNum = image.getRGB(player.getX() + 5, player.getY() + 40);
			// 플레이어 오른쪽 색
			Color rightColor = new Color(image.getRGB(player.getX() + 55 + 10, player.getY() + 40));
			int rightColorNum = image.getRGB(player.getX() + 55 + 10, player.getY() + 40);
			Color bottomColor = new Color(image.getRGB(player.getX() + 27, player.getY() + 80 +10));
			int bottomColorNum = image.getRGB(player.getX() + 10 + 27, player.getY() + 80)
					+ image.getRGB(player.getX() + 27 , player.getY() + 80);
			Color topColor = new Color(image.getRGB(player.getX() + 27, player.getY()));
			int topColorNum = image.getRGB(player.getX(), player.getY())
					+ image.getRGB(player.getX() + 55, player.getY());
			
			
			System.out.println(bottomColor);
			
			// 외벽 및 바닥충돌
			
			if(leftColorNum != -1) {
				// 플레이어 왼쪽 이동 금지
				//player.setLeftWallCrash(true);
				player.setLeft(false);
				System.out.println(leftColor);
			}else if(rightColorNum != -1){
				// 플레이어 오른쪽 이동 금지
				//player.setRightWallCrash(true);
				player.setRight(false);
				System.out.println(rightColor);
			}else if(bottomColorNum != -2) {
				// 플레이어 아래 이동 금지
				player.setDown(false);
				System.out.println(bottomColor);
			}else if(topColorNum != -2) {
				// 플레이어 위로 이동 금지
				player.setUp(false);
				System.out.println(topColorNum);
			}else {
				// 플레이어 자유롭게 이동
				
				// 점프하는 순간 down 메소드 호출
				if(!player.isUp() && !player.isDown()) { // 내려가다가 끝까지 내려감
					// 버그 (무한 호출) : 백그라운드서비스는 계속 실행 됨
					// Player에서 down == false 일 경우에만 한번 실행되게 수정해야 함
					player.down();
					//System.out.println("아래로");
				}
			}
			
			// 주문(노란색) RGB(225 225 0)
			if(leftColor.getRed() == 225 && leftColor.getGreen() == 225 && leftColor.getBlue() == 0) {
				System.out.println("주문이 접수되었습니다");
				// 반죽(연두색) RGB(0 225 0)
			}else if(leftColor.getRed() == 0 && leftColor.getGreen() == 225 && leftColor.getBlue() == 0) { 
				System.out.println("반죽합니다");
				// 튀김기(파란색) RGB(0 0 225)
			}else if(leftColor.getRed() == 0 && leftColor.getGreen() == 0 && leftColor.getBlue() == 225) {
				System.out.println("튀기기1"); 
				// 튀김 (분홍색) RGB(225 0 225)
			}else if(leftColor.getRed() == 225 && leftColor.getGreen() == 0 && leftColor.getBlue() == 225) { 
				System.out.println("튀기기2");
				// 양념 (금색) RGB(200 200 0)
			}else if(rightColor.getRed() == 200 && rightColor.getGreen() == 200 && rightColor.getBlue() == 0) { 
				System.out.println("양념바르기");
				// 포장 (진한금색) RGB(150 150 0)
			}else if(rightColor.getRed() == 150 && rightColor.getGreen() == 150 && rightColor.getBlue() == 0) { 
				System.out.println("포장하기");
				// 냉장고 RGB(92 156 109)
			}else if(rightColor.getRed() == 92 && rightColor.getGreen() == 156 && rightColor.getBlue() == 109) { 
				System.out.println("냉장고에서 생닭 꺼내기");
				// 입구 RGB(0 225 225)
			}else if(rightColor.getRed() == 0 && rightColor.getGreen() == 225 && rightColor.getBlue() == 225) { 
				System.out.println("주방으로 입장하였습니다");
			}else {
				System.out.println("바쁘다 바빠");
			}
			
			// 배달지 상세
			if(topColor.getRed() == 200 && topColor.getGreen() == 160 && topColor.getBlue() == 99) {
				System.out.println("금색지붕 배달완료");
			}else if(topColor.getRed() == 7 && topColor.getGreen() == 145 && topColor.getBlue() == 58) {
				System.out.println("녹색지붕 배달완료");
			}else if(topColor.getRed() == 0 && topColor.getGreen() == 160 && topColor.getBlue() == 233) {
				System.out.println("하늘색지붕 배달완료");
			}else if(topColor.getRed() == 230 && topColor.getGreen() == 0 && topColor.getBlue() == 18) {
				System.out.println("빨간색지붕 배달완료");
			}else if(topColor.getRed() == 164 && topColor.getGreen() == 10 && topColor.getBlue() == 94) {
				System.out.println("분홍색지붕 배달완료");
			}else if(topColor.getRed() == 30 && topColor.getGreen() == 71 && topColor.getBlue() == 156) {
				System.out.println("파란색지붕 배달완료");
			}else if(topColor.getRed() == 128 && topColor.getGreen() == 78 && topColor.getBlue() == 33) {
				System.out.println("갈색지붕 배달완료");
			}
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
