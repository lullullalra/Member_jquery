package gntp.model2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
	public static final int DATE_ONLY = 0;
	public static final int TIME_ONLY = 1;
	public static final int DATE_TIME = 2;
	
	public static String getDateTime(int type, Date date) {
		String now = null;
		// 요청에 따라 날짜, 시간 , 날짜 + 시간 정보를 제공한다.
		String pattern = "yyyy-MM-dd HH시mm분ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		now = sdf.format(date);
		if (type==0) //날짜 제공
		{
			String[] temp = now.split(" ");
			now = temp[0];
		} 
		else if(type==1) //시간 제공
		{
			now = now.split(" ")[1];
		}
		
		return now;
	}
	
}
