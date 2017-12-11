import javax.swing.*;
import java.awt.event.*;

public class Mahjong extends JFrame {

	private JMenuBar menu;
	private Board gamePlay;

	public Mahjong() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (0 == JOptionPane.showConfirmDialog(getRootPane(),"Are you sure you want to quit","Quit",JOptionPane.YES_NO_OPTION, 1))
					System.exit(0);
			}
		});

		this.setTitle("Mahjong");
		setSize(1000,700);
		setResizable(false);
		add(gamePlay = new Board());
		makeMenu();
		setVisible(true);
	}

	private void makeMenu() {
		menu = new JMenuBar();
		setJMenuBar(menu);

		JMenu game = new JMenu("Game");

		JMenuItem play = new JMenuItem("Play New Game");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(gamePlay);
				gamePlay = null;
				add(gamePlay = new Board());
				repaint();
				revalidate();
			}
		});
		game.add(play);

		JMenuItem restart = new JMenuItem("Restart Game");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.resetGame();
			}
		});
		game.add(restart);

		JMenuItem numbered = new JMenuItem("Numbered");
		numbered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seed = JOptionPane.showInputDialog(getRootPane(), "Enter a game number:");
				if (seed == null)
					return;

				while (!(seed.matches("^-?\\d+$"))){
					seed = JOptionPane.showInputDialog(getRootPane(), "Enter a valid number:");
					if (seed == null)
						return;
				}
				remove(gamePlay);
				gamePlay = null;
				add(gamePlay = new Board(Integer.parseInt(seed)));
				repaint();
				revalidate();
			}
		});
		game.add(numbered);

		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (0 == JOptionPane.showConfirmDialog(getRootPane(),"Are you sure you want to quit","Quit",JOptionPane.YES_NO_OPTION, 1))
					System.exit(0);
			}
		});
		game.add(quit);


		JMenu sound = new JMenu("Sound");
		JCheckBoxMenuItem soundToggle = new JCheckBoxMenuItem("Sound On");
		soundToggle.setState(true);
		soundToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayClip.soundToggle();
			}
		});
		sound.add(soundToggle);

		JMenu move = new JMenu("Move");
		JMenuItem undo = new JMenuItem("Undo");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.undoMove();
			}
		});
		move.add(undo);

		JMenu help = new JMenu("Help");
		JMenuItem operation = new JMenuItem("Operation");
		operation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("Operations.html", "Operations");
			}
		});
		help.add(operation);

		JMenuItem rules = new JMenuItem("Game Rules");
		rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("Rules.html", "Rules");
			}
		});
		help.add(rules);

//		JMenuItem fw = new JMenuItem("Fireworks");
//		fw.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				gamePlay.youWin();
//			}
//		});
//		help.add(fw);

		menu.add(game);
		menu.add(sound);
		menu.add(move);
		menu.add(help);
	}

	public static void main(String[] args) {
		new Mahjong();
	}
}
