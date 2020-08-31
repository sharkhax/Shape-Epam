package com.drobot.shape.creator.impl;

import com.drobot.shape.creator.PyramidCreator;
import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.PyramidRecorder;
import com.drobot.shape.entity.PyramidWarehouse;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.entity.pyramid.TrianglePyramid;
import com.drobot.shape.exception.ObserverException;
import com.drobot.shape.observer.impl.TrianglePyramidObserver;
import com.drobot.shape.repository.impl.PyramidRepository;
import com.drobot.shape.specification.impl.PyramidSamePointsSpecification;
import com.drobot.shape.service.IdService;
import com.drobot.shape.validator.PyramidValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TrianglePyramidCreator implements PyramidCreator {

    private static final Logger LOGGER = LogManager.getLogger(TrianglePyramidCreator.class);

    @Override
    public Optional<Pyramid> createPyramid(List<Point> points) throws ObserverException {
        Optional<Pyramid> result = Optional.empty();
        PyramidValidator validator = new PyramidValidator();
        if (validator.arePointsValid(points)) {
            PyramidRepository repository = PyramidRepository.getInstance();
            PyramidSamePointsSpecification samePointsSpecification = new PyramidSamePointsSpecification(points);
            if (repository.query(samePointsSpecification).isEmpty()) {
                UUID pyramidId = IdService.generateId();
                TrianglePyramid pyramid = new TrianglePyramid(pyramidId, points);
                PyramidWarehouse warehouse = PyramidWarehouse.getInstance();
                PyramidRecorder recorder = new PyramidRecorder();
                warehouse.put(pyramidId, recorder);
                repository.add(pyramid);
                new TrianglePyramidObserver(pyramid);
                pyramid.notifyObservers();
                result = Optional.of(pyramid);
                LOGGER.log(Level.INFO, "Creator successfully created a pyramid");
            } else {
                LOGGER.log(Level.INFO, "Pyramid with such points already exists");
            }
        }
        return result;
    }
}
