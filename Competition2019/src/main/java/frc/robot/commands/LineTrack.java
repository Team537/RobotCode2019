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

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
