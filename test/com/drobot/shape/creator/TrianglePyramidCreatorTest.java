package test.com.drobot.shape.creator;

import com.drobot.shape.creator.impl.TrianglePyramidCreator;
import com.drobot.shape.entity.Point;
import com.drobot.shape.exception.ObserverException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TrianglePyramidCreatorTest {

    @Test
    public void createPyramidTest() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        TrianglePyramidCreator creator = new TrianglePyramidCreator();
        try {
            creator.createPyramid(points);
        } catch (ObserverException e) {
            fail(e.getMessage());
        }
    }
}
