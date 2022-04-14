package chickenGame;

public interface Moveable_s {
	void left();
	void right();
	
	void up();//걸어올라감
	void down();//걸어내려감

	void jumpUp();//점프업	
	void jumpDown(); //점프했을때 다운
}