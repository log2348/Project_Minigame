package ver1;

import java.util.Random;

import javax.swing.JLabel;

public class Sales extends JLabel{

	private Player player;

	private Chicken chicken;

	private int totalSales;

	private int goalSales;
	
	public Sales() {
		player = Player.getInstance();
		
		if (player.isCompleteDelivery()) {
			totalSales += chicken.getCHICKEN_PRICE();
		}

	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public void setGoalSales(int goalSales) {
		this.goalSales = goalSales;
	}

	public int getGoalSales() {
		Random rd = new Random();
		int goalSales = (rd.nextInt(10) + 1) * 10000;
		return goalSales;
	}

}
