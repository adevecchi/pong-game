package game.pong.ui.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.pong.component.Ball;

public class OnKeyEvent extends KeyAdapter {
	
	private Ball ball;
	
	public OnKeyEvent(Ball ball) {
		this.ball = ball;
	}
	
	public void keyPressed(KeyEvent e) {
		ball.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		ball.keyReleased(e);
	}

}
