package AAexamples;


// javafx�� import [ awt, swing�� ���������� ��� ] 
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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
			button.setText("�ݱ�");
			button.setOnAction( e -> Platform.exit() ); // �� -> �μ�  ���ٽ� ( �̸��� ���� �޼ҵ� )
			// 3. �����̳ʿ� ��Ʈ�� �ֱ� 
			�����̳�.getChildren().add(button);
			// 4. �� ��ü ���� �� �����̳� �ֱ�
			Scene ��� = new Scene(�����̳�, 500, 500);	// �����̳��̸�, ����ũ��, ����ũ��
		
		
		��������.show();	// �������� ����
	}
	
	public static void main(String[] args) {	// ���ν�����
		
		launch(args);	// start �޼��� ȣ��
	}
}
