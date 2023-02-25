package Lab2b;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Sprite {
Color color;
	public Block(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color=color;
		
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
