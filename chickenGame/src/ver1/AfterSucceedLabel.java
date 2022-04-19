package ver1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class AfterSucceedLabel extends JLabel implements ActionListener {

	private ImageIcon image;
	private JButton restartBtn;
	private JButton finishGameBtn;
	
	private Player player;
	
	BackgroundMapFrame mContext;

	public AfterSucceedLabel(BackgroundMapFrame mContext) {
		this.mContext = mContext;
		initObject();
		initSettings();
		initaddEventListener();
	}

	private void initObject() {

		image = new ImageIcon("images/Map_finishing.jpg");
		restartBtn = new JButton("재시작");
		finishGameBtn = new JButton("게임종료");
		
		player = Player.getInstance();
		
	}

	private void initSettings() {

		setIcon(image);
		setSize(1000, 830);
		setLocation(-8, -15);
		setLayout(null);
		restartBtn.setBounds(300, 500, 100, 40);
		finishGameBtn.setBounds(600, 500, 100, 40);
		restartBtn.setFont(new Font("D2Coding", Font.BOLD, 15));
		finishGameBtn.setFont(new Font("D2Coding", Font.BOLD, 15));
		restartBtn.setBackground(Color.LIGHT_GRAY);
		finishGameBtn.setBackground(Color.LIGHT_GRAY);
		restartBtn.setBorder(null);
		finishGameBtn.setBorder(null);

		add(restartBtn);
		add(finishGameBtn);
		mContext.setContentPane(this);
		this.requestFocusInWindow();

	}

	private void initaddEventListener() {
		restartBtn.addActionListener(this);
		finishGameBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (restartBtn == targetBtn) {
			System.out.println("재시작");
			
			player.setX(450);
			player.setY(700);
			mContext.kitchenMapImg.add(player);
			player.setIcon(mContext.getKitPlayerR());
			player.setPlayerIconF(mContext.getKitPlayerR());
			player.setPlayerIconL(mContext.getKitPlayerL());
			player.setPlayerIconR(mContext.getKitPlayerR());
			
			mContext.kitchenMapImg.add(mContext.getTotalSalesLabel());
			mContext.kitchenMapImg.add(mContext.getGoalSalesLabel());
			mContext.kitchenMapImg.add(mContext.getDeliveryAddressLabel());

			mContext.setContentPane(mContext.kitchenMapImg);
			
			mContext.requestFocusInWindow();
		} else if (finishGameBtn == targetBtn) {
			System.out.println("게임 종료");
			System.exit(0);

		}
	}

}