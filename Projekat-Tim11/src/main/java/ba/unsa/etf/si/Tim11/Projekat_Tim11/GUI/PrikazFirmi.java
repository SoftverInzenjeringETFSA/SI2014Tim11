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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PrikazFirmi extends JFrame{

	private JFrame frmPrikazFirmi;
	private JTextField txtNaziv;
	private JTable table;
	private List<Firma>_firme;
	private static Admin  _a;
	private static Firma _f;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazFirmi window;
					if(_a != null) {
						window = new PrikazFirmi(_a);
					}
					else {
						window = new PrikazFirmi();
					}
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

	public PrikazFirmi(Admin _a2) {
		// TODO Auto-generated constructor stub
		initialize();
		_a=_a2;
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
		


		
		JLabel lbNaziv = new JLabel("Naziv");
		lbNaziv.setBounds(10, 21, 47, 14);
		frmPrikazFirmi.getContentPane().add(lbNaziv);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(67, 18, 86, 20);
		frmPrikazFirmi.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		txtNaziv.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
			 		        "Naziv",
			 		        "Sjedište",
			 		     };

			 		DefaultTableModel model = new DefaultTableModel();
			 		table.setModel(model);
			 		model.setColumnIdentifiers(kolone);
			 		for(Firma f : _firme) {
			 			if(f != null) {
			 				if(f.getIme().toString().contains(txtNaziv.getText())) {
			 					Object[] o = new Object[3];
			 					  o[0] = f.getId();
			 					  o[1] = f.getIme();
			 					  o[2] = f.getSjediste();
			 					 
			 					  model.addRow(o);
			 				}
			 			}
			 		}

		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 String[] kolone = {"ID",
		 		        "Naziv",
		 		        "Sjediste",
		 		       };

		 		DefaultTableModel model = new DefaultTableModel();
		 		table.setModel(model);
		 		model.setColumnIdentifiers(kolone);
		 		for(Firma f : _firme) {
		 			if(f != null) {
		 				if(f.getIme().toString().contains(txtNaziv.getText())) {
		 					Object[] o = new Object[3];
		 					  o[0] = f.getId();
		 					  o[1] = f.getIme();
		 					  o[2] =f.getSjediste();
		 					
		 					  model.addRow(o);
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
		lblSlika.setBounds(163, 20, 89, 17);
		lblSlika.setIcon(new ImageIcon("icons/search16.png"));
		frmPrikazFirmi.getContentPane().add(lblSlika);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 302, 193);
		frmPrikazFirmi.getContentPane().add(scrollPane);
		
		table = new JTable(){
		private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };
		scrollPane.setViewportView(table);
		
		
		String[] kolone = {"ID",
		        "Naziv",
		        "Sjedište",
		        };

		final DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(kolone);
		for (Firma f : _firme) {
			  Object[] o = new Object[4];
			  o[0] = f.getId();
			  o[1] = f.getIme();
			  o[2] = f.getSjediste();
			 
			  model.addRow(o);
		}
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					frmPrikazFirmi.dispose();
			DodavanjeEditovanjeFirmi df= new DodavanjeEditovanjeFirmi(_a);
					df.main(null);
				}
			});
		btnDodaj.setBounds(340, 67, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnDodaj);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				int selectedRowIndex = table.getSelectedRow();
				for (Firma f : _firme) {
				if(table.isRowSelected(selectedRowIndex)&& f.getId()==(Long)table.getModel().getValueAt(selectedRowIndex, 0)){
							frmPrikazFirmi.dispose();
						DodavanjeEditovanjeFirmi ef = new DodavanjeEditovanjeFirmi(f,_a);
						ef.main(null);
						break;
					}
				}
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frmPrikazFirmi, "Morate selektovati firmu");
				}
			}
		});
		
		btnUredi.setBounds(340, 102, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnUredi);
		
		class ItemChangeListener implements ItemListener{
		    public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		          Object item = event.getItem();
		          if(_firme.size() != 0) {
		        	  for(Firma f : _firme) {
		        		  if(f != null) {
		        			  if(f.toString().equals(item)) {
							 		for(Firma f1 : _firme) {
							 			if(f1 != null) {
							 				if(f1.getIme().equals(f)) {
							 					String[] kolone = {"ID",
							 					        "Naziv",
							 					        "Sjediste",
							 					        };
							 					
							 					DefaultTableModel model = new DefaultTableModel();
							 					table.setModel(model);
							 					model.setColumnIdentifiers(kolone);
							 					
							 					Object[] o = new Object[4];
							 					  o[0] = f.getId();
							 					  o[1] = f.getIme();
							 					  o[2] = f.getSjediste();
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
		
		
		
		final JButton btnBrii = new JButton("Brisanje");
		btnBrii.setBounds(340, 136, 89, 23);
		btnBrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION) {
					int selectedRowIndex = table.getSelectedRow();
					for (Firma f : _firme) {
						if (table.isRowSelected(selectedRowIndex) && f.getId() ==(Long) table.getModel().getValueAt(selectedRowIndex, 0)) {
							String ispis = "Uspješno ste obrisali firmu: " + f.getIme();
						Sistem.Firme.izbrisi((int)f.getId());
				_firme.remove(f);
				table.clearSelection();
				model.removeRow(selectedRowIndex);
				
		
							JOptionPane.showMessageDialog(frmPrikazFirmi, ispis);
							break;
						}
					}
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
				}
			}
		});
		frmPrikazFirmi.getContentPane().add(btnBrii);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPrikazFirmi.dispose();
				AdministratorPocetna ap = new AdministratorPocetna(_a);
				ap.main(null);
			}
		});
		btnIzlaz.setBounds(335, 208, 89, 23);
		frmPrikazFirmi.getContentPane().add(btnIzlaz);
		
		
					
				}
		}

