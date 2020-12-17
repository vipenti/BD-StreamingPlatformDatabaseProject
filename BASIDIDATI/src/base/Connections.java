package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connections {

	static Connection con;
	JTextField x;

	public Connections() {
		;
	}

	public void Connessione() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/streamingplatform?user=root&serverTimezone=UTC&useSSL=false";
			con = DriverManager.getConnection(url, "root", "g!4nmYS0S-");
			System.out.println("Connessione aperta \n");
		}

		catch (Exception e) {
			System.out.println("Connessione Fallita \n");
			System.out.println(e);
		}
	}

	public String query1() {

		String r = "";
		String sql = "SELECT a.username, a.nome " + "FROM accountuser as a;";
		try {

			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();

			while (result.next()) {

				String us = result.getString("username");
				String nome = result.getString(2); // index tabella
				r += us + " " + nome + " \n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public String[] query(String em, String ps) {

		String[] r = new String[3];

		try {

			String sql = "select a.username, a.nome, a.cognome\r\n" + "from accountuser as a\r\n"
					+ "where email=? AND passw=?;";

			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, em);
			query.setString(2, ps);
			ResultSet result = query.executeQuery();

			while (result.next()) {

				r[0] = result.getString("username");
				r[1] = result.getString("nome");
				r[2] = result.getString("cognome");
			}

			result.close();
			query.close();
		}

		catch (SQLException e) {

			System.out.println(e);
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Account non trovato", "Errore", JOptionPane.ERROR_MESSAGE);
		}
		return r;
	}

	public boolean registrationQuery(String username, String password, String email, String nome, String cognome,
			String data, String nazione, boolean s) {

		String sql = "INSERT INTO accountuser(username, nome, cognome, email, passw, datanascita, nazionalita) \r\n"
				+ "VALUES\r\n" + "(\r\n" + "? , ? , ? , ? , ? , ? , ?\n" + ");\r\n" + "";
		String sql1 = "INSERT INTO viewer(username, oreGuardate) \r\n" + "VALUES\r\n" + "(\r\n" + "? , ? \n" + ");\r\n"
				+ "";
		String sql2 = "INSERT INTO streamer(username, visualizzazioniTotali) \r\n" + "VALUES\r\n" + "(\r\n" + "? , ? \n"
				+ ");\r\n" + "";
		PreparedStatement query;
		PreparedStatement query1;
		PreparedStatement query2;

		try {
			query = con.prepareStatement(sql);
			query1 = con.prepareStatement(sql1);
			query2 = con.prepareStatement(sql2);

			query.setString(1, username);
			query.setString(2, nome);
			query.setString(3, cognome);
			query.setString(4, email);
			query.setString(5, password);
			query.setString(6, data);
			query.setString(7, nazione);
			query1.setString(1, username);
			query1.setString(2, "0");
			query2.setString(1, username);
			query2.setString(2, "0");

			query.executeUpdate();
			query1.executeUpdate();

			if (s == true)
				query2.executeUpdate();

			return true;
		}

		catch (SQLException e) {

			e.printStackTrace();
			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public boolean operazione3(String URL, String nome, String durata, String lingua, String user, String cat) {

		String sql = "INSERT INTO stream(urlStream, nome, durata, lingua, usernameStreamer, nomeCategoria)\r\n"
				+ "VALUES \r\n" + "(\r\n" + "? , ? , ? , ? , ? , ?\r\n" + ");\r\n" + "";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, URL);
			query.setString(2, nome);
			query.setString(3, durata);
			query.setString(4, lingua);
			query.setString(5, user);
			query.setString(6, cat);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;
	}

	public boolean operazione2(String codice, String testo, String minuto, String username, String URL) {

		String sql = "INSERT INTO messaggioinchat(codice, testo, minutoInvio, username, urlStream)\r\n" + "VALUES\r\n"
				+ "(\r\n" + "? , ? , ? , ? , ?\r\n" + ");\r\n" + "";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, codice);
			query.setString(2, testo);
			query.setString(3, minuto);
			query.setString(4, username);
			query.setString(5, URL);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		}

		catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	public boolean operazione4(String nome, String IVA, String perc, String codice, String nomeP, String user,
			int imp) {

		String sql1 = "INSERT INTO sponsor(nome, partitaiva, percentualeTrattenuta)\r\n" + "VALUES\r\n" + "(\r\n"
				+ "? , ? , ?\r\n" + ");\r\n" + "\r\n";

		String sql2 = "INSERT INTO prodotto(codice, nomeSponsor, nomeProdotto)\r\n" + "VALUES\r\n" + "(\r\n"
				+ "? , ? , ?\r\n" + ");\r\n";

		String sql3 = "INSERT INTO sponsorizza(nomeSponsor, usernameStreamer, importo)\r\n" + "VALUES (\r\n"
				+ "?, ?, ?\r\n" + ");";
		try {

			PreparedStatement query1 = con.prepareStatement(sql1);
			PreparedStatement query2 = con.prepareStatement(sql2);
			PreparedStatement query3 = con.prepareStatement(sql3);

			query1.setString(1, nome);
			query1.setString(2, IVA);
			query1.setString(3, perc);
			query2.setString(1, codice);
			query2.setString(2, nome);
			query2.setString(3, nomeP);
			query3.setString(1, nome);
			query3.setString(2, user);
			query3.setInt(3, imp);

			if (((query1.executeUpdate()) > 0) && ((query2.executeUpdate()) > 0) && ((query3.executeUpdate()) > 0))
				return true;
		}

		catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;
	}

	public boolean operazione5(String username, String nome, String durata, String URL) {

		String sql = "INSERT INTO clip( username, nome, durata, urlStream)\r\n" + "VALUES \r\n" + "(\r\n"
				+ "? , ? , ?, ?\r\n" + ");\r\n";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, username);
			query.setString(2, nome);
			query.setString(3, durata);
			query.setString(4, URL);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		}

		catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;

	}

	public boolean operazione6(String username, String nome, String cognome, String valutazione) {

		String sql = "INSERT INTO moderatore( username, nome, cognome, valutazione)\r\n" + "VALUES \r\n" + "(\r\n"
				+ "? , ? , ? , ?\r\n" + ");\r\n";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, username);
			query.setString(2, nome);
			query.setString(3, cognome);
			query.setString(4, valutazione);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		}

		catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;

	}

	public boolean operazione7(String nome, String descr) {

		String sql = "INSERT INTO categoria ( nome, descrizione)\r\n" + "VALUES \r\n" + "(\r\n" + "? , ?\r\n"
				+ ");\r\n";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, nome);
			query.setString(2, descr);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;

	}

	public String operazione8(String username) {

		String sql = "SELECT COUNT(*)\r\n" + "FROM streamer as s, stream as st\r\n"
				+ "WHERE s.username= ? AND s.username=st.usernamestreamer;\r\n";

		PreparedStatement query;

		try {
			String res = null;

			query = con.prepareStatement(sql);

			query.setString(1, username);

			ResultSet result = query.executeQuery();

			while (result.next())
				res = result.getString(1);

			return res;

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return null;

	}

	public String operazione9(String nome) {

		String sql = "SELECT SUM(sp.importo)\r\n" + "FROM sponsor as s, sponsorizza as sp\r\n"
				+ "WHERE s.nome= ? AND s.nome=sp.nomesponsor;\r\n";

		PreparedStatement query;

		try {

			String res = null;

			query = con.prepareStatement(sql);

			query.setString(1, nome);

			ResultSet result = query.executeQuery();

			while (result.next())
				res = result.getString(1);

			return res;

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return null;

	}

	public void operazione10() {

		String sql = "DELETE \r\n" + "FROM moderatore as m\r\n" + "WHERE m.valutazione<=2;\r\n";

		try {

			PreparedStatement query = con.prepareStatement(sql);
			query.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<String> operazione11() {

		String sql = "SELECT s.nome, s.urlStream\r\n" + "FROM stream as s\r\n"
				+ "WHERE s.durata>20 AND s.lingua='IT';\r\n";

		ArrayList<String> list = new ArrayList<String>();

		try {

			PreparedStatement query = con.prepareStatement(sql);

			ResultSet result = query.executeQuery();

			while (result.next()) {

				list.add(result.getString("nome"));
				list.add(result.getString("urlStream"));

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<String> operazione12(String num) {

		String sql = "SELECT v.username, v.oreGuardate \r\n" + "FROM viewer as v\r\n" + "WHERE v.oreguardate>= ? \r\n"
				+ "ORDER BY v.oreGuardate DESC\r\n";

		ArrayList<String> list = new ArrayList<String>();

		try {

			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, num);
			ResultSet result = query.executeQuery();

			while (result.next()) {

				list.add(result.getString("username") + ",  " + result.getString("oreGuardate") + "h");
			}
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> operazione13(String parola) {

		String sql = "SELECT m.testo, m.username\r\n" + "FROM messaggioinchat as m\r\n" + "WHERE m.testo LIKE ?;\r\n";

		ArrayList<String> list = new ArrayList<String>();

		try {

			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, "%" + parola + "%");
			ResultSet result = query.executeQuery();

			while (result.next()) {

				list.add("@" + result.getString("username") + ":  ''" + result.getString("testo") + "''");
			}
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> operazione14(String lingua) {
		
		String sql = "SELECT c.nome, c.descrizione\r\n" + 
				"FROM categoria as c\r\n" + 
				"WHERE c.nome IN (SELECT s.nomeCategoria\r\n" + 
				"FROM stream as s\r\n" + 
				"WHERE s.lingua=?\r\n" + 
				"GROUP BY s.nomeCategoria\r\n" + 
				"HAVING COUNT(*)>= 2\r\n" + 
				");\r\n";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			query.setString(1, lingua);

			ResultSet set = query.executeQuery();

			while (set.next())
				list.add("\n NOME: " + set.getString("nome") + "\n DESCRIZIONE: ''" + set.getString("descrizione")
								+"''\n");

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}
	
	public ArrayList<String> operazione15(String importo) {
		
		String sql = "SELECT sp.nomeSponsor\r\n" + "FROM sponsorizza as sp\r\n"
				+ "WHERE sp.importo>=? AND sp.usernameStreamer IN (SELECT st.usernameStreamer\r\n"
				+ "FROM stream as st\r\n"
				+ "GROUP BY st.usernameStreamer\r\n"
				+ "HAVING COUNT(*)>=3\r\n"
				+ ");\r\n";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			query.setString(1, importo);

			ResultSet set = query.executeQuery();

			while (set.next())
				list.add(set.getString("nomeSponsor"));

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}
	
	public ArrayList<String> operazione16() {
		
		String sql = "SELECT c.nome, c.urlStream, c.username\r\n" + 
				"FROM clip as c\r\n" + 
				"WHERE c.urlstream IN (SELECT st.urlstream\r\n" + 
				"FROM stream as st , streamer as str\r\n" + 
				"WHERE st.usernameStreamer = str.username AND\r\n" + 
				"str.username IN (SELECT a.username \r\n" + 
				"FROM accountuser as a\r\n" + 
				"WHERE a.nazionalita= 'Italia')\r\n" + 
				");\r\n";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			ResultSet set = query.executeQuery();

			while (set.next())
				list.add("\nNOME CLIP: " + set.getString("nome") + "  URL STREAM: " 
			+ set.getString("urlstream") + "  USERNAME CREATORE: " + set.getString("username") + "\n");

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}
		
	
	public boolean operazione17(String username, String url) {

		String sql = "INSERT INTO moderatoda ( usernamemoderatore, urlstream)\r\n" + "VALUES \r\n" + "(\r\n"
				+ "? , ?\r\n" + ");\r\n";

		PreparedStatement query;

		try {

			query = con.prepareStatement(sql);

			query.setString(1, username);
			query.setString(2, url);

			if ((query.executeUpdate()) > 0) {

				return true;
			}

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return false;

	}

	public ArrayList<String> operazione18(String url) {
		String sql = "SELECT m.testo, m.minutoInvio, m.username\r\n" + "FROM messaggioinchat as m\r\n"
				+ "WHERE m.urlStream=? \r\n" + "ORDER BY m.minutoInvio;\r\n";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			query.setString(1, url);

			ResultSet set = query.executeQuery();

			while (set.next())
				list.add("  @" + set.getString("username") + ":  ''" + set.getString("testo") + "'', "
						+ set.getString("minutoinvio") + "m\n");

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<String> getPrimaryKey(String nometabella, String nomechiave) {

		String sql = "SELECT DISTINCT " + nomechiave + " FROM " + nometabella + ";";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			ResultSet set = query.executeQuery();

			while (set.next())

				list.add(set.getString(nomechiave));

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}
	
	public ArrayList<String> getPrimaryKey2(String nometabella, String nomechiave) {

		String sql = "SELECT " + nomechiave + " FROM " + nometabella + ";";

		PreparedStatement query;
		ArrayList<String> list = new ArrayList<String>();

		try {

			query = con.prepareStatement(sql);

			ResultSet set = query.executeQuery();

			while (set.next())

				list.add(set.getString(nomechiave));

		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Campi non validi", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return list;

	}

	public void close() {

		try {
			con.close();
			System.out.println("Connessione chiusa");
		} catch (SQLException e) {

			JPanel pane = new JPanel();
			JOptionPane.showMessageDialog(pane, "Chiusura non effettuata", "Errore", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}