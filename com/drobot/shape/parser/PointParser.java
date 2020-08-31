package com.drobot.shape.parser;

import com.drobot.shape.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointParser {

    private static final Logger LOGGER = LogManager.getLogger(PointParser.class);
    private static final String SPLIT_POINTS_REGEX = ", ";
    private static final String SPLIT_COORDINATES_REGEX = " ";

    public List<Point> parsePoints(String stringPoints) {
        String[] splitPoints = stringPoints.split(SPLIT_POINTS_REGEX);
        LOGGER.log(Level.DEBUG, "Points have been split");
        List<Point> result = new ArrayList<>();
        for (String string : splitPoints) {
            String[] coordinates = string.split(SPLIT_COORDINATES_REGEX);
            LOGGER.log(Level.DEBUG, "Coordinates have been split");
            if (coordinates.length == 3) {
                try {
                    double x = Double.parseDouble(coordinates[0]);
                    double y = Double.parseDouble(coordinates[1]);
                    double z = Double.parseDouble(coordinates[2]);
                    Point point = new Point(x, y, z);
                    result.add(point);
                    LOGGER.log(Level.DEBUG, "Point has been parsed");
                } catch (NumberFormatException e) {
                    LOGGER.log(Level.INFO, "Invalid line in file", e);
                    return Collections.emptyList();
                }
            } else {
                LOGGER.log(Level.INFO, "Invalid line in file, should be 3 coordinates");
                result = Collections.emptyList();
                break;
            }
        }
        LOGGER.log(Level.INFO, "Parsing complete");
        return result;
    }
}
