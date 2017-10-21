import java.awt.*;
import javax.swing.JPanel;

public class Tile extends JPanel {

    public Tile() {
        setPreferredSize(new Dimension(50 + 10, 75 + 10));
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
        super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    GradientPaint grad = new GradientPaint( 0,75, Color.decode("#FDF5E6"),50,0, Color.decode("#CDBA96"));
	    g2.setPaint(grad);
	    g.fillRect(10, 0, 50, 75);


        Polygon p1 = new Polygon();
        p1.addPoint(10,0);
	    p1.addPoint(10,75);
	    p1.addPoint(5,80);
	    p1.addPoint(5,5);


        Polygon p2 = new Polygon();
	    p2.addPoint(5,5);
	    p2.addPoint(0,10);
	    p2.addPoint(0,85);
	    p2.addPoint(5,80);


	    Polygon p3 = new Polygon();
	    p3.addPoint(60,75);
	    p3.addPoint(55,80);
	    p3.addPoint(5,80);
	    p3.addPoint(10,75);
	    p3.addPoint(60,75);
	    p3.addPoint( 60,0);


	    Polygon p4 = new Polygon();
	    p4.addPoint(55,80);
	    p4.addPoint(50,85);
	    p4.addPoint(0,85);
	    p4.addPoint(5,80);


	    grad = new GradientPaint( 0,75, Color.decode("#FDF5E6"),5,0, Color.decode("#CDBA96"));
	    g2.setPaint(grad);
		g.fillPolygon(p1);

	    grad = new GradientPaint( 0,5, Color.decode("#FDF5E6"),60,0, Color.decode("#CDBA96"));
	    g2.setPaint(grad);
		g.fillPolygon(p3);

	    grad = new GradientPaint( 0,75, Color.decode("#FF8C00"),5,0, Color.decode("#8B4500"));
	    g2.setPaint(grad);
	    g.fillPolygon(p2);

	    grad = new GradientPaint( 0,5, Color.decode("#FF8C00"),60,0, Color.decode("#8B4500"));
	    g2.setPaint(grad);
	    g.fillPolygon(p4);

	    g2.setPaint(Color.black);
	    g.drawPolygon(p1);
	    g.drawPolygon(p2);
	    g.drawPolygon(p3);
	    g.drawPolygon(p4);
	    g.drawRect(10, 0, 50, 75);

    }
}

