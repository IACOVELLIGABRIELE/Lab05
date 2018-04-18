package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO adao = new AnagrammaDAO();
	
	public List<String> anagrammi(String parola){                 //ottengo la lista di anagrammi
		List<String> soluzione = new ArrayList<String>();
		this.recursive(soluzione, parola, 0, "", parola);
		return soluzione;
		
	}
	
	private void recursive(List<String> soluzione, String parola,int livello, String parziale,String togli) {
		
		if(livello == parola.length()) {//caso terminale
			
			if(!soluzione.contains(parziale)) {
			String aggiunta = parziale;
			soluzione.add(aggiunta);
			}
			return;
		}
		
		for(int i = 0; i<togli.length();i++) {
			StringBuilder s = new StringBuilder(togli);
			String originale = parziale;
			parziale += togli.charAt(i);
			s.deleteCharAt(i);
			String daTogliere = s.toString();
			this.recursive(soluzione, parola, livello+1, parziale, daTogliere);
			parziale = originale;
		}
	}
	
	public List<String> anagrammiValidi(List<String> anagrammi){
		List<String> validi = new ArrayList<String>();
		
		for(String s : anagrammi){
			if(adao.isCorrect(s)) {
				validi.add(s);
			}	
		}
		return validi;
	}
	
	public List<String> anagrammiErrati(List<String> anagrammi){
		List<String> errati = new ArrayList<String>();
		
		for(String s : anagrammi){
			if(!adao.isCorrect(s)) {
				errati.add(s);
			}	
		}
		return errati;
	}
}
