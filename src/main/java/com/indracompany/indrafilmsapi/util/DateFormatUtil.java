package com.indracompany.indrafilmsapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {
	
	
	public static Date formatToDate(String date) {
		try {
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
			return sdt.parse(date);
		} catch(ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String formatToString(Date date) {
		try {
			SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
			return sdt.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
