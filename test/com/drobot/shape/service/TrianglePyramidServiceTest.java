package test.com.drobot.shape.service;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.TrianglePyramid;
import com.drobot.shape.exception.ServiceException;
import com.drobot.shape.service.impl.TrianglePyramidService;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

import static org.testng.Assert.*;

public class TrianglePyramidServiceTest {

    @Test
    public void calculateVolumeTest() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            double actual = service.calculateVolume(pyramid);
            double expected = 2.0;
            double delta = 0.001;
            assertEquals(actual, expected, delta);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void calculateSurfaceAreaTest() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        double actual = service.calculateSurfaceArea(pyramid);
        double expected = 12.69;
        double delta = 0.001;
        assertEquals(actual, expected, delta);
    }

    @Test
    public void calculateVolumeRatioTest1() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            double actual = service.calculateVolumeRatio(pyramid);
            double expected = -1.0;
            double delta = 0.001;
            assertEquals(actual, expected, delta);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void calculateVolumeRatioTest2() {
        Point point1 = new Point(2.0, 6.0, -7.0);
        Point point2 = new Point(4.0, 6.0, -7.0);
        Point point3 = new Point(2.0, 8.0, -7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            double actual = service.calculateVolumeRatio(pyramid);
            double expected = 0.25;
            double delta = 0.01;
            assertEquals(actual, expected, delta);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void isBaseOnCoordinatePlaneTest1() {
        Point point1 = new Point(2.0, 6.0, 0.0);
        Point point2 = new Point(4.0, 6.0, 0.0);
        Point point3 = new Point(2.0, 8.0, 0.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            boolean actual = service.isBaseOnCoordinatePlane(pyramid);
            assertTrue(actual);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void isBaseOnCoordinatePlaneTest2() {
        Point point1 = new Point(2.0, 6.0, 7.0);
        Point point2 = new Point(4.0, 6.0, 7.0);
        Point point3 = new Point(2.0, 8.0, 7.0);
        Point point4 = new Point(2.0, 6.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            boolean actual = service.isBaseOnCoordinatePlane(pyramid);
            assertFalse(actual);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void isBaseOnCoordinatePlaneTest3() {
        Point point1 = new Point(2.0, 0.0, 7.0);
        Point point2 = new Point(4.0, 0.0, 7.0);
        Point point3 = new Point(2.0, 0.0, 7.0);
        Point point4 = new Point(2.0, 0.0, 10.0);
        List<Point> points = List.of(point1, point2, point3, point4);
        TrianglePyramid pyramid = new TrianglePyramid(UUID.randomUUID(), points);
        TrianglePyramidService service = new TrianglePyramidService();
        try {
            boolean actual = service.isBaseOnCoordinatePlane(pyramid);
            assertFalse(actual);
        } catch (ServiceException e) {
            fail(e.getMessage());
        }
    }
}
