import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel{

	private static int x = 220;
	private static int y = 95;
	private static int side = 10;
	private Model model;
	private Tile selected;

	public Board() {
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.decode("#8caad2"));
		model = new Model();
		layoutTiles();
		setVisible(true);
		this.repaint();
	}

	private void addTile(Tile t, int zOrder) {
		t.setzOrder(zOrder);
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
					if (selected == null) {
						selected = (Tile)e.getSource();
					} else if (selected != null) {
						if (selected.matches((Tile) e.getSource())) {
							selected.setVisible(false);
							((Tile) e.getSource()).setVisible(false);
							selected = null;
						} else
							selected = (Tile)e.getSource();
					}
				}
			}
		});
		add(t);
	}

	private void layoutTiles() {
		ArrayList<ArrayList<Tile>> layer;
		int zOrder = 0;

		for (int y = 4; y > -1; y--) {
			layer = model.getLayer(y);
			for (int x = layer.size() - 1; x > -1; x--) {
				for (int i = 0; i < layer.get(x).size(); i++) {
					if (y == 0 && x == 8)
						break;
					if (y == 0 && x == 4 && i == 0) {
						addTile(layer.get(8).get(0), zOrder);
						zOrder++;
					}
					addTile(layer.get(x).get(i), zOrder);
					if (y == 0 && x == 3 && i == 11) {
						addTile(layer.get(8).get(1), zOrder);
						zOrder++;
						addTile(layer.get(8).get(2), zOrder);
						zOrder++;
					}
					zOrder++;
				}

			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = getToolkit().getImage(getClass().getResource("images/dragon_bg.png"));
		g.drawImage(img, this.getWidth()/2 - img.getWidth(this)/2, this.getHeight()/2 - img.getHeight(this)/2, this);
	}
}
