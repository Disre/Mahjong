import java.awt.*;
import javax.swing.*;

public class Mahjong extends JFrame {

	public Mahjong() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Mahjong");
		setSize(1200,800);
		setResizable(false);
		add(new Board());
		setVisible(true);
	}

	public static void main(String[] args) {
		new Mahjong();
	}
}
