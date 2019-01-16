package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.SwerveMode;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_gyro.reset();
    Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
		double gyro = Math.toRadians(Robot.m_gyro.getAngle());
		double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
    
    Robot.m_drivetrain.setTarget(gyro, rotation, strafe, forward);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
