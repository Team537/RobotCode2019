package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveReset extends Command {
  public DriveReset() {
    //requires(Robot.m_drivetrain);
  }

  @Override
  protected void initialize() {
    Robot.m_drivetrain.stop();
  }

  @Override
  protected void execute() {
    Robot.m_drivetrain.findZero();
    
    if(Robot.m_drivetrain.findZero()){
      Robot.m_drivetrain.reset();
      end();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_drivetrain.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
