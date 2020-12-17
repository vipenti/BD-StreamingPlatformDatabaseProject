package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LoggedInterface extends JFrame {

	public LoggedInterface(String username, String nome, String cognome, Connections c) {

		JFrame frame = new JFrame("Accesso effettuato");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 800);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		QueryInput sos = new QueryInput(c);

		String[] tips = { "Inviare un nuovo messaggio in chat\r\n", "Trasmettere un nuovo stream\r\n",
				"Registrare uno sponsor\r\n", "Creare una nuova clip\r\n", "Registrare un nuovo moderatore\r\n",
				"Inserire una nuova categoria\r\n",
				"Selezionare il numero di stream effettuati da un dato streamer\r\n",
				"Selezionare quanto ha speso in sponsorizzazioni un dato sponsor\r\n",
				"Rimuovere tutti i moderatori che hanno una valutazione inferiore a 2\r\n",
				"Selezionare tutti gli stream in lingua italiana che durano almeno 20 minuti\r\n",
				"Selezionare l’username dei viewer che hanno guardato almeno un determinato numero di ore di streaming in ordine decrescente\r\n",
				"Selezionare i messaggi che contengono una data parola\r\n",
				"Selezionare nome e descrizione di tutte le categorie che hanno almeno 5 stream in una data lingua\r\n",
				"Selezionare il nome degli sponsor che hanno sponsorizzato per almeno un dato importo degli streamer con almeno 3 stream effettuati\r\n",
				"Contare quante clip sono state create di uno stream effettuato da uno streamer con almeno 5 stream effettuati\r\n", 
				"Moderatore modera uno stream\r\n", "Visualizza la chat completa di uno stream ordinata per minuto", "Chiudi la connessione\r\n" };

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();

		JButton[] group = new JButton[18];

		group[0] = new JButton("Operazione 2 ");
		group[1] = new JButton("Operazione 3 ");
		group[2] = new JButton("Operazione 4 ");
		group[3] = new JButton("Operazione 5 ");
		group[4] = new JButton("Operazione 6 ");
		group[5] = new JButton("Operazione 7 ");
		group[6] = new JButton("Operazione 8 ");
		group[7] = new JButton("Operazione 9 ");
		group[8] = new JButton("Operazione 10");
		group[9] = new JButton("Operazione 11");
		group[10] = new JButton("Operazione 12");
		group[11] = new JButton("Operazione 13");
		group[12] = new JButton("Operazione 14");
		group[13] = new JButton("Operazione 15");
		group[14] = new JButton("Operazione 16");
		group[15] = new JButton("Operazione 17");
		group[16] = new JButton("Operazione 18");		

		group[17] = new JButton("  Finito  ");

		JLabel user = new JLabel("Accesso come: @" + username);
		JLabel name = new JLabel("Benvenuto " + nome + " " + cognome + "!");
		JLabel message = new JLabel("Scegli un'operazione: ");

		JTextArea area = new JTextArea();
		JScrollPane bar = new JScrollPane(area);
		
		area.setAlignmentX(CENTER_ALIGNMENT);
		area.setFont(new Font("", Font.PLAIN, 15));
		area.setText("--- OUTPUT --- ");

		p.setBackground(new Color(230, 230, 230));
		p.setPreferredSize(new Dimension(1080, 130));

		area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		area.setEditable(false);

		p1.setBackground(new Color(230, 230, 230));
		p1.setPreferredSize(new Dimension(900, 30));
		p2.setBackground(new Color(230, 230, 230));

		p3.setBackground(new Color(230, 230, 230));
		p3.setPreferredSize(new Dimension(1080, 20));

		p4.setBackground(new Color(230, 230, 230));
		p4.setPreferredSize(new Dimension(240, 720));

		p5.setBackground(new Color(230, 230, 230));
		p5.setPreferredSize(new Dimension(20, 720));

		p6.setPreferredSize(new Dimension(1080, 60));
		p6.setBackground(new Color(230, 230, 230));

		p7.setPreferredSize(new Dimension(1080, 5));
		p7.setBackground(new Color(230, 230, 230));

		user.setFont(new Font("Calibri", Font.BOLD, 23));
		user.setForeground(new Color(0, 0, 0));
		name.setFont(new Font("Calibri", Font.BOLD, 23));
		name.setForeground(new Color(0, 0, 0));
		message.setFont(new Font("Calibri", Font.PLAIN, 23));
		message.setForeground(new Color(0, 0, 0));

		area.setSize(300, 300);

		p1.add(user);
		p2.add(name);
		p6.add(message);

		for (int i = 0; i < 18; i++) {

			group[i].setFocusPainted(false);
			group[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			group[i].setBackground(new Color(242, 242, 242));
			group[i].setToolTipText(tips[i]);
			p4.add(group[i]);

		}

		group[17].setFont(new Font("Tahoma", Font.BOLD, 16));
		p.add(p1);
		p.add(p2);
		p.add(p7);
		p.add(p6);

		//frame.add(area, BorderLayout.CENTER);
		frame.add(bar, BorderLayout.CENTER);
		frame.add(p, BorderLayout.NORTH);
		frame.add(p3, BorderLayout.SOUTH);
		frame.add(p4, BorderLayout.WEST);
		frame.add(p5, BorderLayout.EAST);
		frame.setVisible(true);

		group[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op2(area);

			}
		});

		group[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op3(area);

			}
		});

		group[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op4(area);

			}
		});

		group[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op5(area);

			}
		});

		group[4].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op6(area);

			}
		});

		group[5].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op7(area);

			}
		});

		group[6].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op8(area);

			}
		});

		group[7].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op9(area);

			}
		});
		
		group[8].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {				
				
				c.operazione10();				
				
				ArrayList<String> list = c.getPrimaryKey2("moderatore", "username");
				ArrayList<String> val = c.getPrimaryKey2("moderatore", "valutazione");
					
				area.setText("Operazione riuscita.\n\nModeratori rimasti: \n");
					
				for(int i = 0; i < list.size() && i < val.size(); i++) {
						
					area.append(list.get(i) + "   ");
					area.append(val.get(i) + "/5\n");
				}
			}
			
		});

		group[10].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op12(area);

			}
		});
		
		group[9].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				
				ArrayList<String> list = c.operazione11();
				
				area.setText("Operazione riuscita.\n\nStream selezionati:\n");
				
				for(int i = 1; i < list.size(); i+=2) {
					
					area.append("NOME: " + list.get(i-1) + "    URL STREAM:   " + list.get(i) + "\n");
				}
			}
		});

		group[11].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op13(area);

			}
		});

		group[12].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op14(area);

			}
		});

		group[13].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op15(area);

			}
		});
		
		group[14].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ArrayList<String> list = c.operazione16();
				
				area.setText("Operazione riuscita.\nRisultati:\n");
				
				if (list.size() == 0)

					area.append("Nessuno");

				else {
					for (int i = 0; i < list.size(); i ++)

						area.append(list.get(i));
				}

			}
		});

		group[15].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op17(area);
			}
		});
		
		group[16].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				sos.op18(area);

			}
		});

		group[17].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				c.close();
				frame.setVisible(false);
			}
		});
		
		
	}

}