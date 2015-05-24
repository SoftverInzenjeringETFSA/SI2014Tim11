package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Operater;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Zaposlenik;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperateriRaspodjela {

	private JFrame frame;
	private JTextField txtID;
	private JTable table;
	private static Operater _o;
	private List<Operater> _operateri;
	private List<Firma> _firme;
private Firma _f;
private static Admin _a;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					OperateriRaspodjela window;
					if(_a != null) {
						window = new OperateriRaspodjela(_a);
					}
					else {
						window = new OperateriRaspodjela();
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
	public OperateriRaspodjela() {
		initialize();
	}

	public OperateriRaspodjela(Admin a) {
		
	_a=a;
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 325);
		frame.setTitle("Operateri");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.getContentPane().setLayout(null);
		_operateri = Sistem.Operateri.lista();
		_firme = Sistem.Firme.lista();
		
		
		JLabel lblFirma = new JLabel("Firma");
		lblFirma.setBounds(20, 11, 46, 14);
		frame.getContentPane().add(lblFirma);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(168, 11, 46, 14);
		frame.getContentPane().add(lblId);
	
		
		txtID = new JTextField();
		txtID.setBounds(153, 36, 86, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		txtID.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
			 		        "Ime",
			 		        "Prezime"
			 		       };

			 		DefaultTableModel model = new DefaultTableModel();
			 		table.setModel(model);
			 		model.setColumnIdentifiers(kolone);
			 		for(Operater o : _f.getOperateri()) {
			 			if(o != null) {
			 				if(txtID.getText().length() == 0) {
			 					Object[] o1 = new Object[3];
			 					  o1[0] = o.getId();
			 					  o1[1] = o.getIme();
			 					  o1[2] = o.getPrezime();
			 					 
			 					  model.addRow(o1);
			 					  break;
			 				}
			 				if(o.getId().toString().contains(txtID.getText())) {
			 					Object[] o1 = new Object[3];
			 					  o1[0] = o.getId();
			 					  o1[1] = o.getIme();
			 					  o1[2] = o.getPrezime();
			 			
			 					  model.addRow(o1);
			 				}
			 			}
			 		}

		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
		 		        "Ime",
		 		        "Prezime"
		 		        };

		 		DefaultTableModel model = new DefaultTableModel();
		 		table.setModel(model);
		 		model.setColumnIdentifiers(kolone);
		 		for(Operater o : _f.getOperateri()) {
		 			if(o != null) {
		 				if(o.getId().toString().contains(txtID.getText())) {
		 					Object[] o1 = new Object[3];
		 					  o1[0] = o.getId();
		 					  o1[1] = o.getIme();
		 					  o1[2] = o.getPrezime();
		 					
		 					  model.addRow(o1);
		 				}
		 			}
		 		}
		     }

		     public void changedUpdate(DocumentEvent e) {
		        // TODO add code!

		     }
		  });
		
		
		JLabel lblSlika = new JLabel("Pretraži");
		lblSlika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlika.setBounds(249, 33, 73, 23);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 302, 183);
		frame.getContentPane().add(scrollPane);
		

		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		class ItemChangeListener implements ItemListener{
		    public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		          Object item = event.getItem();
		          if(_firme.size() != 0) {
		        	  for(Firma f : _firme) {
		        		  if(f != null) {
		        			  if(f.toString().equals(item)) {
							 		for(Operater o : _operateri) {
							 			if(o != null) {
							 				if(o.equals(o.getFirma())) {
							 					_f = f;
							 					String[] kolone = {"ID",
							 					        "Ime",
							 					        "Prezime",
							 					       };
							 					
							 					DefaultTableModel model = new DefaultTableModel();
							 					table.setModel(model);
							 					model.setColumnIdentifiers(kolone);
							 					
							 					Object[] o1 = new Object[3];
							 					  o1[0] =o.getId();
							 					  o1[1] =o.getIme();
							 					  o1[2] =o.getPrezime();
							 			
							 					  model.addRow(o1);
							 				}
							 			}
							 		}
				        	  }
		        		  }
			          }
			       }
		        }		          
		    }       
		}
		
		JComboBox<String> comboFirma = new JComboBox<String>();
		
		comboFirma.setBounds(20, 36, 79, 20);
		comboFirma.addItemListener(new ItemChangeListener());
		frame.getContentPane().add(comboFirma);
		
		if(_firme.size() != 0) {
			for(Firma f : _firme) {
				if(f != null) {
					comboFirma.addItem(f.toString());
				}
			}
		}
		
		
		
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUredi.setBounds(322, 91, 89, 23);
		frame.getContentPane().add(btnUredi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				AdministratorPocetna op = new AdministratorPocetna(_a);
				op.main(null);
			}
		});
		btnIzlaz.setBounds(335, 255, 89, 20);
		frame.getContentPane().add(btnIzlaz);
		
		
	
	if(table.getSelectedRow() == -1) {
		btnUredi.setEnabled(false);
		
	}
		
		
	}
}
