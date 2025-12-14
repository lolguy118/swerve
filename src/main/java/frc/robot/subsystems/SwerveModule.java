package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

public class SwerveModule {
    
    private final TalonFX driveMotor;
    private final TalonFX swerveMotor;

    public enum SwerveModuleLocation {
        FRONT_DRIVER,
        FRONT_PASSENGER,
        BACK_DRIVER,
        BACK_PASSENGER
    }

    public SwerveModule(SwerveModuleLocation locationOfSwerveModule) {
        switch (locationOfSwerveModule) {
            case FRONT_DRIVER:
                driveMotor = new TalonFX(Constants.kfrontDriverDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kfrontDriverSwerveID, Constants.kCANBusName);
                break;
            case FRONT_PASSENGER:
                driveMotor = new TalonFX(Constants.kfrontPassengerDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kfrontPassengerSwerveID, Constants.kCANBusName);
                break;
            case BACK_DRIVER:
                driveMotor = new TalonFX(Constants.kbackDriverDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kbackDriverSwerveID, Constants.kCANBusName);
                break;
            case BACK_PASSENGER:
                driveMotor = new TalonFX(Constants.kbackPassengerDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kbackPassengerSwerveID, Constants.kCANBusName);
                break;
            default:
                throw new IllegalArgumentException("Unknown SwerveModuleLocation: " + locationOfSwerveModule);
        }
    }

    public double convertAngle(double angle, double encoderPosition, double gearRatio) {
        double convertedEncoderPosition = encoderPosition / gearRatio;
        double desiredPosition = (int)convertedEncoderPosition + angle;
        double rotationNeeded = desiredPosition - convertedEncoderPosition;
        if (rotationNeeded < -0.5) rotationNeeded += 1;
        else if (rotationNeeded > 0.5) rotationNeeded -= 1;
        return rotationNeeded;
    }
}
