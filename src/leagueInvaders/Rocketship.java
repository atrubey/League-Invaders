package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	public Rocketship(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = 5; 
	}
	
	int speed; 
	
	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	
}
