package hiberspring.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <O> O fromXml( String filePath, Class<O> objectClass) throws JAXBException, FileNotFoundException;
}
