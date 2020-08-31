package test.com.drobot.shape.parser;

import com.drobot.shape.entity.Point;
import com.drobot.shape.parser.PointParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.Collections;
import java.util.List;

public class PointParserTest {

    @Test
    public void parsePointsTest1() {
        String input = "-37.0 35.2 20.0, -20.0 40.0 20.0, -25.0 45.0 20.0, -20.0 37.5 25.0";
        Point point1 = new Point(-37.0, 35.2, 20.0);
        Point point2 = new Point(-20.0, 40.0, 20.0);
        Point point3 = new Point(-25.0, 45.0, 20.0);
        Point point4 = new Point(-20.0, 37.5, 25.0);
        List<Point> expected = List.of(point1, point2, point3, point4);
        PointParser parser = new PointParser();
        List<Point> actual = parser.parsePoints(input);
        assertEquals(actual, expected);
    }

    @Test
    public void parsePointsTest2() {
        String input = "2 6 7, 3 8 7, 4 10 7, 10 7 10";
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(3.0, 8.0, 7.0);
        Point point3 = new Point(4.0, 10.0, 7.0);
        Point point4 = new Point(10.0, 7.0, 10.0);
        List<Point> expected = List.of(point1, point2, point3, point4);
        PointParser parser = new PointParser();
        List<Point> actual = parser.parsePoints(input);
        assertEquals(actual, expected);
    }

    @Test
    public void parsePointsTest3() {
        String input = "2 6 7, 3 8 7, 4 10 ";
        List<Point> expected = Collections.emptyList();
        PointParser parser = new PointParser();
        List<Point> actual = parser.parsePoints(input);
        assertEquals(actual, expected);
    }

    @Test
    public void parsePointsTest4() {
        String input = "2 6 7, 3 8 7, ф ф 10";
        List<Point> expected = Collections.emptyList();
        PointParser parser = new PointParser();
        List<Point> actual = parser.parsePoints(input);
        assertEquals(actual, expected);
    }
}
