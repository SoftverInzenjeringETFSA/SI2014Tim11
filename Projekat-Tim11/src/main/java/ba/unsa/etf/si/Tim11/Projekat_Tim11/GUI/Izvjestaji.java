package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollPane;

public class Izvjestaji {

	private JFrame frame;
	private JTextField txtImeRadnika;
	private JTextField txtPrezimeRadnika;
	private JTextField txtVrstaIzvjestaja;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Izvjestaji window = new Izvjestaji();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 519, 195);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblImeRadnika = new JLabel("Ime radnika:");
		lblImeRadnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImeRadnika.setBounds(-56, 42, 163, 14);
		panel.add(lblImeRadnika);
		
		txtImeRadnika = new JTextField();
		txtImeRadnika.setBounds(117, 39, 134, 20);
		panel.add(txtImeRadnika);
		txtImeRadnika.setColumns(10);
		
		JLabel lblPrezimeRadnika = new JLabel("Prezime radnika:");
		lblPrezimeRadnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezimeRadnika.setBounds(-21, 88, 128, 14);
		panel.add(lblPrezimeRadnika);
		
		txtPrezimeRadnika = new JTextField();
		txtPrezimeRadnika.setBounds(117, 85, 134, 20);
		panel.add(txtPrezimeRadnika);
		txtPrezimeRadnika.setColumns(10);
		
		JLabel lblVrstaIzvjestaja = new JLabel("Vrsta izvještaja:");
		lblVrstaIzvjestaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVrstaIzvjestaja.setBounds(-21, 133, 128, 14);
		panel.add(lblVrstaIzvjestaja);
		
		txtVrstaIzvjestaja = new JTextField();
		txtVrstaIzvjestaja.setBounds(117, 130, 134, 20);
		panel.add(txtVrstaIzvjestaja);
		txtVrstaIzvjestaja.setColumns(10);
		
		JLabel lblDatumKreiranjaIzvjestaja = new JLabel("Datum kreiranja izvještaja:");
		lblDatumKreiranjaIzvjestaja.setBounds(274, 22, 235, 14);
		panel.add(lblDatumKreiranjaIzvjestaja);
		
		JCalendar calDatumKreiranja = new JCalendar();
		calDatumKreiranja.setBounds(274, 39, 235, 111);
		panel.add(calDatumKreiranja);
		
		JButton btnKreirajIzvjestaj = new JButton("Kreiraj izvještaj");
		btnKreirajIzvjestaj.setBounds(358, 161, 151, 23);
		panel.add(btnKreirajIzvjestaj);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblImeRadnika, txtPrezimeRadnika, txtImeRadnika, lblPrezimeRadnika, lblVrstaIzvjestaja, txtVrstaIzvjestaja, lblDatumKreiranjaIzvjestaja, calDatumKreiranja, calDatumKreiranja.getMonthChooser(), calDatumKreiranja.getMonthChooser().getSpinner(), calDatumKreiranja.getMonthChooser().getComboBox(), calDatumKreiranja.getYearChooser(), calDatumKreiranja.getYearChooser().getSpinner(), calDatumKreiranja.getDayChooser(), calDatumKreiranja.getDayChooser().getDayPanel(), btnKreirajIzvjestaj}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 217, 519, 109);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPrikazi = new JButton("Prikaži");
		btnPrikazi.setBounds(420, 24, 89, 23);
		panel_1.add(btnPrikazi);
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.setBounds(420, 61, 89, 23);
		panel_1.add(btnObrisi);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 104, 415, -100);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setBounds(0, 11, 413, 87);
		panel_1.add(table);
		
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
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_1, panel, lblImeRadnika, txtImeRadnika, lblPrezimeRadnika, txtPrezimeRadnika, lblVrstaIzvjestaja, txtVrstaIzvjestaja, lblDatumKreiranjaIzvjestaja, calDatumKreiranja, calDatumKreiranja.getMonthChooser(), calDatumKreiranja.getMonthChooser().getSpinner(), calDatumKreiranja.getMonthChooser().getComboBox(), calDatumKreiranja.getYearChooser(), calDatumKreiranja.getYearChooser().getSpinner(), calDatumKreiranja.getDayChooser(), calDatumKreiranja.getDayChooser().getDayPanel(), btnKreirajIzvjestaj, btnPrikazi, btnObrisi, btnPrintanje, btnIzlaz}));
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtImeRadnika, txtPrezimeRadnika, txtVrstaIzvjestaja, btnKreirajIzvjestaj, btnPrikazi, btnObrisi, btnPrintanje, btnIzlaz, frame.getContentPane(), panel, lblImeRadnika, lblPrezimeRadnika, lblVrstaIzvjestaja, lblDatumKreiranjaIzvjestaja, calDatumKreiranja, calDatumKreiranja.getMonthChooser(), calDatumKreiranja.getMonthChooser().getSpinner(), calDatumKreiranja.getMonthChooser().getComboBox(), calDatumKreiranja.getYearChooser(), calDatumKreiranja.getYearChooser().getSpinner(), calDatumKreiranja.getDayChooser(), calDatumKreiranja.getDayChooser().getDayPanel(), panel_1}));
		ImageIcon img = new ImageIcon("icons/login_icon.png");
	}
}
