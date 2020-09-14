import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Celcius extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField JTextField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Celcius frame = new Celcius();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Celcius() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField teksti = new JTextField();
		teksti.setBounds(12, 172, 243, 68);
		contentPane.add(teksti);
		teksti.setColumns(10);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.setBounds(267, 170, 153, 70);
		contentPane.add(btnNewButton);
			
		JTextField  tekaistu = new JTextField();
		tekaistu.setBounds(12, 13, 243, 143);
		contentPane.add(tekaistu);
		tekaistu.setColumns(10);
		tekaistu.setEditable(false);
		
		 btnNewButton.addActionListener(new ActionListener() {  // Clear
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String converter = teksti.getText();
				 try {
					 int nmbr = Integer.parseInt(converter.trim()); 
					 double result = nmbr*9/5+32;
					 String finalResult = Double.toString(result);
					 tekaistu.setText(finalResult);
				 }
				 
				 catch (Exception a) {
					 tekaistu.setText("Wrong input!");
				 }
			}}); 

	}
}
