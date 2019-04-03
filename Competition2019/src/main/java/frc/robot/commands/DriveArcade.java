package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.SwerveMode;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.m_drivetrain);
  }

  @Override
  protected void initialize() {
    Robot.m_drivetrain.stop();
    Robot.m_gyro.reset();
    //Robot.m_drivetrain.recalibrate();
    Robot.m_drivetrain.reset();
    //double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    //Robot.m_drivetrain.setTarget(gyro, 0.00, 0.00);
    Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
  }

  @Override
  protected void execute() {
    
    double gyro = Math.toRadians(Robot.m_gyro.getAngle());
    //double rotation = Robot.m_oi.m_main.getRawAxis("DriveRotation");
		//double strafe = Robot.m_oi.m_main.getRawAxis("DriveStrafe");
    //double forward = Robot.m_oi.m_main.getRawAxis("DriveForward");
  
    double rotation;
    double strafe;
    double forward;
    
    if(Robot.m_oi.m_main.getMagnitude() < 0.15) {
      strafe = 0.00;
      forward = 0.00;
    }
    else {
      strafe = Math.pow((Robot.m_oi.m_main.getRawAxis("DriveStrafe")), 3);
      forward = Math.pow((Robot.m_oi.m_main.getRawAxis("DriveForward")), 3);
    }
    rotation = deadband(0.20, Robot.m_oi.m_main.getRawAxis("DriveRotation"));
    //rotation = Math.pow(Robot.m_oi.m_main.getRawAxis("DriveRotation"), 5);

    /*
    double rotation = deadband(0.15, Math.pow((Robot.m_oi.m_main.getRawAxis("DriveRotation")), 3));
		double strafe = deadband(0.10, Math.pow((Robot.m_oi.m_main.getRawAxis("DriveStrafe")), 3));
    double forward = deadband(0.10, Math.pow((Robot.m_oi.m_main.getRawAxis("DriveForward")), 3));
    */

    Robot.m_drivetrain.setTarget(gyro, rotation, strafe, forward);
  }

  /*
  private double deadband(double deadband, double input) {
    double value;
    if(input > deadband || input < -deadband) {
      value = (input > deadband) ? (input - deadband) : (input + deadband);
    } else {
      value = 0.00;
    }
    return value;
  }*/

  private double deadband(double deadband, double input) {
    double value;

    if(input > deadband || input < -deadband) {
      value = Math.pow(input, 5.0) * 0.50;
        //(((1.0 - deadband) * input) - (deadband * Math.pow(input, 3.0)));
    } else {
      value = 0.00;
    }
 
    return value;
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
