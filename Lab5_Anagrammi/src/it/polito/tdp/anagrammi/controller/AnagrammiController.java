/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	Model m = new Model();

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	
    	List<String> anagrammi = new ArrayList<String>(m.anagrammi(parola));
    	List<String> corretti = new ArrayList<String>(m.anagrammiValidi(anagrammi));
    	List<String> errati = new ArrayList<String>(m.anagrammiErrati(anagrammi));
    	
    	for(String s : corretti) {
    		txtCorretti.appendText(s+"\n");
    	}
    	
    	for(String s : errati) {
    		txtErrati.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void reset(ActionEvent event) {
    	
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    	

    }

}

