package Lab2b;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;



public class Game {
	
	Random slumpTal;
	Ball myBall;
	ArrayList<Block> block1,block2,block3 ;
	SquareCollection myColl;
	bottomPaddel myPaddel;
	Integer presentScore=0;
	Integer ballsToGo=1;
	Integer bricksToGo=15*3;
	
	
	public Game(GameBoard board) {
		slumpTal = new Random();
		block1 = new ArrayList<Block>();
		block2 = new ArrayList<Block>();
		block3 = new ArrayList<Block>();
		myBall = new Ball(slumpTal.nextInt(780),50,20,20);
		
		for(int i=0;i<bricksToGo;i++) block1.add(new Block(50+i*50,150,40,15,Color.ORANGE)) ;
		for(int i=0;i<bricksToGo;i++) block2.add(new Block(50+i*50,120,40,15,Color.green)) ;
		for(int i=0;i<bricksToGo;i++) block3.add(new Block(50+i*50,180,40,15,Color.pink)) ;

		myColl = new SquareCollection(120,50,Color.red,slumpTal.nextInt(11));
		myPaddel = new bottomPaddel(350, 550, 100, 20);
	}

	public void update(Keyboard keyboard) {
		
		if(keyboard.isKeyDown(Key.Space)){
			Program.main(null);
		}
		
		myBall.update(keyboard);
		myPaddel.update(keyboard);
		
		if(myPaddel.hasCollided(myBall)) {
			presentScore += 1;
				switch (slumpTal.nextInt(3)) {
				case 0:
					myBall.moveDirX=0*myBall.speed;
				break;
				case 1:
					myBall.moveDirX=1*myBall.speed;
				break;
				case 2:
					myBall.moveDirX=-1*myBall.speed;
				break;
			}
				myBall.moveDirY=-1*myBall.speed;
			
			}
	
		
		for(Block block1 : block1) {
		if(myBall.hasCollided(block1)) {
			switch (slumpTal.nextInt(3)) {
			case 0:
				myBall.moveDirX=0*myBall.speed;
			break;
			case 1:
				myBall.moveDirX=1*myBall.speed;
			break;
			case 2:
				myBall.moveDirX=-1*myBall.speed;
			break;
		}
			myBall.moveDirY=-1*myBall.speed;
			
			block1.setY(700);
			presentScore += 100;
			bricksToGo -= 1;
		}
		}
		
		for(Block block2 : block2) {
			if(myBall.hasCollided(block2)) {
				switch (slumpTal.nextInt(3)) {
				case 0:
					myBall.moveDirX=0*myBall.speed;
				break;
				case 1:
					myBall.moveDirX=1*myBall.speed;
				break;
				case 2:
					myBall.moveDirX=-1*myBall.speed;
				break;
			}
				myBall.moveDirY=-1*myBall.speed;
				
				block2.setY(700);
				presentScore += 100;
				bricksToGo -= 1;
			}
			}
		
		for(Block block3 : block3) {
			if(myBall.hasCollided(block3)) {
				switch (slumpTal.nextInt(3)) {
				case 0:
					myBall.moveDirX=0*myBall.speed;
				break;
				case 1:
					myBall.moveDirX=1*myBall.speed;
				break;
				case 2:
					myBall.moveDirX=-1*myBall.speed;
				break;
			}
				myBall.moveDirY=-1*myBall.speed;
				
				block3.setY(700);
				presentScore += 100;
				bricksToGo -= 1;
			}
			}
	}
	
	
	
	public void draw(Graphics2D graphics) {
		
		// Spelplan
		graphics.setColor(Color.blue);
		graphics.fillRect(0, 0, 800, 600);
		graphics.setColor(Color.black);
		graphics.fillRect(10, 50, 780, 600);
		
		// Text High Score
		graphics.setColor(Color.white);
		graphics.drawString("High SCORE:" ,100, 15);
		graphics.drawString("1. MAR	42000" ,100, 30);
		graphics.drawString("2. LOS	21000" ,100, 45);
		//graphics.drawString("3. .." ,100, 45);
		
		// Text Latest Runs
		graphics.drawString("Latest Runs:" ,650, 15);
		graphics.drawString("1. 21000" ,650, 30);
		graphics.drawString("2. 1000" ,650, 45);
		//graphics.drawString("3. .." ,650, 45);
		
		// Text Present Score and balls left.
		graphics.setColor(Color.yellow);
		graphics.drawString("Present Score:",250, 15);
		graphics.drawString(Integer.toString(presentScore) ,250, 30);
		graphics.drawString("Ball to go:" ,350, 15);
		graphics.drawString(Integer.toString(myBall.ballsToGoLocal) ,350, 30);
		graphics.drawString("Bricks to go:" ,450, 15);
		graphics.drawString(Integer.toString(bricksToGo) ,450, 30);
		
		// Game Ended
		if (myBall.ballsToGoLocal<1) {
			graphics.setColor(Color.red);
			graphics.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			graphics.drawString("Game Over Lost",270, 200);
			graphics.setColor(Color.white);
			graphics.setFont(new Font("TimesRoman", Font.PLAIN, 22));
			graphics.drawString("Press Enter to Exit this Game!",250, 300);
			myBall.moveDirX=0;
			myBall.moveDirY=0;
		}
		
		// Game Winner
				if (bricksToGo<=0) {
					graphics.setColor(Color.green);
					graphics.setFont(new Font("TimesRoman", Font.PLAIN, 36));
					graphics.drawString("Game Over You win!!!",270, 200);
					graphics.setColor(Color.white);
					graphics.setFont(new Font("TimesRoman", Font.PLAIN, 22));
					graphics.drawString("Press Enter to Exit this Game!",250, 300);
					myBall.moveDirX=0;
					myBall.moveDirY=0;
				}
		// draw all sprites Ball Blocks and Paddel
		myBall.draw(graphics);
		for(Block block1 : block1) block1.draw(graphics);
		for(Block block2 : block2) block2.draw(graphics);
		for(Block block3 : block3) block3.draw(graphics);
		myPaddel.draw(graphics);
	
		}
}
