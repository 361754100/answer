package com.test.answer.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * @author Mojianzhang
 *
 */
public class DateUtils {

	public static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Date parseStrToDate(String time, String format) {
		DateFormat dFormat = new SimpleDateFormat(format);
		Date date = null;
		if(StringUtils.isEmpty(time)) {
			return date;
		}
		try {
			date = dFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dFormat = null;
		return date;
	}
	
	public static String parseDateToStr(Date time, String format) {
		DateFormat dFormat = new SimpleDateFormat(format);
		String date = "";
		if(time == null) {
			return date;
		}
		try {
			date = dFormat.format(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dFormat = null;
		return date;
	}
	
}
