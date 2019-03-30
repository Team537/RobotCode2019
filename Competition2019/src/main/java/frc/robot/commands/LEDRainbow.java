package frc.robot.commands;

import java.awt.Color;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LEDRainbow extends Command {
  private double m_r, m_g, m_b;
  public LEDRainbow() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_led);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    float h = (1.0f + (float) Math.cos(0.6 * timeSinceInitialized())) / 2.0f;
    Color color = Color.getHSBColor(h, 1.0f, 1.0f);
    m_r = (double) color.getRed() / 255.0;
    m_g = (double) color.getGreen() / 255.0;
    m_b = (double) color.getBlue() / 255.0;

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
    Robot.m_led.setColor(1.00, 0.00, 0.00);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
