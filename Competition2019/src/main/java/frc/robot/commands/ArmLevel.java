package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmLevel extends Command {
  String level;
  public ArmLevel(String inputLevel) {
    requires(Robot.m_arm);
    this.level = inputLevel;
  }

  @Override
  protected void initialize() {
    Robot.m_arm.disable();
  }

  @Override
  protected void execute() {
    Robot.m_arm.setLevel(level);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_arm.disable();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
