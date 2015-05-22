package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import java.util.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

public class Obracun {

	private JFrame frame;
	private static Operater _o;
	private List<Zaposlenik> _zaposlenici;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obracun window;
					if(_o != null) {
						window = new Obracun(_o);
					}
					else {
						window = new Obracun();
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
	public Obracun() {
		initialize();
	}
	
	public Obracun(Operater o) {
		initialize();
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Obračuni");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		_zaposlenici = Sistem.Zaposlenici.lista();
		
		JLabel lblUposlenici = new JLabel("Uposlenici");
		lblUposlenici.setBounds(10, 11, 200, 50);
		frame.getContentPane().add(lblUposlenici);
		
		final JButton btnIzmjeneObracuna = new JButton("Izmjene obračuna");
		btnIzmjeneObracuna.setBounds(119, 213, 148, 23);
		btnIzmjeneObracuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = table.getSelectedRow();
				for (Zaposlenik z : _zaposlenici) {
					if (table.isRowSelected(selectedRowIndex) && z.getId() == table.getModel().getValueAt(selectedRowIndex, 0)) {
						frame.dispose();
						IzmjenaObracuna io = new IzmjenaObracuna(z, _o);
						io.main(null);
						break;
					}
				}
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Morate selektovati nekog zaposlenika");
				}
			}
		});
		frame.getContentPane().add(btnIzmjeneObracuna);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(276, 213, 148, 23);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OperaterPocetna op = new OperaterPocetna(_o);
				op.main(null);
			}
		});
		frame.getContentPane().add(btnIzlaz);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 152);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            btnIzmjeneObracuna.setEnabled(true);
	        }
	    });
		
		String[] kolone = {"ID",
		        "Ime",
		        "Prezime",
		        "Odjel"};

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(kolone);
		for (Zaposlenik z : _zaposlenici) {
			  Object[] o = new Object[4];
			  o[0] = z.getId();
			  o[1] = z.getIme();
			  o[2] = z.getPrezime();
			  o[3] = z.getPozicija();
			  model.addRow(o);
		}
		
		if(table.getSelectedRow() == -1) {
			btnIzmjeneObracuna.setEnabled(false);
		}
	}
}
