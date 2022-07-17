package utills;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat; //formata numero para double
import java.util.Locale;

public class Utills {
    static NumberFormat numberFormat =
            new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));


    public static String doubleToString(double value){ //meteodo que faz a conversao de valores

        return numberFormat.format(value);
    }

    }
