package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;


public class OI {
  public IJoystick JOYSTICK_MAIN  = new JoystickExtreme(RobotMap.INTERFACE.MAIN_CONTROLLER_PORT);
  //public IJoystick JOYSTICK_SECONDARY = new Joystick(1);
  
  public OI(){

    
  } 
}
