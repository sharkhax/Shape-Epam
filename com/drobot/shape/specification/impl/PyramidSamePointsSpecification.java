package com.drobot.shape.specification.impl;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.specification.Specification;

import java.util.List;

public class PyramidSamePointsSpecification implements Specification<Pyramid> {
    private final List<Point> points;

    public PyramidSamePointsSpecification(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        return pyramid.getPoints().equals(points);
    }
}
