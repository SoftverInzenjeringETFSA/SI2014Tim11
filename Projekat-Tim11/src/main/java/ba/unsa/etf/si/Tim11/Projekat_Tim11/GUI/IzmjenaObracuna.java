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
		frame.setBounds(100, 100, 435, 391);
		frame.setTitle("Izmjena obračuna");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 415, 353);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Obračun plate", null, panel, null);
		panel.setLayout(null);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(302, 291, 98, 23);
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
		lblStvarniRad.setBounds(55, 100, 134, 14);
		panel.add(lblStvarniRad);
		
		final JSpinner spinStvarniRad = new JSpinner();
		spinStvarniRad.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinStvarniRad.setBounds(199, 97, 98, 20);
		panel.add(spinStvarniRad);
		
		JLabel lblMjesecIGodina = new JLabel("Mjesec i godina obračuna:");
		lblMjesecIGodina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMjesecIGodina.setBounds(34, 34, 155, 14);
		panel.add(lblMjesecIGodina);
		
		final JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(199, 28, 109, 20);
		panel.add(monthChooser);
		
		final JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(319, 28, 47, 20);
		panel.add(yearChooser);
		
		JLabel lblBolovanje = new JLabel("Bolovanje:");
		lblBolovanje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBolovanje.setBounds(80, 261, 109, 14);
		panel.add(lblBolovanje);
		
		final JSpinner spinBolovanje = new JSpinner();
		spinBolovanje.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBolovanje.setBounds(199, 258, 98, 20);
		panel.add(spinBolovanje);
		
		JLabel lblGodinjiOdmor = new JLabel("Godišnji odmor:");
		lblGodinjiOdmor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodinjiOdmor.setBounds(61, 131, 128, 14);
		panel.add(lblGodinjiOdmor);
		
		final JSpinner spinGodisnjiOdmor = new JSpinner();
		spinGodisnjiOdmor.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinGodisnjiOdmor.setBounds(199, 128, 98, 20);
		panel.add(spinGodisnjiOdmor);
		
		JLabel lblGodineStaza = new JLabel("Godine staza:");
		lblGodineStaza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodineStaza.setBounds(70, 161, 119, 14);
		panel.add(lblGodineStaza);
		
		final JSpinner spinGodineStaza = new JSpinner();
		spinGodineStaza.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinGodineStaza.setBounds(199, 158, 98, 20);
		panel.add(spinGodineStaza);
		
		JLabel lblPraznici = new JLabel("Praznici:");
		lblPraznici.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPraznici.setBounds(80, 197, 109, 14);
		panel.add(lblPraznici);
		
		final JSpinner spinPraznici = new JSpinner();
		spinPraznici.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinPraznici.setBounds(199, 194, 98, 20);
		panel.add(spinPraznici);
		
		JLabel lblNocniRad = new JLabel("Noćni rad (u danima):");
		lblNocniRad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNocniRad.setBounds(47, 230, 142, 14);
		panel.add(lblNocniRad);
		
		final JSpinner spinNocniRad = new JSpinner();
		spinNocniRad.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinNocniRad.setBounds(199, 227, 98, 20);
		panel.add(spinNocniRad);
		
		JLabel lblBrojRadnihDana = new JLabel("Broj radnih dana:");
		lblBrojRadnihDana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojRadnihDana.setBounds(70, 69, 119, 14);
		panel.add(lblBrojRadnihDana);
		
		final JSpinner spinBrojRadnihDana = new JSpinner();
		spinBrojRadnihDana.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBrojRadnihDana.setBounds(199, 66, 98, 20);
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
		btnIzlaz_1.setBounds(311, 291, 89, 23);
		panel_1.add(btnIzlaz_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 390, 221);
		panel_1.add(scrollPane);
		
		table = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    
	    scrollPane.setViewportView(table);
		
		String[] kolone = {"Mjesec obračuna",
				"Godina obračuna",
				"Dohodak",
		        "Minuli rad",
		        "Stopa poreza",
		        "Porez na dohodak",
		        "Neto plata",
		        "Bruto plata"};

		final DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(kolone);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Integer) spinBrojRadnihDana.getValue() == 0 || (Integer) spinStvarniRad.getValue() == 0
						|| (Integer) spinGodineStaza.getValue() == 0) {
					JOptionPane.showMessageDialog(frame, "Morate unijeti broj radnih dana, stvarni rad i godine staza");
					return;
				}
				try {
					_p = new Plata();
					_p.getDatum().setMonth(monthChooser.getMonth());
					_p.getDatum().setYear(yearChooser.getYear());
					_p.setBrojRadnihDana((Integer) spinBrojRadnihDana.getValue());
					_p.setStvarniRad((Integer) spinStvarniRad.getValue());
					_p.setBolovanje((Integer) spinBolovanje.getValue());
					_p.setGodineStaza((Integer) spinGodineStaza.getValue());
					_p.setGodisnjiOdmor((Integer) spinGodisnjiOdmor.getValue());
					_p.setPrazniciRad((Integer) spinPraznici.getValue());
					_p.setNocniRad((Integer) spinNocniRad.getValue());
					_p.setZaposlenik(_z);
					_z.dodajPlatu(_p);
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tabbedPane.setEnabledAt(1, true);
				if(_z.getPlate().size() != 0) {
					for (Plata p : _z.getPlate()) {
						if(p != null) {
							double dohodak = p.izracunajDohodak();
							  Object[] o = new Object[8];
							  o[0] = p.getDatum().getMonth();
							  o[1] = p.getDatum().getYear();
							  o[2] = p.izracunajDohodak();
							  o[3] = p.izracunajMinuliRad(dohodak);
							  o[4] = p.izracunajStopuPoreza();
							  o[5] = p.izracunajPorezNaDohodak();
							  o[6] = p.izracunajNetoPlatu();
							  o[7] = p.izracunajBrutoPlatu();
							  model.addRow(o);
						}
					}
				}//test
			}
		});
		btnPotvrdi.setBounds(198, 291, 99, 23);
		panel.add(btnPotvrdi);
		
		tabbedPane.setEnabledAt(1, false);
	}
}
