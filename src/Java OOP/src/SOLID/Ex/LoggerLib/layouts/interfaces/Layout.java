package SOLID.Ex.LoggerLib.layouts.interfaces;


import SOLID.Ex.LoggerLib.enumerations.ReportLevel;

public interface Layout {
    String format(String data, ReportLevel reportLevel, String message);
}
