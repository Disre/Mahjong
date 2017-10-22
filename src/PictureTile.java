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
        g.drawImage(img, side + width/10,height/5,(width/5)*4,(width/5)*4, this);
    }
}
