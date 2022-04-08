package app;

import controller.Chatting;
import controller.login.Login;
import dao.RoomDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
		// 5. �����̳� �ҷ�����
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		// 6. �� ��ü-> �����̳�
		Scene scene = new Scene(parent);
		// 7. �� -> ��������
		arg0.setScene(scene);
		
		// 3. ���������ΰ� ����
			Image image = new Image("/img/search.png");
				// ���� ��� VS ��� ���
				// ���� ��� : ��� ��� (C:\Users\504\git\JAVA_study\KYJs_Project\src\img\search.img)
				// ��� ��� : src �������� ���� (/img/search.png)
				// �������� ���� ����η� �ν�, ���������� ���� ����η� �ν��Ѵ�.
			// 2. �������� ����			
			arg0.getIcons().add(image);	// �������� �ΰ� ����
///////////////////////////////////////////////////////////////////////////////////////////////////////			
		// * �ܺ� ��Ʈ �ϰ� ���� & application.css ����
			// 1. ��Ʈ ȣ��
			Font.loadFont(getClass().getResourceAsStream("CookieRun Regular.ttf"), 40);
			// 2. �ܺ� ��Ÿ�Ͻ�Ʈ�� �� ��ü�� ����
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
///////////////////////////////////////////////////////////////////////////////////////////////////////			
			
		// setOnCloseRequest : ������ â���� X��ư ������ ���� �� �̺�Ʈ
		arg0.setOnCloseRequest(e->{
			// ���� �α����� �Ǿ�������
			if(Login.member != null	) {
				// 1. �� ���� ��� ����
				RoomDao.roomDao.roomlivedelete(Login.member.getMid());
				// 2. �� ����	
				if(Chatting.selectroom != null) {
					RoomDao.roomDao.roomdelete(Chatting.selectroom.getRoomnumber());
				}
				// 3. ���� �� �����ϴ� ���� �ʱ�ȭ
				Chatting.selectroom=null;	// �ʱ�ȭ �� �ʿ䰡 �ֳ�?	
			}
		});		// ���ٽ� END
			
		arg0.setResizable(false);	// 4. ��������(â) ũ�� ������ �Ұ� 
		arg0.setTitle("��������");	// 2. �������� â �̸� ����
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
