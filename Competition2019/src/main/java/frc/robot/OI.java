package frc.robot;

import edu.wpi.first.wpilibj.Joystick;


public class OI {
  public Joystick JOYSTICK_MAIN = new Joystick(RobotMap.INTERFACE.MAIN_CONTROLLER_PORT);
  public Joystick JOYSTICK_SECONDARY = new Joystick(RobotMap.INTERFACE.SECONDARY_CONTROLLER_PORT);
  
  
  public OI(){
  } 
}
