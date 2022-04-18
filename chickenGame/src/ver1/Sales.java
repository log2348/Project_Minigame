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
	
	private JLabel afterSucceedLabel;
	private BackgroundMapFrame mContext;

	public Sales(BackgroundMapFrame mContext) {
		this.mContext = mContext;
		player = Player.getInstance();
		address = getRandomAddress();
	}

	public int updateTotalSales() {
		if (player.isCompleteDelivery()) {
			totalSales += 19000;
			address = getRandomAddress();
			
			if (totalSales >= goalSales) {
				System.out.println("목표 매출 달성");
				totalSales = 0;
				getRandomGoalSales();
				afterSucceed();
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
       int localAddress = rd.nextInt(7)+1; // 0~7->1~8
        return localAddress;
        }
	public JLabel afterSucceed() {
		return new AfterSucceedLabel(mContext);

	}

}
