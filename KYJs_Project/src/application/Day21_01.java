package application;

import java.awt.Button;

// javafx�� import [ awt, swing�� ���������� ��� ] 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_01 extends Application{
							// Application : javaFX GUI ���� Ŭ����
	@Override
	public void start(Stage ��������) throws Exception {	// 
		// javaFX�� �����ϴ� �޼��� [ �߻� -> ���� ]
			// ��ӹ����� ����Ŭ���� �� ����� ����� �� �ִ�.
		// 1. �����̳� ����� [ �������� ��Ʈ���� ���η� ���� ] 
		VBox �����̳� = new VBox();	// (Vertical box)
			// 2. ��Ʈ�� �����
			Button button = new Button();
			button =  
			// 3. �����̳ʿ� ��Ʈ�� �ֱ� 
			box.getChildren().add(button);
			// 4. �� ��ü ���� �� �����̳� �ֱ�
			Scene ��� = new Scene(�����̳�, 500, 500);	// �����̳��̸�, ����ũ��, ����ũ��
		
		
		��������.show();	// �������� ����
	}
	
	public static void main(String[] args) {	// ���ν�����
		
		launch(args);	// start �޼��� ȣ��
	}
}
