package com.erick.escolar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	public static String timestampToDate(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data); 
	}
	
	public static String timestampToDate2(Date data) {
		return new SimpleDateFormat("yyyy-MM-dd").format(data); 
	}
	
	public static String timestampToDate(Long data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data); 
	}
	
	
}
