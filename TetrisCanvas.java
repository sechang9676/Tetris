package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TetrisCanvas extends JPanel implements Runnable, KeyListener {
	protected Thread worker;
	protected Color colors[];
	protected int w = 25;
	protected TetrisData data;
	protected int margin = 20;
	protected boolean stop, makeNew;
	protected Piece current;
	protected Piece nextBlock;
	protected int interval = 2000;
	protected int level = 2;
	public JButton exitButton = new JButton("뒤로가기");
	public JLabel scoreText;
	private int score = 0;

	static boolean flag;

	public TetrisCanvas() {
		this.setBounds(0, 0, MyTetris.SCREEN_WIDTH, MyTetris.SCREEN_HEIGHT);
		this.setLayout(null);
		this.setVisible(false);

		// 뒤로가기 버튼
		exitButton.setBounds(270, 10, 100, 50);
		this.add(exitButton);

		// 스코어 텍스트로 띄우는 부분
		scoreText = new JLabel();

		data = new TetrisData();
		addKeyListener(this);
		colors = new Color[9]; // 테트리스 배경 및 조각 색
		colors[0] = new Color(80, 80, 80); // 배경색(검은회색)
		colors[1] = new Color(255, 0, 0); // 빨간색
		colors[2] = new Color(0, 255, 0); // 녹색
		colors[3] = new Color(0, 200, 255); // 노란색
		colors[4] = new Color(255, 255, 0); // 하늘색
		colors[5] = new Color(255, 150, 0); // 황토색
		colors[6] = new Color(210, 0, 240); // 보라색
		colors[7] = new Color(40, 0, 240); // 파란색
		colors[8] = new Color(0, 0, 0);

		// 스코어 텍스트로 띄우는 부분
		scoreText = new JLabel("none");
		scoreText.setBounds(270, 180, 100, 50);
		scoreText.setText("score: " + data.getLine());
		this.add(scoreText);
	}

	public void start() { // 게임 시작
		data.clear();
		worker = new Thread(this);
		worker.start();
		makeNew = true;
		stop = false;
		flag = false;
		requestFocus();
		repaint();
	}

	public void stop() {
//		data.resetScore();
//		scoreText.setText("score: "+0);
		stop = true;
		current = null;
		nextBlock = null;
	}

	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 0; i < TetrisData.ROW; i++) { // 쌓인 조각들 그리기
			for (int k = 0; k < TetrisData.COL; k++) {
				if (data.getAt(i, k) == 0) {
					g.setColor(colors[data.getAt(i, k)]);
					g.draw3DRect(margin / 2 + w * k, margin / 2 + w * i, w, w, true);
				} else {
					g.setColor(colors[data.getAt(i, k)]);
					g.fill3DRect(margin / 2 + w * k, margin / 2 + w * i, w, w, true);
				}
			}
		}
		if (current != null) {
			for (int i = 0; i < 4; i++) {
				g.setColor(colors[current.getType()]);
				g.fill3DRect(margin / 2 + w * (current.getX() + current.c[i]),
						margin / 2 + w * (current.getY() + current.r[i]), w, w, true);

				g.setColor(colors[nextBlock.getType()]);
				g.fill3DRect(178 + w * (nextBlock.getX() + nextBlock.c[i]),
						120 + w * (nextBlock.getY() + nextBlock.r[i]), w, w, true);
			}
		}
		g.setColor(colors[8]);
		g.draw3DRect(274, 90, 103, 103, false);
		g.drawString("N E X T", 280, 80);
	}

	public void view() {

	}

	public Dimension getPreferredSize() { // 테트리스 판의 크기 지정
		int tw = w * TetrisData.COL + margin;
		int th = w * TetrisData.ROW + margin;
		return new Dimension(tw, th);
	}

	public void run() {
		int random, next;
		next = (int) (Math.random() * Integer.MAX_VALUE) % 7;

		while (!stop) {
			if(score < data.getLine() ) {
				score = data.getLine();
				scoreText.setText("score: "+score);
				repaint();
			}
			try {
				if (makeNew) { // 새로운 테트리스 조각 만들기
					if (flag == false) {
						random = (int) (Math.random() * Integer.MAX_VALUE) % 7;
						flag = true;
					} else {
						random = next;
						next = (int) (Math.random() * Integer.MAX_VALUE) % 7;
					}

					switch (random) {
					case 0:
						current = new Bar(data);
						break;
					case 1:
						current = new Tee(data);
						break;
					case 2:
						current = new El(data);
						break;
					case 3:
						current = new J(data);
						break;
					case 4:
						current = new S(data);
						break;
					case 5:
						current = new O(data);
						break;
					case 6:
						current = new Z(data);
						break;
					default:
						if (random % 2 == 0)
							current = new Tee(data);
						else
							current = new El(data);
					}
					switch (next) {
					case 0:
						nextBlock = new Bar(data);
						break;
					case 1:
						nextBlock = new Tee(data);
						break;
					case 2:
						nextBlock = new El(data);
						break;
					case 3:
						nextBlock = new J(data);
						break;
					case 4:
						nextBlock = new S(data);
						break;
					case 5:
						nextBlock = new O(data);
						break;
					case 6:
						nextBlock = new Z(data);
						break;
					default:
						if (next % 2 == 0)
							nextBlock = new Tee(data);
						else
							nextBlock = new El(data);
					}
					makeNew = false;
				} else { // 현재 만들어진 테트리스 조각 아래로 이동
					if (current.moveDown()) {
						makeNew = true;
						if (current.copy()) {
							stop();
							JOptionPane.showMessageDialog(this, "게임끝\n점수 : " + score);
							data.resetScore();
							scoreText.setText("score: "+0);
						}
						current = null;
					}
					data.removeLines();
				}
				repaint();
				Thread.currentThread().sleep(interval / level);
			} catch (Exception e) {
			}
		}
	}

	// 키보드를 이용해서 테트리스 조각 제어
	public void keyPressed(KeyEvent e) {
		if (current == null)
			return;

		switch (e.getKeyCode()) {
		case 32: // 스페이스 바
			current.moveBottom();
			repaint();
			break;

		case 37: // 왼쪽 화살표
			current.moveLeft();
			repaint();
			break;
		case 39: // 오른쪽 화살표
			current.moveRight();
			repaint();
			break;
		case 38: // 윗쪽 화살표
			current.rotate();
			repaint();
			break;
		case 40: // 아랫쪽 화살표
			boolean temp = current.moveDown();
			if (temp) {
				makeNew = true;
				if (current.copy()) {
					stop();
					JOptionPane.showMessageDialog(this, "게임끝\n점수 : " + score);
				}
			}
			data.removeLines();
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
