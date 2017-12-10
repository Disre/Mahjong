import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Board extends JPanel{

	private static int x = 220;
	private static int y = 22;
	private static int side = 10;
	private Model model;
	private Tile selected;
	private ArrayList<Tile> moves = new ArrayList();
	private JScrollPane scroll;
	private JPanel history;

	public Board() {
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.decode("#8caad2"));
		model = new Model();
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
//							temp.isSelected(false);
//							selected.setVisible(false);
//							selected
//							temp.setVisible(false);
//							moves.push(selected);
//							moves.push(temp);
							selected = null;
							if (moves.size() == 144)
								youWin();
							if (model.didILose())
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

	private void youWin() {
		JOptionPane.showMessageDialog(this, "You won!");
	}

	private void addHistory(Tile t, Tile t2) {
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
		int zOrder = 0;

		for (Tile t: model.getTiles()) {
			addTile(t);
		}
//		for (int y = 4; y > -1; y--) {
//			layer = model.getLayer(y);
//			for (int x = layer.size() - 1; x > -1; x--) {
//				for (int i = 0; i < layer.get(x).size(); i++) {
//					if (y == 0 && x == 8)
//						break;
//					if (y == 0 && x == 4 && i == 0) {
//						addTile(layer.get(8).get(0), zOrder);
//						zOrder++;
//					}
//					addTile(layer.get(x).get(i), zOrder);
//					zOrder++;
//					if (y == 0 && x == 3 && i == 11) {
//						addTile(layer.get(8).get(1), zOrder);
//						zOrder++;
//						addTile(layer.get(8).get(2), zOrder);
//						zOrder++;
//					}
//				}
//
//			}
//		}
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
