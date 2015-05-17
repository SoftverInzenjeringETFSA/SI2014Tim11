package ba.unsa.etf.si.Tim11.Projekat_Tim11.GUI;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AzuriranjeFirmi {

	private JFrame frame;
	private JTextField textUnosID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AzuriranjeFirmi window = new AzuriranjeFirmi();
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
	public AzuriranjeFirmi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblId);
		
		textUnosID = new JTextField();
		textUnosID.setBounds(33, 11, 86, 20);
		frame.getContentPane().add(textUnosID);
		textUnosID.setColumns(10);
		
		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(129, 11, 60, 30);
		//ImageIcon img = new ImageIcon("icons/search.png");
		
		frame.getContentPane().add(lblSlika);
		//frame.setIconImage(img.getImage());
		lblSlika.setIcon(new ImageIcon("icons/search.png"));
		
		



		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(298, 34, 126, 20);
		frame.getContentPane().add(btnDodaj);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.setBounds(298, 74, 126, 20);
		frame.getContentPane().add(btnUredi);
		
		JButton btnBrisi = new JButton("Briši");
		btnBrisi.setBounds(298, 117, 126, 20);
		frame.getContentPane().add(btnBrisi);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setBounds(298, 179, 126, 20);
		frame.getContentPane().add(btnIzlaz);


		
	}
	
	/*private Image ScaledImage(String string, int w, int h){
	BufferedImage resizedImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
	Graphics2D g2=resizedImage.createGraphics();
	g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g2.drawImage(string,0,0,w,h,null);	
	g2.dispose();
	return resizedImage;
	}*/
	


	
	
	
}
