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

public class IzmjenaObracuna {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmjenaObracuna window = new IzmjenaObracuna();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 300);
		frame.setTitle("Izmjena obračuna");
		ImageIcon img = new ImageIcon("icons/calculator_icon.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(10, 11, 457, 207);
		frame.getContentPane().add(tabbedPane);
		
		JComponent panel1 = new JPanel();
		tabbedPane.addTab("Izmjena osnovice", panel1);
		panel1.setLayout(null);
		JComponent panel2 = new JPanel();
		tabbedPane.addTab("Bolovanje", panel2);
		panel2.setLayout(null);
		JComponent panel3 = new JPanel();
		tabbedPane.addTab("Godišnji odmor", panel3);
		panel3.setLayout(null);
		JComponent panel4 = new JPanel();
		tabbedPane.addTab("Noćni rad", panel4);
		panel4.setLayout(null);
		JComponent panel5 = new JPanel();
		tabbedPane.addTab("Praznici", panel5);
		panel5.setLayout(null);
		JComponent panel6 = new JPanel();
		tabbedPane.addTab("Finalni obračun", panel6);
		panel6.setLayout(null);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnIzlaz.setBounds(378, 229, 89, 23);
		frame.getContentPane().add(btnIzlaz);
	}
}
