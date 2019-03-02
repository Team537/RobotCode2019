package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Maths;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.SwerveMode;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.m_drivetrain);
  }

  @Override
  protected void initialize() {
    Robot.m_drivetrain.stop();
    //Robot.m_gyro.reset();
    //Robot.m_drivetrain.recalibrate();
    //Robot.m_drivetrain.reset();
    //double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    //Robot.m_drivetrain.setTarget(gyro, 0.00, 0.00);
    Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
  }

  @Override
  protected void execute() {
    /*
    double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
    
    
    Robot.m_drivetrain.setTarget(gyro, rotation, strafe, forward);
    */

    double gyro = Math.toRadians(Robot.m_gyro.getAngle());
		double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		rotation = sensitivity(deadband(0.2, rotation), 1.0);
		double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
		strafe = sensitivity(deadband(0.01, strafe), 1.0);
		double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
		forward = sensitivity(deadband(0.01, forward), 1.0);
		Robot.m_drivetrain.setTarget(gyro, rotation, strafe, forward);
	}
	
	private static double sensitivity(double value, double factor) {
		return ((1.0 - factor) * value) + (factor * Math.pow(value, 3.0));
  }

	public static double deadband(double min, double value) {
		double result = Maths.deadband(min, value);
		
		if (result < 0.0) {
			result += min;
		} else if (result > 0.0) {
			result -= min;
		}
		
  return Maths.clamp(result, -1.0, 1.0);
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
    Robot.m_drivetrain.stop();
  }
}
