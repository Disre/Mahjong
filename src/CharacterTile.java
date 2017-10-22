import java.awt.*;
import javax.swing.*;

public class CharacterTile extends Tile {
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
		g.drawString(String.valueOf(this.symbol),45,15);
		if (Character.isDigit(this.symbol)) {
			g.setFont(new Font("Roman", 3, getWidth()/2));
			g.drawString("\u842C", 16,65);
			g.setColor(Color.black);
			g.setFont(new Font("Roman", 3, getWidth()/4));
			switch (this.symbol) {
				case '1':
					g.drawString("\u4E00", 25,30);
					break;

				case '2':
					g.drawString("\u4E8C", 25,30);
					break;

				case '3':
					g.drawString("\u4E09", 25,30);
					break;

				case '4':
					g.drawString("\u56DB", 25,30);
					break;

				case '5':
					g.drawString("\u4E94", 25,30);
					break;

				case '6':
					g.drawString("\u516D", 25,30);
					break;

				case '7':
					g.drawString("\u4E03", 25,30);
					break;

				case '8':
					g.drawString("\u516B", 25,30);
					break;

				case '9':
					g.drawString("\u4E5d", 25,30);
					break;
			}
		} else {
			g.setColor(Color.black);
			g.setFont(new Font("Roman", 3, getWidth()-20));
			switch (this.symbol) {

				case 'N':
					g.drawString("\u5317", 7,60);
					break;

				case 'E':
					g.drawString("\u6771", 7,60);
					break;

				case 'W':
					g.drawString("\u897F", 7,60);
					break;

				case 'S':
					g.drawString("\u5357", 7,60);
					break;

				case 'C':
					g.setColor(Color.RED);
					g.drawString("\u4E2D", 7,60);
					break;

				case 'F':
					g.setColor(Color.green);
					g.drawString("\u767C", 7,60);
					break;
			}
		}
	}
}
