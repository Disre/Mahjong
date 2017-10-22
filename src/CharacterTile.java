import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterTile extends Tile {

	private static Font chinese;
	private static Font big;
	private static Map<String, String> numbers = new HashMap<String, String>();
	private static Map<String, String> winds = new HashMap<String, String>();
	static {
		chinese = new Font("Roman", 3, width/2);
		big = new Font("Roman", 3, (width/6)*5);

		numbers.put("1","\u4E00");
		numbers.put("2","\u4E8C");
		numbers.put("3","\u4E09");
		numbers.put("4","\u56DB");
		numbers.put("5","\u4E94");
		numbers.put("6","\u516D");
		numbers.put("7","\u4E03");
		numbers.put("8","\u516B");
		numbers.put("9","\u4E5D");
		winds.put("N", "\u5317");
		winds.put("E", "\u6771");
		winds.put("W", "\u897F");
		winds.put("S", "\u5357");
		winds.put("C", "\u4E2D");
		winds.put("F", "\u767C");
	}
	protected char symbol;

	public CharacterTile(char symbol) {
		super();
		this.symbol = symbol;
		setToolTipText(toString());
	}

	public boolean matches(Tile other) {
		CharacterTile otherTile = (CharacterTile) other;
		return super.matches(other) && this.symbol == otherTile.symbol;
	}

	@Override
	public String toString() {
		if (Character.isDigit(this.symbol))
			return "Character " + this.symbol;
		else
			switch (this.symbol) {
				case 'N':
					return "North Wind";

				case 'E':
					return "East Wind";

				case 'W':
					return "West Wind";

				case 'S':
					return "South Wind";

				case 'C':
					return "Red Dragon";

				case 'F':
					return "Green Dragon";
			}
		return "oops";
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawString(String.valueOf(this.symbol),side + width - (width/4),height/6);
		if (numbers.containsKey(Character.toString(symbol))) {
			g.setFont(chinese);
			g.drawString("\u842C", side + width/5,height - (height/10));
			g.setColor(Color.black);
			g.drawString(numbers.get(Character.toString(symbol)), side + width/5,height/2);
		} else if (winds.containsKey(Character.toString(symbol))){
			g.setColor(Color.black);
			g.setFont(big);
			if (symbol == 'C')
				g.setColor(Color.RED);
			if (symbol == 'F')
				g.setColor(Color.decode("#008000"));
			g.drawString(winds.get(Character.toString((symbol))), side + width/20,(height/6)*5);
		}
	}

}
