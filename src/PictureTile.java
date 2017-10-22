import java.awt.*;

public class PictureTile extends Tile{
    private String name;

    public PictureTile(String name){
        super();
        this.name = name;
        setToolTipText(toString());
    }


    public String toString() {
        return name;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = getToolkit().getImage(getClass().getResource("images/" + name + ".png"));
        g.drawImage(img, 15,15,40,40, this);
    }
}
