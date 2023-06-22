package myfirstGUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyFirstGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First GUI");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(450, 200);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setVisible(true);
	}
	private static void placeComponents(JPanel panel)
	{
		panel.setLayout(null);
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		JTextField usertext = new JTextField(10);
		usertext.setBounds(100, 20, 160, 25);
		panel.add(usertext);
		
		JLabel userLabel1 = new JLabel("Password");
		userLabel1.setBounds(10, 55, 80, 25);
		panel.add(userLabel1);
		
		JPasswordField passtext = new JPasswordField(30);
		passtext.setBounds(100, 55, 80, 25);
		panel.add(passtext);
		
		JButton login = new JButton("login");
		login.setBounds(100, 90, 80, 25);
		panel.add(login);
		
		
	}

}
