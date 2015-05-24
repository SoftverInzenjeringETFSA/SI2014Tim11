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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.io.*;

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
		scrollPane.setBounds(0, 0, 519, 109);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Platna lista", "Mjesečni izvještaj", "Doprinosi"}));
		comboBox.setBounds(117, 129, 134, 23);
		panel.add(comboBox);
		
		final JButton btnSpasi = new JButton("Spasi");
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			        BufferedWriter out = new BufferedWriter(new FileWriter("izvjestaj.txt"));
			        for(int i = 0 ; i < table.getColumnCount() ; i++)
			        {
			          out.write(table.getColumnName(i));
			          out.write("\t");
			        }

			        for (int i = 0 ; i < table.getRowCount(); i++)
			        {
			          out.newLine();
			          for(int j = 0 ; j < table.getColumnCount();j++)
			          {
			        	  if(table.getValueAt(i,j) instanceof Double) {
							out.write(Double.toString((Double) table.getValueAt(i,j)));
			        	  }
			        	  else {
			        		  out.write((String)(table.getValueAt(i,j)));  
			        	  }
			            out.write("\t");;
			          }
			        }
			            out.close();
			            JOptionPane.showMessageDialog(frame, "Uspješno ste spasili izvještaj");
			        } catch (IOException e) {}
			}
		});
		btnSpasi.setBounds(341, 337, 89, 23);
		frame.getContentPane().add(btnSpasi);
		
		final JButton btnKreirajIzvjestaj = new JButton("Kreiraj izvještaj");
		btnKreirajIzvjestaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Zaposlenik z : _zaposlenici) {
					if(z.getPlate().size() == 0) {
						JOptionPane.showMessageDialog(frame, "Morate prvo dodati platu");
						return;
					}
				}
				
				final DefaultTableModel model = new DefaultTableModel();
				table.setModel(model);
				
				double d1=17;          //doprinos za PIO/MIo
				double d2=12.5;        //doprinos za zdravstveno osiguranje
				double d3=1.5;         //doprinos za osiguranje od nezaposlenosti
				
				double d4=6;		   //doprinos za PIO na teret poslodavca
				double d5=4;           //doprinos za zdravstveno osiguranje na teret poslodavca
				double d6=0.5;         //doprinos za osiguranje od nezaposlenosti na teret poslodavca
				
				if(comboBox.getSelectedIndex() == 0) {
					String[] kolone = {"Ime uposlenika",
							"Prezime uposlenika",
							"JMBG uposlenika",
							"Neto plata",
							"Lični odbici",
							"Doprinos za PIO",
							"Doprinos za zdravsteno",
							"Doprinos za osiguranje od nezaposlenosti",
							"Doprinos za PIO na teret poslodavca",
							"Doprinos za zdravstveno na teret poslodavca",
							"Doprinos za osiguranje od nezaposlenosti na teret poslodavca",
							"Osnovica za porez na dohodak",
							"Porez na dohodak",
							"Bruto plata"};

					model.setColumnIdentifiers(kolone);
					for(Zaposlenik z : _zaposlenici) {
						if(z.getId() == Long.parseLong(txtId.getText())) {
							double licniodbitak = 300 * z.getFaktor();
							for(Plata p : z.getPlate()) {
								  try {
									  double osnovicaZaPorez=p.izracunajDohodak()-licniodbitak;
										Object[] o = new Object[14];
										  o[0] = z.getIme();
										  o[1] = z.getPrezime();
										  o[2] = z.getJmbg();
										  o[3] = p.izracunajNetoPlatu();
										  o[4] = licniodbitak;
										  o[5] = d1;
										  o[6] = d2;
										  o[7] = d3;
										  o[8] = d4;
										  o[9] = d5;
										  o[10] = d6;
										  o[11] = osnovicaZaPorez;
										  o[12] = p.izracunajPorezNaDohodak();
										  o[13] = p.izracunajBrutoPlatu();
										  model.addRow(o);
								  }
								  catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								  }
							}
						}
					}
				}
				
				if(comboBox.getSelectedIndex() == 1) {
					String[] kolone = {"ID uposlenika",
							"Ime uposlenika",
							"Prezime uposlenika",
							"JMBG uposlenika",
							"Neto plata",
							"Doprinosi na platu",
							"Porez",
							"Bruto plata"};

					model.setColumnIdentifiers(kolone);
					for(Zaposlenik z : _zaposlenici) {
						for(Plata p : z.getPlate()) {
							  try {
								  Object[] o = new Object[8];
								  o[0] = z.getId();
								  o[1] = z.getIme();
								  o[2] = z.getPrezime();
								  o[3] = z.getJmbg();
								  o[4] = p.izracunajNetoPlatu();
								  o[5] = d1+d2+d3+d4+d5+d6;
								  o[6] = p.izracunajPorezNaDohodak();
								  o[7] = p.izracunajBrutoPlatu();
								  model.addRow(o);
							  }
							  catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							  }
						}
					}
				}
				if(comboBox.getSelectedIndex() == 2) {
					String[] kolone = {"Doprinosi",
							"Broj računa",
							"Iznos"};

					model.setColumnIdentifiers(kolone);
					for(Zaposlenik z : _zaposlenici) {
						Plata p = z.getPlate().get(z.getPlate().size()-1);
						Object[] o = new Object[3];
						o[0] = "Penziono i invalidsko osiguranje";
						o[1] = "1610200035700075";
						o[2] = d1;
						model.addRow(o);
						o[0] = "Zdravstveno osiguranje, Kanton";
						o[1] = "1375006001679472";
						o[2] = (d2*89.8) / 100;
						model.addRow(o);
						o[0] = "Zdravstveno osiguranje, FBiH";
						o[1] = "1020500000064018";
						o[2] = (d2*10.2) / 100;
						model.addRow(o);
						o[0] = "Osiguranje od nezaposlenosti, FBiH";
						o[1] = "16100000028570003";
						o[2] = (d3*30) / 100;
						model.addRow(o);
						o[0] = "Osiguranje od nezaposlenosti, HNK";
						o[1] = "1610200013800191";
						o[2] = (d3*70) / 100;
						model.addRow(o);
						o[0] = "Porez na dohodak";
						o[1] = "3380002200005953";
						try {
							o[2] = p.izracunajPorezNaDohodak();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						model.addRow(o);
						o[0] = "Ukupne obaveze";
						try {
							o[2] = d1+(d2*89.8)/100+(d2*10.2)/100+(d3*30)/100+(d3*70)/100+p.izracunajPorezNaDohodak();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
 						model.addRow(o);
					}
				}
				btnSpasi.setEnabled(true);
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
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OperaterPocetna op = new OperaterPocetna(_o);
				op.main(null);
			}
		});
		btnIzlaz.setBounds(440, 337, 89, 23);
		frame.getContentPane().add(btnIzlaz);
		
		btnKreirajIzvjestaj.setEnabled(false);
		btnSpasi.setEnabled(false);
	}
}
