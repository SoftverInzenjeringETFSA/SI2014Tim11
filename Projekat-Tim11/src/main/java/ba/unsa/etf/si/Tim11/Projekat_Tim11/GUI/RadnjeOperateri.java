package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Admin;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Firma;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Operater;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.Sistem;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadnjeOperateri {

	private JFrame frame;
	private JTextField txtID;
	private JTable table;
	private static Admin _a;
	private static Operater _o;
	private List<Operater> _operateri;
	private List<Firma> _firme;
private Firma _f;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					RadnjeOperateri window;
					if(_a != null) {
						window = new RadnjeOperateri(_a);
					}
					else {
						window = new RadnjeOperateri();
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
	public RadnjeOperateri() {
		initialize();
	}



	public RadnjeOperateri(Admin _a2) {
		_a=_a2;
		// TODO Auto-generated constructor stub
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 300);
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
		lblId.setBounds(154, 11, 46, 14);
		frame.getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(149, 25, 86, 20);
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
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DodavanjeEditovanjeOperatera de = new DodavanjeEditovanjeOperatera(_f, _a);
				de.main(null);
			}
		});
	

			
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodaj.setBounds(322, 64, 132, 23);
		frame.getContentPane().add(btnDodaj);
		
		JButton btnObrii = new JButton("Obriši");
		btnObrii.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnObrii.setBounds(322, 108, 132, 23);
		frame.getContentPane().add(btnObrii);
		
		JButton btnDodajPermisiju = new JButton("Dodaj permisiju");
		btnDodajPermisiju.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodajPermisiju.setBounds(322, 153, 132, 23);
		frame.getContentPane().add(btnDodajPermisiju);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdministratorPocetna ap = new AdministratorPocetna(_a);
				ap.main(null);
			}
		});
		btnIzlaz.setBounds(380, 227, 72, 23);
		frame.getContentPane().add(btnIzlaz);
		
		JLabel lblSlika = new JLabel("Pretrazi");
		lblSlika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSlika.setBounds(240, 21, 72, 29);
		frame.getContentPane().add(lblSlika);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 302, 183);
		frame.getContentPane().add(scrollPane);
		

		table = new JTable(){ private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
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
		
		comboFirma.setBounds(20, 25, 106, 20);
		comboFirma.addItemListener(new ItemChangeListener());
		frame.getContentPane().add(comboFirma);
		
		if(_firme.size() != 0) {
			for(Firma f : _firme) {
				if(f != null) {
					comboFirma.addItem(f.toString());
				}
			}
		}
		
		
		
		
		
		
	
	}
}
