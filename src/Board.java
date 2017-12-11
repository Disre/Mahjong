import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Board extends JPanel {

	private static int x = 220;
	private static int y = 22;
	private static int side = 10;
	private static Fireworks fire;
	private Model model;
	private Tile selected;
	private ArrayList<Tile> moves = new ArrayList();
	private History history;
	private boolean firstRun = true;

	public Board() {
		fire = new Fireworks(this);
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.decode("#8caad2"));
		model = new Model();
		layoutTiles();
		add(history = new History());
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
		add(history = new History());
		setVisible(true);
		this.repaint();
	}

	private void addTile(Tile t) {
		t.setSize(60, 85);
		if (t.getLayer() == 4) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side) - 30, (y + (t.getRow() * 75) - t.getLayer() * side) - 42);
		} else if (t.getLayer() == 0 && t.getRow() == 8) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (3 * 75) - t.getLayer() * side) + 38);
		} else {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (t.getRow() * 75) - t.getLayer() * side));
		}
		if (firstRun) {
			addTileAction(t);
		}
		add(t, t.getzOrder());
	}

	private void youLost() {
		JOptionPane.showMessageDialog(this, "There are no more moves available.");
	}

	public void youWin() {
		setBackground(Color.black);
		fire.setExplosions(23, 1000);
		fire.fire();
	}

	public void undoMove() {
		Tile[] undid = history.undo();

		if (undid != null) {
			for (Tile t : undid) {
				t.setPlay(true);
			}
			layoutTiles();
			revalidate();
			repaint();
		}
	}

	public void resetGame() {
		while (history.getCount() != 0)
			undoMove();
	}

	private void layoutTiles() {
		ArrayList<ArrayList<Tile>> layer;
		int num = 0;
		for (Tile t : model.getTiles()) {
			if (t.isInPlay()) {
				t.setzOrder(num++);
				addTile(t);
			}
		}
		revalidate();
		repaint();
		if (firstRun)
			firstRun = false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = getToolkit().getImage(getClass().getResource("images/dragon_bg.png"));
		g.drawImage(img, x / 2 + this.getWidth() / 2 - img.getWidth(this) / 2, this.getHeight() / 2 - img.getHeight(this) / 2, this);
	}

	private void addTileAction(Tile t) {
		t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (model.isTileOpen((Tile) e.getSource())) {
					Tile temp = (Tile) e.getSource();
					if (selected == null) {
						selected = (Tile) e.getSource();
						temp.isSelected(true);
					} else if (selected != null) {
						if (selected.matches(temp)) {
							history.add(selected, temp);
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
					revalidate();
					repaint();
				}
			}
		});
	}
}
