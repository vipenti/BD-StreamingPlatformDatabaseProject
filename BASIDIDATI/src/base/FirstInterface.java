package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FirstInterface extends JFrame {
	static Connections x;
	public FirstInterface()
	{
		/* FRAME EDITOR */
		this.setName("Effettua l'accesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 400); 
		setBackground(new Color(217, 217, 217));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		
		/* PANEL*/
		JPanel panel = new JPanel();
	    panel.setBackground(new Color(217, 217, 217));	    
	    
	    /* TITLE */
	    JLabel l= new JLabel("        Streaming Platform");
	    l.setForeground(new Color(0, 0, 0));
	    l.setFont(new Font("Copperplate gothic bold", Font.PLAIN,35));	   
	    
	    /* BUTTONS EDITOR */
	    JButton b1= new JButton("LOGIN");
	    JButton b2= new JButton("REGISTRAZIONE");
	    b1.setFocusPainted(false);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBackground(new Color(242, 242, 242));
        b2.setFocusPainted(false);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBackground(new Color(242, 242, 242));
        b1.setPreferredSize(new Dimension(180,50));
	    b2.setPreferredSize(new Dimension(180,50));
        
        /* BUTTONS PANELS */
        JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    p1.add(b1,new BorderLayout().SOUTH);
	    p2.add(b2,new BorderLayout().CENTER);
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));

	    /* PANELS ON FRAME */
	    panel.setLayout(new GridLayout(3,1)); 
	    panel.add(l); 
	    panel.add(p1);
	    panel.add(p2);
	  
	   
	    add(panel, BorderLayout.CENTER);
	    panel.setLocation(new Point(panel.getLocation().x, (panel.getLocation().y+100)));	    
	    
	    /* ACTION LISTENERS */	    
	    b1.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		setVisible(false);	    		
	    		new LoginListener();	    	
	    	}
	    });	
	    
	    b2.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent ez) {
	    		
	    		setVisible(false);	    		
	    		new RegistrationInterface();
	    	}
	    });

	}//fine costruttore
}
