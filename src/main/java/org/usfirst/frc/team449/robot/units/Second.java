package org.usfirst.frc.team449.robot.units;

public class Second extends TimeUnit<Second> {
    public Second(final double value) {
        super(value);
    }

    public Second(final int value) {
        this((double) value);
    }

    @Override
    public Second withValue(final double value) {
        return new Second(value);
    }

    private static final Second UNIT = new Second(1);

    @Override
    public Second getUnit() {
        return UNIT;
    }

    @Override
    public String getShortUnitName() {
        return "s";
    }
}