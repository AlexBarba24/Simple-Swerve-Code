package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveSubsystem;


public class RobotContainer {

  private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();

  private final XboxController driveController = new XboxController(OIConstants.kDriverControllerPort);

  public RobotContainer() {
    swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(swerveSubsystem, () -> -driveController.getLeftY(), () -> driveController.getLeftX(), () -> driveController.getRightX()));
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    new Button(() -> driveController.getXButton()).whenPressed(()-> swerveSubsystem.zeroHeading());
  }


  public Command getAutonomousCommand() {
    return null;
  }
}
