package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ba.unsa.etf.si.Tim11.Projekat_Tim11.Klase.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private Osoba _o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_o=new Osoba("John","Doe");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel lbl_ime = new JLabel("Ime:  ");
		lbl_ime.setBounds(118, 82, 243, 73);
		frame.getContentPane().add(lbl_ime);
		
		final JButton btn_ime = new JButton("Prikaži ime");
		btn_ime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_ime.setText(lbl_ime.getText() + _o.getIme() + " " + _o.getPrezime());
				btn_ime.setVisible(false);
			}
		});
		btn_ime.setBounds(164, 166, 113, 52);
		frame.getContentPane().add(btn_ime);
	}
}
