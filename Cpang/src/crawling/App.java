package crawling;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\JAVAlibrary\\chromedriver.exe ";
	public static String id = "";	// c:\javalibrary\coupang\account.txt
	public static String pw = "";	// coupangaccount() 메서드에서 초기화해줌.
	
	List<WebElement> sharedel;	// coupang과 searchgoogle 메서드가 공유하는 List
	
	public static void main(String[] args) {
		
		coupangaccount();
			System.out.println("읽어온 이메일 : "+id);
			System.out.println("읽어온 비밀번호 : "+pw);
		
		coupang();	// 로그인쿠팡 메서드 내에서 서치구글 메서드 호출
			
			

	}	// m e
	
	
	// 내 쿠팡 계정 담긴 txt파일 읽어오기
	public static void coupangaccount() {
		try {
			FileInputStream fis = new FileInputStream("C:/JAVAlibrary/coupang/account.txt");
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			id = new String(bytes).split("/")[0];
			pw = new String(bytes).split("/")[1];
			fis.close();
			
		} catch (Exception e) {System.out.println("coupangaccount_exception : "+e);}
	}
	
	
	public static void coupang() {	
		// 1. 메인페이지 실행
		// 2. 로그인 페이지 접속
		// 3. id,pw 입력
		// 4. 로그인 
		// 5. 메인페이지로 이동
		// 6. 카트 페이지로 이동. 끝.
		try {System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);}
			catch (Exception e) {e.printStackTrace();}
		ChromeOptions options = new ChromeOptions();

		String useragent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36";
		options.addArguments("user-agent="+useragent);
		WebDriver driver_logincoupang = new ChromeDriver(options);
		Map javascriptCodes = Map.of("source", "Object.defineProperty(navigator, 'webdriver', {get: () => undefined });");
		((ChromiumDriver) driver_logincoupang).executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", javascriptCodes);
		
		String url = "https://www.coupang.com";
		driver_logincoupang.get(url);
		new WebDriverWait(driver_logincoupang, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.className("login")));
			// login버튼 뜰 떄 까지 최대 30초간 기다림. 
		System.out.println("mainpage_loaded");
		try {Thread.sleep(2000);} catch (InterruptedException e) {}	// 페이지 로딩 다 되면 2초간 대기
		WebElement el = driver_logincoupang.findElement(By.className("login"));	// 로그인 버튼 찾기
		el.click();	// 메인페이지 - 로그인 버튼 클릭
		System.out.println("login_process_executed");
		new WebDriverWait(driver_logincoupang, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.className("_loginSubmitButton")));
			// 로그인 페이지의 로그인하기 버튼 로드 될때까지 최장 30초간 대기
		
		el = driver_logincoupang.findElement(By.className("_loginIdInput"));
		el.sendKeys(id);
			try {Thread.sleep(1111);} catch (InterruptedException e) {}
		
		el = driver_logincoupang.findElement(By.className("_loginPasswordInput"));
		el.sendKeys(pw);
			try {Thread.sleep(1234);} catch (InterruptedException e) {}
		
		el = driver_logincoupang.findElement(By.className("_loginSubmitButton"));
		el.click();
		System.out.println("ID / PW 입력 후 로그인버튼 클릭 완료");
		new WebDriverWait(driver_logincoupang, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.className("logout")));
		System.out.println("메인페이지 로딩 완료");
		try {Thread.sleep(1500);} catch (InterruptedException e) {}
		driver_logincoupang.get("https://cart.coupang.com/cartView.pang");
		try {Thread.sleep(1500);} catch (InterruptedException e) {}
		System.out.println("쿠팡 카트 실행 완료");
		
		
		searchgoogle();
	}	// logincoupang end
	
	
	public static void searchgoogle() {
		try {System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);}
			catch (Exception e) {e.printStackTrace();}
		
		ChromeOptions options = new ChromeOptions();
		String useragent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36";
		options.addArguments("user-agent="+useragent);
		WebDriver driver_google = new ChromeDriver(options);
		Map javascriptCodes = Map.of("source", "Object.defineProperty(navigator, 'webdriver', {get: () => undefined });");
		((ChromiumDriver) driver_google).executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", javascriptCodes);
		String url = "https://www.google.com/search?q=site%3Awww.coupang.com+products+item+offerList+(%2216GB%22+%7C+%2232GB%22)&oq=site%3Awww.coupang.com+products+item+offerList+(%2216GB%22+%7C+%2232GB%22)&aqs=chrome..69i57j69i58.1031j0j7&sourceid=chrome&ie=UTF-8";
		driver_google.get(url);
		
		new WebDriverWait(driver_google, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.id("pnnext")));
			// 구글 검색창 하단 gooooooooogle에 있는 다음 버튼이 로드될 떄 까지 대기
		try {Thread.sleep(1231);} catch (Exception e) {}
		List<WebElement> search_result_url = driver_google.findElements(By.className("yuRUbf"));	// 각 검색 결과들의 주소가 담긴 div의 클래스 이름
		List<WebElement> search_result_content = driver_google.findElements(By.className("VwiC3b"));// 각 검색 결과들의 간략한 내용이 담긴 div의 클래스 이름
		for(int i=0; i<search_result_content.size();i++) {
			if(search_result_content.get(i).getTagName("span"))	// gettagname은 맞는데, if문이 아니라 list 써서 저장해야 하지 않을까???
		}
	}	// searchgoogle end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void memo() {
		// login버튼 뜰 떄 까지 최대 30초간 기다림. 뜨는 즉시 클릭
//		List<WebElement> el1 = driver.findElements(By.className("title"));
//		for (int i = 0; i < el1.size(); i++) {
//			//nav 클래스의 객체 중 "뉴스"라는 텍스트를 가진 WebElement를 클릭한다.
//			if(el1.get(i).getText().contains("XPS")) {
//				el1.get(i).click();
//				System.out.println(el1.get(i).getText()); 
//			}
//		}
//		//1초 대기
//		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		//버튼을 클릭했기 때문에 브라우저는 뉴스창으로 이동돼 있다.
		//이동한 뉴스 창의 IT/과학 뉴스 헤드라인을 가져온다.
		//iT/과학뉴스를 담은 div
//		WebElement el2 = driver.findElement(By.id("section_it"));
		//div속에서 strong태그를 가진 모든 element를 받아온다.
//		List<WebElement> el3 = el2.findElements(By.tagName("strong"));
//		int count = 0;
//		for (int i = 0; i < el3.size(); i++) {
			//뉴스의 제목을 모두 출력한다.
//			System.out.println(++count + "번 뉴스: "+ el3.get(i).getText());
//		}
		
		
//		try {
//			//드라이버가 null이 아니라면
//			if(driver != null) {
//				//드라이버 연결 종료
//				driver.close(); //드라이버 연결 해제
//				
//				//프로세스 종료
//				driver.quit();
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
	}	// memo end

}	// c e
