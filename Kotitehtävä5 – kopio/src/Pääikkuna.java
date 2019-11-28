import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.event.*;
import java.sql.*;

import javax.swing.JButton;



public class Pääikkuna extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model; 
	private String SQL; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pääikkuna frame = new Pääikkuna();
					frame.setResizable(false);
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
	public Pääikkuna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LuoTaulu();
		uusiTaulu(model, table);
	
		
		JButton btnNewButton = new JButton("Lis\u00E4ys ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lisäysikkuna Aa = new Lisäysikkuna();
				Aa.setVisible(true);
				System.out.println(Aa.getPPaikka());
			}		
		});			 
		btnNewButton.setBounds(29, 251, 135, 70);
		contentPane.add(btnNewButton);
		
		JButton btnPoisto = new JButton("Poisto");
		btnPoisto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Poisto(model, table);
			}		
		});
		btnPoisto.setBounds(243, 251, 135, 70);
		contentPane.add(btnPoisto);
		
		JButton btnPivitys = new JButton("P\u00E4ivitys");
		btnPivitys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable(model, table);
			}
		});
		btnPivitys.setBounds(445, 251, 135, 70);
		contentPane.add(btnPivitys);
	}
	
	public void LuoTaulu() {
		String [] KolumnienNimet = {"Pelaajan nimi", "Pelaajan pelipaikka", "Pelaajan pelinumero"};
		model = new DefaultTableModel(KolumnienNimet, 0);
		contentPane.setLayout(null);
		table = new JTable(model);
		table.setBorder(null);
		table.setDefaultEditor(Object.class, null);
		table.setBounds(0, 0, 388, 295);
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(null);
		sp.setBounds(0, 0, 614, 209);
		contentPane.add(sp);
		
		  
	}
	
	public void uusiTaulu(DefaultTableModel model, JTable table) {
		 try {			 
			   String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7311114";
	              String USERID = "sql7311114";
	              String PASSWORD = "xi3Lf6E5Iz";
			  
			  SQL = "SELECT * FROM Pelaajat";
			  System.out.print(SQL);
			
			  Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			  System.out.println("Yhteys tietokantaan on luotu.");
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery(SQL);
			  
			  while (rs.next()) {
				  	model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3)});
			  }
			  con.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public void Poisto(DefaultTableModel model, JTable table) {
		String loikka = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()); 
		SQL = "DELETE FROM Pelaajat WHERE PelaajaNimi = '" + loikka + "' OR PeliPaikka = '" + loikka + "' OR PeliNumero = '" + loikka + "';"; 
		
		 try {			 
			   String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7311114";
	              String USERID = "sql7311114";
	              String PASSWORD = "xi3Lf6E5Iz";
			
			  Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			 
			  System.out.println("Yhteys tietokantaan on luotu.");
			  
			  Statement state = con.createStatement();
			  int tulos = state.executeUpdate(SQL);
			  
			  model.removeRow(table.getSelectedRow());
			  con.close();
		  } 
		  catch (SQLException e1) {
		 	System.out.println("Virhe tietokannan käytössä!");
		 	System.out.println(e1);
		  } 
	}

	public void updateTable(DefaultTableModel model, JTable table) {
		// TODO Auto-generated method stub
		 try {			 
			   String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7311114";
	              String USERID = "sql7311114";
	              String PASSWORD = "xi3Lf6E5Iz";
			  
			  SQL = "SELECT * FROM Pelaajat";
			
			  Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			  System.out.println("Yhteys tietokantaan on luotu.");
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery(SQL);
			  int muuttuja = 0; 
			  
			  while (rs.next()) {
				  if (rs.getRow() > model.getRowCount()) {
				  System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));
				  	model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3)});
			  }
				  else {
					 table.setValueAt(rs.getString(1), muuttuja, 0);
					 table.setValueAt(rs.getString(2), muuttuja, 1);
					 table.setValueAt(rs.getString(3), muuttuja, 2);
					 muuttuja++;
				  }
			  }
			  con.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
}
