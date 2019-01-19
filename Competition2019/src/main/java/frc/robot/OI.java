package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;


public class OI {
  public IJoystick m_main;
  public IJoystick m_secondary;

  public OI(){
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);  

    
  } 
}
