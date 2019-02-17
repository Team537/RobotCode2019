package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmManual extends Command {
  double armSpeed;
  public ArmManual(double speed) {
    requires(Robot.m_arm);
    this.armSpeed = speed;
  }

  @Override
  protected void initialize() {
    Robot.m_arm.disable();
  }

  @Override
  protected void execute() {
    Robot.m_arm.armManual(armSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_arm.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
