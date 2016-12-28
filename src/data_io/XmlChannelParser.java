package data_io;

import model.ChannelListModel;
import model.ChannelModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;

/**
 * Created by loge on 2016-12-22.
 */
public class XmlChannelParser implements Iterable<ChannelModel>{

    NodeList nodeList;
    ChannelListModel channelList;
    String CHANNEL_URL = "http://api.sr.se/api/v2/channels/?size=100";


    public XmlChannelParser(){

        XmlReader reader = new XmlReader(CHANNEL_URL);
        this.channelList = new ChannelListModel();
        nodeList = reader.doc.getElementsByTagName("channel");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                int id = Integer.parseInt(eElement.getAttribute("id"));
                String name = eElement.getAttribute("name");
                if(eElement.getElementsByTagName("scheduleurl").getLength()!=0){
                    String scheduleUrl = eElement.getElementsByTagName("scheduleurl").item(0).getTextContent();
                    this.channelList.add(new ChannelModel(id, name, scheduleUrl));

                }
            }
        }


    }

    public Iterator<ChannelModel> iterator() {
        return channelList.iterator();
    }


}
