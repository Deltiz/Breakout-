package Lab2b;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Sprite{
int posX,posY,moveDirX,moveDirY,speed;
Random slumpTal;
Integer ballsToGoLocal;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		posX=x;
		posY=y;
		moveDirX=1; //stop
		moveDirY=-1;//up
		speed=1;
		slumpTal = new Random();
		ballsToGoLocal =5;
	}

	@Override
	public void update(Keyboard keyboard) {
	/*	if(keyboard.isKeyDown(Key.Up)){
			setY(getY()-2);
		}
		if(keyboard.isKeyDown(Key.Down)){
			setY(getY()+2);
		}
		if(keyboard.isKeyDown(Key.Left)){
			setX(getX()-2);
			moveDirX=-1;
		}
				
		if(keyboard.isKeyDown(Key.Right)){
			setX(getX()+2);
			moveDirX=1;
		} 
		*/
		//if(keyboard.isKeyDown(Key.Space)){
	//		speed = 1;
	//	}
		
		if(keyboard.isKeyDown(Key.Enter)){
			System.exit(0);
		}
		if (getY()< 50) {
			moveDirY=1*speed;
			speed+=1;
		}
	
		/*if (getY()> 560) {
			moveDirY=-1*speed;
			speed+=1;
		}*/
		
		if (getY()> 600) {
		//setX(posX);
			setX(slumpTal.nextInt(780)+10);
			setY(slumpTal.nextInt(400)+50);
			ballsToGoLocal -= 1;
			switch (slumpTal.nextInt(3)) {
				case 0:
				moveDirX=0; 
				break;
				case 1:
				moveDirX=1; 
				break;
				case 2:
				moveDirX=-1; 
				break;
			}
		//moveDirX=1; //stop
		if(slumpTal.nextInt(3)== 0) moveDirY=1; else moveDirY=-1; 
		//moveDirY=-1*slumpTal.nextInt(2);//up
		speed=slumpTal.nextInt(5);
		}
		
		if (getX()< 10) {
			moveDirX=1*speed;
			speed+=1;
		}
		
	
		if (getX()> 770) {
			moveDirX=-1*speed;
			speed+=1;
		}
		
		if (speed>40) speed=0;
		
		
				setY(getY()+moveDirY);
				setX(getX()+moveDirX);
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.green);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
	public boolean hasCollided(Sprite Box) {
		Rectangle playerRect	= new Rectangle(getX(),getY(),getWidth(),getHeight());
		Rectangle hitRect	= new Rectangle(Box.getX(),Box.getY(),Box.getWidth(),Box.getHeight());
		
		return playerRect.intersects(hitRect);
	}
}
