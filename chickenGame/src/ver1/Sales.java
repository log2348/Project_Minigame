package ver1;

import java.util.Random;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales extends JLabel{

	private Player player;

	private Chicken chicken;

	private int totalSales;

	private int goalSales;
	
	public Sales() {
		player = Player.getInstance();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if (player.isCompleteDelivery()) {
					totalSales += chicken.getCHICKEN_PRICE();
				}
				
			}
		}).start();

	}
	
	public int getRandomGoalSales() {
		Random rd = new Random();
		int goalSales = (rd.nextInt(10) + 1) * 10000;
		return goalSales;
	}
	
	private void resetGoal() {
		if(totalSales >= goalSales) {
			System.out.println("목표 매출 달성");
			getRandomGoalSales();
		}
	}

}
