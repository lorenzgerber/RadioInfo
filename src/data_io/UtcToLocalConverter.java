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
