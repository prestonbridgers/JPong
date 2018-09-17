import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
The GamePanel class represents the JPanel that holds the game itself. It should be added to a JFrame.
@author Curt Bridgers
@version 1.0
*/

public class GamePanel extends JPanel {

	public static final String GAME_NAME = "4 Player Pong";
	public static final int GAME_WIDTH = 900;
	public static final int GAME_HEIGHT = 700;

	private VerPaddle paddle_left;
	private VerPaddle paddle_right;
	private Ball ball;
	
	/**
	Initializes the JPanel.
	*/
	public GamePanel()
	{
		Dimension dim = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setFocusable(true);
		requestFocus();

		paddle_left = new VerPaddle(Paddle.SPACING, (GAME_HEIGHT / 2) - (VerPaddle.HEIGHT / 2));
		paddle_right = new VerPaddle(GAME_WIDTH - (Paddle.SPACING + VerPaddle.WIDTH), (GAME_HEIGHT / 2) - (VerPaddle.HEIGHT / 2));
		ball = new Ball(GAME_WIDTH / 2, GAME_HEIGHT / 2, GAME_WIDTH, GAME_HEIGHT);

		addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				int keyCode = e.getKeyCode();
				switch(keyCode)
				{
					case 87: //W
					paddle_left.moveUp();
					break;
					case 83: //S
					paddle_left.moveDown();
					break;

					case 38: //up_arrow
					paddle_right.moveUp();
					break;
					case 40: //down_arrow
					paddle_right.moveDown();
					break;

					case 65: //A
					break;
					case 68: //D
					break;

					case 37: //left_arrow
					break;
					case 39: //right_arrow
					break;
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
	}

	/**
	The game loop which updates all the paddles and balls: check's collision, moves the ball, etc.
	*/
	public void go()
	{
		while(true)
		{	
			ball.checkBounds();
			ball.checkVerPaddleCollision(paddle_left);
			ball.checkVerPaddleCollision(paddle_right);

			ball.move();

			repaint();

			try
			{
				if(ball.getBounceCount() < 1)
				{
					Thread.sleep(1);
				} else
				{
					Thread.sleep(ball.getBounceCount());
				}
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	The paint method that gets called every tick.
	@param g The Graphics object to handle rendering.
	*/
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

		g.setColor(Color.WHITE);
		g.fillRect(GAME_WIDTH / 2 - 3, 0, 6, GAME_HEIGHT);

		g.setColor(Color.BLACK);
		for(int i = 0; i < 14; i++)
		{
			g.fillRect(GAME_WIDTH / 2 - 3, i*50, 6, 25);
		}


		ball.draw(g);
		paddle_right.draw(g);
		paddle_left.draw(g);
	}

}