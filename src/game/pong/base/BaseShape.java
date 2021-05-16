package game.pong.base;

import java.awt.Shape;

public class BaseShape {

	private Shape shape;
	private double x;
	private double y;
	private double velX;
	private double velY;
	
	public BaseShape() {
		setShape(null);
		setX(0.0);
		setY(0.0);
		setVelX(0.0);
		setVelY(0.0);
	}
	
	public Shape getShape() { 
		return shape; 
	}
	public void setShape(Shape shape) { 
		this.shape = shape; 
	}
	
	public double getX() { 
		return x; 
	}
	public void setX(double x) { 
		this.x = x; 
	}
	
	public double getY() { 
		return y; 
	}
	public void setY(double y) { 
		this.y = y; 
	}
	
	public double getVelX() { 
		return velX; 
	}
	public void setVelX(double velX) { 
		this.velX = velX; 
	}
	
	public double getVelY() { 
		return velY; 
	}
	public void setVelY(double velY) { 
		this.velY = velY; 
	}
	
	public void incX(double inc) { 
		this.x += inc; 
	}
	
	public void incY(double inc) { 
		this.y += inc; 
	}
	
	public void incVelX(double inc) { 
		this.velX += inc; 
	}
	
	public void incVelY(double inc) { 
		this.velY += inc; 
	}
	
}
