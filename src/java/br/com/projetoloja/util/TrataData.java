package br.com.projetoloja.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrataData {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean dataInvalida(String data) {
        try {
            String[] dt = data.split("/");
            int ano = Integer.parseInt(dt[2]);
            int mes = Integer.parseInt(dt[1]);
            int dia = Integer.parseInt(dt[0]);
            if ((dia < 1) || (dia > 31)) {
                return true;
            }
            if (((dia == 30) || (dia == 31)) && (mes == 2)) {
                return true;
            }
            if ((dia == 31) && ((mes == 2) || (mes == 4) || (mes == 6) || (mes == 9) || (mes == 11))) {
                return true;
            }
            if ((mes < 1) || (mes > 12)) {
                return true;
            }
            if ((dia == 29) && (mes == 2) && (new GregorianCalendar().isLeapYear(ano) == false)) {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public static Date strToDate(String umaData) {
        String[] dt = umaData.split("/");
        int ano = Integer.parseInt(dt[2]);
        int mes = Integer.parseInt(dt[1]);
        int dia = Integer.parseInt(dt[0]);

        return Date.valueOf(ano + "-" + mes + "-" + dia);
    }

    public static String dateToStr(Date umaData) {
        if (umaData == null) {
            return "";
        } else {
            return sdf.format(umaData);
        }
    }

    public static String dataSistema() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            GregorianCalendar date = new GregorianCalendar();
            return dateFormat.format(date.getTime());
        } catch (DateTimeException e) {
            System.err.println("Erros ao pegar a data do sistema: " + e.toString());
            return null;
        }
    }

    public static String dataToMysql(Calendar data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(data.getTime());
        } catch (DateTimeException e) {
            System.err.println("Erros ao converter data para texto: " + e.toString());
            return null;
        }

    }

    public static Calendar mysqlToDate(Date data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Calendar date = Calendar.getInstance();
            date.setTime(Date.valueOf(dateFormat.format(data)));
            return date;
        } catch (DateTimeException e) {
            System.err.println("Erros ao converter texto em data: " + e.toString());
            return null;
        }

    }

}
