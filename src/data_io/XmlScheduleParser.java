package data_io;

import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import model.ProgramModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by loge on 2016-12-23.
 */
public class XmlScheduleParser {

    NodeList nodeList;
    ProgramListModel programs = new ProgramListModel();


    public XmlScheduleParser(String stringUrl, LocalDate date ){

        XmlReader reader = new XmlReader(stringUrl);

        nodeList = reader.doc.getElementsByTagName("scheduledepisode");


        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElementEpisode = (Element) nNode;
                Element eElementProgram;

                ProgramModel tempProgram;

                eElementProgram = (Element) eElementEpisode.getElementsByTagName("program").item(0);

                int programid = Integer.parseInt(eElementProgram.getAttribute("id"));
                String name = eElementProgram.getAttribute("name");
                tempProgram = new ProgramModel(programid, name);

                String description = eElementEpisode
                        .getElementsByTagName("description")
                        .item(0).getTextContent();
                if (description.length()>0){
                    tempProgram.setDescription(description);
                }

                // parse start time
                LocalDateTime start = new UtcToLocalConverter(
                        eElementEpisode
                                .getElementsByTagName("starttimeutc")
                                .item(0)
                                .getTextContent())
                        .getDate();

                // parse end time
                LocalDateTime end = new UtcToLocalConverter(
                        eElementEpisode
                                .getElementsByTagName("endtimeutc")
                                .item(0)
                                .getTextContent())
                        .getDate();
                tempProgram.setStartTime(start);
                tempProgram.setEndTime(end);

                programs.add(tempProgram);

            }
        }

    }

    public ProgramListModel getProgramList(){
        return this.programs;
    }


}
