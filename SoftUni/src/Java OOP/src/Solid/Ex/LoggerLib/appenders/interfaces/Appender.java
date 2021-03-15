package Solid.Ex.LoggerLib.appenders.interfaces;

import Solid.Ex.LoggerLib.enumerations.ReportLevel;

public interface Appender {
    void append(String data, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
