package frc.robot;

import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;


public class OI {
  public IJoystick m_main;
  public IJoystick m_main2;
  public IJoystick m_secondary;

  public OI(){
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);
    this.m_main2 = new JoystickF310(RobotMap.INTERFACE.JOYSTICK_MAIN);    
  } 
}
