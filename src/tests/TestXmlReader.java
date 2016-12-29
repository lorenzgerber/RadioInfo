package tests;

import data_io.XmlReader;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * Created by loge on 2016-12-29.
 */
public class TestXmlReader {

    String xmlFile = "/tests/channels.xml";
    String localPath;

    @Before
    public void getFilePath(){
        URL loc = this.getClass().getResource(xmlFile);
        localPath = loc.getPath();
    }


    @Test
    public void TestConstructor(){
        XmlReader reader = new XmlReader(localPath);
        assert(reader != null);
    }


}
