package com.drobot.shape.observer.impl;

import com.drobot.shape.entity.PyramidRecorder;
import com.drobot.shape.entity.PyramidWarehouse;
import com.drobot.shape.entity.pyramid.TrianglePyramid;
import com.drobot.shape.exception.ObserverException;
import com.drobot.shape.exception.ServiceException;
import com.drobot.shape.observer.Observer;
import com.drobot.shape.service.impl.TrianglePyramidService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class TrianglePyramidObserver implements Observer {

    private static final Logger LOGGER = LogManager.getLogger(TrianglePyramidObserver.class);
    private final TrianglePyramid pyramid;

    public TrianglePyramidObserver(TrianglePyramid pyramid) {
        this.pyramid = pyramid;
        LOGGER.log(Level.DEBUG, "TrianglePyramidObserver has been created");
        pyramid.attach(this);
    }

    @Override
    public void handleEvent() throws ObserverException {
        TrianglePyramidService service = new TrianglePyramidService();
        PyramidWarehouse warehouse = PyramidWarehouse.getInstance();
        UUID pyramidId = pyramid.getPyramidId();
        PyramidRecorder recorder = warehouse.get(pyramidId);
        try {
            double newVolume = service.calculateVolume(pyramid);
            double newSurfaceArea = service.calculateSurfaceArea(pyramid);
            double newVolumeRatio = service.calculateVolumeRatio(pyramid);
            boolean onCoordinatePlane = service.isBaseOnCoordinatePlane(pyramid);
            recorder.setVolume(newVolume);
            recorder.setSurfaceArea(newSurfaceArea);
            recorder.setVolumeRatio(newVolumeRatio);
            recorder.setOnCoordinatePlane(onCoordinatePlane);
        } catch (ServiceException e) {
            throw new ObserverException(e);
        }
        LOGGER.log(Level.DEBUG, "TrianglePyramidObserver has handled an event");
    }
}
