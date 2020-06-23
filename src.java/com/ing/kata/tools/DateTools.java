package com.ing.kata.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTools {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String fromLocalDateTimeToString(LocalDateTime localDateTime) {	
		String formattedDateTime = localDateTime.format(formatter);
		return formattedDateTime;
	}

}
