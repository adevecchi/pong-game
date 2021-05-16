package game.pong.component;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.URL;

import game.pong.base.BaseShape;
import game.pong.ui.PongUI;

public class Ball extends BaseShape implements Runnable {
	
	private PaddleLeft paddleLeft;
	private PaddleRight paddleRight;
	
	private int paddleLeftScore;
	private int paddleRightScore;
	
	private AudioClip paddle_sound, limit_sound;
	private URL url;
	
  	public Ball(int x, int y, PaddleLeft pl,  PaddleRight pr) {
  		this.setX(x);
  		this.setY(y);
  		this.paddleLeft = pl;
  		this.paddleRight = pr;
  		this.paddleLeftScore = 0;
  		this.paddleRightScore = 0;
  		this.setShape(new Rectangle(0, 0, 20, 20));
  		
  		url = PongUI.class.getResource("/game/pong/ui/resources/bateu.wav");
		paddle_sound = Applet.newAudioClip(url);
		
		url = PongUI.class.getResource("/game/pong/ui/resources/limit.wav");
		limit_sound = Applet.newAudioClip(url);
  	}
  	
  	public String getPaddleLeftScore() {
  		return String.valueOf(paddleLeftScore);
  	}
  	
  	public String getPaddleRightScore() {
  		return String.valueOf(paddleRightScore);
  	}
	
  	public Rectangle getBounds() {
		Rectangle r;
		r = new Rectangle((int)getX(), (int)getY(), 20, 20);
		return r;
	}
  	
	public void keyPressed(KeyEvent ev) {
		paddleLeft.keyPressed(ev);
		paddleRight.keyPressed(ev);
	}


	public void keyReleased(KeyEvent ev) {
		paddleLeft.keyReleased(ev);
		paddleRight.keyReleased(ev);
	}
	
	private void collision() {   
		if(this.getBounds().intersects(paddleLeft.getBounds())) {
			//setX(35);
			if(this.getX() > 35) {
				setVelX(getVelX() * -1);
				limit_sound.play();
			}
		}
		
		if(this.getBounds().intersects(paddleRight.getBounds())) {
			//setX(745);
			if(this.getX() < 747) {
				setVelX(getVelX() * -1);
				limit_sound.play();
			}
		}
	}
	
	private void move() {
		collision();

		incX(getVelX());
		incY(getVelY());
		
		if((int)this.getX() < 0) {
			setVelX(getVelX() * -1);
			paddleRightScore++;
			paddle_sound.play();
			this.setX(800 / 2);
			this.setY(500 / 2);
			
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) { }
		}
		
		if((int)this.getX() > 800 - 20) {
			setVelX(getVelX() * -1);
			paddleLeftScore++;
			paddle_sound.play();
			this.setX(800 / 2);
			this.setY(500 / 2);
			
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) { }
		}
		
		if((int)this.getY() < 22) {
			setVelY(getVelY() * -1);
			limit_sound.play();
		}
		
		if((int)this.getY() > 500 - 20) {
			setVelY(getVelY() * -1);
			limit_sound.play();
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
