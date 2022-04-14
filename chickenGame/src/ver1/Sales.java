package ver1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales {

	private Player player;

	private int totalSales;

	public Sales(Player player) {
		this.player = player;
		
		if(player.isCompleteDelivery()) {
			Chicken chicken = new Chicken(player);
			totalSales += chicken.getCHICKEN_PRICE();
		}

	}

	@Override
	public String toString() {
		return "총 매출 : " + totalSales;
	}

}
