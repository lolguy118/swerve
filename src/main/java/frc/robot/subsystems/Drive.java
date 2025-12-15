package frc.robot.subsystems;
import frc.robot.subsystems.SwerveModule.SwerveModuleLocation;

public class Drive {
    private final SwerveModule frontDriver = new SwerveModule(SwerveModuleLocation.FRONT_DRIVER);
    private final SwerveModule frontPassenger = new SwerveModule(SwerveModuleLocation.FRONT_PASSENGER);
    private final SwerveModule backDriver = new SwerveModule(SwerveModuleLocation.BACK_DRIVER);
    private final SwerveModule backPassenger = new SwerveModule(SwerveModuleLocation.BACK_PASSENGER);
}
