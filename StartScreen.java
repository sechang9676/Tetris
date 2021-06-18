package tetris;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel {
	// 화면 해상도를 결정
	public static final int SCREEN_WIDTH = 330;
	public static final int SCREEN_HEIGHT = 600;

	// 이미지 리소스를 가져옴
	private ImageIcon icon = new ImageIcon(GameManager.class.getResource("../images/tetris_start_screen.jpg"));
	// 이미지 리소스를 이미지 변수에 저장
	private Image startImage = icon.getImage();
	// 버튼의 이미지 리소스를 가져옴
	public ImageIcon startButtonIcon = new ImageIcon(GameManager.class.getResource("../images/startButton.gif")); // 넣어줌
	public ImageIcon endButtonIcon = new ImageIcon(GameManager.class.getResource("../images/endButton.gif"));
	public ImageIcon optionButtonIcon = new ImageIcon(GameManager.class.getResource("../images/optionButton.gif"));
	// 버튼에 이미지를 넣어줌
	public JButton startButton = new JButton("", startButtonIcon);
	public JButton endButton = new JButton("", endButtonIcon);
	public JButton optionButton = new JButton("", optionButtonIcon);

	/**
	 * Create the panel.
	 */
	public StartScreen() {

		// 시작 버튼
		startButton.setBounds(135, 50, 100, 100);
		startButton.setSize(120, 50);
		startButton.setBorderPainted(false);// 버튼의 외곽선을 없애줌
		startButton.setContentAreaFilled(false);// 버튼안의 채우기를 없애줌

		// 종료 버튼
		endButton.setBounds(135, 150, 100, 100);
		endButton.setSize(120, 50);
		endButton.setBorderPainted(false);// 버튼의 외곽선을 없애줌
		endButton.setContentAreaFilled(false);// 버튼안의 채우기를 없애줌
		

		// 옵션 버튼
		optionButton.setBounds(110, 100, 100, 100);
		optionButton.setSize(170, 50);
		optionButton.setBorderPainted(false);// 버튼의 외곽선을 없애줌
		optionButton.setContentAreaFilled(false);// 버튼안의 채우기를 없애줌
		

		this.add(startButton);
		this.add(optionButton);
		this.add(endButton);
		this.setBounds(0, 0, MyTetris.SCREEN_WIDTH, MyTetris.SCREEN_HEIGHT);
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(startImage, 0, 0, getWidth(), getHeight(), this);
	}

}
