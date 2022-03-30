module KYJs_Project {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
// 모듈인포는 자바11버전부터 사용. 우리가 사용하는 1.8은 불필요함. 삭제해도 무방