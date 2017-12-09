import java.awt.*;
import javax.swing.*;

public class Mahjong extends JFrame {

	private JMenuBar menuBar;

	public Mahjong() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mahjong");
		setSize(1200,800);
		setResizable(false);
		add(new Board());

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu game = new JMenu("Game");
		JMenuItem play = new JMenuItem("Play");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem numbered = new JMenuItem("Numbered");
		JMenuItem quit = new JMenuItem("Quit");
		game.add(play);
		game.add(restart);
		game.add(numbered);
		game.add(quit);

		JMenu sound = new JMenu("Sound");
		JCheckBoxMenuItem soundToggle = new JCheckBoxMenuItem("Sound On");
		sound.add(soundToggle);

		JMenu move = new JMenu("Move");
		JMenuItem undo = new JMenuItem("Undo");
		move.add(undo);

		JMenu help = new JMenu("Help");
		JMenuItem operation = new JMenuItem("Operation");
		JMenuItem rules = new JMenuItem("Game Rules");
		help.add(operation);
		help.add(rules);

		menuBar.add(game);
		menuBar.add(sound);
		menuBar.add(move);
		menuBar.add(help);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Mahjong();
	}
}
