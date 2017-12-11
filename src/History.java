import javax.swing.*;
import java.awt.*;
import java.util.*;

public class History extends JScrollPane {

	private static Dimension size = new Dimension(Tile.width + Tile.side * 2, Tile.height + Tile.side);

	private JPanel[] discarded = new JPanel[2];
	private Stack<Tile> undo = new Stack<>();

	private int width = Tile.width + Tile.side;
	private int height = Tile.height + Tile.side + 6;
	private int count = 0;

	public History() {

		setLocation(-2,-2);
		setPreferredSize(new Dimension(2 * width + 10 + 20, 700));
		setSize(new Dimension(2 * width + 10+10, 700));
		setBorder(BorderFactory.createRaisedBevelBorder());


		for (int i = 0; i < 2; i++) {
			discarded[i] = new JPanel(new FlowLayout((FlowLayout.CENTER)));
			discarded[i].setPreferredSize(new Dimension(width, 0));
//			discarded[i].setBorder(new EmptyBorder(5,5,5,5));
			discarded[i].setBackground(Color.decode("#5581bc"));
		}
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		JPanel panel = new JPanel(new BorderLayout());
		setViewportView(panel);

		panel.add(discarded[0], BorderLayout.WEST);
		panel.add(discarded[1], BorderLayout.EAST);

		panel.setBackground(Color.decode("#5581bc"));
	}

	public void add(Tile t, Tile t2) {
		PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
		clip.play();

		t.isSelected(false);
		t.setPlay(false);
		t2.setPlay(false);
		undo.push(t);
		undo.push(t2);

		Dimension size = (new Dimension(width + 6, ++count * height));
		discarded[0].setPreferredSize(size);
		discarded[1].setPreferredSize(size);

		discarded[0].add(t, 0);
		discarded[1].add(t2, 0);

		revalidate();
		repaint();
	}

	public Tile[] undo() {
		if (undo.size() != 0) {
			Tile[] undid = new Tile[2];

			undid[1] = undo.pop();
			undid[0] = undo.pop();

			Dimension size = (new Dimension(width + 6, --count * height));
			discarded[0].setPreferredSize(size);
			discarded[1].setPreferredSize(size);

			discarded[0].remove(undid[0]);
			discarded[1].remove(undid[1]);

			revalidate();
			repaint();
			return undid;
		}
		return null;
	}

	public int getCount() {
		return undo.size();
	}

}
