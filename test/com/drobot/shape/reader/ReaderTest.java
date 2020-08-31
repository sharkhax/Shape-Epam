package test.com.drobot.shape.reader;

import com.drobot.shape.exception.ReaderException;
import com.drobot.shape.reader.DataReader;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.List;

public class ReaderTest {

    @Test
    public void readFileTest() {
        DataReader dataReader = new DataReader();
        List<String> actual = null;
        List<String> expected = List.of("-37.0 35.2 20.0, -20.0 40.0 20.0, -25.0 45.0 20.0, -20.0 37.5 25.0",
                "2 6 7, 3 8 7, 4 10 7");
        try {
            actual = dataReader.readFile();
        } catch (ReaderException e) {
            fail(e.getMessage());
        }
        assertEquals(actual, expected);
    }
}
