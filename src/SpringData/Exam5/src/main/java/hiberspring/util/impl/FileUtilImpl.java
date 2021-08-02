package hiberspring.util.impl;

import hiberspring.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileUtilImpl implements FileUtil {
    @Override
    public String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }
}
