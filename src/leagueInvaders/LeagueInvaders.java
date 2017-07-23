package leagueInvaders;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class LeagueInvaders {
	public LeagueInvaders() {

		frame = new JFrame();
		panel = new GamePanel();
		setup();

	}

	GamePanel panel;
	JFrame frame;

	static final int WIDTH = 500;
	static final int HEIGHT = 800;

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);

		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.startGame();
	}

	public static void main(String[] args) {

		LeagueInvaders league = new LeagueInvaders();

	}

}
