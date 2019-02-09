package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CommandsBallCollection extends Command {
    public void BallCollection(){
     requires(Robot.ballCollector);
    }

@Override
protected void initialize() {
    Robot.ballCollector.reset();
    }

@Override
protected void execute() {

    }

@Override
  protected boolean isFinished() {
    return false;}

    
  @Override
  protected void end() {
      Robot.ballCollector.disable();
  }

  @Override
  protected void interrupted() {
  }
}