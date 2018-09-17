import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;

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

		paddle_left = new VerPaddle(Paddle.SPACING, (GAME_HEIGHT / 2) - (VerPaddle.HEIGHT / 2));
		paddle_right = new VerPaddle(GAME_WIDTH - (Paddle.SPACING + VerPaddle.WIDTH), (GAME_HEIGHT / 2) - (VerPaddle.HEIGHT / 2));
		ball = new Ball(GAME_WIDTH / 2, GAME_HEIGHT / 2, GAME_WIDTH, GAME_HEIGHT);
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
				Thread.sleep(5);
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

		ball.draw(g);
		paddle_right.draw(g);
		paddle_left.draw(g);
	}

	/**
	The entry point for the program. It simply creates a JFrame and adds a GamePanel object to it.
	@param args Boilerplate for the main(String[] args) method of the program.
	*/
	public static void main(String[] args)
	{
		GamePanel game = new GamePanel();

		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				JFrame f = new JFrame(GamePanel.GAME_NAME);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.add(game);
				f.pack();
				f.setVisible(true);
			}
		});

		game.go();
	}

}