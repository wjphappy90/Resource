package cn.itcast.utils;

import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static Date addTime(Date date,int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 10);
		return calendar.getTime();
	}
	
}
