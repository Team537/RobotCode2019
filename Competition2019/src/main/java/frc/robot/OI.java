package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveReset;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickBox;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;


public class OI {
  public IJoystick m_main;
  public IJoystick m_main2;
  public IJoystick m_secondary;
  public IJoystick m_test;
  //public Joystick stick = new Joystick(1);

  public OI(){

  
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);  
    this.m_secondary = new JoystickBox(RobotMap.INTERFACE.JOYSTICK_SECONDARY);

    this.m_test = new JoystickF310(1);
    //this.m_test.getJoystickButton("TiltUp").whileHeld(new CollectorTilt());
    
    if(RobotMap.SUBSYSTEMS.DRIVE) {
      this.m_main.getJoystickButton("ResetDrive").whenPressed(new DriveReset());
    }

    if(RobotMap.SUBSYSTEMS.COLLECTOR) {
      this.m_secondary.getJoystickButton("CollectIn").whileHeld(new BallIn());
      this.m_secondary.getJoystickButton("CollectOut").whileHeld(new CollectorSpeed(0.50));

    }

    if(RobotMap.SUBSYSTEMS.ARM) {
    }

    if(RobotMap.SUBSYSTEMS.CAMERA) {
    }
    
    
  
  }
}