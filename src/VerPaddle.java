import java.awt.Color;
import java.awt.Graphics;

/**
The HorPaddle class describes the Vertival Paddles on the right and left of the screen.
@author Curt Bridgers
@version 1.0
*/

public class VerPaddle extends Paddle
{

	public static final int WIDTH = Paddle.THICKNESS;
	public static final int HEIGHT = 200;

	/**
	The VerPaddle constructer that sends it's paramaters to the abstract Paddle class' constructor.
	@param xPos The initial x position value.
	@param yPos The initial y position value.
	*/
	public VerPaddle(int xPos, int yPos) {
		super(xPos, yPos);
	}

	/**
	The moveUp method calls the incrementYPos method from the super class and uses the negative Paddle.SPEED value to increment yPos by.
	*/
	public void moveUp()
	{
		incrementYPos(-Paddle.SPEED);
	}

	/**
	The moveDown method calls the incrementYPos method from the super class and uses the Paddle.SPEED value to increment yPos by.
	*/
	public void moveDown()
	{
		incrementYPos(Paddle.SPEED);
	}

	/**
	The VerPaddle's draw method to handle rendering it to the screen.
	@param g The Graphics object to render it.
	*/
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(getXPos(), getYPos(), WIDTH, HEIGHT);
	}

}