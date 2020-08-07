import java.util.Date;

import wjw.cron.ex.CronExpressionEx;
import wjw.cron.ex.DateFormatUtil;


public class MyTest {

	public static void main(String[] args) throws Exception {
		
		 CronExpressionEx exp = new CronExpressionEx("0 0,15,30,45 * * * ?");
	     Date dd = new Date();
	      
	     for (int i = 1; i <= 8; i++) {
	        dd = exp.getNextValidTimeAfter(dd);
	        System.out.println(i+":"+DateFormatUtil.format("yyyy-MM-dd HH:mm:ss", dd));
	        dd = new Date(dd.getTime() + 1000L);
	     }
	}

}
