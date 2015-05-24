package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.Sistem.*;

import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JScrollPane;

public class OperatoriPrikazAdmin {

	private JFrame frame;
	private JTextField txtID;
	private static Operater _o;
	private List<Zaposlenik> _zaposlenici;
	private List<Firma> _firme;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatoriPrikazAdmin window;
					if(_o != null) {
						window = new OperatoriPrikazAdmin(_o);
					}
					else {
						window = new OperatoriPrikazAdmin();
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
	public OperatoriPrikazAdmin() {
		initialize();
	}
	
	public OperatoriPrikazAdmin(Operater o) {
		initialize();
		_o = o;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 330);
		frame.setTitle("Operateri");
		ImageIcon img = new ImageIcon("icons/staff_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_zaposlenici = Sistem.Zaposlenici.lista();
		_firme = Sistem.Firme.lista();
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirma = new JLabel("Firma:");
		lblFirma.setBounds(-31, 39, 102, 14);
		lblFirma.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblFirma);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 335, 155);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
    
		scrollPane.setViewportView(table);
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
		
		class ItemChangeListener implements ItemListener{
		    public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		          Object item = event.getItem();
		          if(_firme.size() != 0) {
		        	  for(Firma f : _firme) {
		        		  if(f != null) {
		        			  if(f.toString().equals(item)) {
							 		for(Zaposlenik z : _zaposlenici) {
							 			if(z != null) {
							 				if(f.equals(z.getFirma())) {
							 					String[] kolone = {"ID",
							 					        "Ime",
							 					        "Prezime",
							 					        "Odjel"};
							 					
							 					DefaultTableModel model = new DefaultTableModel();
							 					table.setModel(model);
							 					model.setColumnIdentifiers(kolone);
							 					
							 					Object[] o = new Object[4];
							 					  o[0] = z.getId();
							 					  o[1] = z.getIme();
							 					  o[2] = z.getPrezime();
							 					  o[3] = z.getPozicija();
							 					  model.addRow(o);
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
		comboFirma.setBounds(81, 36, 124, 20);
		comboFirma.addItemListener(new ItemChangeListener());
		frame.getContentPane().add(comboFirma);
		
		if(_firme.size() != 0) {
			for(Firma f : _firme) {
				if(f != null) {
					comboFirma.addItem(f.toString());
				}
			}
		}
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(215, 39, 70, 14);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(295, 36, 124, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		txtID.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
			 		        "Ime",
			 		        "Prezime",
			 		        "Odjel"};

			 		DefaultTableModel model = new DefaultTableModel();
			 		table.setModel(model);
			 		model.setColumnIdentifiers(kolone);
			 		for(Zaposlenik z : _zaposlenici) {
			 			if(z != null) {
			 				if(z.getId().toString().contains(txtID.getText())) {
			 					Object[] o = new Object[4];
			 					  o[0] = z.getId();
			 					  o[1] = z.getIme();
			 					  o[2] = z.getPrezime();
			 					  o[3] = z.getPozicija();
			 					  model.addRow(o);
			 				}
			 			}
			 		}

		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
		 		        "Ime",
		 		        "Prezime",
		 		        "Odjel"};

		 		DefaultTableModel model = new DefaultTableModel();
		 		table.setModel(model);
		 		model.setColumnIdentifiers(kolone);
		 		for(Zaposlenik z : _zaposlenici) {
		 			if(z != null) {
		 				if(z.getId().toString().contains(txtID.getText())) {
		 					Object[] o = new Object[4];
		 					  o[0] = z.getId();
		 					  o[1] = z.getIme();
		 					  o[2] = z.getPrezime();
		 					  o[3] = z.getPozicija();
		 					  model.addRow(o);
		 				}
		 			}
		 		}
		     }

		     public void changedUpdate(DocumentEvent e) {
		        // TODO add code!

		     }
		  });
		
		JButton btnDodavanje = new JButton("Dodavanje");
		btnDodavanje.setBounds(355, 126, 124, 23);
		btnDodavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciUposlenika pu = new PodaciUposlenika();
				pu.main(null);
			}
		});
		frame.getContentPane().add(btnDodavanje);
		
		JButton btnAzuriranje = new JButton("Ažuriranje");
		btnAzuriranje.setBounds(355, 160, 124, 23);
		btnAzuriranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PodaciOperatera pu = new PodaciOperatera();
				pu.main(null);
			}
		});
		frame.getContentPane().add(btnAzuriranje);
		
		JButton btnDodajPermisiju = new JButton("Dodaj Permisiju");
		btnDodajPermisiju.setBounds(355, 194, 124, 23);
		btnDodajPermisiju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION) {
					
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		frame.getContentPane().add(btnDodajPermisiju);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(355, 258, 124, 23);
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OperaterPocetna op = new OperaterPocetna(_o);
				op.main(null);
			}
		});
		frame.getContentPane().add(btnIzlaz);
	}
}
