import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
public class Adder implements ActionListener {
	JFrame frame;
	JButton submit;
	JTextField fileName;
	public Adder() {
		frame = new JFrame("Add");
		submit = new JButton("Submit");
		fileName = new JTextField("Enter path of image of a note");
		frame.setSize(300,400);
		frame.setLayout(new GridLayout(2,1));
		frame.add(fileName);
		frame.add(submit);

		submit.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent ae) {
		try
		{
			String file = fileName.getText();
			Runtime.getRuntime().exec( "tesseract " + file +" hello" );
			FileReader fr=new FileReader("hello.txt");
			BufferedReader st=new BufferedReader(fr);
			String line,temp = "";
			while(!(line = st.readLine()).equals("")) 
			{
				temp += line+"\n";

			}
			new note(temp);
		}
		catch(Exception E)
		{
			E.printStackTrace();

		}
		frame.setVisible(false);
		frame.dispose();
		System.exit(0);
	}
}
