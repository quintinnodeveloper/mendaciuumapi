package br.com.quintinno.mendaciuumapi.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    private static final String FORMATO_DDMMYYYY = "dd/MM/yyyy";

    private static final String FORMATO_DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";

    private DateUtility() {}

    public static LocalDate getData(String data, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(data, formatter);
    }

    public static String getDataHoraString(LocalDateTime data, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return data.format(formatter);
    }

    public static String getFormatoDDMMYYYY() {
        return FORMATO_DDMMYYYY;
    }

    public static String getFormatoDDMMYYYYHHMMSS() {
        return FORMATO_DDMMYYYYHHMMSS;
    }

}
