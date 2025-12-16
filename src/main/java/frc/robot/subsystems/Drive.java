package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveModule.SwerveModuleLocation;

public class Drive {
    private final SwerveModule frontDriver = new SwerveModule(SwerveModuleLocation.FRONT_DRIVER);
    private final SwerveModule frontPassenger = new SwerveModule(SwerveModuleLocation.FRONT_PASSENGER);
    private final SwerveModule backDriver = new SwerveModule(SwerveModuleLocation.BACK_DRIVER);
    private final SwerveModule backPassenger = new SwerveModule(SwerveModuleLocation.BACK_PASSENGER);

    private final Pigeon2 gyroscope = new Pigeon2(Constants.kgyroID, Constants.kCANBusName);

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(frontDriver.getLocation(), frontPassenger.getLocation(), backDriver.getLocation(), backPassenger.getLocation());
    private final SwerveDriveOdometry odometry;

    private final Joystick joystick = new Joystick(Constants.kjoystickPortNumber);

    public Drive() {
        gyroscope.setYaw(0);
        this.odometry = new SwerveDriveOdometry(this.kinematics, Rotation2d.fromDegrees(gyroscope.getYaw().getValueAsDouble()), null);
    }

    private double[] getJoystickValues() {
        return new double[] {
            joystick.getRawAxis(Constants.kspeedAxisNumber), 
            joystick.getRawAxis(Constants.kswerveAxisNumber), 
            joystick.getRawAxis(Constants.krotationAxisNumber)
        };
    }
}
