package leagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public GamePanel() {

		timer = new Timer(1000 / 60, this);
		game = new GameObject();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 20);
		instructionsFont = new Font("Arial", Font.PLAIN, 20);
		gameOverFont = new Font("Arial", Font.PLAIN, 48);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		ship = new Rocketship(250, 700, 50, 50);
		manager = new ObjectManager(); 
		manager.addObject(ship);

	}

	Timer timer;
	GameObject game;
	Font titleFont, startFont, instructionsFont, gameOverFont, scoreFont; 
	Rocketship ship;
	ObjectManager manager; 

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (ship.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			ship = new Rocketship(250, 700, 50, 50);
			manager.addObject(ship);
		}
	}

	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(startFont);
		g.setColor(Color.BLUE);
		g.drawString("Press enter to start", 150, 300);
		g.drawString("Press space for instructions", 120, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(gameOverFont);
		g.setColor(Color.BLUE);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(scoreFont);
		g.setColor(Color.BLUE);
		g.drawString("Score: " + manager.getScore(), 225, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		repaint();

	}

	void startGame() {

		timer.start();

	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}

		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.y -= ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.y += ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.x += ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.x -= ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addObject(new Projectile(ship.x + 20, ship.y, 10, 10));;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
