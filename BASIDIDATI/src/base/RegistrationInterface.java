package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationInterface extends JFrame {
	
	
	public RegistrationInterface() {
		
		setName("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		
		setSize(450, 470); 
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		JPanel p = new JPanel();
		p.setBackground(new Color(217, 217, 217));		
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		
		p1.setPreferredSize(new Dimension(600,40));
		p1.setBackground(new Color(217, 217, 217));		
		JLabel registrazione = new JLabel("Registrazione");
		registrazione.setFont(new Font("Copperplate gothic bold", Font.PLAIN,23));			
		p1.add(registrazione);		
		
		p2.setBackground(new Color(217, 217, 217));	
		p2.setPreferredSize(new Dimension(600,40));
		JLabel username = new JLabel("Username:  ");
		JTextField tfusername = new JTextField(20);
		p2.add(username);
		p2.add(tfusername);
		
		p9.setBackground(new Color(217, 217, 217));	
		p9.setPreferredSize(new Dimension(600,40));
		JLabel email = new JLabel("      E-mail:  ");
		JTextField tfemail = new JTextField(20);
		p9.add(email);
		p9.add(tfemail);	
		
		p3.setBackground(new Color(217, 217, 217));
		p3.setBackground(new Color(217, 217, 217));
		p3.setPreferredSize(new Dimension(600,40));
		JLabel password = new JLabel("Password:  ");
		JTextField tfpassword = new JTextField(20);
		p3.add(password);
		p3.add(tfpassword);
		
		p4.setBackground(new Color(217, 217, 217));
		p4.setBackground(new Color(217, 217, 217));
		p4.setPreferredSize(new Dimension(600,40));
		JLabel nome = new JLabel("       Nome:  ");
		JTextField tfnome = new JTextField(20);
		p4.add(nome);
		p4.add(tfnome);
		
		p5.setBackground(new Color(217, 217, 217));
		p5.setBackground(new Color(217, 217, 217));
		p5.setPreferredSize(new Dimension(600,40));
		JLabel cognome = new JLabel("Cognome:  ");
		JTextField tfcognome = new JTextField(20);
		p5.add(cognome);
		p5.add(tfcognome);
		
		p6.setBackground(new Color(217, 217, 217));
		p6.setBackground(new Color(217, 217, 217));
		p6.setPreferredSize(new Dimension(600,40));
		JLabel data = new JLabel("Data di nascita (aaaa/mm/gg):  ");
		JTextField tfdata = new JTextField(10);
		p6.add(data);
		p6.add(tfdata);
		
		p7.setBackground(new Color(217, 217, 217));
		p7.setBackground(new Color(217, 217, 217));
		p7.setPreferredSize(new Dimension(600,40));
		JLabel nazionalita = new JLabel("Nazionalità:  ");
		JTextField tfnazionalita = new JTextField(20);
		p7.add(nazionalita);
		p7.add(tfnazionalita);
		
		p8.setBackground(new Color(217, 217, 217));
		p8.setBackground(new Color(217, 217, 217));
		p8.setPreferredSize(new Dimension(600,40));
		JButton button= new JButton("Registrami");
		JCheckBox box = new JCheckBox("Viewer", true);
		box.setEnabled(false);
		JCheckBox box1 = new JCheckBox("Streamer", false);
	    button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setBackground(new Color(242, 242, 242));	
        p8.add(button);	
        p8.add(box);
        p8.add(box1);
		
        p.add(p1);
		p.add(p2);
		p.add(p9);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		p.add(p8);
		add(p);
		
		setVisible(true);
		
		button.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {
				
				Connections x = new Connections();
				x.Connessione();
				if( (x.registrationQuery(tfusername.getText(), tfpassword.getText(), tfemail.getText(), 
						tfnome.getText(), tfcognome.getText(), tfdata.getText(), tfnazionalita.getText(), box1.isSelected())) == true)	{			
					
				setVisible(false);
	    		new LoggedInterface(tfusername.getText(), tfnome.getText(), tfcognome.getText(), x); 	    		
				}
			}
		});		
		
	}	

}
