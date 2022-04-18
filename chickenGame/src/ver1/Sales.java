package ver1;

import java.util.Random;

import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales extends JLabel {

	private Player player;

	static int totalSales = 0;

	static int goalSales;

	public Sales() {
		player = Player.getInstance();
		updateTotalSales();

	}

	public int updateTotalSales() {
		if (player.isCompleteDelivery()) {
			totalSales += 19000;
			if (totalSales >= goalSales) {
				System.out.println("목표 매출 달성");
				totalSales = 0;
				getRandomGoalSales();
			}
		}
		return totalSales;
	}

	public int getRandomGoalSales() {
		Random rd = new Random();
		goalSales = (rd.nextInt(10) + 1) * 10000;
		return goalSales;
	}


}
