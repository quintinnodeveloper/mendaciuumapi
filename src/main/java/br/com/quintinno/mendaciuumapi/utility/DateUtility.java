package br.com.quintinno.mendaciuumapi.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    private static final String FORMATO_DDMMYYYY = "dd/MM/yyyy";

    private DateUtility() {}

    public static LocalDate getData(String data, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(data, formatter);
    }

    public static String getFormatoDDMMYYYY() {
        return FORMATO_DDMMYYYY;
    }

}
