package Lab2b;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class bottomPaddel extends Sprite {
	int posX,posY,moveDirX,moveDirY,speed;
	
	public bottomPaddel(int x, int y, int width, int height) {
		super(x, y, width, height);
		posX=x;
		posY=y;
		moveDirX=0; //stop
		moveDirY=-1;//up
		speed=1;
	}

	@Override
	public void update(Keyboard keyboard) {
		if(keyboard.isKeyDown(Key.Left)){
			setX(getX()-2);
			moveDirX=-1*speed;
		}
				
		if(keyboard.isKeyDown(Key.Right)){
			setX(getX()+2);
			moveDirX=1*speed;
		}
		if (getX()< 10) {
			moveDirX=1*speed;
			speed-=1;
		}
	
		if (getX()> 690) {
			moveDirX=-1*speed;
			speed+=1;
		}
		setX(getX()+moveDirX);
	}

	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.red);
		graphics.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 5, 5);
	
	}

	public boolean hasCollided(Sprite Box) {
		Rectangle playerRect	= new Rectangle(getX(),getY(),getWidth(),getHeight());
		Rectangle hitRect	= new Rectangle(Box.getX(),Box.getY(),Box.getWidth(),Box.getHeight());
		
		return playerRect.intersects(hitRect);
	}
	
 
}
