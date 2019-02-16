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
    Robot.m_gyro.reset();
    Robot.m_drivetrain.reset();
    Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
  }

  @Override
  protected void execute() {
    
    double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
    
    /*
    double rotation = Robot.m_oi.stick.getRawAxis(2);
		double strafe = Robot.m_oi.stick.getRawAxis(1);
    double forward = Robot.m_oi.stick.getRawAxis(0);
    */
    
    Robot.m_drivetrain.setTarget(gyro, rotation, strafe, forward);
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
    Robot.m_drivetrain.stop();
  }
}
