package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QueryInput extends JFrame {
	
	private Connections c;
	
	private String[] res = null;
	
	public QueryInput(Connections x) {
		
		c = x;
	}
	
	public void op2(JTextArea area) {	//FINITO
		
		JFrame f = new JFrame("Operazione 2");
		f.setSize(350, 340);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    JPanel p6 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p4.setBackground(new Color(217, 217, 217));
	    p5.setBackground(new Color(217, 217, 217));
	    p6.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 50));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    p4.setPreferredSize(new Dimension(380, 30));
	    p5.setPreferredSize(new Dimension(380, 30));
	    p6.setPreferredSize(new Dimension(380, 30));

	    
	    JLabel message = new JLabel("Inserisci un nuovo messaggio");
	    JLabel i1 = new JLabel("Codice: ");
	    JLabel i2 = new JLabel("Testo: ");
	    JLabel i3 = new JLabel("Minuto di invio: ");
	    JLabel i4 = new JLabel("Username: ");
	    JLabel i5 = new JLabel("URL Stream: ");
	    
	    message.setFont(new Font("", Font.BOLD, 15));
		ArrayList<String> users = c.getPrimaryKey("accountuser", "username");
		ArrayList<String> urls = c.getPrimaryKey("stream", "urlstream");
	    
	    JTextField t1 = new JTextField(10);
	    JTextField t2 = new JTextField(20);
	    JTextField t3 = new JTextField(10);
	    JComboBox t4 = new JComboBox(users.toArray());
	    JComboBox t5 = new JComboBox(urls.toArray());	
	    
	       
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {					
				
				 if((c.operazione2(t1.getText(), t2.getText(), t3.getText(), 
						t4.getSelectedItem().toString(), t5.getSelectedItem().toString())) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento riuscito. \n "
						+ "Codice: " + t1.getText() + "\nTesto: " + t2.getText() + "\nMinuto: "
						+ t3.getText() + "\nUsername mittente: " + t4.getSelectedItem().toString() + "\nURL Stream: "
						+ t5.getSelectedItem().toString());
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}
		});	 
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p4.add(i3);
	    p4.add(t3);
	    p5.add(i4);
	    p5.add(t4);
	    p6.add(i5);
	    p6.add(t5);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p4);
	    p.add(p5);
	    p.add(p6);
	    p.add(p7);
	    
	    f.add(p);
	    
	}
	
	public void op3(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 3");
		f.setSize(350, 360);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    JPanel p6 = new JPanel();
	    JPanel p7 = new JPanel();
	    JPanel p8 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p4.setBackground(new Color(217, 217, 217));
	    p5.setBackground(new Color(217, 217, 217));
	    p6.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	    p8.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 40));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    p4.setPreferredSize(new Dimension(380, 30));
	    p5.setPreferredSize(new Dimension(380, 30));
	    p6.setPreferredSize(new Dimension(380, 30));
	    p8.setPreferredSize(new Dimension(380, 30));

	    
	    JLabel message = new JLabel("Inserisci un nuovo stream");
	    JLabel i1 = new JLabel("URL Stream: ");
	    JLabel i2 = new JLabel("Nome: ");
	    JLabel i3 = new JLabel("Durata: ");
	    JLabel i4 = new JLabel("Lingua: ");
	    JLabel i5 = new JLabel("Streamer username: ");
	    JLabel i6 = new JLabel("Categoria: ");
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    ArrayList<String> users = c.getPrimaryKey("streamer", "username");
	    ArrayList<String> cat = c.getPrimaryKey("categoria", "nome");
	    
	    JTextField t1 = new JTextField(20);
	    t1.setText("http://streamplat.com/");
	    JTextField t2 = new JTextField(15);
	    JTextField t3 = new JTextField(10);
	    JTextField t4 = new JTextField(10);
	    JComboBox t5 = new JComboBox(users.toArray());	
	    JComboBox t6 = new JComboBox(cat.toArray());
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				if((c.operazione3(t1.getText(), t2.getText(), t3.getText(), 
						t4.getText(), t5.getSelectedItem().toString(), t6.getSelectedItem().toString())) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento riuscito. \n "
						+ "URL stream: " + t1.getText() + "\nNome: " + t2.getText() + "\nDurata: "
						+ t3.getText() + "\nLingua: " + t4.getText() + "\nUsername streamer: " 
						+ t5.getSelectedItem().toString() + "\nCategoria: " + t6.getSelectedItem().toString());
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p4.add(i3);
	    p4.add(t3);
	    p5.add(i4);
	    p5.add(t4);
	    p6.add(i5);
	    p6.add(t5);
	    p8.add(i6);
	    p8.add(t6);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p4);
	    p.add(p5);
	    p.add(p6);
	    p.add(p8);
	    p.add(p7);
	    
	    f.add(p);		
		
	}
	
	public void op4(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 4");
		f.setSize(350, 390);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    JPanel p6 = new JPanel();
	    JPanel p7 = new JPanel();
	    JPanel p8 = new JPanel();
	    JPanel p9 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p4.setBackground(new Color(217, 217, 217));
	    p5.setBackground(new Color(217, 217, 217));
	    p6.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	    p8.setBackground(new Color(217, 217, 217));
	    p9.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 50));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    p4.setPreferredSize(new Dimension(380, 30));
	    p5.setPreferredSize(new Dimension(380, 30));
	    p6.setPreferredSize(new Dimension(380, 30));
	    p8.setPreferredSize(new Dimension(380, 30));
	    p9.setPreferredSize(new Dimension(380, 30));   

	    
	    JLabel message = new JLabel("Inserisci un nuovo sponsor");
	    JLabel i1 = new JLabel("Nome: ");
	    JLabel i2 = new JLabel("Partita IVA: ");
	    JLabel i3 = new JLabel("Percentuale: ");
	    JLabel i4 = new JLabel("Codice prodotto: ");
	    JLabel i5 = new JLabel("Nome prodotto: ");
	    JLabel i6 = new JLabel("Streamer sponsorizzato: ");
	    JLabel i7 = new JLabel("Importo speso: ");
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    ArrayList<String> users = c.getPrimaryKey("streamer", "username");
	    
	    
	    JTextField t1 = new JTextField(10);
	    JTextField t2 = new JTextField(10);
	    JTextField t3 = new JTextField(10);
	    JTextField t4 = new JTextField(10);
	    JTextField t5 = new JTextField(10);
	    JComboBox t6 = new JComboBox(users.toArray());
	    JTextField t7 = new JTextField(6);
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				if((c.operazione4(t1.getText(), t2.getText(), t3.getText(), 
						t4.getText(), t5.getText(), t6.getSelectedItem().toString(), Integer.parseInt(t7.getText()))) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento sponsor riuscito. \n "
						+ "Nome: " + t1.getText() + "\nPartita IVA: " + t2.getText() + "\nPercentuale trattenuta: "
						+ t3.getText() + "%\n\nInserimento prodotto riuscito. \nCodice: " + t4.getText() + "\nNome sponsor: " 
						+ t1.getText() + "\nNome prodotto: " + t5.getText() + "\n\nDati sponsorizzazione: \nStreamer sponsorizzato: "
						+ t6.getSelectedItem().toString() + "\nImporto speso: $" + t7.getText());
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p4.add(i3);
	    p4.add(t3);
	    p5.add(i4);
	    p5.add(t4);
	    p6.add(i5);
	    p6.add(t5);
	    p8.add(i6);
	    p8.add(t6);
	    p9.add(i7);
	    p9.add(t7);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p4);
	    p.add(p5);
	    p.add(p6);
	    p.add(p8);
	    p.add(p9);
	    p.add(p7);
	    
	    f.add(p);		
		
	}
	
	public void op5(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 5");
		f.setSize(400, 300);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p4.setBackground(new Color(217, 217, 217));
	    p5.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 50));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    p4.setPreferredSize(new Dimension(380, 30));
	    p5.setPreferredSize(new Dimension(380, 30));
	    
	    JLabel message = new JLabel("Inserisci una nuova clip");
	    JLabel i1 = new JLabel("Username creatore: ");
	    JLabel i2 = new JLabel("Nome clip: ");
	    JLabel i3 = new JLabel("Durata: ");
	    JLabel i4 = new JLabel("URL Stream: ");	    
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    ArrayList<String> users = c.getPrimaryKey("accountuser", "username");
	    ArrayList<String> urls = c.getPrimaryKey("stream", "urlstream");	    
	    
	    JComboBox t1 = new JComboBox(users.toArray());
	    JTextField t2 = new JTextField(10);
	    JTextField t3 = new JTextField(10);
	    JComboBox t4 = new JComboBox(urls.toArray());
	    	
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if((c.operazione5(t1.getSelectedItem().toString(), t2.getText(), t3.getText(), 
						t4.getSelectedItem().toString())) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento riuscito. \n "
						+ "Username creatore: " + t1.getSelectedItem().toString() + "\nNome: " + t2.getText() + "\nDurata: "
						+ t3.getText() + "\nURL Stream: " + t4.getSelectedItem().toString());
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}		
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p4.add(i3);
	    p4.add(t3);
	    p5.add(i4);
	    p5.add(t4);

	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p4);
	    p.add(p5);
	    p.add(p7);
	    
	    f.add(p);		
		
	}
	
	public void op6(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 6");
		f.setSize(350, 300);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p4.setBackground(new Color(217, 217, 217));
	    p5.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 50));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    p4.setPreferredSize(new Dimension(380, 30));
	    p5.setPreferredSize(new Dimension(380, 30));
	    
	    JLabel message = new JLabel("Inserisci un nuovo moderatore");
	    JLabel i1 = new JLabel("Username: ");
	    JLabel i2 = new JLabel("Nome: ");
	    JLabel i3 = new JLabel("Cognome: ");
	    JLabel i4 = new JLabel("Valutazione (da 1 a 5): ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    String[] val = {"1", "2", "3", "4", "5"};
	    
	    JTextField t1 = new JTextField(10);
	    JTextField t2 = new JTextField(10);
	    JTextField t3 = new JTextField(10);
	    JComboBox t4 = new JComboBox(val);	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				if((c.operazione6(t1.getText(), t2.getText(), t3.getText(), 
						t4.getSelectedItem().toString())) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento riuscito. \n "
						+ "Username: " + t1.getText() + "\nNome: " + t2.getText() + "\nCognome: "
						+ t3.getText() + "\nValutazione: " + t4.getSelectedItem().toString() + "/5\n");
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p4.add(i3);
	    p4.add(t3);
	    p5.add(i4);
	    p5.add(t4);

	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p4);
	    p.add(p5);
	    p.add(p7);
	    
	    f.add(p);			
		
	}
	
	public void op7(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 7");
		f.setSize(350, 240);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p3.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(380, 50));
	    p2.setPreferredSize(new Dimension(380, 30));
	    p3.setPreferredSize(new Dimension(380, 30));
	    
	    JLabel message = new JLabel("Inserisci una nuova categoria");
	    JLabel i1 = new JLabel("Nome: ");
	    JLabel i2 = new JLabel("Descrizione: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    JTextField t1 = new JTextField(10);
	    JTextField t2 = new JTextField(20);	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if((c.operazione7(t1.getText(), t2.getText())) == true) {
					
					f.setVisible(false);
				
					area.setText("Inserimento riuscito. \n "
						+ "Nome: " + t1.getText() + "\nDescrizione: " + t2.getText());
				}
				
				else {
					
					f.setVisible(false);
					area.setText("INSERIMENTO FALLITO!");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p3.add(i2);
	    p3.add(t2);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p3);
	    p.add(p7);
	    
	    f.add(p);			
		
	}
	
	public void op8(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 8");
		f.setSize(500, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona lo streamer di cui visualizzare il numero di stream");
	    JLabel i1 = new JLabel("Streamer username: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    ArrayList<String> users = c.getPrimaryKey("streamer", "username");
	    
	    JComboBox t1 = new JComboBox(users.toArray());	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String res;
				res = c.operazione8(t1.getSelectedItem().toString());
				
				if(res != null)
					area.setText("Numero di stream effettuati da " + t1.getSelectedItem().toString() 
							+ ": " + res);
				
				else area.setText("FALLITO!");
				
				f.setVisible(false);
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}
	
	public void op9(JTextArea area) {   //FINITO
		
		JFrame f = new JFrame("Operazione 9");
		f.setSize(450, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona lo sponsor di cui visualizzare l'importo");
	    JLabel i1 = new JLabel("Nome sponsor: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    ArrayList<String> sponsor = c.getPrimaryKey("sponsor", "nome");
	    
	    JComboBox t1 = new JComboBox(sponsor.toArray());	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				String res;
				res = c.operazione9(t1.getSelectedItem().toString());
				
				if(res != null)
					area.setText("Importo totale speso da " + t1.getSelectedItem().toString() 
							+ ": $" + res);
				
				else area.setText("FALLITO!");
				
				f.setVisible(false);
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}
	
	public void op12(JTextArea area) {	//FINITO
		
		JFrame f = new JFrame("Operazione 12");
		f.setSize(360, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona il numero di ore minimo");
	    JLabel i1 = new JLabel("Numero ore: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    JTextField t1 = new JTextField(8);	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				ArrayList<String> list = c.operazione12(t1.getText());
				
				if(list.size() == 0)
					area.setText("Operazione riuscita.\n\nNessun risultato trovato!");
				
				else {
					
					area.setText("Operazione riuscita.\n\nUsername viewers: \n");				
					for(int i = 0; i < list.size(); i++) 					
					area.append("   "+ list.get(i)+"\n");
				}
				
				f.setVisible(false);
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}
	
	public void op13(JTextArea area) {  //FINITO
		
		JFrame f = new JFrame("Operazione 13");
		f.setSize(300, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona la parola da cercare");
	    JLabel i1 = new JLabel("Parola: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    JTextField t1 = new JTextField(15);	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			
				
				ArrayList<String> list = c.operazione13(t1.getText());
				
				if(list.size() == 0)
					area.setText("Operazione riuscita.\n\nNessun risultato trovato!");
				
				else {
					
					area.setText("Operazione riuscita.\n\nRisultati: \n");				
					for(int i = 0; i < list.size(); i++) 					
					area.append("   "+ list.get(i)+"\n");
				}
				
				f.setVisible(false);
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}	
	
	public void op14(JTextArea area) {  //FINITO
		
		JFrame f = new JFrame("Operazione 14");
		f.setSize(300, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona la lingua degli stream:");
	    JLabel i1 = new JLabel("Lingua: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    ArrayList<String> lingue = c.getPrimaryKey("stream", "lingua");
	    
	    JComboBox t1 = new JComboBox(lingue.toArray());   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> list = c.operazione14(t1.getSelectedItem().toString());

				if (list.size() > 0) {
					f.setVisible(false);
					area.setText("Operazione riuscita.\n Risultati: \n");
					for (int i = 0; i < list.size(); i++) {
						area.append(list.get(i));
					}
				} 
				else {
					f.setVisible(false);
					area.setText("Operazione riuscita.\n Nessun risultato.");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}	
	
	public void op15(JTextArea area) {	//FINITO
		
		JFrame f = new JFrame("Operazione 15");
		f.setSize(300, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
	    
	    JPanel p = new JPanel();
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p7 = new JPanel();
	    
	    p.setBackground(new Color(217, 217, 217));
	    p1.setBackground(new Color(217, 217, 217));
	    p2.setBackground(new Color(217, 217, 217));
	    p7.setBackground(new Color(217, 217, 217));
	   
	    p1.setPreferredSize(new Dimension(580, 50));
	    p2.setPreferredSize(new Dimension(580, 30));
	    
	    JLabel message = new JLabel("Seleziona l'importo speso");
	    JLabel i1 = new JLabel("Importo: ");	   
	    
	    message.setFont(new Font("", Font.BOLD, 15));
	    
	    JTextField t1 = new JTextField(8);	   
	    
	    JButton ok = new JButton("OK");
	    ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));	
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {	
				
				ArrayList<String> list = c.operazione15(t1.getText());

				if (list.size() > 0) {
					f.setVisible(false);
					area.setText("Operazione riuscita.\n\n");
					for (int i = 0; i < list.size(); i++) {
						area.append(list.get(i) + "\n");
					}
				} 
				else {
					f.setVisible(false);
					area.setText("Operazione riuscita.\n Nessun risultato.");
				}
			}
		});	    
	    
	    p1.add(message);	    
	    p2.add(i1);
	    p2.add(t1);
	    p7.add(ok);
	    
	    p.add(p1);
	    p.add(p2);
	    p.add(p7);
	    
	    f.add(p);	
	
	}	
	
	public void op17(JTextArea area) {	//FINITO
		  
		JFrame f = new JFrame("Operazione 17");
		f.setSize(550, 230);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();

		JPanel p7 = new JPanel();

		p.setBackground(new Color(217, 217, 217));
		p1.setBackground(new Color(217, 217, 217));
		p2.setBackground(new Color(217, 217, 217));
		p3.setBackground(new Color(217, 217, 217));

		p7.setBackground(new Color(217, 217, 217));

		p1.setPreferredSize(new Dimension(580, 50));
		p2.setPreferredSize(new Dimension(580, 30));
		p3.setPreferredSize(new Dimension(580, 30));

		JLabel message = new JLabel("Inserire il moderatore che ha moderato lo stream e il suo url");
		JLabel i1 = new JLabel("Username moderatore: ");
		JLabel i2 = new JLabel("URL Stream: ");

		message.setFont(new Font("", Font.BOLD, 15));

		JComboBox t1 = new JComboBox(c.getPrimaryKey("moderatore", "username").toArray());
		JComboBox t2 = new JComboBox(c.getPrimaryKey("stream", "urlstream").toArray());

		JButton ok = new JButton("OK");
		ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));

		String res;

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (c.operazione17(t1.getSelectedItem().toString(), t2.getSelectedItem().toString()) == true) {
					f.setVisible(false);
					area.setText("Inserimento riuscito. \n\n" + "Username Moderatore: " + t1.getSelectedItem().toString()
							+ "\nUrl Stream: " + t2.getSelectedItem().toString());
				} else {
					f.setVisible(false);
					area.setText("Moderazione già registrata");
				}
			}
		});

		p1.add(message);
		p2.add(i1);
		p2.add(t1);
		p3.add(i2);
		p3.add(t2);
		p7.add(ok);

		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p7);

		f.add(p);

	}
	
	public void op18(JTextArea area) {	//FINITO 

		JFrame f = new JFrame("Operazione 17");
		f.setSize(550, 200);
		f.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p7 = new JPanel();

		p.setBackground(new Color(217, 217, 217));
		p1.setBackground(new Color(217, 217, 217));
		p2.setBackground(new Color(217, 217, 217));
		p7.setBackground(new Color(217, 217, 217));

		p1.setPreferredSize(new Dimension(580, 50));
		p2.setPreferredSize(new Dimension(580, 30));

		JLabel message = new JLabel("Inserire lo stream di cui visualizzare la chat");
		JLabel i1 = new JLabel("URL Stream : ");

		message.setFont(new Font("", Font.BOLD, 15));

		JComboBox t1 = new JComboBox(c.getPrimaryKey("stream", "urlstream").toArray());

		JButton ok = new JButton("OK");
		ok.setFont(new Font("Tahoma", Font.BOLD, 16));
		ok.setBackground(new Color(242, 242, 242));

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ArrayList<String> list = c.operazione18(t1.getSelectedItem().toString());

				if (list.size() > 0) {
					f.setVisible(false);
					area.setText("Trasposizione chat: \n\n");
					for (int i = 0; i < list.size(); i++) {
						area.append(list.get(i));
					}
				} else {
					f.setVisible(false);
					area.setText("Chat vuota.");
				}
			}
		});

		p1.add(message);
		p2.add(i1);
		p2.add(t1);

		p7.add(ok);

		p.add(p1);
		p.add(p2);

		p.add(p7);

		f.add(p);

	}
}
