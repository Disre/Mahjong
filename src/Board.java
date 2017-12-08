import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel{

	private static int x = 50;
	private static int side = 10;
	private static ArrayList<Tile> tiles = new ArrayList<Tile>();

	public Board() {
		setLayout(null);
		setPreferredSize(getSize());
		setBackground(Color.orange);
		prepareTiles();
		Model model = new Model(tiles);
		for (Tile t :tiles) {
			t.setSize(60, 85);
			t.setLocation((x + (t.getColumn() * 50) + t.getLayer() * side), (x + (t.getRow() * 75) - t.getLayer() * side));
			add(t);
			t.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					((Tile) e.getSource()).setVisible(false);
				}
			});
		}
		setVisible(true);
		this.repaint();
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
