package SOLID.Ex.LoggerLib.layouts;

import SOLID.Ex.LoggerLib.enumerations.ReportLevel;
import SOLID.Ex.LoggerLib.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {


    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",date,reportLevel.toString(),message);
    }
}
