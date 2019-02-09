package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorTilt extends Command {
  public CollectorTilt() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_collector);
  }

  @Override
  protected void initialize() {
    Robot.m_collector.tilt();
  }

  @Override
  protected void execute() {
      Robot.m_collector.tilt();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
      Robot.m_collector.disable();
  }

  @Override
  protected void interrupted() {
      Robot.m_collector.disable();
  }
}
