package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CollectorDefault;

public class Collector extends Subsystem {

  //private Compressor m_compressor = new Compressor(RobotMap.PNEUMATICS.COMPRESSOR);
    
  private Solenoid m_hatch1 = new Solenoid(0);
  private Solenoid m_hatch2 = new Solenoid(1);
  private WPI_TalonSRX m_intake = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR_INTAKE);
  private WPI_TalonSRX m_wrist = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR_WRIST);

  public void setSpeed(double intakeSpeed) {
    m_intake.set(ControlMode.PercentOutput, intakeSpeed);
  }

  public void hatchOut(){
    m_hatch1.set(true);
    m_hatch2.set(true);

  }
  public void ballToHatch() {
    m_wrist.set(ControlMode.PercentOutput, 0.1);
  }
    
  public void hatchToBall() {
    m_wrist.set(ControlMode.PercentOutput, -0.1);
  }

  public void tilt(double speed){
    m_wrist.set(ControlMode.PercentOutput, speed);
  }
  
  public void disable() {
    m_hatch1.set(false);
    m_hatch2.set(false);
    m_intake.set(ControlMode.PercentOutput, 0.00);
  }

  public void reset() {
    m_intake.set(ControlMode.PercentOutput, 0.00);
  }

   @Override
   public void initDefaultCommand() {
   //setDefaultCommand(new CollectorDefault());
  }

}