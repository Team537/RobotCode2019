/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.joysticks.JoystickExtreme;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick JoystickMain = new Joystick(0);
  public Joystick JoystickSecondary = new Joystick(1);

  public String Main = "EXTREME";
  public String Secondary = "BOX";

  
  
  public OI(){
    if(Main == "EXTREME") {
      //new JoystickButton(JoystickMain, JoystickExtreme.Interface.button1).whenPressed(new ExampleCommand());
      //new JoystickButton(JoystickMain, JoystickExtreme.Interface.button2).whenPressed(new ExampleCommand());   
    }
    if (Secondary == "BOX") {
      
    }
    
  }
}