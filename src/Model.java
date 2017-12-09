import java.util.ArrayList;

public class Model {

	private ArrayList<Tile> tiles = new ArrayList<>();
	private ArrayList<Tile> searchTiles = new ArrayList<>();
	private int num = 0;

	private ArrayList<ArrayList<Tile>> layer0 = new ArrayList<>();
	private ArrayList<ArrayList<Tile>> layer1 = new ArrayList<>();
	private ArrayList<ArrayList<Tile>> layer2 = new ArrayList<>();
	private ArrayList<ArrayList<Tile>> layer3 = new ArrayList<>();
	private ArrayList<ArrayList<Tile>> layer4 = new ArrayList<>();

	public Model () {
		prepareTiles();
		randomizeTiles(tiles);
	}

	public boolean isTileOpen(Tile t) {
		if (t.getLayer() == 4)
			return true;
		if (t.getLayer() == 3 && layer4.get(0).get(0).isVisible())
				return false;
		if (t.getLayer() <= 2)
			if (getTile(t.getRow(), t.getColumn(), t.getLayer()+1) != null)
				if (getTile(t.getRow(), t.getColumn(), t.getLayer()+1).isVisible())
					return false;
		if (getTile(t.getRow(), t.getColumn()-1, t.getLayer()) != null && getTile(t.getRow(), t.getColumn()+1, t.getLayer()) != null)
			if (getTile(t.getRow(), t.getColumn()-1, t.getLayer()).isVisible() && getTile(t.getRow(), t.getColumn()+1, t.getLayer()).isVisible())
				return false;
		return true;
	}

	private Tile getTile(int row, int column, int layer) {
		for (Tile t: searchTiles)
				if (t.getRow() == row && t.getColumn() == column && t.getLayer() == layer)
					return t;
		return null;
	}

	public boolean didILose() {
		System.out.println("not yet");
		int x = 0;
		for (Tile t: searchTiles) {
			x++;
			if (t.isVisible() && isTileOpen(t)){
				for (int i = x; i < searchTiles.size(); i++)
					if (t.matches(searchTiles.get(i)) && searchTiles.get(i).isVisible() && isTileOpen(searchTiles.get(i)))
						return false;
			}
		}
		System.out.println("yes");
		return true;
	}

	public ArrayList<ArrayList<Tile>> getLayer(int layer) {
		if (layer == 0)
			return layer0;
		if (layer == 1)
			return layer1;
		if (layer == 2)
			return layer2;
		if (layer == 3)
			return layer3;
		if (layer == 4)
			return layer4;
		else
			return null;
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

	private void randomizerAssigner(ArrayList<ArrayList<Tile>> layer, int rows, int columns, int rowOffset, int colOffset, int layerOffset) {
		for (int i = 0; i < rows; i++) {
			layer.add(new ArrayList<>());
			for (int x = 0; x < columns; x++) {
				int rand = (int) ((Math.random() * tiles.size()));
				tiles.get(rand).setPosition(i + rowOffset, x + colOffset, layerOffset);
				layer.get(i).add(tiles.get(rand));
				searchTiles.add(tiles.get(rand));
				tiles.remove(rand);
				num++;
			}
		}
	}

	private void randomizeTiles(ArrayList<Tile> tiles) {
		randomizerAssigner(layer4,1, 1, 4,7, 4);
//		int rand;
//		rand = (int) ((Math.random() * tiles.size()));
//		tiles.get(rand).setPosition(4, 7, 4);
//		layer4.add(new ArrayList<>());
//		layer4.get(0).add(tiles.get(rand));
////		layer4.add(tiles.get(rand));
//		searchTiles.add(tiles.get(rand));
//		tiles.remove(rand);
//		num++;
//
//
//
//
		randomizerAssigner(layer3, 2, 2, 3, 6, 3);
//		for (int i = 0; i < 2; i++) {
//			layer3.add(new ArrayList<>());
//			for (int x = 0; x < 2; x++) {
//				rand = (int) ((Math.random() * tiles.size()));
//				tiles.get(rand).setPosition(i+3, x+6, 3);
//				layer3.get(i).add(tiles.get(rand));
//				searchTiles.add(tiles.get(rand));
//				tiles.remove(rand);
//				num++;
//			}
//		}
//
		randomizerAssigner(layer2, 4, 4,2, 5, 2);
//		for (int i = 0; i < 4; i++) {
//			layer2.add(new ArrayList<>());
//			for (int x = 0; x < 4; x++) {
//				rand = (int) ((Math.random() * tiles.size()));
//				tiles.get(rand).setPosition(i+2, x+5, 2);
//				layer2.get(i).add(tiles.get(rand));
//				searchTiles.add(tiles.get(rand));
//				tiles.remove(rand);
//				num++;
//			}
//		}
//
		randomizerAssigner(layer1, 6, 6, 1, 4, 1);
//		for (int i = 0; i < 6; i++) {
//			layer1.add(new ArrayList<>());
//			for (int x = 0; x < 6; x++) {
//				rand = (int) ((Math.random() * tiles.size()));
//				tiles.get(rand).setPosition(i+1, x+4, 1);
//				layer1.get(i).add(tiles.get(rand));
//				searchTiles.add(tiles.get(rand));
//				tiles.remove(rand);
//				num++;
//			}
//		}
//
		randomizerAssigner(layer0, 1, 12, 7, 1, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 12; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(0, i+1, 0);
//			layer0.get(0).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 8, 6, 3, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 8; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(1, i+3, 0);
//			layer0.get(1).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 10, 5, 2, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 10; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(2, i+2, 0);
//			layer0.get(2).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 12, 4, 1, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 12; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(3, i+1, 0);
//			layer0.get(3).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 12, 3, 1, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 12; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(4, i+1, 0);
//			layer0.get(4).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 10, 2, 2 ,0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 10; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(5, i+2, 0);
//			layer0.get(5).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 8, 1, 3, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 8; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(6, i+3, 0);
//			layer0.get(6).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 12, 0, 1, 0);
//		layer0.add(new ArrayList<>());
//		for (int i = 0; i < 12; i++) {
//			rand = (int) ((Math.random() * tiles.size()));
//			tiles.get(rand).setPosition(7, i+1, 0);
//			layer0.get(7).add(tiles.get(rand));
//			searchTiles.add(tiles.get(rand));
//			tiles.remove(rand);
//			num++;
//		}
//
		randomizerAssigner(layer0, 1, 1, 8, 0, 0);
//		layer0.add(new ArrayList<>());
//		rand = (int) ((Math.random() * tiles.size()));
//		tiles.get(rand).setPosition(8, 0, 0);
//		layer0.get(8).add(tiles.get(rand));
//		searchTiles.add(tiles.get(rand));
//		tiles.remove(rand);
//		num++;
//
		randomizerAssigner(layer0, 1, 1, 8, 13, 0);
//		rand = (int) ((Math.random() * tiles.size()));
//		tiles.get(rand).setPosition(8, 13, 0);
//		layer0.get(8).add(tiles.get(rand));
//		searchTiles.add(tiles.get(rand));
//		tiles.remove(rand);
//		num++;
//
		randomizerAssigner(layer0, 1, 1, 8, 14, 0);
//		rand = (int) ((Math.random() * tiles.size()));
//		tiles.get(rand).setPosition(8, 14, 0);
//		layer0.get(8).add(tiles.get(rand));
//		searchTiles.add(tiles.get(rand));
//		tiles.remove(rand);
//		num++;
		System.out.println(num);
	}

}
