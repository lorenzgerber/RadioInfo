/*
 * XmlChannelParser
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
package data_io;

import model.ChannelListModel;
import model.ChannelModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URL;
import java.util.Iterator;

/**
 * XmlChannelParser Class
 * This class is used to parse the channel list from
 * "Sveriges Radio" web API v2 obtained by a XmlReader instance.
 */
public class XmlChannelParser implements Iterable<ChannelModel>{

    private NodeList nodeList;
    private ChannelListModel channelList;
    private String CHANNEL_URL = "http://api.sr.se/api/v2/channels";

    /**
     * XmlChannelParser
     * Constructor that reads from the hardcoded
     * default web API address.
     * @param numberChannels int maximum number of channels to read
     */
    public XmlChannelParser(int numberChannels){
        StringBuilder urlBuilder = new StringBuilder(CHANNEL_URL);
        urlBuilder.append("/?size=" + numberChannels);
        this.ChannelParser(urlBuilder.toString());
    }

    /**
     * XmlChannelParser Constructor
     * Used for JUnit tests with local xml file
     * @param channelFile
     */
    public XmlChannelParser(String channelFile) {
        this.ChannelParser(channelFile);
    }

    /**
     * ChannelParser
     * Actual parser method for 'Sveriges Radio'
     * web API xml format 2
     * @param channelUrl string with the url to the web API
     *                   or a respective resource
     */
    public void ChannelParser(String channelUrl){

        XmlReader reader = new XmlReader(channelUrl);
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

    /**
     * Iterator method
     * @return Iterator that iterates over ChannlListModel
     * of obtained channels.
     */
    public Iterator<ChannelModel> iterator() {
        return channelList.iterator();
    }

}
