package frc.robot.subsystems;

import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;

public class SwerveModule {
    
    private final TalonFX driveMotor;
    private final TalonFX swerveMotor;
    private final Translation2d location;

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
                this.location = new Translation2d(Constants.kwheelBase / 2, Constants.ktrackWidth / 2);
                break;
            case FRONT_PASSENGER:
                driveMotor = new TalonFX(Constants.kfrontPassengerDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kfrontPassengerSwerveID, Constants.kCANBusName);
                this.location = new Translation2d(Constants.kwheelBase / 2, -Constants.ktrackWidth / 2);
                break;
            case BACK_DRIVER:
                driveMotor = new TalonFX(Constants.kbackDriverDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kbackDriverSwerveID, Constants.kCANBusName);
                this.location = new Translation2d(-Constants.kwheelBase / 2, Constants.ktrackWidth / 2);
                break;
            case BACK_PASSENGER:
                driveMotor = new TalonFX(Constants.kbackPassengerDriveID, Constants.kCANBusName);
                swerveMotor = new TalonFX(Constants.kbackPassengerSwerveID, Constants.kCANBusName);
                this.location = new Translation2d(-Constants.kwheelBase / 2, -Constants.ktrackWidth / 2);
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

    public boolean shouldReverse(double angle, double encoderPosition, double gearRatio) {
        double convertedEnconderPosition = (encoderPosition / gearRatio) % 1;
        if (angle < 0) angle += 1;
        double differenceBetweenCurrentAndDesiredPosition = Math.abs(angle - convertedEnconderPosition);
        if (Math.min(differenceBetweenCurrentAndDesiredPosition, 1 - differenceBetweenCurrentAndDesiredPosition) > 0.25) return true;
        return false;
    }

    public double[] computeSetPoints(double nomrmalizedSpeed, double angle, double encoderPosition, double gearRatio) {
        double newAngle = this.convertAngle(angle, encoderPosition, gearRatio);
        double speed = nomrmalizedSpeed;

        if (this.shouldReverse(newAngle, encoderPosition, gearRatio)) {
            if (newAngle > 0) newAngle -= 0.5;
            if (newAngle < 0) newAngle += 0.5;
            speed *= -1;
        }

        return new double[] {speed, newAngle};
    }

    public void move(double nomrmalizedSpeed, double angle) {
        double[] setPoint = this.computeSetPoints(nomrmalizedSpeed, angle, swerveMotor.getPosition().getValueAsDouble(), Constants.kgearRatio);

        driveMotor.set(setPoint[0]);
        if (setPoint[0] != 0.0) swerveMotor.setControl(new PositionDutyCycle(angle * Constants.ksteeringGearRatio));
    }

    public Translation2d getLocation() {
        return this.location;
    }
}
