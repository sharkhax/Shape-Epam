package com.drobot.shape.type;

public enum BasePlaneType {
    INVALID_POINTS(-1),
    NO_BASE(0),
    OYZ(1),
    OXZ(2),
    OXY(3);

    private final int value;

    BasePlaneType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
