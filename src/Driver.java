import javax.swing.JFrame;

/**
The class that drives the pong program.
@author Curt Bridgers
@version 1.0
*/
public class Driver extends JFrame
{
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
				f.setResizable(false);
				f.add(game);
				f.pack();
				f.setVisible(true);
			}
		});

		game.go();
	}
}