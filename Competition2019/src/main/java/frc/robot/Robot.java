package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.ManipulatorArm;
import frc.robot.subsystems.Photosensor;
import frc.robot.subsystems.ManipulatorArm2;


public class Robot extends TimedRobot {
  public static Drivetrain m_drivetrain;
  public static Gyro m_gyro;
  public static Photosensor m_photosensor;
  public static OI m_oi;
  public static Collector m_collector;
  public static ManipulatorArm m_arm;
  public static ManipulatorArm2 m_arm2;
  public static Camera m_camera;

  
  
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
  m_oi = new OI();
    
    
    if(RobotMap.SUBSYSTEMS.DRIVE) {
      m_drivetrain = new Drivetrain();
    }
    
    if(RobotMap.SUBSYSTEMS.GYRO){
      m_gyro = new Gyro();
    }

    if(RobotMap.SUBSYSTEMS.PHOTOSENSOR){
      m_photosensor = new Photosensor();
    }

    
    if(RobotMap.SUBSYSTEMS.COLLECTOR) {
      m_collector = new Collector();
    }

    if(RobotMap.SUBSYSTEMS.ARM) {
      m_arm = new ManipulatorArm();
    }

    if(RobotMap.SUBSYSTEMS.CAMERA) {
      m_camera = new Camera();
    }
    
    if(RobotMap.SUBSYSTEMS.ARM2) {
      m_arm2 = new ManipulatorArm2();
    }

    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
