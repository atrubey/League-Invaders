package leagueInvaders;

import java.awt.Graphics;

public class GameObject {
	public GameObject() {

	}

	int x;
	int y;
	int width;
	int height;

	public void update() {
		for (int i = 0; i < 2; i++) {
			x++;
			y++;
		}
	}

	public void draw(Graphics g) {

		g.fillRect(x, y, 100, 100);

	}

}
