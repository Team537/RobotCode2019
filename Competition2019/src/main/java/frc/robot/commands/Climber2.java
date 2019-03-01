package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Climber2 extends Command {
  public Climber2() {
    
    requires(Robot.m_climber);
  }

  @Override
  protected void initialize() {
    Robot.m_climber.disable();
  }

  @Override
  protected void execute() {
    Robot.m_climber.climb2Deploy();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_climber.disable();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
