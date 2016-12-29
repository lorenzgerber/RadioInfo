package tests;

import data_io.XmlChannelParser;
import model.ChannelModel;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * Created by loge on 2016-12-28.
 */
public class TestXmlChannelParser {

    String xmlFile = "/tests/channels.xml";
    String localPath;

    @Before
    public void getFilePath(){
        URL loc = this.getClass().getResource(xmlFile);
        localPath = loc.getPath();
    }


    @Test
    public void TestConstructor(){
        XmlChannelParser parser = new XmlChannelParser(localPath);
        assert(parser != null);
    }

    @Test
    public void TestIterator(){
        XmlChannelParser parser = new XmlChannelParser(localPath);

        int counter = 0;

        for(ChannelModel channel : parser){
            if (!channel.equals(null)){
                counter++;
            }
        }

        assert(counter == 33);

    }



}
