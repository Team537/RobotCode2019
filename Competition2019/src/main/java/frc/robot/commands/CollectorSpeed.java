package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorSpeed extends Command {

  double inSpeed;

  public CollectorSpeed(double collectSpeed) {
    requires(Robot.m_collector);
    this.inSpeed = collectSpeed;
  }

  @Override
  protected void initialize() {
    Robot.m_collector.reset();
  }

  @Override
  protected void execute() {
    Robot.m_collector.setSpeed(inSpeed);
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
