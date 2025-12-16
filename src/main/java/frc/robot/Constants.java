package frc.robot;

public class Constants {
    // CAN IDs for the drive motors
    public static final int kfrontDriverDriveID = 2;
    public static final int kfrontPassengerDriveID = 4;
    public static final int kbackDriverDriveID = 6;
    public static final int kbackPassengerDriveID = 8;

    // CAN IDs for the swerve motors
    public static final int kfrontDriverSwerveID = 1;
    public static final int kfrontPassengerSwerveID = 3;
    public static final int kbackDriverSwerveID = 5;
    public static final int kbackPassengerSwerveID = 7;
    
    // TODO: Add Gear Ratio
    // TODO: Add Stearing Gear Ratio
    public static final double kgearRatio = 2048;
    public static final double ksteeringGearRatio = 12.8;

    // TODO: Add wheel base
    // TODO: Add track width
    public static final double wheelBase = 5.0;
    public static final double trackWidth = 2.0;

    // CAN Bus
    public static final String kCANBusName = "271";

    // Joystick Information
    // TODO: Add the Axis numbers
    public static final int kjoystickPortNumber = 0;
    public static final int kspeedAxisNumber = 1;
    public static final int kswerveAxisNumber = 4;
    public static final int krotationAxisNumber = 4;
}
