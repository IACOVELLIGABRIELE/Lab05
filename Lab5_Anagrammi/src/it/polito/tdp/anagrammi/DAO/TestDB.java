package it.polito.tdp.anagrammi.DAO;

public class TestDB {

	public static void main(String[] args) {
		
		AnagrammaDAO adao = new AnagrammaDAO();
		
		System.out.println(adao.isCorrect("calcolava"));

	}

}
