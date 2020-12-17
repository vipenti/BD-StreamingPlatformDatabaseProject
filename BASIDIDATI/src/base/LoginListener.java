package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginListener {
	
	public LoginListener() {
		
		JFrame f = new JFrame("LOGIN");
		f.setSize(300, 180);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
		
		JPanel p=new JPanel();
		p.setBackground(new Color(217, 217, 217));
		f.add(p);
		JTextField t1= new JTextField(20);
		JTextField t2= new JTextField(20);
		t1.setBorder(new TitledBorder("E-Mail"));
		t2.setBorder(new TitledBorder("Password"));
		
		JButton b1 = new JButton("Log In");
		b1.setFocusPainted(false);
	    b1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    b1.setBackground(new Color(242, 242, 242));
		
		p.add(t1);
		p.add(t2);
		p.add(b1);
		
		b1.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent ezz) {	    		
	    		
	    		/* CONNESSIONE */	    		
	    		Connections con = new Connections();
	    		con.Connessione();
	    		String email= t1.getText();
	    		String psw = t2.getText();
	    		
	    		
	    		String[] res= con.query(email, psw).clone();	
	    		
	    		if(res[0] == null) {
	    			
	    			JOptionPane.showMessageDialog(null,"Account non trovato","Errore", JOptionPane.ERROR_MESSAGE);
	    			return;
	    		}
	    		
	    		else {
	    			f.setVisible(false);	    		
	    			new LoggedInterface(res[0], res[1], res[2], con); 
	    		}	    		
	    	}
	    });

	}
	
	

}
