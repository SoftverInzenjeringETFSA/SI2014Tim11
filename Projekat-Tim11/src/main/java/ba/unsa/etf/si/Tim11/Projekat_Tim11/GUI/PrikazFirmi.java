package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PrikazFirmi extends JFrame{

	private JFrame frmPrikazFirmi;
	private JTextField textField;

	private	JPanel	Panel;

	private	JScrollPane scrollPane;
	private JTable table;
	

	

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
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 21, 46, 14);
		frmPrikazFirmi.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(30, 18, 86, 20);
		frmPrikazFirmi.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(128, 21, 46, 17);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		frmPrikazFirmi.getContentPane().add(lblSlika);


		
		
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(340, 67, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnDodaj);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.setBounds(340, 102, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnUredi);
		
		JButton btnBrii = new JButton("Briši");
		btnBrii.setBounds(340, 136, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnBrii);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(335, 208, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnIzlaz);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 315, 150);
		frmPrikazFirmi.getContentPane().add(panel);
		
	

	
		
		  String data[][] = {{"005","Naziv","Neka","Sarajevo"},
				   {"002","Naziv1","ABC","Kanada"},
				   {"003","naziv2","DEF","India"},
				   {"004","Naziv3","GH","India"},
				   {"004","Naziv4","IJK","India"}};
		  
				  String col[] = {"ID","Naziv","Vrsta","Sjedište"};
				  table = new JTable(data,col);
				  
				  JScrollPane scrollPane= new JScrollPane(table);
				  scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
					panel.add(scrollPane);
					
					
					
				}

		}

