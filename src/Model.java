import java.util.ArrayList;

public class Model {

	private static ArrayList<ArrayList<Tile>> layer0 = new ArrayList<ArrayList<Tile>>();
	private static ArrayList<ArrayList<Tile>> layer1 = new ArrayList<ArrayList<Tile>>();
	private static ArrayList<ArrayList<Tile>> layer2 = new ArrayList<ArrayList<Tile>>();
	private static ArrayList<ArrayList<Tile>> layer3 = new ArrayList<ArrayList<Tile>>();
	private static ArrayList<ArrayList<Tile>> layer4 = new ArrayList<ArrayList<Tile>>();

	public Model (ArrayList<Tile> tiles) {
		ArrayList<Tile> tile = new ArrayList<Tile>(tiles);
		randomizeTiles(tile);
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

	private void randomizeTiles(ArrayList<Tile> tiles) {
		int rand;
		rand = (int) ((Math.random() * tiles.size()));
		layer4.add(new ArrayList<>());
		layer4.get(0).add(tiles.get(rand));
//		layer4.add(tiles.get(rand));
		tiles.remove(rand);

		for (int i = 0; i < 2; i++) {
			layer3.add(new ArrayList<>());
			for (int x = 0; x < 2; x++) {
				rand = (int) ((Math.random() * tiles.size()));
				tiles.get(rand).setPosition(i+3, x+6, 3);
				layer3.get(i).add(tiles.get(rand));
				tiles.remove(rand);
			}
		}

		for (int i = 0; i < 4; i++) {
			layer2.add(new ArrayList<>());
			for (int x = 0; x < 4; x++) {
				rand = (int) ((Math.random() * tiles.size()));
				tiles.get(rand).setPosition(i+2, x+5, 2);
				layer2.get(i).add(tiles.get(rand));
				tiles.remove(rand);
			}
		}

		for (int i = 0; i < 6; i++) {
			layer1.add(new ArrayList<>());
			for (int x = 0; x < 6; x++) {
				rand = (int) ((Math.random() * tiles.size()));
				tiles.get(rand).setPosition(i+1, x+4, 1);
				layer1.get(i).add(tiles.get(rand));
				tiles.remove(rand);
			}
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 12; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(0, i+1, 0);
			layer0.get(0).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 8; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(1, i+3, 0);
			layer0.get(1).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 10; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(2, i+2, 0);
			layer0.get(2).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 12; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(3, i+1, 0);
			layer0.get(3).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 12; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(4, i+1, 0);
			layer0.get(4).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 10; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(5, i+2, 0);
			layer0.get(5).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 8; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(6, i+3, 0);
			layer0.get(6).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		for (int i = 0; i < 12; i++) {
			rand = (int) ((Math.random() * tiles.size()));
			tiles.get(rand).setPosition(7, i+1, 0);
			layer0.get(7).add(tiles.get(rand));
			tiles.remove(rand);
		}

		layer0.add(new ArrayList<>());
		rand = (int) ((Math.random() * tiles.size()));
		tiles.get(rand).setPosition(8, 0, 0);
		layer0.get(8).add(tiles.get(rand));
		tiles.remove(rand);

		rand = (int) ((Math.random() * tiles.size()));
		tiles.get(rand).setPosition(8, 13, 0);
		layer0.get(8).add(tiles.get(rand));
		tiles.remove(rand);

		rand = (int) ((Math.random() * tiles.size()));
		tiles.get(rand).setPosition(8, 14, 0);
		layer0.get(8).add(tiles.get(rand));
		tiles.remove(rand);
	}

	//	public Tile getTile(int x, int y, int z) {
//		for (Tile t :tiles) {
//			if (t.getRow() == x && t.getColumn() == y && t.getLayer() == z)
//				return t;
//		}
//		return null;
//	}

//	public boolean isTileOpen(Tile t) {
//
//	}
}
