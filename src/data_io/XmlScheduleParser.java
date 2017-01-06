/*
 * XmlScheduleParser
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

import model.ProgramListModel;
import model.ProgramModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

/**
 * XmlScheduleParser Class
 * This class parses the program obtained by a
 * XmlReader instance from the 'Sveriges Radio' web
 * API V2.
 */
public class XmlScheduleParser implements Iterable<ProgramModel>{

    NodeList nodeList;
    ProgramListModel programList = new ProgramListModel();


    /**
     * XmlScheduleParser
     * Constructor method
     * @param channelId int channel Id from SR's web API V2
     * @param localDate localDate object, date of program to be loaded
     */
    public XmlScheduleParser(int channelId, LocalDate localDate){


        ArrayList<LocalDate> threeDates = this.threeDateRange(localDate);

        for(LocalDate date : threeDates){
            String SCHEDULE_URL = "http://api.sr.se/api/v2/scheduledepisodes?channelid=";
            StringBuilder urlBuilder = new StringBuilder(SCHEDULE_URL);
            urlBuilder.append(channelId);
            /* add date as string */
            String formattedString = date.format(ISO_LOCAL_DATE);
            urlBuilder.append("&date=" + formattedString);

            /* choose large size to include all programs */
            urlBuilder.append("&size=1000");

            this.ScheduleParser(urlBuilder.toString());
        }
    }

    /**
     * XmlScheduleParser
     * Alternative constructor method used for
     * unit testing.
     * @param stringUrl
     */
    public XmlScheduleParser(String stringUrl){

        this.ScheduleParser(stringUrl);

    }

    /**
     * ScheduleParser
     * Actual parse method that will
     * fill a ProgramListModel with ProgramModel
     * objects.
     * @param stringUrl
     */
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

                /* Check if there is a more detailed title tag available */
                Node titleNode = eElementEpisode
                        .getElementsByTagName("title")
                        .item(0);
                if (titleNode != null){
                    name = titleNode.getTextContent();
                }

                tempProgram = new ProgramModel(programid, name);

                /* parse Description, if available */
                Node descriptionNode = eElementEpisode
                        .getElementsByTagName("description")
                        .item(0);
                if (descriptionNode != null){
                    tempProgram.setDescription(descriptionNode.getTextContent());
                }

                /* parse image url, if available */
                Node imageUrlNode = eElementEpisode
                        .getElementsByTagName("imageurl")
                        .item(0);
                if(imageUrlNode != null){
                    tempProgram.setImageUrl(imageUrlNode.getTextContent());
                }

                /* parse start time */
                LocalDateTime start = new UtcToLocalConverter(
                        eElementEpisode
                                .getElementsByTagName("starttimeutc")
                                .item(0)
                                .getTextContent())
                        .getDate();

                /* parse end time */
                LocalDateTime end = new UtcToLocalConverter(
                        eElementEpisode
                                .getElementsByTagName("endtimeutc")
                                .item(0)
                                .getTextContent())
                        .getDate();
                tempProgram.setStartTime(start);
                tempProgram.setEndTime(end);

                programList.add(tempProgram);

            }
        }

    }

    public Iterator<ProgramModel> iterator() {
        return programList.iterator();
    }

    /**
     * threeDateRange
     * Helper method that returns an ArrayList with a range
     * of three LocalDate objects from one date before to
     * one day after the input argument middleDate. This is used
     * to guarantee a complete set of programs for 12 hours before and
     * after the current time.
     * @param middleDate LocalDate middelDate
     * @return ArrayList that contains three LocalDate objects
     */
    private ArrayList<LocalDate> threeDateRange(LocalDate middleDate){
        ArrayList<LocalDate> threeDateRange = new ArrayList<>();
        LocalDate dateToday = middleDate;
        LocalDate dateTomorrow = dateToday.plusDays(1);
        LocalDate dateYesterday = dateToday.minusDays(1);
        threeDateRange.add(dateYesterday);
        threeDateRange.add(dateToday);
        threeDateRange.add(dateTomorrow);
        return threeDateRange;
    }


}
