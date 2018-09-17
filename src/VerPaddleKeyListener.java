import java.awt.event.*;

public class PongKeyListener extends KeyListener
{

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		System.out.println(keyCode);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}