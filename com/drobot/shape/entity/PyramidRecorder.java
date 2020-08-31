package com.drobot.shape.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidRecorder {

    private static final Logger LOGGER = LogManager.getLogger(PyramidRecorder.class);
    private double volume;
    private double surfaceArea;
    private double volumeRatio;
    private boolean onCoordinatePlane;

    public PyramidRecorder() {
        LOGGER.log(Level.DEBUG, "PyramidRecorder has been created");
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
        LOGGER.log(Level.DEBUG, "Volume has been set");
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
        LOGGER.log(Level.DEBUG, "Surface area has been set");
    }

    public double getVolumeRatio() {
        return volumeRatio;
    }

    public void setVolumeRatio(double volumeRatio) {
        this.volumeRatio = volumeRatio;
        LOGGER.log(Level.DEBUG, "Volume ratio has been set");
    }

    public boolean isOnCoordinatePlane() {
        return onCoordinatePlane;
    }

    public void setOnCoordinatePlane(boolean onCoordinatePlane) {
        this.onCoordinatePlane = onCoordinatePlane;
        LOGGER.log(Level.DEBUG, "Is on coordinate plane has been set");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PyramidRecorder recorder = (PyramidRecorder) o;
        if (Double.compare(recorder.volume, volume) != 0) {
            return false;
        }
        if (Double.compare(recorder.surfaceArea, surfaceArea) != 0) {
            return false;
        }
        if (Double.compare(recorder.volumeRatio, volumeRatio) != 0) {
            return false;
        }
        return onCoordinatePlane == recorder.onCoordinatePlane;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(surfaceArea);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volumeRatio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (onCoordinatePlane ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PyramidRecorder{");
        sb.append("volume=").append(volume);
        sb.append(", surfaceArea=").append(surfaceArea);
        sb.append(", volumeRatio=").append(volumeRatio);
        sb.append(", onCoordinatePlane=").append(onCoordinatePlane);
        sb.append('}');
        return sb.toString();
    }
}
