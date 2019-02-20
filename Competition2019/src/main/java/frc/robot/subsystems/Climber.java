package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Solenoid m_climb1 = new Solenoid(RobotMap.PNEUMATICS.CLIMB_1);
  private Solenoid m_climb2 = new Solenoid(RobotMap.PNEUMATICS.CLIMB_2);

  public void disable(){
    m_climb1.set(false);
    m_climb2.set(false);
  }

  public void climb1Deploy() {
    m_climb1.set(true);
  }

  public void climb2Deploy() {
    m_climb2.set(true);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());
  }
}
