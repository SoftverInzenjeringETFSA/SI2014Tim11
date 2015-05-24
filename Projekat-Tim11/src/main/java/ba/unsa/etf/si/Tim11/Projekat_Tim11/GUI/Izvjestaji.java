package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import java.util.*;

import com.toedter.calendar.JCalendar;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Izvjestaji {

	private JFrame frame;
	private JTextField txtId;
	private JTable table;
	private static Operater _o;
	private List<Zaposlenik> _zaposlenici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Izvjestaji window;
					if(_o != null) {
						window = new Izvjestaji(_o);
					}
					else {
						window = new Izvjestaji();
					}
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Izvjestaji() {
		initialize();
	}
	
	public Izvjestaji(Operater o) {
		initialize();
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Izvještaji");
		ImageIcon img = new ImageIcon("icons/report_icon.png");
		frame.setIconImage(img.getImage());
		_zaposlenici = Sistem.Zaposlenici.lista();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 519, 195);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 217, 519, 109);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 414, 109);
		panel_1.add(scrollPane);
		
		table = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		scrollPane.setViewportView(table);
		
		final DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		
		JLabel lblId = new JLabel("ID uposlenika:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(-56, 60, 163, 14);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(117, 57, 134, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblVrstaIzvjestaja = new JLabel("Vrsta izvještaja:");
		lblVrstaIzvjestaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVrstaIzvjestaja.setBounds(-21, 133, 128, 14);
		panel.add(lblVrstaIzvjestaja);
		
		JLabel lblDatumKreiranjaIzvjestaja = new JLabel("Datum kreiranja izvještaja:");
		lblDatumKreiranjaIzvjestaja.setBounds(274, 22, 235, 14);
		panel.add(lblDatumKreiranjaIzvjestaja);
		
		JCalendar calDatumKreiranja = new JCalendar();
		calDatumKreiranja.setBounds(274, 39, 235, 111);
		panel.add(calDatumKreiranja);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Platna lista", "Specifikacija 2001", "Mjesečni izvještaj", "Godišnji izvještaj"}));
		comboBox.setBounds(117, 129, 134, 23);
		panel.add(comboBox);
		
		final JButton btnKreirajIzvjestaj = new JButton("Kreiraj izvještaj");
		btnKreirajIzvjestaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Zaposlenik z : _zaposlenici) {
					if(z.getPlate().size() == 0) {
						JOptionPane.showMessageDialog(frame, "Morate prvo dodati platu");
						return;
					}
				}
				if(comboBox.getSelectedIndex() == 3) {
					String[] kolone = {"ID uposlenika",
							"Ime uposlenika",
							"Prezime uposlenika",
							"ID plate",
							"Neto plata",
							"Bruto plata"};

					final DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);
					model.setColumnIdentifiers(kolone);
					for(Zaposlenik z : _zaposlenici) {
						for(Plata p : z.getPlate()) {
							Object[] o = new Object[6];
							  o[0] = z.getId();
							  o[1] = z.getIme();
							  o[2] = z.getPrezime();
							  o[3] = p.getId();
							  try {
								o[4] = p.izracunajNetoPlatu();
								o[5] = p.izracunajBrutoPlatu();
							  }
							  catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							  }
							  model.addRow(o);
						}
					}
				}
				if(comboBox.getSelectedIndex() == 2) {
					String[] kolone = {"Datum",
							"ID uposlenika",
							"Ime uposlenika",
							"Prezime uposlenika",
							"ID plate",
							"Neto plata",
							"Bruto plata"};

					final DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);
					model.setColumnIdentifiers(kolone);
					for(Zaposlenik z : _zaposlenici) {
						for(Plata p : z.getPlate()) {
							Object[] o = new Object[7];
							  o[0] = p.getDatum();
							  o[1] = z.getId();
							  o[2] = z.getIme();
							  o[3] = z.getPrezime();
							  o[4] = p.getId();
							  try {
								o[5] = p.izracunajNetoPlatu();
								o[6] = p.izracunajBrutoPlatu();
							  }
							  catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							  }
							  model.addRow(o);
						}
					}
				}
			}
		});
		btnKreirajIzvjestaj.setBounds(358, 161, 151, 23);
		panel.add(btnKreirajIzvjestaj);
		
		txtId.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {	
		    	if(txtId.getText().length() != 0) {
		    		for(Zaposlenik z : _zaposlenici) {
		    			if(z != null) {
		    				if(z.getId().toString().contains(txtId.getText())) {
								btnKreirajIzvjestaj.setEnabled(true);
								break;
							}
							else {
								btnKreirajIzvjestaj.setEnabled(false);
							}
		    			}
					}
		    	}
		    	else {
		    		btnKreirajIzvjestaj.setEnabled(false);
		    	}
		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 for(Zaposlenik z : _zaposlenici) {
		    		if(z != null) {
		    			if(z.getId().toString().contains(txtId.getText())) {
							btnKreirajIzvjestaj.setEnabled(true);
							break;
						}
						else {
							btnKreirajIzvjestaj.setEnabled(false);
						}
		    		}
				}
		     }

		     public void changedUpdate(DocumentEvent e) {
		        // TODO add code!

		     }
		  });
		
		JButton btnPrikazi = new JButton("Prikaži");
		btnPrikazi.setBounds(420, 24, 89, 23);
		panel_1.add(btnPrikazi);
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setBounds(420, 61, 89, 23);
		panel_1.add(btnObrisi);
		
		JButton btnPrintanje = new JButton("Printanje");
		btnPrintanje.setBounds(341, 337, 89, 23);
		frame.getContentPane().add(btnPrintanje);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnIzlaz.setBounds(440, 337, 89, 23);
		frame.getContentPane().add(btnIzlaz);
		
		btnKreirajIzvjestaj.setEnabled(false);
	}
}
