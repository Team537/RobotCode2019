package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmDefault extends Command {
  public ArmDefault() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_arm);
  }

  @Override
  protected void initialize() {
    Robot.m_arm.disable();
  }

  @Override
  protected void execute() {
    Robot.m_arm.disable();
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
