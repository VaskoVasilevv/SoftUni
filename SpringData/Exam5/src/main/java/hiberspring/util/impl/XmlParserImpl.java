package hiberspring.util.impl;

import hiberspring.util.XmlParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class XmlParserImpl implements XmlParser {

    @Override
    public <O> O fromXml(String filePath, Class<O> objectClass) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (O) unmarshaller.unmarshal(new FileReader(filePath));
    }
}
