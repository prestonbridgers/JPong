import java.awt.Color;
import java.awt.Graphics;

/**
The HorPaddle class describes the Horizontal Paddles on the top and bottom of the screen.
@author Curt Bridgers
@version 1.0
*/

public class HorPaddle extends Paddle
{

	public static final int WIDTH = Paddle.THICKNESS;
	public static final int HEIGHT = 150;

	/**
	The HorPaddle constructer that sends it's paramaters to the abstract Paddle class' constructor.
	@param xPos The initial x position value.
	@param yPos The initial y position value.
	*/
	public HorPaddle(int xPos, int yPos) {
		super(xPos, yPos);
	}

	/**
	The moveLeft method calls the incrementXPos method from the super class and uses the negative Paddle.SPEED value to increment xPos by.
	*/
	public void moveLeft()
	{
		incrementXPos(-Paddle.SPEED);
	}

	/**
	The moveRight method calls the incrementXPos method from the super class and uses the Paddle.SPEED value to increment xPos by.
	*/
	public void moveRight()
	{
		incrementXPos(Paddle.SPEED);
	}

	/**
	The HorPaddle's draw method to handle rendering it to the screen.
	@param g The Graphics object to render it.
	*/
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(getXPos(), getYPos(), getXPos() + WIDTH, getYPos() + HEIGHT);
	}

}