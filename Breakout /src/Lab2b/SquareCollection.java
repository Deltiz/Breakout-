package Lab2b;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SquareCollection {
	int i=9;
	//private ArrayList<ColoredBox> boxar2;
	ArrayList<ColoredBox> boxar2 = new ArrayList<ColoredBox>();
	public SquareCollection(int x, int y,Color color) {
		
		for(int antal=0 ; antal< 10; antal ++) {
		boxar2.add(new ColoredBox(x+50*antal,y,20,20,color));
		}
	}
	
	public SquareCollection(int x, int y, Color color,int max) {
		boxar2 = new ArrayList<ColoredBox>();
		for(int antal=0 ; antal< max; antal ++) {
		boxar2.add(new ColoredBox(x+50*antal,y,20,20,color));
		}
	}
	
	public void draw(Graphics2D graphics) {
		
		for (ColoredBox i_box : boxar2 ) {
			i_box.draw(graphics);
		}
	
}
	public void moveDown(Graphics2D graphics) {
		
		for (ColoredBox i_box : boxar2 ) {
			i_box.draw(graphics);
			if (i_box.getY()< 550 ) {
				i_box.setY(i_box.getY()+1);
			}
		}
	}
	
	public void moveUp(Graphics2D graphics) {
		
		for (ColoredBox i_box : boxar2 ) {
			i_box.draw(graphics);
			if (i_box.getY()> 10 ) {
			i_box.setY(i_box.getY()-1);
			}
		}
	}
	
}