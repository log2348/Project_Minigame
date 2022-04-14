package ver1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sales {

	private Player player;
	
	private int totalSales;

	@Override
	public String toString() {
		return "총 매출 : " + totalSales;
	}
	
	

}
