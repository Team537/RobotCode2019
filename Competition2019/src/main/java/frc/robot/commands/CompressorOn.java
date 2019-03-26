package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CompressorOn extends Command {
  public CompressorOn() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_pneumatics);
  }

  @Override
  protected void initialize() {
    //Robot.m_pneumatics.CompressorOn();
  }

  @Override
  protected void execute() {
    Robot.m_pneumatics.CompressorOn();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    //Robot.m_pneumatics.Stop();
    //Robot.m_pneumatics.CompressorOn();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
