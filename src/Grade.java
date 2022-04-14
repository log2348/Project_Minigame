package ver1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade {
	
	int avgGrade;

	@Override
	public String toString() {
		return "평점 : " + avgGrade;
	}
	
	

}
