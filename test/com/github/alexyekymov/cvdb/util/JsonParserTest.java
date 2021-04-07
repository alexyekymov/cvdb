package com.github.alexyekymov.cvdb.util;

import com.github.alexyekymov.cvdb.model.Resume;
import com.github.alexyekymov.cvdb.model.Section;
import com.github.alexyekymov.cvdb.model.TextSection;
import org.junit.Test;

import static com.github.alexyekymov.cvdb.util.ResumeTestData.R1;
import static org.junit.Assert.assertEquals;

public class JsonParserTest {
    @Test
    public void testResume() throws Exception {
        String json = JsonParser.write(R1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        assertEquals(R1, resume);
    }

    @Test
    public void write() throws Exception {
        Section section1 = new TextSection("Objective1");
        String json = JsonParser.write(section1, Section.class);
        System.out.println(json);
        Section section2 = JsonParser.read(json, Section.class);
        assertEquals(section1, section2);
    }
}