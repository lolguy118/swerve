package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class Drive {
    // Instantiate Drive Motors
    private TalonFX frontDriverDrive = new TalonFX(Constants.kfrontDriverDriveID, Constants.kCANBusName);
    private TalonFX frontPassengerDrive = new TalonFX(Constants.kfrontPassengerDriveID, Constants.kCANBusName);
    private TalonFX backPassengerDrive = new TalonFX(Constants.kbackPassengerDriveID, Constants.kCANBusName);
    private TalonFX backDriverDrive = new TalonFX(Constants.kbackDriverDriveID, Constants.kCANBusName);

    // Instantiate Swerve Motors
    private TalonFX frontDriverSwerve = new TalonFX(Constants.kfrontDriverSwerveID, Constants.kCANBusName);
    private TalonFX frontPassengerSwerve = new TalonFX(Constants.kfrontPassengerSwerveID, Constants.kCANBusName);
    private TalonFX backPassengerSwerve = new TalonFX(Constants.kbackPassengerSwerveID, Constants.kCANBusName);
    private TalonFX backDriverSwerve = new TalonFX(Constants.kbackDriverSwerveID, Constants.kCANBusName);

    // Instantiate Joystick
    private XboxController logitech
}
