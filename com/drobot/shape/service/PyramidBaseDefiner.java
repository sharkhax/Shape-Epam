package com.drobot.shape.service;

import com.drobot.shape.entity.Point;
import com.drobot.shape.exception.ServiceException;
import com.drobot.shape.type.BasePlaneType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PyramidBaseDefiner {

    private static final Logger LOGGER = LogManager.getLogger(PyramidBaseDefiner.class);

    public BasePlaneType defineBasePlane(List<Point> pyramidPoints) {
        BasePlaneType result = BasePlaneType.NO_BASE;
        Point firstPoint = pyramidPoints.get(0);
        Predicate<Point> predicateX = x -> x.getX() == firstPoint.getX();
        Predicate<Point> predicateY = y -> y.getY() == firstPoint.getY();
        Predicate<Point> predicateZ = z -> z.getZ() == firstPoint.getZ();
        if (pyramidPoints.stream().skip(1).limit(pyramidPoints.size() - 2).allMatch(predicateX)) {
            result = BasePlaneType.OYZ;
        } else if (pyramidPoints.stream().skip(1).limit(pyramidPoints.size() - 2).allMatch(predicateY)) {
            result = BasePlaneType.OXZ;
        } else if (pyramidPoints.stream().skip(1).limit(pyramidPoints.size() - 2).allMatch(predicateZ)) {
            result = BasePlaneType.OXY;
        }
        if (result != BasePlaneType.NO_BASE && layOnStraight(pyramidPoints, result)) {
            result = BasePlaneType.INVALID_POINTS;
        }
        LOGGER.log(Level.DEBUG, "Base plane has been defined: " + result);
        return result;
    }

    private boolean layOnStraight(List<Point> pyramidPoints, BasePlaneType basePlane) {
        List<Point> temp = new ArrayList<>(List.copyOf(pyramidPoints));
        boolean result = false;
        while (temp.size() > 2) {
            int index = 0;
            Point point = temp.get(index);
            Predicate<Point> predicate1;
            Predicate<Point> predicate2;
            if (basePlane == BasePlaneType.OYZ) {
                predicate1 = y -> y.getY() == point.getY();
                predicate2 = z -> z.getZ() == point.getZ();
            } else if (basePlane == BasePlaneType.OXZ) {
                predicate1 = x -> x.getX() == point.getX();
                predicate2 = z -> z.getZ() == point.getZ();
            } else if (basePlane == BasePlaneType.OXY) {
                predicate1 = x -> x.getX() == point.getX();
                predicate2 = y -> y.getY() == point.getY();
            } else {
                LOGGER.log(Level.ERROR,
                        "Error at layOnStraight(): unexpected basePlane value " + basePlane);
                throw new EnumConstantNotPresentException(BasePlaneType.class, basePlane.toString());
            }
            List<Point> matchList1 = temp.stream().skip(1).limit(temp.size() - 2)
                    .filter(predicate1).collect(Collectors.toList());
            List<Point> matchList2 = temp.stream().skip(1).limit(temp.size() - 2)
                    .filter(predicate2).collect(Collectors.toList());
            if (matchList1.size() >= 2 || matchList2.size() >= 2) {
                result = true;
                break;
            } else {
                temp.removeAll(matchList1);
                temp.removeAll(matchList2);
                temp.remove(point);
            }
        }
        return result;
    }
}
