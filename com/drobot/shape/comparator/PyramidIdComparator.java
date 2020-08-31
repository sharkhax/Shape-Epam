package com.drobot.shape.comparator;

import com.drobot.shape.entity.pyramid.Pyramid;

import java.util.Comparator;

public class PyramidIdComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        return o1.getPyramidId().compareTo(o2.getPyramidId());
    }
}
