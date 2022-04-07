package AAexamples.Day22_01;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Day22_01_controller implements Initializable{
										// Initializable : FXML�� ���� ������ �� �ʱⰪ ���� �޼��带 �����ϴ� �������̽�
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Day22_02 DB���� = new Day22_02();
	}

	@FXML
    private TextField txtwriter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB�� �����͸� �����մϴ�.");
    	
    	String �ۼ��� = txtwriter.getText();
    	String ���� = txtcontent.getText();
    	
    	
    	// 1. 
    	Day22_02 DB���� = new Day22_02();
    	// 2. 
    	boolean result = DB����.write(�ۼ���, ����);
    	
    	if(result) {
    		System.out.println("DB�� ���� ����");
    		
    		// ������ ��Ʈ�ѿ� �Էµ� ������ �����ֱ�.
    		txtwriter.setText("");
    		txtcontent.setText("");
    	}else {
    		System.out.println("DB�� ������ �����߽��ϴ�.");
    	}
    }
    
    @FXML
    void get(ActionEvent event) {
    	System.out.println("DB�� ������ ȣ��");
    	
    	// 1. DB ���� ��ü �����
    	Day22_02 DB���� = new Day22_02();
    	
    	// 2. DB ��ü �� �޼��� ȣ�� �� ����� ����Ʈ�� 
    	ArrayList<������> �����͸�� = DB����.get();
    	
    	for(������ tmp : �����͸��) {
    		txtcontentlist.appendText(
    				"��ȣ"+tmp.get��ȣ()+
    				"�ۼ���"+tmp.get�ۼ���()+
    				"����"+tmp.get����()+"\n");
    	}
    	
    	
    	
    }
    
	
}
