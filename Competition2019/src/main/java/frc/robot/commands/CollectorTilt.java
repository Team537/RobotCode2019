package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectorTilt extends Command {
  public double speed;
  public CollectorTilt(double tiltSpeed) {
    requires(Robot.m_collector);
    this.speed = tiltSpeed;
  }

  @Override
  protected void initialize() {
    Robot.m_collector.disable();
  }

  @Override
  protected void execute() {
      Robot.m_collector.tilt(speed);
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