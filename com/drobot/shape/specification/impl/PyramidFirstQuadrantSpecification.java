package com.drobot.shape.specification.impl;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.specification.Specification;

import java.util.List;
import java.util.function.Predicate;

public class PyramidFirstQuadrantSpecification<T extends Pyramid> implements Specification<T> {

    @Override
    public boolean specify(T pyramid) {
        List<Point> points = pyramid.getPoints();
        Predicate<Point> predicate = x -> x.getCoordinates().stream().allMatch(y -> y > 0);
        return points.stream().allMatch(predicate);
    }
}
