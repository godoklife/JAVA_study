package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable{
				// fxml ���� �� �ʱⰪ ���� �޼��带 �����ϴ� �������̽�
	public static Home home;
	public Home() {
		System.out.println("ȣ��� Home ��ü�� �޸� �ּ� : "+home);
		home = this;
	}
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@FXML
	private Label lbldelete;
	
	@FXML
	private Label lblupdate;
	
	@FXML
	private Label lblboard;
	
	@FXML
	private Label lblproduct;
	
	@FXML
	private BorderPane borderpane;
	
	@FXML
	public void accboard(MouseEvent e) {
		loadpage("/view/board/board.fxml");
	}
	
	@FXML
	public void update(MouseEvent e) {
		loadpage("/view/home/update.fxml");
	}
	
	@FXML	
	public void accinfo(MouseEvent e) {
		loadpage("/view/home/info.fxml");
	}
	
	@FXML
	public void product(MouseEvent e) {
		loadpage("/view/product/product.fxml");
	}
	
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page) );
			borderpane.setCenter(parent);
		}catch( Exception e ) { System.out.println("�ش� ������ �����ϴ�. "+e);}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("����Ʈ : "+Login.member.getMpoint());
	}
	
	@FXML	// �α׾ƿ� Ŭ���� �̺�Ʈ
	public void logout (MouseEvent e) {	
		// 1. �α��� ���� ������
		Login.member = null;
		// 2. ������ ��ȯ
		Main.instance.loadpage("/view/main.fxml");
	}
	
	@FXML	// ȸ��Ż�� ���̺��� Ŭ������ �� �̺�Ʈ
	public void delete(MouseEvent e) {
		// 1. �޽��� ����
		Alert alert = new Alert(AlertType.CONFIRMATION);	// Ȯ�ΰ� ��� ��ư�� ����.
			alert.setHeaderText("���� Ż���Ͻðڽ��ϱ�?");
		// 2. ��ư Ȯ�� [ Optional : Ŭ���� ]
		Optional<ButtonType> optional = alert.showAndWait();
		
		if(optional.get() == ButtonType.OK) {
			System.out.println("Ȯ�� ����");
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
				// ���� �α��� ���� ȸ���� ȸ����ȣ�� �μ��� �־ delete �޼���� ����.
			if(result) {	// Ż�� ������
				// �α׾ƿ�	[ Login Ŭ���� �� Member ��ü�� null�� ���� ] 
				Login.member = null;
				Main.instance.loadpage("/view/main.fxml");
				
				// ������ ��ȯ
			}else {	// Ż�� ���н�
				
			}
		}else {
			System.out.println("��� ����");
		}
		
		
	}
	
	
	
}
