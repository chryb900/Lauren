import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Background {

	private JFrame frame;
	Sound s = new Sound();
	boolean sound;
	JLabel imageLabel;
	BufferedImage myPicture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Background window = new Background();
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
	public Background() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnSound = new JRadioButton("Sound");
		rdbtnSound.setSelected(true);
		rdbtnSound.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sound = rdbtnSound.isSelected();
				if(sound)
					s.playMusic();
				else
					s.stopMusic();
				
			}
		});
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(rdbtnSound);
		
		JPanel background = new JPanel();
		frame.getContentPane().add(background);
		
		JButton btnPressMe = new JButton("Press Me");
		btnPressMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					myPicture = ImageIO.read(new File("Lauren.jpg"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		try {
			myPicture = ImageIO.read(new File("Lauren.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		background.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		background.add(picLabel);
		background.add(btnPressMe);
	}
}
