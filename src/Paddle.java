/**
The Paddle class holds all common variables that the VerPaddle and HorPaddle share.
@author Curt Bridgers
@version 1.0
*/

public abstract class Paddle
{
	public static final byte SPACING = 20;
	public static final byte THICKNESS = 10;
	public static final byte SPEED = 10;

	private int xPos;
	private int yPos;

	/**
	The Paddle constructor sets the xPos and yPos variables.
	@param xPos Initial x coordinate.
	@param yPos Initial y coordinate.
	*/
	public Paddle(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
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
	Mutator method that increments the xPos field by amt.
	@param amt The amount to add to xPos.
	*/
	public void incrementXPos(int amt)
	{
		xPos += amt;
	}

	/**
	Mutator method that increments the yPos field by amt.
	@param amt The amount to add to yPos.
	*/
	public void incrementYPos(int amt)
	{
		yPos += amt;
	}
}