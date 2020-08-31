package com.drobot.shape.service;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.exception.ServiceException;

public interface PyramidService<T extends Pyramid> {

    double calculateVolume(T pyramid) throws ServiceException;
    double calculateSurfaceArea(T pyramid);
    double calculateVolumeRatio(T pyramid) throws ServiceException;
    boolean isBaseOnCoordinatePlane(T pyramid) throws ServiceException;
}
