import java.awt.*;

public class CircleTile extends RankTile {

    private static int big;
    private static int sDiameter;
    private static int mDiameter;
    private static int bDiameter;

    private static int x1; //case 2
    private static int x2; //case 3, 5
    private static int x3; //case 3, 4, 5, 6
    private static int x4; //case 3, 4, 5, 6
    private static int x5;
    private static int x6;
    private static int x7;
    private static int x8;
    private static int x9;
    private static int x10;
    private static int x11;

    private static int y1; //case 2
    private static int y2; //case 2
    private static int y3; //case 3, 5, 6
    private static int y4; //case 3, 5, 6
    private static int y5; //case 3, 5, 6
    private static int y6;
    private static int y7;
    private static int y8;
    private static int y9;
    private static int y10;
    private static int y11;
    private static int y12;
    private static int y13;
    private static int y14;
    private static int y15;
    private static int y16;
    private static int y17;
    private static int y18;
    private static int y19;



    static {
        big = width/10*8;
        sDiameter = height/5;
        mDiameter = height/7*2;
        bDiameter = height/3;

        x1 = side + width/2 - bDiameter/2;
        x2 = side + width/2 - mDiameter/2;
        x3 = side + mDiameter/5;
        x4 = side + width - mDiameter/5*6;
        x5 = side + width/2 - sDiameter/2;
        x6 = side + width/2 + sDiameter/4*3;
        x7 = side + width/2 - sDiameter/4*8;
        x8 = side + sDiameter/2;
        x9 = side + width - sDiameter/2*3;
        x10 = side + width - sDiameter - 1;
        x11 = side + 1;

        y1 = height/4 - bDiameter/3;
        y2 = height - height/4 - bDiameter/3 * 2;
        y3 = height/2 - mDiameter/2;
        y4 = mDiameter/4;
        y5 = height - mDiameter/4*5;
        y6 = mDiameter/4*3;
        y7 = height - mDiameter - mDiameter/4*3;
        y8 = height/4 - sDiameter/2;
        y9 = height/4;
        y10 = height/4 - sDiameter;
        y11 = height/2;
        y12 = height - sDiameter/2*3;
        y13 = height/25;
        y14 = height/25*2 + sDiameter;
        y15 = height/25*3 + sDiameter*2;
        y16 = height/25*4 + sDiameter*3;
        y17 = 30/4;
        y18 = height/2 - sDiameter/2;
        y19 = height - sDiameter - 30/4;
    }

    public CircleTile(int rank){
        super(rank);
    }

    public String toString() {
        return "Circle " + Integer.toString(rank);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch(rank){
            case 1:
                drawPancake(g, Color.decode("#008000"), big, side + width/2 - big/2, height/2-big/2);
                break;
            case 2:
                drawCircle(g, Color.decode("#008000"), bDiameter, x1, y1);
                drawCircle(g, Color.blue, bDiameter, x1, y2);
                break;
            case 3:
                drawCircle(g, Color.red, mDiameter, x2, y3);
                drawCircle(g, Color.blue, mDiameter, x3, y4);
                drawCircle(g, Color.decode("#008000"), mDiameter, x4, y5);
                break;
            case 4:
                drawCircle(g, Color.blue, mDiameter, x3, y6);
                drawCircle(g, Color.blue, mDiameter, x4, y7);
                drawCircle(g, Color.decode("#008000"), mDiameter, x3, y7);
                drawCircle(g, Color.decode("#008000"), mDiameter, x4, y6);
                break;
            case 5:
                drawCircle(g, Color.red, mDiameter, x2, y3);
                drawCircle(g, Color.blue, mDiameter, x3, y4);
                drawCircle(g, Color.blue, mDiameter, x4, y5);
                drawCircle(g, Color.decode("#008000"), mDiameter, x3, y5);
                drawCircle(g, Color.decode("#008000"), mDiameter, x4, y4);
                break;
            case 6:
                drawCircle(g, Color.decode("#008000"), mDiameter, x3, y4);
                drawCircle(g, Color.decode("#008000"), mDiameter, x4, y4);

                drawCircle(g, Color.red, mDiameter, x3, y3);
                drawCircle(g, Color.red, mDiameter, x4, y3);

                drawCircle(g, Color.red, mDiameter, x3, y5);
                drawCircle(g, Color.red, mDiameter, x4, y5);
                break;
            case 7:
                drawCircle(g, Color.decode("#008000"), sDiameter, x5, y8);
                drawCircle(g, Color.decode("#008000"), sDiameter, x6, y9);
                drawCircle(g, Color.decode("#008000"), sDiameter, x7, y10);

                drawCircle(g, Color.red, sDiameter, x8, y11);
                drawCircle(g, Color.red, sDiameter, x9, y11);

                drawCircle(g, Color.red, sDiameter, x8, y12);
                drawCircle(g, Color.red, sDiameter, x9, y12);
                break;
            case 8:
                drawCircle(g, Color.blue, sDiameter, x8, y13);
                drawCircle(g, Color.blue, sDiameter, x9, y13);

                drawCircle(g, Color.blue, sDiameter, x8, y14);
                drawCircle(g, Color.blue, sDiameter, x9, y14);

                drawCircle(g, Color.blue, sDiameter, x8, y15);
                drawCircle(g, Color.blue, sDiameter, x9, y15);

                drawCircle(g, Color.blue, sDiameter, x8, y16);
                drawCircle(g, Color.blue, sDiameter, x9, y16);
                break;
            case 9:
                drawCircle(g, Color.decode("#008000"), sDiameter, x10, y17);
                drawCircle(g, Color.decode("#008000"), sDiameter, x5, y17);
                drawCircle(g, Color.decode("#008000"), sDiameter, x11, y17);

                drawCircle(g, Color.red, sDiameter, x10, y18);
                drawCircle(g, Color.red, sDiameter, x5, y18);
                drawCircle(g, Color.red, sDiameter, x11, y18);

                drawCircle(g, Color.blue, sDiameter, x10, y19);
                drawCircle(g, Color.blue, sDiameter, x5, y19);
                drawCircle(g, Color.blue, sDiameter, x11, y19);
                break;
        }
    }

    protected static void drawCircle(Graphics g, Color c, int diameter, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(c);
        g.fillOval(x,y,diameter,diameter);
        g.setColor(Color.white);
        g.fillOval(x + diameter/2 - diameter/4, y + diameter/2 - diameter/4, diameter/2, diameter/2);
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        g.drawOval(x, y, diameter, diameter);
        g.drawOval(x + diameter/2 - diameter/4, y + diameter/2 - diameter/4, diameter/2, diameter/2);

    }

    protected static void drawPancake(Graphics g, Color c, int diameter, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(c);
        g.fillOval(x,y,diameter,diameter);
        g.setColor(Color.red);
        g.fillOval(x + diameter/2 - diameter/4, y + diameter/2 - diameter/4, diameter/2, diameter/2);
        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, 0));
        g.setColor(Color.white);
        g.drawOval(x + diameter/6, y + diameter/6, diameter/12*9, diameter/12*9);
    }
}
