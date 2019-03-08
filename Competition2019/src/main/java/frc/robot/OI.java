package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmLevel;
import frc.robot.commands.ArmManual;
import frc.robot.commands.Climber1;
import frc.robot.commands.Climber2;
import frc.robot.commands.CollectorBalltoHatch;
import frc.robot.commands.CollectorHatchOut;
import frc.robot.commands.CollectorHatchToBall;
import frc.robot.commands.CollectorSpeed;
import frc.robot.commands.CollectorTilt;
import frc.robot.commands.DriveReset;
import frc.robot.commands.DriveSetPID;
import frc.robot.commands.DriveSetZero;
import frc.robot.commands.DriveSetPID.TuneCommand;
import frc.robot.groups.Cargo;
import frc.robot.groups.Hatch;
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

    //this.m_test = new JoystickF310(1);
    //this.m_test.getJoystickButton("TiltUp").whileHeld(new CollectorTilt());
    
    if(RobotMap.SUBSYSTEMS.DRIVE) {
      //this.m_main.getJoystickButton("SetZero").whenPressed(new DriveSetZero());
      //this.m_main.getJoystickButton("ResetDrive").whenPressed(new DriveReset());

      //this.m_main.getJoystickButton("P_UP").whenPressed(new );
    }

    if(RobotMap.SUBSYSTEMS.COLLECTOR) {
      this.m_main.getJoystickButton("Get Hatch").whileHeld(new CollectorTilt(10));
      this.m_main.getJoystickButton("Go Back").whileHeld(new CollectorTilt(-50));

      this.m_secondary.getJoystickButton("CollectIn").whileHeld(new CollectorSpeed(0.50));
      this.m_secondary.getJoystickButton("CollectOut").whileHeld(new CollectorSpeed(-1.00));

      this.m_secondary.getJoystickButton("Hatch Out").whenPressed(new CollectorHatchOut());

      this.m_secondary.getJoystickButton("Hatch Level 1").whenPressed(new ArmLevel(0.00));
      this.m_secondary.getJoystickButton("Hatch Level 2").whenPressed(new ArmLevel(1000.00));
      this.m_secondary.getJoystickButton("Hatch Level 3").whenPressed(new ArmLevel(2000.00));

      this.m_secondary.getJoystickButton("Collector Level 1").whenPressed(new ArmLevel(0.00));
      this.m_secondary.getJoystickButton("Collector Level 2").whenPressed(new ArmLevel(1000.00));
      this.m_secondary.getJoystickButton("Collector Level 3").whenPressed(new ArmLevel(2000.00));

    }

    if(RobotMap.SUBSYSTEMS.ARM) {
      this.m_secondary.getJoystickButton("ArmUp").whileHeld(new ArmManual(1));
      this.m_secondary.getJoystickButton("ArmDown").whileHeld(new ArmManual(-1));

      //this.m_secondary.getJoystickButton("ArmUp").whileHeld(new ArmManual(0.30));
      //this.m_secondary.getJoystickButton("ArmDown").whileHeld(new ArmManual(-0.30));
    }

    if(RobotMap.SUBSYSTEMS.CLIMB) {
      this.m_secondary.getJoystickButton("Climb Level 1").whileHeld(new Climber1());
      this.m_secondary.getJoystickButton("Climb Level 2").whileHeld(new Climber2());
    }
    
    
  
  }
}
