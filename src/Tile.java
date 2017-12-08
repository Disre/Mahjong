import java.awt.*;
import javax.swing.JPanel;

public class Tile extends JPanel {

	private int row;
	private int column;
	private int layer;

	protected static int height;
	protected static int width;
	protected static int side;
	private static GradientPaint main;
	private static GradientPaint left;
	private static GradientPaint bottom;
	private static GradientPaint left2;
	private static GradientPaint bottom2;
	private static Polygon p1;
	private static Polygon p2;
	private static Polygon p3;
	private static Polygon p4;

	static {
		height = 75;
		width = 50;
		side = 10;
		main = new GradientPaint( 0,75, Color.decode("#FDF5E6"),50,0, Color.decode("#CDBA96"));
		left = new GradientPaint( 0,75, Color.decode("#FDF5E6"),5,0, Color.decode("#CDBA96"));
		bottom = new GradientPaint( 0,5, Color.decode("#FDF5E6"),60,0, Color.decode("#CDBA96"));
		left2 = new GradientPaint( 0,75, Color.decode("#FF8C00"),5,0, Color.decode("#8B4500"));
		bottom2 = new GradientPaint( 0,5, Color.decode("#FF8C00"),60,0, Color.decode("#8B4500"));

		p1 = new Polygon();
		p1.addPoint(10,0);
		p1.addPoint(10,75);
		p1.addPoint(5,80);
		p1.addPoint(5,5);

		p2 = new Polygon();
		p2.addPoint(5,5);
		p2.addPoint(0,10);
		p2.addPoint(0,85);
		p2.addPoint(5,80);

		p3 = new Polygon();
		p3.addPoint(60,75);
		p3.addPoint(55,80);
		p3.addPoint(5,80);
		p3.addPoint(10,75);
		p3.addPoint(60,75);
		p3.addPoint( 60,0);

		p4 = new Polygon();
		p4.addPoint(55,80);
		p4.addPoint(50,85);
		p4.addPoint(0,85);
		p4.addPoint(5,80);
	}

    public Tile() {
        setPreferredSize(new Dimension(width + side, height + side));
    }

    public boolean matches(Tile other) {
//        if (this == other)
//            return true;
//        if (other == null)
//            return false;
        if (getClass() == other.getClass())
            return true;
        else
            return false;
    }

    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(main);
	    g.fillRect(side, 0, width, height);

	    g2.setPaint(left);
		g.fillPolygon(p1);

	    g2.setPaint(bottom);
		g.fillPolygon(p3);

	    g2.setPaint(left2);
	    g.fillPolygon(p2);

	    g2.setPaint(bottom2);
	    g.fillPolygon(p4);

	    g2.setPaint(Color.black);
	    g.drawPolygon(p1);
	    g.drawPolygon(p2);
	    g.drawPolygon(p3);
	    g.drawPolygon(p4);
	    g.drawRect(side, 0, width, height);

    }

    public void setPosition(int row, int column, int layer) {
	    this.column = column;
	    this.row = row;
	    this.layer = layer;
    }

//    public void setRow(int y) {
//		this.y = y;
//    }
//
//	public void setColumn(int x) {
//		this.x = x;
//	}
//
//	public void setLayer(int z) {
//		this.z = z;
//	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getLayer() {
		return layer;
	}
}

