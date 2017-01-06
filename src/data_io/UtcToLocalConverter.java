/*
 * UtcToLocalConverter
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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

/**
 * UtcToLocalConverter
 * This class parses a string that contains
 * dateTime in UTC and converts it to localtime
 */
public class UtcToLocalConverter {

    LocalDateTime outDateTime;

    /**
     * UtcToLocalConverter
     * Constructor method that takes a string which has to
     * contain a datetime in UTC which is then parsed, converted
     * and stored in the instance.
     * @param dateTime
     */
    public UtcToLocalConverter(String dateTime){

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("GMT"));
        ZonedDateTime test = ZonedDateTime.parse(dateTime, formatter).withZoneSameInstant(ZoneId.systemDefault());
        outDateTime = test.toLocalDateTime();

    }

    /**
     * getDate()
     * Property accessor method.
     * @return LocaldateTime the parsed and converted localtime
     */
    public LocalDateTime getDate(){
        return outDateTime;
    }

}
