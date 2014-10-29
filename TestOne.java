import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;
public class TestOne implements ActionListener{
	JPanel panel;
	JFrame frame;
	JButton[] hashtags;
	ArrayList<note> list;
	public TestOne() {
		
		try {
			FileInputStream fileIn = new FileInputStream("notes.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			list = (ArrayList<note>)in.readObject();
			in.close();
			fileIn.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Nothing to show");
			
		}
		ArrayList<String> hashTags = new ArrayList<String>();
		for(note n: list) {
			for(String hash: n.hash) {
				if(!hashTags.contains(hash)) {
					hashTags.add(hash);
				}
			}
		}
		panel = new JPanel();
		frame = new JFrame("Hashtags");
		frame.setSize(600, 800);
		hashtags = new JButton[hashTags.size()];
		for( int i = 0; i < hashTags.size(); i++) {
			hashtags[i] = new JButton(hashTags.get(i));
			panel.add(hashtags[i]);
			hashtags[i].addActionListener(this);
		}
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton temp = (JButton)ae.getSource();
		String name = temp.getText();
		String out = "";
		for(note n: list) {
			for(int i = 0; i < n.hash.length; i++) {
				if(n.hash[i].equals(name)) {
					out= out + n.text + "\n ___________________ \n";
				}
			}
		}
		new Notes(out,name);
	}
	public static void main(String args[]) throws Exception
	{
		new TestOne();

	}
}
