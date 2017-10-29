import java.awt.*;

public class WhiteDragonTile extends Tile {

    public static int outside;
    public static int inside;

    static {
        outside = 40;
        inside = 30;
    }
    public WhiteDragonTile(){
        super();
        setToolTipText(toString());
    }
    public String toString() {
        return "White Dragon";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(side + 5, side*2 + 5, 5,5);
        g.fillRect(side + 5 +10, side*2 + 5, 5,5);
        g.fillRect(side + 5 + 20, side*2 + 5, 5,5);
        g.fillRect(side + 5 + 30, side*2 + 5, 5,5);

        g.fillRect(side + 5 + 35, side*2 + 5 + 5, 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 15, 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 25, 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 35, 5, 5);

        g.fillRect(side + 5 + 25, side*2 + 5 + 35, 5, 5);
        g.fillRect(side + 5 + 15, side*2 + 5 + 35, 5, 5);
        g.fillRect(side + 5 + 5, side*2 + 5 + 35, 5, 5);

        g.fillRect(side + 5, side*2 + 5 + 30, 5, 5);
        g.fillRect(side + 5, side*2 + 5 + 20, 5, 5);
        g.fillRect(side + 5, side*2 + 5 + 10, 5, 5);

        g. setColor(Color.white);
        g.fillRect(side + 5 + 5, side*2 + 5, 5,5);
        g.fillRect(side + 5 + 15, side*2 + 5, 5,5);
        g.fillRect(side + 5 + 25, side*2 + 5, 5,5);
        g.fillRect(side + 5 + 35, side*2 + 5, 5,5);

        g.fillRect(side + 5 + 35, side*2 + 5 , 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 10, 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 20, 5, 5);
        g.fillRect(side + 5 + 35, side*2 + 5 + 30, 5, 5);

        g.fillRect(side + 5 + 30, side*2 + 5 + 35, 5, 5);
        g.fillRect(side + 5 + 20, side*2 + 5 + 35, 5, 5);
        g.fillRect(side + 5 + 10, side*2 + 5 + 35, 5, 5);
        g.fillRect(side + 5, side*2 + 5 + 35, 5, 5);

        g.fillRect(side + 5, side*2 + 5 + 25, 5, 5);
        g.fillRect(side + 5, side*2 + 5 + 15, 5, 5);
        g.fillRect(side + 5, side*2 + 5 + 5, 5, 5);

        g.setColor(Color.black);
        g.drawRect(side + 5, side*2 + 5, outside, outside);
        g.drawRect(side + 10, side*2 + 10, inside, inside);
    }
}
