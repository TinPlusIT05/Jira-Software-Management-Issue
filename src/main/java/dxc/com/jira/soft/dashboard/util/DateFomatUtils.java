package dxc.com.jira.soft.dashboard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateFomatUtils {
	
	public static String dateFomat(String oldDatetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String isDate = null;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.parse(oldDatetime);
			isDate = sdf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDate;
	}
	
	public static List<String> dateCurrentWeek(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		List<String> rs = new ArrayList<String>();
		LocalDate today = LocalDate.now();

	    // Go backward to get Monday
	    LocalDate monday = today;
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY)
	    {
	      monday = monday.minusDays(1);
	    }
	    rs.add(monday.format(formatter));

	    // Go forward to get Sunday
	    LocalDate sunday = today;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY)
	    {
	    	sunday = sunday.plusDays(1);
	    }
	    
	    rs.add(sunday.format(formatter));
	    
	    return rs;
	}
}
