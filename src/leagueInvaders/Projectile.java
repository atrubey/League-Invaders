package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	public Projectile(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = 10; 
	}
	
	int speed; 
	
	public void update() {
		super.update();
		y -= speed; 
		if (y < 0) {
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
}
