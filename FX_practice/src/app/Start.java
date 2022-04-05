package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
		// ������ â ���� ������[ ���� �޼��尡 ����ִ� Ŭ���� ]
			// Application : javaFX ���� ���� �޼��� ����. ���� �޼��尡 �ݵ�� ��� �޾ƾ� �Ѵ�.
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		// 1.FXML ������ �����̳ʷ� �ҷ�����
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		// 2. �����̳� -> �� ��ü�� ����	
		Scene scene = new Scene(parent);
		
		// 3. ������â(primaryStage)�� ��� �� ��ü ����
		primaryStage.setScene(scene);
		
		Image image = new Image("/img/thunder.png");	// ������ ��� ����
		primaryStage.getIcons().add(image);	// ������ ����
		primaryStage.setTitle("��������");		// ���� â Ÿ��Ʋ ����
		primaryStage.setResizable(false);	// ����ڰ� â ũ�� �缳�� ���� ���� ���� [ T / F ] 
		primaryStage.show();				// ���� â ����
		
	}
	
	public static void main(String[] args) {
		launch(args);	// �ٷ� ������ ������ start �޼��� ����
	}
	
}
