import javax.swing.*;
public class Notes {
	JFrame frame;
	JTextArea text;
	public Notes(String out,String hash) {
		frame = new JFrame(hash);
		text = new JTextArea();
		frame.setSize(300, 400);
		text.setText(out);
		text.setSize(200, 300);
		frame.add(text);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
