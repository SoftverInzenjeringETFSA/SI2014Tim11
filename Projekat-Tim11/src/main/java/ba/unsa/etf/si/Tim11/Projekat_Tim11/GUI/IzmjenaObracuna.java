package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
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

public class IzmjenaObracuna {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtNoviIznosOsnovice;
	private JTextField txtBrojRadnihDana;
	private JTextField txtSatnica;
	private JTextField txtSatnica_4;
	private JTextField txtBrojSati;
	private JTextField txtBrojDana;
	private JTable table;
	private static Zaposlenik _z;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmjenaObracuna window;
					if (_z != null) {
						window = new IzmjenaObracuna(_z);
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
	
	public IzmjenaObracuna(Zaposlenik z) {
		initialize();
		_z = z;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 369);
		frame.setTitle("Izmjena obračuna");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(0, 0, 622, 286);
		frame.getContentPane().add(tabbedPane);
		
		JComponent panel1 = new JPanel();
		tabbedPane.addTab("Izmjena osnovice", panel1);
		panel1.setLayout(null);
		
		JLabel lblNoviIznosOsnovice = new JLabel("Novi iznos osnovice:");
		lblNoviIznosOsnovice.setBounds(23, 17, 137, 14);
		panel1.add(lblNoviIznosOsnovice);
		
		txtNoviIznosOsnovice = new JTextField();
		txtNoviIznosOsnovice.setBounds(170, 14, 86, 20);
		panel1.add(txtNoviIznosOsnovice);
		txtNoviIznosOsnovice.setColumns(10);
		
		JLabel lblBrojRadnihDana = new JLabel("Broj radnih dana:");
		lblBrojRadnihDana.setBounds(347, 17, 139, 14);
		panel1.add(lblBrojRadnihDana);
		
		txtBrojRadnihDana = new JTextField();
		txtBrojRadnihDana.setBounds(488, 14, 86, 20);
		panel1.add(txtBrojRadnihDana);
		txtBrojRadnihDana.setColumns(10);
		
		JLabel lblDatumOd = new JLabel("Datum od:");
		lblDatumOd.setBounds(23, 49, 120, 14);
		panel1.add(lblDatumOd);
		
		JCalendar calDatumOd = new JCalendar();
		calDatumOd.setBounds(23, 74, 233, 139);
		panel1.add(calDatumOd);
		
		JLabel lblDatumDo = new JLabel("Datum do:");
		lblDatumDo.setBounds(347, 49, 120, 14);
		panel1.add(lblDatumDo);
		
		JCalendar calDatumDo = new JCalendar();
		calDatumDo.setBounds(347, 74, 227, 139);
		panel1.add(calDatumDo);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPotvrdi.setBounds(518, 224, 89, 23);
		panel1.add(btnPotvrdi);
		JComponent panel2 = new JPanel();
		tabbedPane.addTab("Bolovanje", panel2);
		panel2.setLayout(null);
		
		JLabel lblDatumOd_2 = new JLabel("Datum od:");
		lblDatumOd_2.setBounds(58, 23, 198, 14);
		panel2.add(lblDatumOd_2);
		
		JCalendar calDatumOd_2 = new JCalendar();
		calDatumOd_2.setBounds(58, 48, 198, 153);
		panel2.add(calDatumOd_2);
		
		JLabel lblDatumDo_2 = new JLabel("Datum do:");
		lblDatumDo_2.setBounds(320, 23, 198, 14);
		panel2.add(lblDatumDo_2);
		
		JCalendar calDatumDo_2 = new JCalendar();
		calDatumDo_2.setBounds(320, 48, 198, 153);
		panel2.add(calDatumDo_2);
		
		JButton btnPotvrdi_2 = new JButton("Potvrdi");
		btnPotvrdi_2.setBounds(518, 224, 89, 23);
		panel2.add(btnPotvrdi_2);
		JComponent panel3 = new JPanel();
		tabbedPane.addTab("Godišnji odmor", panel3);
		panel3.setLayout(null);
		
		JLabel lblDatumOd_3 = new JLabel("Datum od:");
		lblDatumOd_3.setBounds(59, 36, 177, 14);
		panel3.add(lblDatumOd_3);
		
		JCalendar calDatumOd_3 = new JCalendar();
		calDatumOd_3.setBounds(59, 61, 198, 153);
		panel3.add(calDatumOd_3);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSatnica.setBounds(16, 11, 88, 14);
		panel3.add(lblSatnica);
		
		txtSatnica = new JTextField();
		txtSatnica.setBounds(115, 8, 104, 20);
		panel3.add(txtSatnica);
		txtSatnica.setColumns(10);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(230, 11, 87, 14);
		panel3.add(lblKmh);
		
		JLabel lblDatumDo_3 = new JLabel("Datum do:");
		lblDatumDo_3.setBounds(321, 36, 171, 14);
		panel3.add(lblDatumDo_3);
		
		JCalendar calDatumDo_3 = new JCalendar();
		calDatumDo_3.setBounds(321, 61, 198, 153);
		panel3.add(calDatumDo_3);
		
		JButton btnPotvrdi_3 = new JButton("Potvrdi");
		btnPotvrdi_3.setBounds(518, 224, 89, 23);
		panel3.add(btnPotvrdi_3);
		JComponent panel4 = new JPanel();
		tabbedPane.addTab("Noćni rad", panel4);
		panel4.setLayout(null);
		
		JLabel lblSatnica_4 = new JLabel("Satnica:");
		lblSatnica_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSatnica_4.setBounds(94, 81, 143, 14);
		panel4.add(lblSatnica_4);
		
		txtSatnica_4 = new JTextField();
		txtSatnica_4.setBounds(247, 78, 143, 20);
		panel4.add(txtSatnica_4);
		txtSatnica_4.setColumns(10);
		
		JLabel lblKmh_4 = new JLabel("KM/h");
		lblKmh_4.setBounds(400, 81, 95, 14);
		panel4.add(lblKmh_4);
		
		JLabel lblBrojSati = new JLabel("Broj sati:");
		lblBrojSati.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojSati.setBounds(94, 135, 143, 14);
		panel4.add(lblBrojSati);
		
		txtBrojSati = new JTextField();
		txtBrojSati.setBounds(247, 132, 143, 20);
		panel4.add(txtBrojSati);
		txtBrojSati.setColumns(10);
		
		JButton btnPotvrdi_4 = new JButton("Potvrdi");
		btnPotvrdi_4.setBounds(518, 224, 89, 23);
		panel4.add(btnPotvrdi_4);
		JComponent panel5 = new JPanel();
		tabbedPane.addTab("Praznici", panel5);
		panel5.setLayout(null);
		
		JLabel lblPraznik = new JLabel("Praznik:");
		lblPraznik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPraznik.setBounds(126, 85, 118, 14);
		panel5.add(lblPraznik);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Nova godina", "Dan drzavnosti", "Dan nezavisnosti", "Dan rada", "Ramazanski bajram", "Kurban bajram", "Katolicki bozic", "Pravoslavni bozic", "Uskrs", "Vaskrs"}));
		comboBox.setMaximumRowCount(15);
		comboBox.setBounds(254, 82, 142, 20);
		panel5.add(comboBox);
		
		JLabel lblBrojDana = new JLabel("Broj dana:");
		lblBrojDana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBrojDana.setBounds(126, 142, 118, 14);
		panel5.add(lblBrojDana);
		
		txtBrojDana = new JTextField();
		txtBrojDana.setBounds(254, 139, 142, 20);
		panel5.add(txtBrojDana);
		txtBrojDana.setColumns(10);
		
		JButton btnPotvrdi_5 = new JButton("Potvrdi");
		btnPotvrdi_5.setBounds(518, 224, 89, 23);
		panel5.add(btnPotvrdi_5);
		JComponent panel6 = new JPanel();
		tabbedPane.addTab("Finalni obračun", panel6);
		panel6.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Iznos osnovice", "Radni dani", "Satnica", "Porez", "Dodaci", "Praznik", "Bolovanje", "Godi\u0161nji", "Neto plata", "Bruto plata"
			}
		));
		table.setBounds(10, 194, 452, -182);
		panel6.add(table);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(523, 297, 89, 23);
		frame.getContentPane().add(btnIzlaz);
	}
}
