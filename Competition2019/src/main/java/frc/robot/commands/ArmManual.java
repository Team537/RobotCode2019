package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmManual extends Command {
  double armIncrement;
  public ArmManual(double increment) {
    requires(Robot.m_arm);
    this.armIncrement = increment;
  }

  @Override
  protected void initialize() {
    Robot.m_arm.armManual(0.00);
  }

  @Override
  protected void execute() {
    if(Robot.m_arm.m_armLimit.get() && armIncrement > 0){
      end();
    } 
    else if(Robot.m_arm.m_armBottomLimit.get() && armIncrement < 0){
      end();
    }
    else {
      Robot.m_arm.armManual(armIncrement);
    }
    
    //Robot.m_arm.setTarget(Robot.m_arm.getTarget() + armIncrement);
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
