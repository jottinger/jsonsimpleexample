package com.autumncode.javachannel;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.assertEquals;

/**
 * Created by Joseph on 4/8/2016.
 */
public class JSONTest {
    @Test
    public void readAndWriteEvent() throws IOException, ParseException {
        Event event=new Event(10, System.currentTimeMillis());
        event.setType("foo");
        event.setUpdatedAt(event.getCreatedAt()+10);
        System.out.println(event);
        String json=event.toJSON();
        System.out.println(json);
        Event e2=Event.fromJSON(new StringReader(json));
        System.out.println(e2);
        assertEquals(event, e2);
    }
}
