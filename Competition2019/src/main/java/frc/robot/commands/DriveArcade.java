package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.SwerveMode;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.m_drivetrain);
  }

  @Override
  protected void initialize() {
    Robot.m_drivetrain.stop();
    Robot.m_gyro.reset();
    //Robot.m_drivetrain.recalibrate();
    Robot.m_drivetrain.reset();
    //double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    //Robot.m_drivetrain.setTarget(gyro, 0.00, 0.00);
    Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
  }

  @Override
  protected void execute() {
    
    double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    //double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		//double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    //double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
  
    double rotation = deadband(0.15, Robot.m_oi.m_main.getRawAxis("DriveRotation"));
		double strafe = deadband(0.1, Robot.m_oi.m_main.getRawAxis("DriveStrafe"));
    double forward = deadband(0.1, Robot.m_oi.m_main.getRawAxis("DriveForward"));
    
    Robot.m_drivetrain.setTarget(0.00, rotation, strafe, forward);
  }

  private double deadband(double deadband, double input) {
    if(input < deadband || input > -deadband) {
      return 0.00;
    } else {
      double value = input - deadband;
      return value;
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_drivetrain.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
