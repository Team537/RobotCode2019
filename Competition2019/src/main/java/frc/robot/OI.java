package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.commands.ArmLevel;
import frc.robot.commands.ArmManual;
import frc.robot.commands.Climber1;
import frc.robot.commands.Climber2;
import frc.robot.commands.CollectorHookOut;
import frc.robot.commands.CollectorPistonOut;
import frc.robot.commands.CollectorSpeed;
import frc.robot.commands.CollectorTilt;
import frc.robot.commands.DriveLock;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickBox;
import frc.robot.joysticks.JoystickExtreme;


public class OI {
  public IJoystick m_main;
  public IJoystick m_main2;
  public IJoystick m_secondary;
  public IJoystick m_test;

  //public Joystick stick = new Joystick(1);

  public OI(){
try {
    this.m_main = new JoystickExtreme(RobotMap.INTERFACE.JOYSTICK_MAIN);  
    this.m_secondary = new JoystickBox(RobotMap.INTERFACE.JOYSTICK_SECONDARY);


    if(RobotMap.SUBSYSTEMS.COLLECTOR) {
      this.m_secondary.getJoystickButton("WristUp").whileHeld(new CollectorTilt(10));
      this.m_secondary.getJoystickButton("WristDown").whileHeld(new CollectorTilt(-10));

      this.m_secondary.getJoystickButton("CollectIn").whileHeld(new CollectorSpeed(0.50));
      this.m_secondary.getJoystickButton("CollectOut").whileHeld(new CollectorSpeed(-1.00));

      this.m_secondary.getJoystickButton("HookOut").whileHeld(new CollectorHookOut());
      this.m_secondary.getJoystickButton("PistonOut").whileHeld(new CollectorPistonOut());
    }

    if(RobotMap.SUBSYSTEMS.ARM) {
      this.m_secondary.getJoystickButton("ArmUp").whileHeld(new ArmManual(0.40));
      this.m_secondary.getJoystickButton("ArmDown").whileHeld(new ArmManual(-0.20));
    }

    if(RobotMap.SUBSYSTEMS.CLIMB) {
      this.m_secondary.getJoystickButton("Climb Level 1").whileHeld(new Climber1());
      this.m_secondary.getJoystickButton("Climb Level 2").whileHeld(new Climber2());
    }
  } catch (Exception tex) {
    DriverStation.reportError("oi init", tex.getStackTrace());
  }
    
  
  }
}
