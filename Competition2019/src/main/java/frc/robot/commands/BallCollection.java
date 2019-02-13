package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class BallCollection extends Command {
    double inTakeSpeed;

    public BallCollection(double speed){
     requires(Robot.m_collector);
     this.inTakeSpeed = speed;
    }

@Override
protected void initialize() {
    Robot.m_collector.reset();
    }

@Override
protected void execute() {
    Robot.m_collector.setSpeed(inTakeSpeed);
    }

@Override
  protected boolean isFinished() {
    return false;}

    
  @Override
  protected void end() {
      Robot.m_collector.disable();
  }

  @Override
  protected void interrupted() {
  }
}