import java.awt.*;

public class BambooTile extends RankTile {
    
    private static int h;
    private static int w;

    private static int x11; //center
    private static int x21; //2 columns 1st column
    private static int x22; //2 columns 1st column
    private static int x31; //3 columns 1st column
    private static int x33; //3 columns 3rd column
    private static int x6;
    private static int x7;
    private static int x8;
    private static int x9;
    private static int x10;

    private static int y11; //center
    private static int y21; // 2 rows 1st row
    private static int y22; // 2 rows 2nd row
    private static int y31; //3 rows 1st row
    private static int y33; //3 rows 2nd row
    private static int y6; //3 rows 3rd row
    private static int y7;
    private static int y8;
    private static int y9;
    private static int y10;

    static{
        h = ((height/10)*9)/3;
        w = width/5;

        x11 = side + width/2 - w/2;
        x21 = side + width/5;
        x22 = side + (width/5)*3;
        x31 = side + (width/10);
        x33 = side + (width/10)*7;

        y11 = height/2 - h/2;
        y21 = (height/10)*2;
        y22 = (height/10)*6;
        y31 = (height/15);
        y33 = (height/10)*7;

    }

    public BambooTile(int rank){
        super(rank);
    }

    public String toString() {
        return "Bamboo " + Integer.toString(rank);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (rank) {
            case 2:
                drawBamboo(g, Color.blue, x11, y21);
                drawBamboo(g, Color.decode("#008000"), x11, y22);
                break;
            case 3:
                drawBamboo(g, Color.blue, x11, y21);
                drawBamboo(g, Color.decode("#008000"), x21, y22);
                drawBamboo(g, Color.decode("#008000"), x22, y22);
                break;
            case 4:
                drawBamboo(g, Color.blue, x21, y21);
                drawBamboo(g, Color.decode("#008000"), x22, y21);
                drawBamboo(g, Color.decode("#008000"), x21, y22);
                drawBamboo(g, Color.blue, x22, y22);
                break;
            case 5:
                drawBamboo(g, Color.red, x11, y11);
                drawBamboo(g, Color.decode("#008000"), x31, y21);
                drawBamboo(g, Color.blue, x33, y21);
                drawBamboo(g, Color.blue, x31, y22);
                drawBamboo(g, Color.decode("#008000"), x33, y22);
                break;
            case 6:
                drawBamboo(g, Color.decode("#008000"), x31, y21);
                drawBamboo(g, Color.decode("#008000"), x11, y21);
                drawBamboo(g, Color.decode("#008000"), x33, y21);
                drawBamboo(g, Color.blue, x31, y22);
                drawBamboo(g, Color.blue, x11, y22);
                drawBamboo(g, Color.blue, x33, y22);
                break;
            case 7:
                drawBamboo(g, Color.red, x11, y31);

                drawBamboo(g, Color.decode("#008000"), x31, y11);
                drawBamboo(g, Color.blue, x11, y11);
                drawBamboo(g, Color.decode("#008000"), x33, y11);

                drawBamboo(g, Color.decode("#008000"), x31, y33);
                drawBamboo(g, Color.blue, x11, y33);
                drawBamboo(g, Color.decode("#008000"), x33, y33);
                break;
            case 8:
                drawBamboo(g, Color.decode("#008000"), x31, y31);
                drawBamboo(g, Color.decode("#008000"), x11, y31);
                drawBamboo(g, Color.decode("#008000"), x33, y31);

                drawBamboo(g, Color.red, x21, y11);
                drawBamboo(g, Color.red, x22, y11);

                drawBamboo(g, Color.blue, x31, y33);
                drawBamboo(g, Color.blue, x11, y33);
                drawBamboo(g, Color.blue, x33, y33);
                break;
            case 9:
                drawBamboo(g, Color.red, x31, y31);
                drawBamboo(g, Color.blue, x11, y31);
                drawBamboo(g, Color.decode("#008000"), x33, y31);

                drawBamboo(g, Color.red, x31, y11);
                drawBamboo(g, Color.blue, x11, y11);
                drawBamboo(g, Color.decode("#008000"), x33, y11);

                drawBamboo(g, Color.red, x31, y33);
                drawBamboo(g, Color.blue, x11, y33);
                drawBamboo(g, Color.decode("#008000"), x33, y33);
                break;
        }
    }

    protected static void drawBamboo(Graphics g, Color c, int x, int y)
    {
        g.setColor(c);
        g.fillRect(x+w/5,y,(w/5)*3,h);
        g.fillArc(x, y - (h/8), w, h/4, 180, 180);
        g.fillArc(x,y + h - (h/8), w, h/4, 0, 180);
        g.setColor(Color.white);
        g.fillRect(x + 5, y + 5, w/5, h/2);
    }
}

