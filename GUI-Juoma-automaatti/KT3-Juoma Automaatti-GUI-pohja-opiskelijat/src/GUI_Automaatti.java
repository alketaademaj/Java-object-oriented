import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	private JTextField txtKahvia;
	private JTextField txtTeet;
	private JTextField txtWannabeKaakaota;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 447, 26);
		contentPane.add(menuBar);
		
		JMenu mnYllpito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllpito);
		
		JMenu mnAseta = new JMenu("Aseta");
		mnYllpito.add(mnAseta);
		
		JMenuItem mntmAsetaKahvinMr = new JMenuItem("kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kahvi = JOptionPane.showInputDialog(null, "Aseta kahvin m‰‰r‰: ");
				int kahvi1 = Integer.parseInt(kahvi);
				if (kahvi1 < 0) {
					ja.setKahvi(0);
				}
				else if (kahvi1 >50) {
					ja.setKahvi(50);
				}
				else {
					ja.setKahvi(kahvi1);
				}
				txtKahvia.setText("Kahvia: " + ja.getKahvi());
			}
		});
		mnAseta.add(mntmAsetaKahvinMr);
		
		JMenuItem mntmAsetaTeenMr = new JMenuItem("teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tee = JOptionPane.showInputDialog(null, "Aseta teen m‰‰r‰: ");
				int tee1 = Integer.parseInt(tee);
				if (tee1 < 0) {
					ja.setTee(0);
				}
				else if (tee1 >50) {
					ja.setTee(50);
				}
				else {
					ja.setTee(tee1);
				}
				txtTeet.setText("Teet‰: " + ja.getTee());
			}
		});
		mnAseta.add(mntmAsetaTeenMr);
		
		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kaakao = JOptionPane.showInputDialog(null, "Aseta kaakaon m‰‰r‰: ");
				int kaakao1 = Integer.parseInt(kaakao);
				if (kaakao1 < 0) {
					ja.setKaakao(0);
				}
				else if (kaakao1 >50) {
					ja.setKaakao(50);
				}
				else {
					ja.setTee(kaakao1);
				}
				txtWannabeKaakaota.setText("Wannabee kaakaota: " + ja.getKaakao());	
			}
		});
		mnAseta.add(mntmAsetaKaakaonMr);
		
		JMenuItem mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmTallennaAutomaatinTila_1);
		
		JMenuItem mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusiJA = Sarjallistamista.lueTiedostosta();
					ja.setKahvi(uusiJA.getKahvi());
					ja.setTee(uusiJA.getTee());
					ja.setKaakao(uusiJA.getKaakao());
					txtKahvia.setText("Kahvia: " + uusiJA.getKahvi());
					txtTeet.setText("Teet‰: " + uusiJA.getTee());
					txtWannabeKaakaota.setText("Wannabee kaakaota: " + uusiJA.getKaakao());
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmLataaAutomaatti_1);
		
		JMenuItem mntmLopetaOhjelma = new JMenuItem("Lopeta");
		mntmLopetaOhjelma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllpito.add(mntmLopetaOhjelma);
		
		JMenu mnTietoaOhjelmasta = new JMenu("Tietoa ohjelmasta");
		menuBar.add(mnTietoaOhjelmasta);
		
		JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot A = new Versiotiedot();
				A.setVisible(true);
			}
		});
		mnTietoaOhjelmasta.add(mntmVersiotiedot);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();
				txtWannabeKaakaota.setText("Wannabe kaakaota: " + ja.getKaakao());
				if (ja.getKaakao() < 10) {
					txtWannabeKaakaota.setText("Kaakao loppu!");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Omistaja\\eclipse-workspace\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\cocoa.jpg"));
		btnNewButton.setBounds(23, 401, 109, 121);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKahvi();
				txtKahvia.setText("Kahvia: " + ja.getKahvi());	
				if (ja.getKahvi() <10) {
					txtKahvia.setText("Kahvi loppu!");
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Omistaja\\eclipse-workspace\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\coffee.jpg"));
		button.setBounds(23, 71, 109, 121);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaTee();
				txtTeet.setText("Teet\u00E4: " + ja.getTee());
				if (ja.getTee() <10) {
					txtTeet.setText("Tee loppu!");
				}
			}
		});

		button_1.setIcon(new ImageIcon("C:\\Users\\Omistaja\\eclipse-workspace\\KT3-Juoma Automaatti-GUI-pohja-opiskelijat\\img\\tea.jpg"));
		button_1.setBounds(23, 236, 109, 121);
		contentPane.add(button_1);
		
		txtKahvia = new JTextField();
		txtKahvia.setDisabledTextColor(Color.BLACK);
		txtKahvia.setBorder(null);
		txtKahvia.setEnabled(false);
		txtKahvia.setEditable(false);
		txtKahvia.setText("Kahvia: " + ja.getKahvi());
		txtKahvia.setBounds(209, 118, 138, 22);
		contentPane.add(txtKahvia);
		txtKahvia.setColumns(10);
		
		txtTeet = new JTextField();
		txtTeet.setDisabledTextColor(Color.BLACK);
		txtTeet.setBorder(null);
		txtTeet.setEnabled(false);
		txtTeet.setEditable(false);
		txtTeet.setText("Teet\u00E4: " + ja.getTee());
		txtTeet.setColumns(10);
		txtTeet.setBounds(209, 281, 138, 22);
		contentPane.add(txtTeet);
		
		txtWannabeKaakaota = new JTextField();
		txtWannabeKaakaota.setDisabledTextColor(Color.BLACK);
		txtWannabeKaakaota.setBorder(null);
		txtWannabeKaakaota.setEnabled(false);
		txtWannabeKaakaota.setEditable(false);
		txtWannabeKaakaota.setText("Wannabe kaakaota: " + ja.getKaakao());
		txtWannabeKaakaota.setColumns(10);
		txtWannabeKaakaota.setBounds(209, 450, 138, 22);
		contentPane.add(txtWannabeKaakaota);
		
		
	}
}
