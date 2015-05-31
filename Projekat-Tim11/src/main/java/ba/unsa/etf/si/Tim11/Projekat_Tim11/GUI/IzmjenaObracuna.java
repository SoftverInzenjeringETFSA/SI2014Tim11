package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;

import java.util.*;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import com.toedter.calendar.JCalendar;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;

public class IzmjenaObracuna {

	private JFrame frame;
	private static Zaposlenik _z;
	private static Operater _o;
	private Plata _p;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmjenaObracuna window;
					if (_z != null && _o != null) {
						window = new IzmjenaObracuna(_z, _o);
					}
					else {
						window = new IzmjenaObracuna();
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
	public IzmjenaObracuna() {
		initialize();
	}
	
	public IzmjenaObracuna(Zaposlenik z, Operater o) {
		initialize();
		_z = z;
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 391);
		frame.setTitle("Izmjena obračuna");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 684, 353);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Obračun plate", null, panel, null);
		panel.setLayout(null);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(571, 291, 98, 23);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Obracun o = new Obracun(_o);
				o.main(null);
			}
		});
		panel.add(btnIzlaz);
		
		JLabel lblStvarniRad = new JLabel("Stvarni rad (u danima):");
		lblStvarniRad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStvarniRad.setBounds(156, 100, 134, 14);
		panel.add(lblStvarniRad);
		
		final JSpinner spinStvarniRad = new JSpinner();
		spinStvarniRad.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinStvarniRad.setBounds(300, 97, 98, 20);
		panel.add(spinStvarniRad);
		
		JLabel lblMjesecIGodina = new JLabel("Mjesec i godina obračuna:");
		lblMjesecIGodina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMjesecIGodina.setBounds(135, 41, 155, 14);
		panel.add(lblMjesecIGodina);
		
		JLabel lblBolovanje = new JLabel("Bolovanje:");
		lblBolovanje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBolovanje.setBounds(181, 228, 109, 14);
		panel.add(lblBolovanje);
		
		final JSpinner spinBolovanje = new JSpinner();
		spinBolovanje.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBolovanje.setBounds(300, 225, 98, 20);
		panel.add(spinBolovanje);
		
		JLabel lblGodinjiOdmor = new JLabel("Godišnji odmor:");
		lblGodinjiOdmor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodinjiOdmor.setBounds(162, 131, 128, 14);
		panel.add(lblGodinjiOdmor);
		
		final JSpinner spinGodisnjiOdmor = new JSpinner();
		spinGodisnjiOdmor.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinGodisnjiOdmor.setBounds(300, 128, 98, 20);
		panel.add(spinGodisnjiOdmor);
		
		JLabel lblPraznici = new JLabel("Praznici:");
		lblPraznici.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPraznici.setBounds(181, 162, 109, 14);
		panel.add(lblPraznici);
		
		final JSpinner spinPraznici = new JSpinner();
		spinPraznici.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinPraznici.setBounds(300, 159, 98, 20);
		panel.add(spinPraznici);
		
		JLabel lblNocniRad = new JLabel("Noćni rad (u danima):");
		lblNocniRad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNocniRad.setBounds(148, 195, 142, 14);
		panel.add(lblNocniRad);
		
		final JSpinner spinNocniRad = new JSpinner();
		spinNocniRad.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		spinNocniRad.setBounds(300, 192, 98, 20);
		panel.add(spinNocniRad);
		
		JLabel lblBrojRadnihDana = new JLabel("Broj radnih dana:");
		lblBrojRadnihDana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojRadnihDana.setBounds(171, 69, 119, 14);
		panel.add(lblBrojRadnihDana);
		
		final JSpinner spinBrojRadnihDana = new JSpinner();
		spinBrojRadnihDana.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBrojRadnihDana.setBounds(300, 66, 98, 20);
		panel.add(spinBrojRadnihDana);		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Prikaz obračuna", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnIzlaz_1 = new JButton("Izlaz");
		btnIzlaz_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Obracun o = new Obracun(_o);
				o.main(null);
			}
		});
		btnIzlaz_1.setBounds(543, 291, 126, 23);
		panel_1.add(btnIzlaz_1);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 35, 98, 20);
		panel.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 679, 221);
		panel_1.add(scrollPane);
		
		table = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    
	    scrollPane.setViewportView(table);
		
		final String[] kolone = {"ID plate",
				"Datum obračuna",
				"Dohodak",
				"Topli obrok",
		        "Minuli rad",
		        "Stopa poreza",
		        "Porez na dohodak",
		        "Bruto plata",
		        "Neto plata"};

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(kolone);
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION) {
					int selectedRowIndex = table.getSelectedRow();
					for (Plata p : _z.getPlate()) {
						if (table.isRowSelected(selectedRowIndex) && p.getId() == (Long) table.getModel().getValueAt(selectedRowIndex, 0)) {
							_z.izbrisiPlatu(p);
							Sistem.Zaposlenici.izmijeni(_z);
							_z=Sistem.Zaposlenici.nadji(Integer.parseInt(_z.getId().toString()));
							JOptionPane.showMessageDialog(frame, "Uspješno ste obrisali platu");
							break;
						}
					}
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);
					model.setColumnIdentifiers(kolone);
					for (Plata p : _z.getPlate()) {	
						double dohodak;
						try {
							dohodak = p.izracunajDohodak();
							Object[] o = new Object[9];
							  o[0] = p.getId();
							  o[1] = p.getDatum();
							  o[2] = p.izracunajDohodak();
							  o[3] = p.izracunajTopliObrok();
							  o[4] = p.izracunajMinuliRad(dohodak);
							  o[5] = p.izracunajStopuPoreza();
							  o[6] = p.izracunajPorezNaDohodak();
							  o[7] = p.izracunajBrutoPlatu();
							  o[8] = p.izracunajNetoPlatu();
							  model.addRow(o);
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		btnObrisi.setBounds(407, 291, 126, 23);
		panel_1.add(btnObrisi);		
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Integer) spinBrojRadnihDana.getValue() == 0 || (Integer) spinStvarniRad.getValue() == 0) {
					JOptionPane.showMessageDialog(frame, "Morate unijeti broj radnih dana i stvarni rad");
					return;
				}
				if((Integer) spinBrojRadnihDana.getValue() != ((Integer) spinStvarniRad.getValue() +
						(Integer) spinBolovanje.getValue() + (Integer) spinGodisnjiOdmor.getValue()
						+ (Integer) spinPraznici.getValue() + (Integer) spinNocniRad.getValue())) {
					JOptionPane.showMessageDialog(frame, "Suma ostalih vrijednosti mora biti jednaka broju radnih dana");
					return;
				}				
				if(dateChooser.getDate().after(new Date())) {
					JOptionPane.showMessageDialog(frame, "Pogresan datum");
					return;
				}
				if(dateChooser.getDate().getMonth() == 1 && (Integer) spinBrojRadnihDana.getValue() > 28) {
					JOptionPane.showMessageDialog(frame, "Februar nema toliko dana");
					return;
				}
				try {
					_p = new Plata();
					_p.setDatum(dateChooser.getDate());
					_p.setBrojRadnihDana((Integer) spinBrojRadnihDana.getValue());
					_p.setStvarniRad((Integer) spinStvarniRad.getValue());
					_p.setBolovanje((Integer) spinBolovanje.getValue());
					_p.setGodineStaza(_z.radniStaz());
					_p.setGodisnjiOdmor((Integer) spinGodisnjiOdmor.getValue());
					_p.setPrazniciRad((Integer) spinPraznici.getValue());
					_p.setNocniRad((Integer) spinNocniRad.getValue());
					_p.setZaposlenik(_z);
					_z.dodajPlatu(_p);
					Sistem.Zaposlenici.izmijeni(_z);
					_z=Sistem.Zaposlenici.nadji(Integer.parseInt(_z.getId().toString()));
					JOptionPane.showMessageDialog(frame, "Uspješno ste dodali platu");
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tabbedPane.setEnabledAt(1, true);
				if(_z.getPlate().size() != 0) {
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);
					model.setColumnIdentifiers(kolone);
					for (Plata p : _z.getPlate()) {
						if(p != null) {
							double dohodak;
							try {
								dohodak = p.izracunajDohodak();
								Object[] o = new Object[9];
								  o[0] = p.getId();
								  o[1] = p.getDatum();
								  o[2] = p.izracunajDohodak();
								  o[3] = p.izracunajTopliObrok();
								  o[4] = p.izracunajMinuliRad(dohodak);
								  o[5] = p.izracunajStopuPoreza();
								  o[6] = p.izracunajPorezNaDohodak();
								  o[7] = p.izracunajBrutoPlatu();
								  o[8] = p.izracunajNetoPlatu();
								  model.addRow(o);
							}
							catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}	
			}
		});
		btnPotvrdi.setBounds(462, 291, 99, 23);
		panel.add(btnPotvrdi);
		
		tabbedPane.setEnabledAt(1, false);
		if(_z != null) {
			if(_z.getPlate().size() > 0) {
				tabbedPane.setEnabledAt(1, true);
				for (Plata p : _z.getPlate()) {
					if(p != null) {
						double dohodak;
						try {
							dohodak = p.izracunajDohodak();
							Object[] o = new Object[9];
							  o[0] = p.getId();
							  o[1] = p.getDatum();
							  o[2] = p.izracunajDohodak();
							  o[3] = p.izracunajTopliObrok();
							  o[4] = p.izracunajMinuliRad(dohodak);
							  o[5] = p.izracunajStopuPoreza();
							  o[6] = p.izracunajPorezNaDohodak();
							  o[7] = p.izracunajBrutoPlatu();
							  o[8] = p.izracunajNetoPlatu();
							  model.addRow(o);
						}
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
}
