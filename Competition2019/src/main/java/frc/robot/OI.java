package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CollectorTilt;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;


public class OI {
  public IJoystick m_main;
  public IJoystick m_secondary;
  public IJoystick m_test;

  public OI(){
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);  
    this.m_test = new JoystickF310(1);

    this.m_test.getJoystickButton("TiltUp").whileHeld(new CollectorTilt());
  } 
}
