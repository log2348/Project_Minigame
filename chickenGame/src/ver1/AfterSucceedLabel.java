package ver1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class AfterSucceedLabel extends JLabel {

	private ImageIcon image;
	private JButton restartBtn;
	private JButton finishGameBtn;

	public AfterSucceedLabel(BackgroundMapFrame mContext) {
		

		image = new ImageIcon("images/Map_finishing.jpg");
		restartBtn = new JButton("재시작");
		finishGameBtn = new JButton("게임종료");

		setIcon(image);
		setSize(1000, 830);
		setLocation(0, 0);
		setLayout(null);
		restartBtn.setBounds(300, 500, 100, 40);
		finishGameBtn.setBounds(600, 500, 100, 40);
		add(restartBtn);
		add(finishGameBtn);
		mContext.setContentPane(this);

	}

}