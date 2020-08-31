package test.com.drobot.shape.service;

import com.drobot.shape.entity.Point;
import com.drobot.shape.service.PyramidBaseDefiner;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PyramidBaseDefinerTest {

    @Test
    public void defineBasePlaneTest1() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(2.0, 5.0, 7.0);
        Point point3 = new Point(1.0, 6.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        int actual = definer.defineBasePlane(points).getValue();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void defineBasePlaneTest2() {
        Point point1 = new Point(2.0, 6.0, 2.0);
        Point point2 = new Point(2.0, 5.0, 7.0);
        Point point3 = new Point(2.0, 6.0, 3.0);
        Point point4 = new Point(1.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        int actual = definer.defineBasePlane(points).getValue();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void defineBasePlaneTest3() {
        Point point1 = new Point(2.0, 6.0, 3.0);
        Point point2 = new Point(2.0, 5.0, 3.0);
        Point point3 = new Point(2.0, 6.0, 3.0);
        Point point4 = new Point(1.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        int actual = definer.defineBasePlane(points).getValue();
        int expected = -1;
        assertEquals(actual, expected);
    }
}
