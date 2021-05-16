package game.pong.component;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import game.pong.base.BaseShape;

public class PaddleLeft extends BaseShape implements Runnable {

	private boolean up = false;
	private boolean down = false;
	
  	public PaddleLeft(int x, int y) {
  		setX(x);
  		setY(y);
  		setShape(new Rectangle(0, 0, 20, 90));
  	}
	
  	public Rectangle getBounds() {
		Rectangle r;
		r = new Rectangle((int)getX(), (int)getY(), 22, 92);
		return r;
	}
	
	public void keyPressed(KeyEvent ev) {
		switch (ev.getKeyCode()) {
			case KeyEvent.VK_A:
				up = true;
				break;
			case KeyEvent.VK_Z:
				down = true;
				break;
		}	
	}

	public void keyReleased(KeyEvent ev) {
		switch (ev.getKeyCode()) {
			case KeyEvent.VK_A:
				up = false;
				break;
			case KeyEvent.VK_Z:
				down = false;
				break;
		}
	}
	
	public void move() {
		if ((int)this.getY() > 25) {
			if(up)
				this.incY(this.getVelY() * -1);
			else
				this.incY(0);
		}
		
		if ((int)this.getY() < 410) {
			if(down)
				this.incY(this.getVelY() * +1);
			else
				this.incY(0);
		}
	}
	
	@Override
	public void run() {
		 try {
			 while(true) {
	    		move();
	            Thread.sleep(10);
			 } 
		 } 
		 catch(InterruptedException e) { }
	}
	
}
