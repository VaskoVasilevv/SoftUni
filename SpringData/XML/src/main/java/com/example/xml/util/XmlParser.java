package com.example.xml.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filePath,Class<T> tClass) throws JAXBException, FileNotFoundException;

    <T> T toFile(String filePath, T entity) throws JAXBException;

}
