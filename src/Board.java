import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel{

	private static int x = 220;
	private static int y = 95;
	private static int side = 10;
	private static ArrayList<Tile> tiles = new ArrayList<>();
	private Model model;

	public Board() {
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.orange);
		prepareTiles();
		model = new Model(tiles);
		for (Tile t :tiles) {
//			t.setSize(60, 85);
//			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (x + (t.getRow() * 75) - t.getLayer() * side));
//			add(t);
			t.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					((Tile) e.getSource()).setVisible(false);
				}
			});
		}
		layoutTiles();
		setVisible(true);
		this.repaint();
	}

	private void addTile(Tile t) {
		t.setSize(60, 85);
		if (t.getLayer() == 4) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side) -30, (y + (t.getRow() * 75) - t.getLayer() * side) - 42);
		} else if (t.getLayer() == 0 && t.getRow() == 8) {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (3 * 75) - t.getLayer() * side) + 38);
		} else {
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (y + (t.getRow() * 75) - t.getLayer() * side));
		}
		add(t);
	}

	private void layoutTiles() {
		int num = 0;
		ArrayList<ArrayList<Tile>> layer;

		for (int y = 4; y > -1; y--) {
			layer = model.getLayer(y);
			for (int x = layer.size() - 1; x > -1; x--) {
				for (int i = 0; i < layer.get(x).size(); i++) {
					if (y == 0 && x == 8)
						break;
					if (y == 0 && x == 4 && i == 0)
						addTile(layer.get(8).get(0));
					addTile(layer.get(x).get(i));
					if (y == 0 && x == 3 && i == 11) {
						addTile(layer.get(8).get(1));
						addTile(layer.get(8).get(2));
					}
				}

			}
		}
	}

	private void prepareTiles() {

		tiles.add(new FlowerTile("Bamboo"));
		tiles.add(new FlowerTile("Chrysanthemum"));
		tiles.add(new FlowerTile("Orchid"));
		tiles.add(new FlowerTile("Plum"));
		tiles.add(new SeasonTile("Fall"));
		tiles.add(new SeasonTile("Spring"));
		tiles.add(new SeasonTile("Summer"));
		tiles.add(new SeasonTile("Winter"));

		for (int i = 0; i < 4; i++)
		{
			for (int x = 0; x < 9; x++)
			{
				tiles.add(new CharacterTile(Character.forDigit(x+1, 10)));
				tiles.add(new CircleTile(x+1));
			}

			for (int x = 0; x < 8; x++)
			{
				tiles.add(new BambooTile(x+2));
			}

			tiles.add(new Bamboo1Tile());
			tiles.add(new CharacterTile('N'));
			tiles.add(new CharacterTile('W'));
			tiles.add(new CharacterTile('E'));
			tiles.add(new CharacterTile('S'));
			tiles.add(new CharacterTile('C'));
			tiles.add(new CharacterTile('F'));
			tiles.add(new WhiteDragonTile());
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = getToolkit().getImage(getClass().getResource("images/dragon_bg.png"));
		g.drawImage(img, this.getWidth()/2 - img.getWidth(this)/2, this.getHeight()/2 - img.getHeight(this)/2, this);
	}
}
