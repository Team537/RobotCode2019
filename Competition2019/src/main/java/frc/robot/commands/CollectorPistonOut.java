package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorPistonOut extends Command {
  public CollectorPistonOut() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_pneumatics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_pneumatics.pistonOut();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_pneumatics.pistonOut();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_pneumatics.pistonIn();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
