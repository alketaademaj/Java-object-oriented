import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Lisäysikkuna extends JFrame {

	private JPanel contentPane;
	private JTextField PNimi;
	private JTextField PPaikka;
	private JTextField PNro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lisäysikkuna frame = new Lisäysikkuna();
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
	public Lisäysikkuna() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PNimi = new JTextField();
		PNimi.setBounds(25, 32, 380, 22);
		contentPane.add(PNimi);
		PNimi.setColumns(10);
		
		PPaikka = new JTextField();
		PPaikka.setBounds(25, 95, 380, 22);
		contentPane.add(PPaikka);
		PPaikka.setColumns(10);
		
		PNro = new JTextField();
		PNro.setBounds(25, 156, 380, 22);
		contentPane.add(PNro);
		PNro.setColumns(10);
		
		JButton Add = new JButton("Lis\u00E4\u00E4");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {			 
					   String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7311114";
			              String USERID = "sql7311114";
			              String PASSWORD = "xi3Lf6E5Iz";
					
					  Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
					 
					  System.out.println("Yhteys tietokantaan on luotu.");
					  String pNimi = PNimi.getText();
					  String pPaikka = PPaikka.getText();
					  String pNro = PNro.getText();
					  int PNRo = Integer.parseInt(pNro);
					  String SQL = "INSERT INTO Pelaajat VALUES ('"+pNimi+"','"+pPaikka+"','"+PNRo+"')";
					
					Statement stmt = con.createStatement();
					  int results = stmt.executeUpdate(SQL);
					  con.close();
					  System.out.println("Update Affected " + results + " rows.");
					  Component component = (Component)e.getSource();
					  Window window = SwingUtilities.windowForComponent(component);
					  window.dispose();
					  
				  } 
				  catch (SQLException e1) {
				 	System.out.println("Virhe tietokannan käytössä!");
				 	System.out.println(e1);
				  } // catch
			}
		});
		Add.setBounds(144, 203, 97, 25);
		contentPane.add(Add);
		
		JLabel lblPelaajanNimi = new JLabel("Pelaajan nimi:");
		lblPelaajanNimi.setBounds(144, 13, 119, 16);
		contentPane.add(lblPelaajanNimi);
		
		JLabel lblPelaajanPelipaikka = new JLabel("Pelaajan pelipaikka:");
		lblPelaajanPelipaikka.setBounds(144, 67, 119, 16);
		contentPane.add(lblPelaajanPelipaikka);
		
		JLabel lblPelaajanPelinro = new JLabel("Pelaajan pelinro:");
		lblPelaajanPelinro.setBounds(144, 127, 119, 16);
		contentPane.add(lblPelaajanPelinro);
	}

	public JTextField getPNimi() {
		return PNimi;
	}

	public void setPNimi(JTextField pNimi) {
		PNimi = pNimi;
	}

	public JTextField getPPaikka() {
		return PPaikka;
	}

	public void setPPaikka(JTextField pPaikka) {
		PPaikka = pPaikka;
	}

	public JTextField getPNro() {
		return PNro;
	}

	public void setPNro(JTextField pNro) {
		PNro = pNro;
	}
}
