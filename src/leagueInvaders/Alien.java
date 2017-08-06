package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	public Alien(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
	}
	
	public void update() {
		super.update();
		y++; 

	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	
}
