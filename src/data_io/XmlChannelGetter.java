package data_io;

import model.ChannelListModel;
import model.ChannelModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by loge on 2016-12-22.
 */
public class XmlChannelGetter {

    NodeList nodeList;
    ChannelListModel channels = new ChannelListModel();


    public XmlChannelGetter(XmlReader reader){

        nodeList = reader.doc.getElementsByTagName("channel");


        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                int id = Integer.parseInt(eElement.getAttribute("id"));
                String name = eElement.getAttribute("name");
                String scheduleUrl = eElement.getElementsByTagName("scheduleurl").item(0).getTextContent();

                this.channels.add(new ChannelModel(id, name, scheduleUrl));

            }
        }

    }

    public ChannelListModel getChannelList(){
        return this.channels;
    }

}
