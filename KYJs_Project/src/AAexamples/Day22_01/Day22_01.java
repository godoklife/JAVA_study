package AAexamples.Day22_01;
// ������ [ javaFX ó�� ��� ] 

	// javaFX ��� ����
		// 1.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





public class Day22_01 extends Application{
						// �ݵ�� Application Ŭ���� ��� �ޱ�.
	// 1. ��ŸƮ �޼��� ������
	@Override
	public void start(Stage stage) throws Exception {
						// �������� �̸��� �� �����.
		Parent parent = FXMLLoader.load(getClass().getResource("DB�׽�Ʈ.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	// 2. ���� �޼��� �ۼ�
	public static void main(String[] args) {
		launch(args);
	}	// m e
	
	
	
	
	// 3. ���θ޼��尡 �ִ� Ŭ�������� --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.graphics ��� ���̺귯�� �߰����ֱ�.
}	// c e
