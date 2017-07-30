package leagueInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	public GameObject() {
		isAlive = true; 
		collisionBox = new Rectangle(x, y, width, height);
	}

	int x, y, width, height;
	boolean isAlive; 
	Rectangle collisionBox; 

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {


	}

}
