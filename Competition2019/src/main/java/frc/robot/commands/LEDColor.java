package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LEDColor extends Command {
  private double m_r, m_g, m_b;

  public LEDColor(double r, double g, double b) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_led);

    m_r = r;
    m_g = g;
    m_b = b;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_led.setColor(m_r, m_g, m_b);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_led.setColor(1.0, 0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
