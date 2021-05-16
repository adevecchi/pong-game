package game.pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import game.pong.component.Ball;
import game.pong.component.PaddleLeft;
import game.pong.component.PaddleRight;
import game.pong.ui.event.OnKeyEvent;

public class PongUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private final int GWIDTH = 800;
	private final int GHEIGHT = 500;
	
	private PaddleLeft paddleLeft = new PaddleLeft(15, 205);
	private PaddleRight paddleRight = new PaddleRight(765, 205);
	
	private Ball ball = new Ball(400, 250, paddleLeft, paddleRight);
	
	private Graphics2D g2;
	private BufferedImage backbuffer;
	private AffineTransform identity = new AffineTransform();
	
    public PongUI() {
    	ball.setVelX(2);
    	ball.setVelY(2);
    	
    	paddleLeft.setVelY(1);
    	paddleRight.setVelY(1);
    	
    	backbuffer = new BufferedImage(GWIDTH, GHEIGHT, BufferedImage.TYPE_INT_RGB);
    	g2 = backbuffer.createGraphics();
    	g2.setFont( new Font("Monospaced", Font.BOLD, 30) );
    	
		this.setTitle("Pong Clone");
		this.setSize(GWIDTH, GHEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new OnKeyEvent(ball));
		
		Thread threadBall = new Thread(ball);
        Thread threadPaddleL = new Thread(paddleLeft);
        Thread threadPaddleR = new Thread(paddleRight);
        
        threadBall.start();
        threadPaddleL.start();
        threadPaddleR.start();
    }
  
    @Override
    public void paint(Graphics g) {
    	draw(g);
    	g.drawImage(backbuffer, 0, 0, this);
    }
	
    private void draw(Graphics g) {
    	g2.setTransform(identity);
    	g2.setPaint(Color.BLACK);
    	g2.fillRect(0, 0, getSize().width, getSize().height);
    	drawBall();
    	drawPaddleLeft();
    	drawPaddleRight();
    	drawString();
    	repaint();
    }
    
    private void drawBall() {
    	g2.setTransform(identity);
    	g2.translate(ball.getX(), ball.getY());
    	g2.setColor(Color.WHITE);
    	g2.fill(ball.getShape());
    }
    
    private void drawPaddleLeft() {
    	g2.setTransform(identity);
    	g2.translate(paddleLeft.getX(), paddleLeft.getY());
    	g2.setColor(Color.WHITE);
    	g2.fill(paddleLeft.getShape());
    }
    
    private void drawPaddleRight() {
    	g2.setTransform(identity);
    	g2.translate(paddleRight.getX(), paddleRight.getY());
    	g2.setColor(Color.WHITE);
    	g2.fill(paddleRight.getShape());
    }
    
    private void drawString() {
    	g2.setTransform(identity);
    	g2.translate(0, 40);
    	g2.setColor(Color.WHITE);
    	g2.drawString(ball.getPaddleLeftScore(), 90, 12);
    	g2.drawString(ball.getPaddleRightScore(), 700, 12);
    }

}
