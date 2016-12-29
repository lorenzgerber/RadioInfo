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
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

/**
 * Created by loge on 2016-12-23.
 */
public class XmlScheduleParser {

    NodeList nodeList;
    ProgramListModel programs = new ProgramListModel();


    public XmlScheduleParser(int channelId, LocalDate localDate){
        String SCHEDULE_URL = "http://api.sr.se/api/v2/scheduledepisodes?channelid=";
        StringBuilder urlBuilder = new StringBuilder(SCHEDULE_URL);
        urlBuilder.append(channelId);

        // add date as string
        String formattedString = localDate.format(ISO_LOCAL_DATE);
        urlBuilder.append("&date=" + formattedString);

        // choose large size to include all programs
        urlBuilder.append("&size=1000");

        this.ScheduleParser(urlBuilder.toString());

    }


    public XmlScheduleParser(String stringUrl){

        this.ScheduleParser(stringUrl);

    }

    private void ScheduleParser(String stringUrl){

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
