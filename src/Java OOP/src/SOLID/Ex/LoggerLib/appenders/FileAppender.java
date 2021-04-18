package SOLID.Ex.LoggerLib.appenders;

import SOLID.Ex.LoggerLib.coustomFiles.LogFile;
import SOLID.Ex.LoggerLib.coustomFiles.interfaces.File;
import SOLID.Ex.LoggerLib.enumerations.ReportLevel;
import SOLID.Ex.LoggerLib.layouts.interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;
    public FileAppender(Layout layout) {
        super(layout);

    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String data, ReportLevel reportLevel, String message) {
        if (this.file == null){
//            throw new NullPointerException("File reference not set "
//                    +"to an instance of an object");
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = this.format(data,reportLevel,message);

        file.appendBuffer(str);
        this.file.write();

    }

    @Override
    public String toString() {
        return super.toString() + ", File size: "+ this.file.getSize();
    }
}
