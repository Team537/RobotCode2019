package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VisionAlignTarget extends Command {
  public VisionAlignTarget() {
    requires(Robot.m_drivetrain);
  }


  @Override
  protected void initialize() {
    
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
  }

  @Override
  protected void interrupted() {
  }
}
