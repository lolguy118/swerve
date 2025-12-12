package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

public class Drive {
    // instantiage all drive motors
    private final TalonFX kfrontDriverDrive = new TalonFX(Constants.kfrontDriverDriveID, Constants.kCANBusName);
    private final TalonFX kfrontPassengerDrive = new TalonFX(Constants.kfrontPassengerDriveID, Constants.kCANBusName);
    private final TalonFX kbackDriverDrive = new TalonFX(Constants.kbackDriverDriveID, Constants.kCANBusName);
    private final TalonFX kbackPassengerDrive = new TalonFX(Constants.kbackPassengerDriveID, Constants.kCANBusName);

    // instantiate all swerve motors
    private final TalonFX kfrontDriverSwerve = new TalonFX(Constants.kfrontDriverSwerveID, Constants.kCANBusName);
    private final TalonFX kfrontPassengerSwerve = new TalonFX(Constants.kfrontPassengerSwerveID, Constants.kCANBusName);
    private final TalonFX kbackDriverSwerve = new TalonFX(Constants.kbackDriverSwerveID, Constants.kCANBusName);
    private final TalonFX kbackPassengerSwerve = new TalonFX(Constants.kbackPassengerSwerveID, Constants.kCANBusName);
}
