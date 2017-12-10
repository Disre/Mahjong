import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Board extends JPanel{

	private static int x = 220;
	private static int y = 22;
	private static int side = 10;
	private static Fireworks fire;
	private Model model;
	private Tile selected;
	private ArrayList<Tile> moves = new ArrayList();
	private JScrollPane scroll;
	private JPanel history;

	public Board() {
		fire = new Fireworks(this);
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.decode("#8caad2"));
		model = new Model();
		layoutTiles();
		makeHistory();
		setVisible(true);
		this.repaint();
	}

	public Board(int seed) {
		fire = new Fireworks(this);
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.decode("#8caad2"));
		model = new Model(seed);
		layoutTiles();
		makeHistory();
		setVisible(true);
		this.repaint();
	}

	private void addTile(Tile t/*, int zOrder*/) {
		t.setzOrder(t.getzOrder());
		t.setSize(60, 85);
		if (t.getLayer() == 4) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side) -30, (y + (t.getRow() * 75) - t.getLayer() * side) - 42);
		} else if (t.getLayer() == 0 && t.getRow() == 8) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (3 * 75) - t.getLayer() * side) + 38);
		} else {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (t.getRow() * 75) - t.getLayer() * side));
		}
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (model.isTileOpen((Tile) e.getSource())) {
					Tile temp = (Tile) e.getSource();
					if (selected == null) {
						selected = (Tile)e.getSource();
						temp.isSelected(true);
					} else if (selected != null) {
						if (selected.matches(temp)) {
							addHistory(selected, temp);
							selected = null;
							if (moves.size() == 144)
								youWin();
							else if (model.didILose())
								youLost();
						} else {
							selected.isSelected(false);
							selected = (Tile) e.getSource();
							((Tile) e.getSource()).isSelected(true);
						}
					}
					repaint();
				}
			}
		});
		add(t, t.getzOrder());
	}

	private void youLost() {
		JOptionPane.showMessageDialog(this, "There are no more moves available.");
	}

	public void youWin() {
		setBackground(Color.black);
		fire.setExplosions(23, 1000);
		fire.fire();
//		try
//		{
//			Thread.sleep(10000);
//			fire.stop();
//		}
//		catch (InterruptedException ie) {}
//		JOptionPane.showMessageDialog(this, "You won!");

	}

	private void addHistory(Tile t, Tile t2) {
		PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
		clip.play();

		t.isSelected(false);
		t.setVisible(false);
		t2.setVisible(false);
		t.setPlay(false);
		t2.setPlay(false);
		moves.add(0, t);
		moves.add(0,t2);
	}

	public void undoMove() {
		Tile t;
		Tile t2;
		if (moves.size() != 0) {
			t = moves.remove(0);
			t2 = moves.remove(0);
			t.setPlay(true);
			t2.setPlay(true);
			t.setVisible(true);
			t2.setVisible(true);
		}
	}

	public void resetGame() {
		while (moves.size() != 0)
			undoMove();
	}

	private void layoutTiles() {
		ArrayList<ArrayList<Tile>> layer;
		for (Tile t: model.getTiles()) {
			addTile(t);
		}
	}

	private void makeHistory() {
		history = new JPanel();
		history.setBackground(Color.decode("#5581bc"));
		history.setBorder(BorderFactory.createRaisedBevelBorder());
		history.setLocation(-2,-2);
		history.setSize(140, 700);
		add(history);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = getToolkit().getImage(getClass().getResource("images/dragon_bg.png"));
		g.drawImage(img, x/2 + this.getWidth()/2 - img.getWidth(this)/2, this.getHeight()/2 - img.getHeight(this)/2, this);
	}
}
