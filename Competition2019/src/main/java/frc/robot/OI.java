package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CollectorSpeed;
import frc.robot.commands.CollectorBalltoHatch;
import frc.robot.commands.CollectorHatchOut;
import frc.robot.commands.CollectorHatchToBall;
import frc.robot.commands.DriveReset;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickBox;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;


public class OI {
  public IJoystick m_main;
  public IJoystick m_secondary;
  

  public OI(){
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);  
    this.m_secondary = new JoystickBox(RobotMap.INTERFACE.JOYSTICK_SECONDARY);

    
    if(RobotMap.SUBSYSTEMS.DRIVE) {
      this.m_main.getJoystickButton("ResetDrive").whenPressed(new DriveReset());
    }

    if(RobotMap.SUBSYSTEMS.COLLECTOR) {
      this.m_secondary.getJoystickButton("CollectIn").whileHeld(new CollectorSpeed(0.50));
      this.m_secondary.getJoystickButton("CollectOut").whileHeld(new CollectorSpeed(-0.50));
      this.m_secondary.getJoystickButton("HatchOut").whenPressed(new CollectorHatchOut());
      this.m_secondary.getJoystickButton("Hatch Level 1").whenPressed(new CollectorBalltoHatch());
      this.m_secondary.getJoystickButton("Hatch Level 2").whenPressed(new CollectorBalltoHatch());
      this.m_secondary.getJoystickButton("Hatch Level 3").whenPressed(new CollectorBalltoHatch());
      this.m_secondary.getJoystickButton("Collector Level 1").whenPressed(new CollectorHatchToBall());
      this.m_secondary.getJoystickButton("Collector Level 2").whenPressed(new CollectorHatchToBall());
      this.m_secondary.getJoystickButton("Collector Level 3").whenPressed(new CollectorHatchToBall());

    }


    if(RobotMap.SUBSYSTEMS.ARM) {
    }

    if(RobotMap.SUBSYSTEMS.CAMERA) {
    }
    
  } 
}
