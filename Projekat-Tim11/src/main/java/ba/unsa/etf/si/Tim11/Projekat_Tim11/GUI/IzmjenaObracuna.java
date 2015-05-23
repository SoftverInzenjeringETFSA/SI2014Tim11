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
		frame.setBounds(100, 100, 431, 391);
		frame.setTitle("Izmjena obračuna");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] kolone = {"ID",
		        "Ime",
		        "Prezime",
		        "Odjel"};

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(kolone);
		/*for (Zaposlenik z : _zaposlenici) {
			  Object[] o = new Object[4];
			  o[0] = z.getId();
			  o[1] = z.getIme();
			  o[2] = z.getPrezime();
			  o[3] = z.getPozicija();
			  model.addRow(o);
		}*/
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(307, 319, 98, 23);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Obracun o = new Obracun(_o);
				o.main(null);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblStvarniRad = new JLabel("Stvarni rad (u danima):");
		lblStvarniRad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStvarniRad.setBounds(55, 100, 134, 14);
		frame.getContentPane().add(lblStvarniRad);
		
		JSpinner spinStvarniRad = new JSpinner();
		spinStvarniRad.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinStvarniRad.setBounds(199, 97, 98, 20);
		frame.getContentPane().add(spinStvarniRad);
		
		JLabel lblMjesecIGodina = new JLabel("Mjesec i godina obračuna:");
		lblMjesecIGodina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMjesecIGodina.setBounds(34, 34, 155, 14);
		frame.getContentPane().add(lblMjesecIGodina);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(199, 28, 98, 20);
		frame.getContentPane().add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(307, 28, 47, 20);
		frame.getContentPane().add(yearChooser);
		
		JLabel lblBolovanje = new JLabel("Bolovanje:");
		lblBolovanje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBolovanje.setBounds(80, 261, 109, 14);
		frame.getContentPane().add(lblBolovanje);
		
		JSpinner spinBolovanje = new JSpinner();
		spinBolovanje.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBolovanje.setBounds(199, 258, 98, 20);
		frame.getContentPane().add(spinBolovanje);
		
		JLabel lblGodinjiOdmor = new JLabel("Godišnji odmor:");
		lblGodinjiOdmor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodinjiOdmor.setBounds(61, 131, 128, 14);
		frame.getContentPane().add(lblGodinjiOdmor);
		
		JSpinner spinGodisnjiOdmor = new JSpinner();
		spinGodisnjiOdmor.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinGodisnjiOdmor.setBounds(199, 128, 98, 20);
		frame.getContentPane().add(spinGodisnjiOdmor);
		
		JLabel lblGodineStaza = new JLabel("Godine staza:");
		lblGodineStaza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGodineStaza.setBounds(70, 161, 119, 14);
		frame.getContentPane().add(lblGodineStaza);
		
		JSpinner spinGodineStaza = new JSpinner();
		spinGodineStaza.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinGodineStaza.setBounds(199, 158, 98, 20);
		frame.getContentPane().add(spinGodineStaza);
		
		JLabel lblPraznici = new JLabel("Praznici:");
		lblPraznici.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPraznici.setBounds(80, 197, 109, 14);
		frame.getContentPane().add(lblPraznici);
		
		JSpinner spinPraznici = new JSpinner();
		spinPraznici.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinPraznici.setBounds(199, 194, 98, 20);
		frame.getContentPane().add(spinPraznici);
		
		JLabel lblNocniRad = new JLabel("Noćni rad (u danima):");
		lblNocniRad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNocniRad.setBounds(47, 230, 142, 14);
		frame.getContentPane().add(lblNocniRad);
		
		JSpinner spinNocniRad = new JSpinner();
		spinNocniRad.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinNocniRad.setBounds(199, 227, 98, 20);
		frame.getContentPane().add(spinNocniRad);
		
		JLabel lblBrojRadnihDana = new JLabel("Broj radnih dana:");
		lblBrojRadnihDana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojRadnihDana.setBounds(70, 69, 119, 14);
		frame.getContentPane().add(lblBrojRadnihDana);
		
		JSpinner spinBrojRadnihDana = new JSpinner();
		spinBrojRadnihDana.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinBrojRadnihDana.setBounds(199, 66, 98, 20);
		frame.getContentPane().add(spinBrojRadnihDana);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBounds(198, 319, 99, 23);
		frame.getContentPane().add(btnPotvrdi);
	}
}
