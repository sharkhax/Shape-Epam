package com.drobot.shape.service.impl;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.TrianglePyramid;
import com.drobot.shape.exception.ServiceException;
import com.drobot.shape.service.PyramidService;
import com.drobot.shape.service.PyramidBaseDefiner;
import com.drobot.shape.type.BasePlaneType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TrianglePyramidService implements PyramidService<TrianglePyramid> {

    private static final Logger LOGGER = LogManager.getLogger(TrianglePyramidService.class);

    @Override
    public double calculateVolume(TrianglePyramid pyramid) throws ServiceException {
        List<Point> points = pyramid.getPoints();
        double result = calculateVolume(points);
        LOGGER.log(Level.DEBUG, "Volume has been calculated: " + result);
        return result;
    }

    @Override
    public double calculateSurfaceArea(TrianglePyramid pyramid) {
        List<Point> points = pyramid.getPoints();
        double result = 0.0;
        for (int i = 0; i < points.size(); i++) {
            List<Point> temp = new ArrayList<>(List.copyOf(points));
            temp.remove(i);
            result += calculateTriangleArea(temp);
        }
        LOGGER.log(Level.DEBUG, "Surface area has been calculated: " + result);
        return result;
    }

    @Override
    public double calculateVolumeRatio(TrianglePyramid pyramid) throws ServiceException {
        List<Point> points = pyramid.getPoints();
        List<Point> smallPyramidPoints = findCrossPoints(points);
        Point vertex = points.get(3);
        smallPyramidPoints.add(vertex);
        double smallPyramidVolume = calculateVolume(smallPyramidPoints);
        double pyramidVolume = calculateVolume(pyramid);
        double result;
        if (Double.compare(pyramidVolume, smallPyramidVolume) == 1) {
            double deltaVolume = pyramidVolume - smallPyramidVolume;
            result = smallPyramidVolume / deltaVolume;
        } else {
            result = -1;
        }
        LOGGER.log(Level.DEBUG, "Volume ratio has been calculated: " + result);
        return result;
    }

    @Override
    public boolean isBaseOnCoordinatePlane(TrianglePyramid pyramid) throws ServiceException {
        List<Point> points = pyramid.getPoints();
        Point firstPoint = points.get(0);
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        BasePlaneType basePlane = definer.defineBasePlane(points);
        boolean result;
        switch (basePlane) {
            case OYZ -> result = firstPoint.getX() == 0.0;
            case OXZ -> result = firstPoint.getY() == 0.0;
            case OXY -> result = firstPoint.getZ() == 0.0;
            default ->
                    throw new ServiceException("Incorrect defineBasePlane() return value: " + basePlane.toString());
        }
        LOGGER.log(Level.DEBUG, "Base on coordinate plane: " + result);
        return result;
    }

    private double calculateHeight(List<Point> points) throws ServiceException {
        double height;
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        BasePlaneType basePlane = definer.defineBasePlane(points);
        Point firstPoint = points.get(0);
        Point vertex = points.get(3);
        switch (basePlane) {
            case OYZ -> height = Math.abs(vertex.getX() - firstPoint.getX());
            case OXZ -> height = Math.abs(vertex.getY() - firstPoint.getY());
            case OXY -> height = Math.abs(vertex.getZ() - firstPoint.getZ());
            default ->
                    throw new ServiceException("Incorrect defineBasePlane() return value :" + basePlane.toString());
        }
        LOGGER.log(Level.DEBUG, "Height has been calculated: " + height);
        return height;
    }

    private double calculateTriangleArea(List<Point> trianglePoints) {
        Point point1 = trianglePoints.get(0);
        Point point2 = trianglePoints.get(1);
        Point point3 = trianglePoints.get(2);
        double a = calculateSide(point1, point2);
        double b = calculateSide(point2, point3);
        double c = calculateSide(point1, point3);
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        LOGGER.log(Level.DEBUG, "Triangle area has been calculated: " + area);
        return area;
    }

    private double calculateSide(Point point1, Point point2) {
        double result = Math.pow(point1.getX() - point2.getX(), 2)
                + Math.pow(point1.getY() - point2.getY(), 2)
                + Math.pow(point1.getZ() - point2.getZ(), 2);
        result = Math.sqrt(result);
        LOGGER.log(Level.DEBUG, "Side has been calculated: " + result);
        return result;
    }

    private double calculateVolume(List<Point> points) throws ServiceException {
        double height = calculateHeight(points);
        double baseArea = calculateTriangleArea(points.subList(0, 3));
        double result = height * baseArea / 3;
        LOGGER.log(Level.DEBUG, "Volume has been calculated: " + result);
        return result;
    }

    private List<Point> findCrossPoints(List<Point> pyramidPoints) throws ServiceException {
        Point vertex = pyramidPoints.get(3);
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        BasePlaneType basePlane = definer.defineBasePlane(pyramidPoints);
        List<Point> result = new ArrayList<>();
        switch (basePlane) {
            case OYZ -> {
                for (int i = 0; i < 3; i++) {
                    Point point = pyramidPoints.get(i);
                    double t = -vertex.getX() / (point.getX() - vertex.getX());
                    double x = 0;
                    double y = (point.getY() - vertex.getY()) * t - vertex.getY();
                    double z = (point.getZ() - vertex.getZ()) * t - vertex.getZ();
                    Point crossPoint = new Point(x, y, z);
                    result.add(crossPoint);
                }
            }
            case OXZ -> {
                for (int i = 0; i < 3; i++) {
                    Point point = pyramidPoints.get(i);
                    double t = -vertex.getY() / (point.getY() - vertex.getY());
                    double x = (point.getX() - vertex.getX()) * t - vertex.getX();
                    double y = 0;
                    double z = (point.getZ() - vertex.getZ()) * t - vertex.getZ();
                    Point crossPoint = new Point(x, y, z);
                    result.add(crossPoint);
                }
            }
            case OXY -> {
                for (int i = 0; i < 3; i++) {
                    Point point = pyramidPoints.get(i);
                    double t = -vertex.getZ() / (point.getZ() - vertex.getZ());
                    double x = (point.getX() - vertex.getX()) * t - vertex.getX();
                    double y = (point.getY() - vertex.getY()) * t - vertex.getY();
                    double z = 0;
                    Point crossPoint = new Point(x, y, z);
                    result.add(crossPoint);
                }
            }
            default ->
                    throw new ServiceException("Incorrect defineBasePlane() return value: " + basePlane.toString());
        }
        LOGGER.log(Level.DEBUG, "Cross points have been found");
        return result;
    }
}
