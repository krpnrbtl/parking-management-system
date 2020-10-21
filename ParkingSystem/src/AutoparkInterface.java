import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AutoparkInterface extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AutoPark ap = new AutoPark(5.7, 50);
	private SubscribedVehicle bmw = new SubscribedVehicle("34 AS 842");
	private SubscribedVehicle mercedes = new SubscribedVehicle("61 YFA 95");
	

	private JPanel contentPane;
	private JTextField plakaText;
	private JTextField textField_1;
	private JTextField txtBaslangc;
	private JTextField txtBitis;
	private JTextField textField_4;
	private JTextField txtAracIsmi;
	private JTextField txtAracIsmi_1;
	private JTextField txtGirisZaman;
	private JTextField txtCksZaman;
	private JTextField txtAracPlakas;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoparkInterface frame = new AutoparkInterface();
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
	public AutoparkInterface() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bet\u00FCl\\Desktop\\Ko.png"));
		setTitle("Kardesler Otopark");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Park Kaydý", null, layeredPane_1, null);
		
		txtAracPlakas = new JTextField();
		txtAracPlakas.setText("arac plakasi...");
		txtAracPlakas.setBounds(10, 11, 104, 31);
		layeredPane_1.add(txtAracPlakas);
		txtAracPlakas.setColumns(10);
		
		final TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(13, 48, 373, 111);
		layeredPane_1.add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("Park Halinde Mi?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ap.isParked(txtAracPlakas.getText())== true) 
					textArea_1.setText("Plakasý girilen aracýn park kaydý vardýr.\n");
				else
					textArea_1.setText("Plakasý girilen aracýn park kaydý yoktur.\n");
			}
		});
		btnNewButton_1.setBounds(124, 11, 132, 31);
		layeredPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Park Kaydi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText("");
				textArea_1.append("Plakasi girilen aracin park kayitlari:\n");
				for(int i=0; i<ap.getVehicleCount(); i++) {
					if(ap.prPlateDondurme(i).equalsIgnoreCase(txtAracPlakas.getText())) {
					     textArea_1.append("giris zamani: " + Integer.toString(ap.prgSaatDondurme(i)) + "." + Integer.toString(ap.prgDakikaDondurme(i)));
					     if((ap.prcSaatDondurme(i)!=-1) && (ap.prcDakikaDondurme(i)!=-1))
					    	 textArea_1.append("   cikis zamani: " + Integer.toString(ap.prcSaatDondurme(i)) + "." + Integer.toString(ap.prcDakikaDondurme(i)));
					     textArea_1.append("\n");
				    }
				}
			}
		});
		btnNewButton_2.setBounds(266, 11, 127, 31);
		layeredPane_1.add(btnNewButton_2);
		
		final TextArea textArea_2 = new TextArea();
		textArea_2.setBounds(10, 220, 380, 136);
		layeredPane_1.add(textArea_2);
		
		JButton btnNewButton_3 = new JButton("Tum Park Kayitlarini Listele");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_2.setText("");
				for(int i=0; i<ap.getVehicleCount(); i++) {
					textArea_2.append(ap.prPlateDondurme(i));
					textArea_2.append("  giris zamani: " + Integer.toString(ap.prgSaatDondurme(i)) + "." + Integer.toString(ap.prgDakikaDondurme(i)));
					if((ap.prcSaatDondurme(i)!=-1) && (ap.prcDakikaDondurme(i)!=-1))
						textArea_2.append( "   cikis zamani: " + Integer.toString(ap.prcSaatDondurme(i)) + "." + Integer.toString(ap.prcDakikaDondurme(i)));
					textArea_2.append("\n");
				}
			}
		});
		btnNewButton_3.setBounds(10, 183, 242, 31);
		layeredPane_1.add(btnNewButton_3);
		
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Arac Giris-Cýkýs", null, layeredPane_2, null);
		
		txtAracIsmi_1 = new JTextField();
		txtAracIsmi_1.setText("arac ismi...");
		txtAracIsmi_1.setBounds(10, 11, 107, 30);
		layeredPane_2.add(txtAracIsmi_1);
		txtAracIsmi_1.setColumns(10);
		
		txtGirisZaman = new JTextField();
		txtGirisZaman.setText("giris zamani...");
		txtGirisZaman.setBounds(10, 57, 107, 30);
		layeredPane_2.add(txtGirisZaman);
		txtGirisZaman.setColumns(10);
		
		txtCksZaman = new JTextField();
		txtCksZaman.setText("cikis zamani...");
		txtCksZaman.setBounds(10, 98, 107, 30);
		layeredPane_2.add(txtCksZaman);
		txtCksZaman.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arac Tipi", "Resmi", "Normal"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(150, 12, 107, 29);
		layeredPane_2.add(comboBox);
		
		JButton btnGiris = new JButton("Giris");
		btnGiris.setBounds(150, 57, 107, 30);
		layeredPane_2.add(btnGiris);
		
		JButton btnCks = new JButton("Cikis");
		btnCks.setBounds(150, 98, 107, 30);
		layeredPane_2.add(btnCks);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setToolTipText("");
		tabbedPane.addTab("Abone Araclar", null, layeredPane, null);
		
		
		ap.addVehicle(mercedes);
		ap.addVehicle(bmw);
		ap.vehicleEnters(bmw, new Time(14,14), false);
		ap.vehicleEnters(mercedes, new Time(9,37), false);
		ap.vehicleExits(bmw, new Time(14,14), new Time(18,22));
		ap.vehicleEnters(bmw, new Time(20,53), false);
		//ap.vehicleExits(mercedes, new Time(9,37), new Time(18,22));
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(10, 46, 376, 116);
		layeredPane.add(textArea);
		
		JButton btnNewButton = new JButton("Arac Ara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ap.searchVehicle(plakaText.getText())== null) {
					textArea.setText("Aranýlan araç bulunamadý\n");
				}
				else
					textArea.setText("Aranýlan araç bulundu"+ " " + ap.searchVehicle(plakaText.getText())+ "\n");
			}
		});
		btnNewButton.setBounds(142, 10, 112, 30);
		layeredPane.add(btnNewButton);
		
		plakaText = new JTextField();
		plakaText.setText("plakayi giriniz...");
		plakaText.setToolTipText("");
		plakaText.setBounds(10, 10, 122, 30);
		layeredPane.add(plakaText);
		plakaText.setColumns(10);
		
		
		
		JButton btnTmnListele = new JButton("Tumunu Listele");
		btnTmnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for(int i=0; i<ap.getSubscribedVehiclesCount(); i++) {
					textArea.append(ap.svPlateDondurme(i));
				    textArea.append("\n");
				}
			} 
		});
		btnTmnListele.setBounds(264, 10, 122, 30);
		layeredPane.add(btnTmnListele);
		
		
		
		
		JButton btnAracEkle = new JButton("Arac Ekle");
		btnAracEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		btnAracEkle.setBounds(151, 179, 116, 30);
		layeredPane.add(btnAracEkle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 220, 357, 30);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		txtBaslangc = new JTextField();
		txtBaslangc.setText("baslang\u0131c...");
		txtBaslangc.setBounds(10, 261, 122, 30);
		layeredPane.add(txtBaslangc);
		txtBaslangc.setColumns(10);
		
		txtBitis = new JTextField();
		txtBitis.setText("bitis...");
		txtBitis.setBounds(151, 261, 103, 30);
		layeredPane.add(txtBitis);
		txtBitis.setColumns(10);
		
		JButton btnAboneEkle = new JButton("Abonelik Ekle");
		btnAboneEkle.setBounds(264, 261, 122, 31);
		layeredPane.add(btnAboneEkle);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 309, 357, 30);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		txtAracIsmi = new JTextField();
		txtAracIsmi.setText("arac ismi...");
		txtAracIsmi.setBounds(10, 179, 122, 30);
		layeredPane.add(txtAracIsmi);
		txtAracIsmi.setColumns(10);
		
		
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Otopark Bilgisi", null, layeredPane_3, null);
		
		
		TextArea textArea_3 = new TextArea();
		textArea_3.setBounds(10, 10, 407, 361);
		layeredPane_3.add(textArea_3);
		
		textArea_3.append(ap.toString());
	}

}
