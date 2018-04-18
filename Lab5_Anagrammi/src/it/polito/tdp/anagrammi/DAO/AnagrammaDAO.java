package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AnagrammaDAO {
	
	public List<String> getDizionario() {

		final String sql = "SELECT nome " + 
				"FROM parola ";

		List<String> dizionario = new LinkedList<String>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
				dizionario.add(nome);
				
			}

			return dizionario;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public boolean isCorrect(String parolaDaCercare) {

		final String sql = "SELECT nome " + 
				"FROM parola " +
				"WHERE parola.nome = ? ";
		
		boolean result = false;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, parolaDaCercare);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");
				
				if(parolaDaCercare.compareTo(nome) == 0) {
					result = true;
				}
				
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}


}
