package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorDefault extends Command {
  public CollectorDefault() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_collector);
  }

  @Override
  protected void initialize() {
    Robot.m_collector.reset();
  }

  @Override
  protected void execute() {

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
    end();
  }
}
