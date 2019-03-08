package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorHatchOut extends Command {
  public CollectorHatchOut() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_pneumatics);
  }

  @Override
  protected void initialize() {
    Robot.m_pneumatics.hatchOut();
  }

  @Override
  protected void execute() {
      Robot.m_pneumatics.hatchOut();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
      Robot.m_pneumatics.hatchIn();
  }

  @Override
  protected void interrupted() {
      end();
  }
}
