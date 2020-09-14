import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tekstiediittori {
	public static void main (String args[]) {
		JFrame frame = new JFrame("Texteditor");
		frame.setBackground(new Color(0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Frame dimentions
		frame.setSize(500,500);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.NORTH);
		
		//Icon in the button save
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(Tekstiediittori.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		toolBar.add(btnSave);
		
		//Icon in the button open
		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon(Tekstiediittori.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		toolBar.add(btnOpen);
		
		//Icon in the button cut
		JButton btnCut = new JButton("");
		btnCut.setIcon(new ImageIcon(Tekstiediittori.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		toolBar.add(btnCut);
		
		//The text area you can write in 
		JTextArea txtrEka = new JTextArea();
		txtrEka.setBackground(Color.WHITE);
		panel.add(txtrEka, BorderLayout.CENTER);
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnTiedosto = new JMenu("File");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmAvaa = new JMenuItem("Open");
		mnTiedosto.add(mntmAvaa);
		
		//Menu: Saves the file and opens a path to the computer to save the file 
		JMenuItem mntmTallenna = new JMenuItem("Save");
		mntmTallenna.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {                
                 JFileChooser fc = new JFileChooser();
                 fc.setDialogTitle("Save to a text file");
                 fc.setApproveButtonText("Save");
                 fc.setApproveButtonToolTipText("Save to a file");
                 fc.showOpenDialog(null);
                 String newFile = fc.getSelectedFile().getAbsolutePath();
                 File file = new File(newFile);
                 
                 try {
                     PrintWriter pw = new PrintWriter(file);
                     String content = txtrEka.getText();
                     pw.println(content);
                     
                     pw.flush();
                     pw.close();
                 }
                 catch (IOException e1) {
                 }
     } 
		});
		
		mnTiedosto.add(mntmTallenna);
		
		//Empties what you have typed to textfield 
		JMenuItem mntmTyhjenn = new JMenuItem("Empty");
		mntmTyhjenn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrEka.setText(null);
			}
		});
		mnTiedosto.add(mntmTyhjenn);
		
		//Closes the text editor
		JMenuItem mntmLopeta = new JMenuItem("End");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmLopeta);
		
		//Part of the menu
		JMenu mnMuokkaa = new JMenu("Edit");
		menuBar.add(mnMuokkaa);
		
		//Looks for an existing word in your file 
		JMenuItem mntmEtsi = new JMenuItem("Search");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String etsit‰‰n = txtrEka.getText();
				String lˆydet‰‰n = JOptionPane.showInputDialog(null, "What do you want to find? ");
				int x = etsit‰‰n.indexOf(lˆydet‰‰n);
				if(x != -1) {
				txtrEka.setSelectionStart(x);
				txtrEka.setSelectionEnd(x + lˆydet‰‰n.length());
				}
			
				else {
					JOptionPane.showMessageDialog(null, "There is no such word.", "error", JOptionPane.ERROR_MESSAGE);
				}
			}});
		
		mnMuokkaa.add(mntmEtsi);
		
		//Looks for an existing word and asks you with what word would you like to replace it 
		JMenuItem mntmKorvaa = new JMenuItem("Replace");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String etsit‰‰n = txtrEka.getText();
				JTextField nimi = new JTextField(10);
				JTextField erinimi = new JTextField(10);
				JPanel jokunimi = new JPanel();
				jokunimi.add(new JLabel("Replacing word"));
				jokunimi.add(nimi);
				jokunimi.add(new JLabel("Replaced word"));
				jokunimi.add(erinimi);
				JOptionPane.showConfirmDialog(null, jokunimi, "Replace a word", JOptionPane.OK_CANCEL_OPTION);
				int a = etsit‰‰n.indexOf(nimi.getText());
				try {
					txtrEka.replaceRange(erinimi.getText(), a, (a + nimi.getText().length()));
				}
				catch (Exception e1)  {
					JOptionPane.showMessageDialog(null, "Replaced word cannot be found.", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnMuokkaa.add(mntmKorvaa);
		
		//Part of the menu
		JMenu mnListietoa = new JMenu("Info");
		menuBar.add(mnListietoa);
		
		//Part of the menu: lets you know who created the file
		JMenuItem mntmTekij = new JMenuItem("Creator");
		mntmTekij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Alkete Ademaj","Tekij‰", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnListietoa.add(mntmTekij);
		
		//Opens the file and prints the written text 
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Kokeilija = new JFileChooser();
				Kokeilija.showOpenDialog(null);
				
				String newFile = Kokeilija.getSelectedFile().getAbsolutePath(); 
				File KanaFile1 = new File (newFile);

				try {
					Scanner lukija = new Scanner(KanaFile1);
					while (lukija.hasNextLine()) {
						String y = lukija.nextLine();
						txtrEka.append(y+"\n");
					}
					lukija.close();
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//Saves the written text in to a form
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				JFileChooser Valitsija = new JFileChooser(); 
				Valitsija.setDialogTitle("Saveth");
				Valitsija.setApproveButtonText("Openth");
				Valitsija.setApproveButtonToolTipText("Openth selected fileth");
				Valitsija.showOpenDialog(null);
				
				String newFile = Valitsija.getSelectedFile().getAbsolutePath(); 
				File KanaFile = new File (newFile);
				try {
					PrintWriter write = new PrintWriter(KanaFile);
					String talteen =  txtrEka.getText();
					write.println(talteen);
					write.flush();
					write.close();
				}
				
				catch (Exception e) {
					
				}
			}
		});
		
		//Opens the selected file
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser Kokeilija = new JFileChooser();
				Kokeilija.showOpenDialog(null);
				
				File Kanafile1 = new File(Kokeilija.getSelectedFile().getAbsolutePath());
				try {
					Scanner lukija = new Scanner(Kanafile1);
					while (lukija.hasNextLine()) {
						String y = lukija.nextLine();
						txtrEka.append(y+"\n");
					}
					lukija.close();
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//You can choose to cut the desired word
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kaikki = txtrEka.getText();
				String word = JOptionPane.showInputDialog(null,"Which word do you want to cut?");
				int arvo = kaikki.indexOf(word);
				try {
					txtrEka.replaceRange("", arvo,(arvo + word.length()));
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "There is no such word in the file!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		frame.setVisible(true);
}
}