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
 * Created by loge on 2016-12-23.
 */
public class UtcToLocalConverter {

    LocalDateTime outDateTime;

    public UtcToLocalConverter(String dateTime){

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("GMT"));
        ZonedDateTime test = ZonedDateTime.parse(dateTime, formatter).withZoneSameInstant(ZoneId.systemDefault());
        outDateTime = test.toLocalDateTime();

    }

    public LocalDateTime getDate(){
        return outDateTime;
    }

}
