import java.awt.Graphics;
import java.awt.Color;

/**
The Ball class describes the ball that starts in the center of the screen and intereacts with the paddles and boundaries of the screen.
@author Curt Bridgers
@version 1.0
*/

public class Ball
{
	public static final int DIAMETER = 10;
	public static final int SPEED = 2;

	private int xPos;
	private int yPos;
	private int xVel = SPEED;
	private int yVel = SPEED;
	private int xBounds;
	private int yBounds;

	/**
	The Ball constructor sets the initial x and y values of the ball.
	@param xPos Initial x value.
	@param yPos Initial y value.
	@param xBounds Initial x boundary to contain the ball.
	@param yBounds Initial y boundary to contain the ball.
	*/
	public Ball(int xPos, int yPos, int xBounds, int yBounds)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.xBounds = xBounds;
		this.yBounds = yBounds;
	}

	/**
	Accessor method for the xPos field.
	@return xPos
	*/
	public int getXPos()
	{
		return xPos;
	}

	/**
	Accessor method for the yPos field.
	@return yPos
	*/
	public int getYPos()
	{
		return yPos;
	}

	/**
	Updates the position of the ball by adding the xVel to the xPos and yVel to the yPos.
	*/
	public void move()
	{
		xPos += xVel;
		yPos += yVel;
	}

	/**
	Checks that the ball's xPos and yPos are within the xBounds and yBounds set by the constructor and calls the appropriate bounce method.
	*/
	public void checkBounds()
	{
		if(xPos <= 0 || xPos + DIAMETER >= xBounds)
		{
			bounceX();
		}

		if(yPos <= 0 || yPos + DIAMETER >= yBounds)
		{
			bounceY();
		}
	}

	/**
	Flips the sign of the xVel field which changes the ball's horizontal direction.
	*/
	public void bounceX()
	{
		xVel = -xVel;
	}

	/**
	Flips the sign of the yVel field which changes the ball's vertical direction.
	*/
	public void bounceY()
	{
		yVel = -yVel;
	}

	/**
	The draw method to handle drawing a Ball to a JFrame.
	@param g The Graphics object to render it.
	*/
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawOval(xPos, yPos, DIAMETER, DIAMETER);
	}
}