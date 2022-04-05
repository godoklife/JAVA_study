package app;

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
			Font.loadFont(getClass().getResourceAsStream("CookieRun Regular.ttf"), 14);
			// 2. �ܺ� ��Ÿ�Ͻ�Ʈ�� �� ��ü�� ����
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
///////////////////////////////////////////////////////////////////////////////////////////////////////			
			
		arg0.setResizable(false);	// 4. ��������(â) ũ�� ������ �Ұ� 
		arg0.setTitle("�������R");	// 2. �������� â �̸� ����
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
