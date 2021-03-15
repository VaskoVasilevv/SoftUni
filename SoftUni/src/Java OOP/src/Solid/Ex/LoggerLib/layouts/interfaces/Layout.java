package Solid.Ex.LoggerLib.layouts.interfaces;


import Solid.Ex.LoggerLib.enumerations.ReportLevel;

public interface Layout {
    String format(String data, ReportLevel reportLevel, String message);
}
