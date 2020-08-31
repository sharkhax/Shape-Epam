package com.drobot.shape.factory;

import com.drobot.shape.creator.PyramidCreator;
import com.drobot.shape.creator.impl.TrianglePyramidCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PyramidCreatorFactory {

    private static final int TRIANGLE_PYRAMID_POINTS_NUMBER = 4;
    private static final Logger LOGGER = LogManager.getLogger(PyramidCreatorFactory.class);

    private PyramidCreatorFactory() {
    }

    public static Optional<PyramidCreator> defineCreator(int pyramidPointsNumber) {
        Optional<PyramidCreator> result = Optional.empty();
        if (pyramidPointsNumber == TRIANGLE_PYRAMID_POINTS_NUMBER) {
            result = Optional.of(new TrianglePyramidCreator());
            LOGGER.log(Level.DEBUG, "Creator has been defined");
        } else {
            LOGGER.log(Level.DEBUG, "There is no creator for such pyramid");
        }
        return result;
    }
}
