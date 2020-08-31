package com.drobot.shape.validator;

import com.drobot.shape.entity.Point;
import com.drobot.shape.service.PyramidBaseDefiner;
import com.drobot.shape.type.BasePlaneType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class PyramidValidator {

    private static final Logger LOGGER = LogManager.getLogger(PyramidValidator.class);
    private static final double MAX_ABSOLUTE_POINT_VALUE = 100.0;
    private static final int[] SUPPORTED_POINTS_NUMBER = {4};

    public boolean arePointsValid(List<Point> points) {
        boolean result = false;
        boolean supported = false;
        for (int value : SUPPORTED_POINTS_NUMBER) {
            if (points.size() == value) {
                supported = true;
                result = areInRange(points)
                        && isBaseOnPlane(points)
                        && hasVertex(points)
                        && notSame(points);
                if (result) {
                    LOGGER.log(Level.DEBUG, "Points are valid");
                } else {
                    LOGGER.log(Level.DEBUG, "Points are not valid");
                }
                break;
            }
        }
        if (!supported) {
            LOGGER.log(Level.WARN, "Unsupported points number");
        }
        return result;
    }

    private boolean areInRange(List<Point> points) {
        Predicate<Point> predicate = point -> point.getCoordinates()
                .parallelStream()
                .allMatch(x -> Math.abs(x) <= MAX_ABSOLUTE_POINT_VALUE);
        boolean result = points.stream().allMatch(predicate);
        if (result) {
            LOGGER.log(Level.DEBUG, "Points are in range");
        } else {
            LOGGER.log(Level.DEBUG, "Points are not in range");
        }
        return result;
    }

    private boolean isBaseOnPlane(List<Point> points) {
        PyramidBaseDefiner definer = new PyramidBaseDefiner();
        BasePlaneType basePlane = definer.defineBasePlane(points);
        return basePlane.getValue() > 0;
    }

    private boolean hasVertex(List<Point> points) {
        boolean result = false;
        int possibleVertexPosition = points.size() - 1;
        Point possibleVertex = points.get(possibleVertexPosition);
        Point firstPoint = points.get(0);
        Predicate<Point> predicateX = x -> x.getX() == firstPoint.getX();
        Predicate<Point> predicateY = y -> y.getY() == firstPoint.getY();
        Predicate<Point> predicateZ = z -> z.getZ() == firstPoint.getZ();
        if (points.stream().skip(1).limit(points.size() - 2).allMatch(predicateX)) {
            result = possibleVertex.getX() != firstPoint.getX();
        } else if (points.stream().skip(1).limit(points.size() - 2).allMatch(predicateY)) {
            result = possibleVertex.getY() != firstPoint.getY();
        } else if (points.stream().skip(1).limit(points.size() - 2).allMatch(predicateZ)) {
            result = possibleVertex.getZ() != firstPoint.getZ();
        }
        if (result) {
            LOGGER.log(Level.DEBUG, "Vertex point is valid");
        } else {
            LOGGER.log(Level.DEBUG, "Vertex point is not valid");
        }
        return result;
    }

    private boolean notSame(List<Point> points) {
        boolean result = true;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i; j < points.size() - 1; j++) {
                if (points.get(i).equals(points.get(i + 1))) {
                    result = false;
                    LOGGER.log(Level.DEBUG, "There are some equal points");
                    break;
                }
            }
        }
        if (result) {
            LOGGER.log(Level.DEBUG, "There are no equal points");
        }
        return result;
    }
}
