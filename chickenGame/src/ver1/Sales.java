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
	
	static int address;
	
	static final int HOUSE_AMOUNT = 8;

	public Sales() {
		player = Player.getInstance();
		updateTotalSales();

	}

	public int updateTotalSales() {
		if (player.isCompleteDelivery()) {
			totalSales += 19000;
			getRandomAddress();
			
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
	
	public int getRandomAddress() {
        Random rd = new Random();
        address = rd.nextInt(HOUSE_AMOUNT) + 1;
        return address;
    }

}
