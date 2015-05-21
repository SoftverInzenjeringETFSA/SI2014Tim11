package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrikazFirmi extends JFrame{

	private JFrame frmPrikazFirmi;
	private JTextField textField;
	private JTable table;
	private List<Firma>_firme;

	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazFirmi window = new PrikazFirmi();
					window.frmPrikazFirmi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrikazFirmi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrikazFirmi = new JFrame();
		frmPrikazFirmi.setTitle("Prikaz Firmi");
		frmPrikazFirmi.setBounds(100, 100, 450, 310);
		frmPrikazFirmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrikazFirmi.getContentPane().setLayout(null);
		_firme = Sistem.Firme.lista();
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 21, 46, 14);
		frmPrikazFirmi.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(30, 18, 86, 20);
		frmPrikazFirmi.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSlika = new JLabel("Pretraži");
		lblSlika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlika.setBounds(128, 21, 89, 17);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		frmPrikazFirmi.getContentPane().add(lblSlika);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 302, 193);
		frmPrikazFirmi.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Naziv", "Sjedište"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setMinWidth(2);
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(340, 67, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnDodaj);
		
		JButton btnUredi = new JButton("Uredi");
		/*btnUredi.addActionListener(new ActionListener() {
			/*public void actionPerformed(ActionEvent arg0)  {
				int selectedRowIndex = table.getSelectedRow();
				for (Firma f : _firme) {
				//	if(table.isRowSelected(selectedRowIndex)&& f.getId()==table.getModel().getValueAt(selectedRowIndex, 0)){
							frmPrikazFirmi.dispose();
						EditovanjeFirma ef = new EditovanjeFirma(f);
						ef.main(null);
						break;
					}
				}
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Morate selektovati firmu");
				}
			}
		});*/
		btnUredi.setBounds(340, 102, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnUredi);
		
		JButton btnBrii = new JButton("Briši");
		btnBrii.setBounds(340, 136, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnBrii);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(335, 208, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnIzlaz);
		
	

					
				}
		}

