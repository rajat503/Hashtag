import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
public class MainMenu implements ActionListener {
	JFrame frame;
	JButton add, view;
	public MainMenu() {
		frame = new JFrame("Main Menu");
		add = new JButton("Add");
		view = new JButton("View");
		add.addActionListener(this);
		view.addActionListener(this);
		frame.setLayout(new GridLayout(2,1));
		frame.add(add);
		frame.add(view);
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			new Adder();
			
		}
		else {
			new TestOne();
		}
	}
	public static void main(String args[])
	{
		new MainMenu();
	}
}