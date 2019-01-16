package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LineTrack extends Command {
  public LineTrack() {
    requires(Robot.m_photosensor); 
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.m_photosensor.onWhiteLine(Robot.m_photosensor.sensorRight.get(), Robot.m_photosensor.sensorLeft.get());
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
