package tetris;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class MyTetris extends JFrame {
	//화면 해상도를 결정 
	public static final int SCREEN_WIDTH = 400;
	public static final int SCREEN_HEIGHT = 650;
	
	public StartScreen startScreen = new StartScreen();
	public TetrisCanvas tetrisCanvas = new TetrisCanvas();
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MyTetris() {
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT); // 화면 해상도 설정 
		setVisible(true);
		setLayout(null);	
		//프레임에 패널 추가
		this.add(startScreen);
		this.add(tetrisCanvas);
		
		
		//버튼 클릭 이벤트 
		//시작버튼 
		startScreen.startButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 시작 버튼을 눌렀을 때 이벤트 실행
				startScreen.setVisible(false);
				tetrisCanvas.setVisible(true);
				tetrisCanvas.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.startButton.setIcon(startScreen.startButtonIcon);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		startScreen.startButton.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.startButton.setIcon(new ImageIcon(GameManager.class.getResource("../images/mouseOnStartButton.gif")));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		//종료버튼
		startScreen.endButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.endButton.setIcon(startScreen.endButtonIcon);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		startScreen.endButton.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.endButton.setIcon(new ImageIcon(GameManager.class.getResource("../images/mouseOnEndButton.gif")));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		//옵션버튼
		startScreen.optionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		startScreen.optionButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.optionButton.setIcon(startScreen.optionButtonIcon);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		startScreen.optionButton.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				startScreen.optionButton.setIcon(new ImageIcon(GameManager.class.getResource("../images/mouseOnOptionButton.gif")));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		tetrisCanvas.exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tetrisCanvas.stop();
				tetrisCanvas.setVisible(false);
				startScreen.setVisible(true);
			}
		});
		
	}
}
