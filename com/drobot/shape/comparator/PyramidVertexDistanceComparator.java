package com.drobot.shape.comparator;

import com.drobot.shape.entity.Point;
import com.drobot.shape.entity.pyramid.Pyramid;

import java.util.Comparator;
import java.util.List;

public class PyramidVertexDistanceComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        List<Point> points = o1.getPoints();
        Point vertex1 = points.get(points.size() - 1);
        points = o2.getPoints();
        Point vertex2 = points.get(points.size() - 1);
        double temp = Math.hypot(vertex1.getX(), vertex1.getY());
        double vector1 = Math.hypot(temp, vertex1.getZ());
        temp = Math.hypot(vertex2.getX(), vertex2.getY());
        double vector2 = Math.hypot(temp, vertex2.getZ());
        return Double.compare(vector1, vector2);
    }
}
