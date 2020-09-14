import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

public class Versiotiedot extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeiItsYour;
	private JTextField txtWithLoveAlketa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versiotiedot frame = new Versiotiedot();
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
	public Versiotiedot() {
		setTitle("Versiotiedot");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHeiItsYour = new JTextField();
		txtHeiItsYour.setBorder(null);
		txtHeiItsYour.setDisabledTextColor(Color.BLACK);
		txtHeiItsYour.setEnabled(false);
		txtHeiItsYour.setEditable(false);
		txtHeiItsYour.setText("Hey, it's your girl Alqaida. Hope this task blows your mind away.\r\n");
		txtHeiItsYour.setBounds(12, 35, 408, 72);
		contentPane.add(txtHeiItsYour);
		txtHeiItsYour.setColumns(10);
		
		txtWithLoveAlketa = new JTextField();
		txtWithLoveAlketa.setDisabledTextColor(Color.BLACK);
		txtWithLoveAlketa.setEnabled(false);
		txtWithLoveAlketa.setEditable(false);
		txtWithLoveAlketa.setBorder(null);
		txtWithLoveAlketa.setText("With Love: Alketa");
		txtWithLoveAlketa.setBounds(163, 161, 116, 22);
		contentPane.add(txtWithLoveAlketa);
		txtWithLoveAlketa.setColumns(10);
	}

}
