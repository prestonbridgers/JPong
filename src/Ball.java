import java.awt.Graphics;
import java.awt.Color;

/**
The Ball class describes the ball that starts in the center of the screen and intereacts with the paddles and boundaries of the screen.
@author Curt Bridgers
@version 1.0
*/

public class Ball
{
	public static final int DIAMETER = 20;
	public static final int SPEED = 1;

	private int xPos;
	private int yPos;
	private int xVel = SPEED;
	private int yVel = SPEED;
	private int xBounds;
	private int yBounds;

	private int bounceCount = 5;

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
	Accessor method for the bounceCount field;
	@return bounceCount
	*/
	public int getBounceCount()
	{
		return bounceCount;
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
			bounceCount++;
			if(xPos < GamePanel.GAME_WIDTH / 2)
			{
				GamePanel.score_right++;
			} else
			{
				GamePanel.score_left++;
			}
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
	This method checks collision with the passed HorPaddle object.
	@param p The HorPaddle object to check collision with.
	*/
	public void checkHorPaddleCollision(HorPaddle p)
	{
		int xCenter = xPos + (DIAMETER / 2);
		int yCenter = yPos + (DIAMETER / 2);

		if(xCenter >= p.getXPos() && xCenter <= p.getXPos() + HorPaddle.WIDTH)
		{
			if(yCenter >= p.getYPos() && yCenter <= p.getYPos() + HorPaddle.HEIGHT)
			{
				bounceY();
				bounceCount--;
			}
		}
	}

	/**
	This method check collision with the passed VerPaddle object.
	@param p The VerPaddle object to check collision with.
	*/
	public void checkVerPaddleCollision(VerPaddle p)
	{
		int xCenter = xPos + (DIAMETER / 2);
		int yCenter = yPos + (DIAMETER / 2);

		if(xCenter >= p.getXPos() && xCenter <= p.getXPos() + VerPaddle.WIDTH)
		{
			if(yCenter >= p.getYPos() && yCenter <= p.getYPos() + VerPaddle.HEIGHT)
			{
				bounceX();
				bounceCount--;
			}
		}
	}

	/**
	The draw method to handle drawing a Ball to a JFrame.
	@param g The Graphics object to render it.
	*/
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(xPos, yPos, DIAMETER, DIAMETER);
	}
}