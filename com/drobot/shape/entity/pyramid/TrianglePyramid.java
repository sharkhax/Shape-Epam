package com.drobot.shape.entity.pyramid;

import com.drobot.shape.entity.Point;

import java.util.List;
import java.util.UUID;

public class TrianglePyramid extends Pyramid {

    public TrianglePyramid(UUID pyramidId, List<Point> points) {
        super(pyramidId, points, PyramidType.TRIANGLE_PYRAMID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrianglePyramid{");
        sb.append("pyramidId=").append(pyramidId);
        sb.append(", points=").append(points);
        sb.append(", observers=").append(observers);
        sb.append('}');
        return sb.toString();
    }
}
