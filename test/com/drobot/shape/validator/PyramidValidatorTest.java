package test.com.drobot.shape.validator;

import com.drobot.shape.entity.Point;
import com.drobot.shape.validator.PyramidValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.List;

public class PyramidValidatorTest {

    @Test
    public void arePointsValidTest1() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertTrue(condition);
    }

    @Test
    public void arePointsValidTest2() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(2.0, 5.0, 7.0);
        Point point3 = new Point(1.0, 6.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertTrue(condition);
    }

    @Test
    public void arePointsValidTest3() {
        Point point1 = new Point(200.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertTrue(condition);
    }

    @Test
    public void arePointsValidTest4() {
        Point point1 = new Point(-200.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertTrue(condition);
    }

    @Test
    public void arePointsValidTest5() {
        Point point1 = new Point(2.0, 6.0, 6.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 7.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertFalse(condition);
    }

    @Test
    public void arePointsValidTest6() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(1.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 7.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertFalse(condition);
    }

    @Test
    public void arePointsValidTest7() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(2.0, 6.0, 7.0);
        Point point3 = new Point(1.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        PyramidValidator validator = new PyramidValidator();
        boolean condition = validator.arePointsValid(points);
        assertFalse(condition);
    }
}
