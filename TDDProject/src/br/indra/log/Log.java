package br.indra.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {

	public static void log(Class errorCause, String message) {
		System.out.println("["+errorCause + "] - "+Calendar.getInstance()+" - "+message);
	}

	public static void log(String message) {
		System.out.println(Calendar.getInstance()+" - "+message);		
	}
}
