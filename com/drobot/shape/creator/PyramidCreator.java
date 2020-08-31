package com.drobot.shape.creator;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.exception.ObserverException;
import com.drobot.shape.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface PyramidCreator {
    Optional<Pyramid> createPyramid(List<Point> points) throws ObserverException, ServiceException;
}
