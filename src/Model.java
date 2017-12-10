import java.util.*;

public class Model {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Tile> searchTiles = new ArrayList<>();
	private int num = 0;

	public Model () {
		prepareTiles();
		Collections.shuffle(tiles);
		randomizeTiles();
	}

	public Model (int seed) {
		prepareTiles();
		Random rand = new Random(seed);
		Collections.shuffle(tiles, rand);
		randomizeTiles();
	}

	public boolean isTileOpen(Tile t) {
//		if (!t.isInPlay())
//			return false;
//		if (t.getLayer() == 3 && searchTiles.get(0).isInPlay())
//				return false;
////		//covered
//		if (t.getLayer() <= 2)
//			if (getTile(t.getRow(), t.getColumn(), t.getLayer()+1) != null)
//				if (getTile(t.getRow(), t.getColumn(), t.getLayer()+1).isInPlay())
//					return false;
////		//side
//		if (getTile(t.getRow(), t.getColumn()-1, t.getLayer()) != null && getTile(t.getRow(), t.getColumn()+1, t.getLayer()) != null)
//			if (getTile(t.getRow(), t.getColumn()-1, t.getLayer()).isInPlay() && getTile(t.getRow(), t.getColumn()+1, t.getLayer()).isInPlay())
//				return false;
////		//special
//		if (t.getLayer() == 0 && t.getRow() == 8 && t.getColumn() == 13)
//			if (getTile(8, 14, 0).isInPlay())
//				return false;
//		if (t.getLayer() == 0 && (t.getRow() == 3 || t.getRow() == 4)) {
//			if (t.getColumn() == 1 && getTile(8, 0, 0).isInPlay())
//				return false;
//			if (t.getColumn() == 12 && getTile(8, 13, 0).isInPlay())
//				return false;
//		}
		return true;
	}

	public ArrayList<Tile> getTiles() {
		return searchTiles;
	}

	private Tile getTile(int row, int column, int layer) {
		for (Tile t: searchTiles)
				if (t.getRow() == row && t.getColumn() == column && t.getLayer() == layer)
					return t;
		return null;
	}

	public boolean didILose() {
		int x = 0;
		for (Tile t: searchTiles) {
			x++;
			if (t.isVisible() && isTileOpen(t)){
				for (int i = x; i < searchTiles.size(); i++)
					if (t.matches(searchTiles.get(i)) && searchTiles.get(i).isVisible() && isTileOpen(searchTiles.get(i)))
						return false;
			}
		}
		return true;
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

	private void randomizerAssigner(int rows, int columns, int rowOffset, int colOffset, int layerOffset) {
		for (int i = rows-1; i > -1; i--) {
			for (int x = 0; x < columns; x++) {
//				int rand = (int) ((Math.random() * tiles.size()));
				tiles.get(0).setPosition(i + rowOffset, x + colOffset, layerOffset);
				tiles.get(0).setzOrder(num++);
				searchTiles.add(tiles.get(0));
				tiles.remove(0);
			}
		}
	}

	private void randomizeTiles() {
		//layer4
		randomizerAssigner(1, 1, 4,7, 4);
		//layer3
		randomizerAssigner(2, 2, 3, 6, 3);
		//layer2
		randomizerAssigner(4, 4,2, 5, 2);
		//layer1
		randomizerAssigner(6, 6, 1, 4, 1);
		//layer0
		randomizerAssigner(1, 1, 8, 0, 0);
		randomizerAssigner(1, 12, 7, 1, 0);
		randomizerAssigner( 1, 8, 6, 3, 0);
		randomizerAssigner( 1, 10, 5, 2, 0);
		randomizerAssigner( 1, 12, 4, 1, 0);
		randomizerAssigner( 1, 12, 3, 1, 0);
		randomizerAssigner(1, 10, 2, 2 ,0);
		randomizerAssigner(1, 8, 1, 3, 0);
		randomizerAssigner(1, 12, 0, 1, 0);
		randomizerAssigner(1, 1, 8, 13, 0);
		randomizerAssigner(1, 1, 8, 14, 0);
	}

}
