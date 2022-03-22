package 시험연습4;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String aa=simpleDateFormat.format(calendar.getTime());
		System.out.println(aa);
	}
}
