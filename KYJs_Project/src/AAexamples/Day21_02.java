package AAexamples;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_02 extends Application {	// 1. Application Ŭ�����κ��� ���
	
	@Override
	public void start(Stage stage) throws Exception {
						// �������� �̸�
		// 1) FXML ���� �ҷ����� : �����̳�
		Parent parent = FXMLLoader.load( getClass().getResource("test.fxml"));
			// Parent : fxml ���� (�������� ������ ����)�� ��üȭ
				// FXML.Loader.load(getClass().getRecource("���.fxml���ϸ�"));
		// 2) �� ��ü ���� : 
		Scene scene = new Scene(parent);
		// 3) ���������� �� �ֱ�
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
