package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.ModuleConstants;

public class SwerveModule{

  private final TalonFX driveMotor;
  private final TalonSRX turningMotor;

  private final double id;

  private final Encoder turningEncoder;

  private final PIDController turningPidController;



  public SwerveModule(int driveMotorID, int turningMotorId, boolean driveMotorReversed, boolean turningMotorReversed, int turningEncoderIdA, int turningEncoderIdB){

    id = driveMotorID;

    turningEncoder = new Encoder(turningEncoderIdA, turningEncoderIdB);
      
    driveMotor = new TalonFX(driveMotorID);
    turningMotor = new TalonSRX(turningMotorId);

    // driveMotor.getSelectedSensorVelocity(); units (2048) per 100ms
    //driveMotor.getSelectedSensorPosition(); in units (2048)

    turningPidController = new PIDController(ModuleConstants.kPTurning, 0, 0);
    turningPidController.enableContinuousInput(-Math.PI, Math.PI);
  }

  public double getDrivePosition(){
    return driveMotor.getSelectedSensorPosition()/2048 * ModuleConstants.kDriveEncoderRot2Meter;
  }

  public double getTurningPosition(){
    return turningEncoder.get() * ModuleConstants.kTurningEncoderRot2Rad;
  }

  public double getDriveVelocity(){
    return driveMotor.getSelectedSensorVelocity()/2048 * 10 * ModuleConstants.kDriveEncoderRot2Meter;
  }

  public double getTurningVelocity(){
    return turningEncoder.getRate() * ModuleConstants.kTurningEncoderRot2Rad;
  }

  public void resetEncoders(){
    
  }

  public SwerveModuleState getState(){
    return new SwerveModuleState(getDriveVelocity(), new Rotation2d(getTurningPosition()));
  }

  public void setDesiredState(SwerveModuleState state) {
    if(Math.abs(state.speedMetersPerSecond) < 0.001){
      stop();
      return;
    }
    state = SwerveModuleState.optimize(state, getState().angle);
    driveMotor.set(ControlMode.PercentOutput, state.speedMetersPerSecond / DriveConstants.kPhysicalMaxSpeedMetersPerSecond);
    turningMotor.set(ControlMode.PercentOutput,turningPidController.calculate(getTurningPosition(), state.angle.getRadians()));
    SmartDashboard.putString("Swerve["+ id + "]", state.toString());
  }

  public void stop(){
    driveMotor.set(ControlMode.PercentOutput, 0);
    turningMotor.set(ControlMode.PercentOutput, 0);
  }

}
