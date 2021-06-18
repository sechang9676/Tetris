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
	// ȭ�� �ػ󵵸� ����
	public static final int SCREEN_WIDTH = 330;
	public static final int SCREEN_HEIGHT = 600;

	// �̹��� ���ҽ��� ������
	private ImageIcon icon = new ImageIcon(GameManager.class.getResource("../images/tetris_start_screen.jpg"));
	// �̹��� ���ҽ��� �̹��� ������ ����
	private Image startImage = icon.getImage();
	// ��ư�� �̹��� ���ҽ��� ������
	public ImageIcon startButtonIcon = new ImageIcon(GameManager.class.getResource("../images/startButton.gif")); // �־���
	public ImageIcon endButtonIcon = new ImageIcon(GameManager.class.getResource("../images/endButton.gif"));
	public ImageIcon optionButtonIcon = new ImageIcon(GameManager.class.getResource("../images/optionButton.gif"));
	// ��ư�� �̹����� �־���
	public JButton startButton = new JButton("", startButtonIcon);
	public JButton endButton = new JButton("", endButtonIcon);
	public JButton optionButton = new JButton("", optionButtonIcon);

	/**
	 * Create the panel.
	 */
	public StartScreen() {

		// ���� ��ư
		startButton.setBounds(135, 50, 100, 100);
		startButton.setSize(120, 50);
		startButton.setBorderPainted(false);// ��ư�� �ܰ����� ������
		startButton.setContentAreaFilled(false);// ��ư���� ä��⸦ ������

		// ���� ��ư
		endButton.setBounds(135, 150, 100, 100);
		endButton.setSize(120, 50);
		endButton.setBorderPainted(false);// ��ư�� �ܰ����� ������
		endButton.setContentAreaFilled(false);// ��ư���� ä��⸦ ������
		

		// �ɼ� ��ư
		optionButton.setBounds(110, 100, 100, 100);
		optionButton.setSize(170, 50);
		optionButton.setBorderPainted(false);// ��ư�� �ܰ����� ������
		optionButton.setContentAreaFilled(false);// ��ư���� ä��⸦ ������
		

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
