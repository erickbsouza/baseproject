package br.com.mobit.gvm.util.jsf;


import java.text.DateFormat; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * @param date, format
	 * @author DeivideDuarte
	 * @param date
	 * @return data formatada
	 * @typereturn {yyyy-MM-dd}, {yyyy-MM-dd}, {yyyyMMdd}, {yyyy-MM-dd}, {yyyyMM}, {dd}, {MM}
	 * {HH:mm}
	 */


	public static String formatDate(Date date, String format){
		String getDateFormat;
		SimpleDateFormat dt = new SimpleDateFormat(format);
		getDateFormat = dt.format(date);
		return getDateFormat;

	}

	public static Date stringToDate(String dateP, String format)  { 
		Date date = null;
		if (dateP == null || dateP.equals(""))
			return null;
		try {
			DateFormat formatter = new SimpleDateFormat(format);
			date = (java.util.Date)formatter.parse(dateP);
		} catch (ParseException e) {            
			e.getMessage();
		}
		return date;
	}


	public static boolean validDate(Date dataIni, Date dataFim) {
		boolean isvalid = true;
		if(dataIni == null || dataFim== null){
			//JOptionPane.showMessageDialog(null, "Campo data nao pode ser Vazio !!");
			isvalid = false;
		}else{
			if(dataIni.after(dataFim)){
				//JOptionPane.showMessageDialog(null, "Data Invalida !!");
				isvalid = false;
			}
		}
		return isvalid;
	}

	public static int difDateDayDate (Date dateStar, Date dateEnd){ 
		Calendar dInicial = Calendar.getInstance(); 
		dInicial.setTime(dateStar);
		Calendar dFinal = Calendar.getInstance();
		dFinal.setTime(dateEnd);
		int count = 0;    
		while (dInicial.get(Calendar.DAY_OF_MONTH) != dFinal.get(Calendar.DAY_OF_MONTH)){    
			dInicial.add(Calendar.DAY_OF_MONTH, 1);    
			count ++;    
		}    
		return count;   
	}
	
	public static int difDateDayCal (Calendar dateStar, Calendar dateEnd){ 

		int count = 0;    
		while (dateStar.get(Calendar.DAY_OF_MONTH) != dateEnd.get(Calendar.DAY_OF_MONTH)){    
			dateStar.add(Calendar.DAY_OF_MONTH, 1);    
			count ++;    
		}    
		return count;   
	}

}
