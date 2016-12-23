package tests;

import data_io.UtcToLocalConverter;
import org.junit.Test;

/**
 * Created by loge on 2016-12-23.
 */
public class TestUtcToLocalConverter {

    @Test
    public void constructorTest(){

        String str = "2016-12-22T23:45:00Z";
        System.out.println(new UtcToLocalConverter(str).getDate());
    }


}
