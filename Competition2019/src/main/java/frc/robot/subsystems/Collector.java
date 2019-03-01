package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.CollectorDefault;

public class Collector extends Subsystem {

  //private Compressor m_compressor = new Compressor(RobotMap.PNEUMATICS.COMPRESSOR);
    
  private Solenoid m_hatchLeft = new Solenoid(RobotMap.PNEUMATICS.HATCH_LEFT);
  //private Solenoid m_hatchRight = new Solenoid(RobotMap.PNEUMATICS.HATCH_RIGHT);
  private WPI_TalonSRX m_intake = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR_INTAKE);
  private WPI_TalonSRX m_wrist = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR_WRIST);

  public Collector() {
    m_wrist.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    m_wrist.setInverted(false);
    m_wrist.setSensorPhase(true);
    m_wrist.config_kP(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getP(), RobotMap.kTimeoutMs);
		m_wrist.config_kI(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getI(), RobotMap.kTimeoutMs);
		m_wrist.config_kD(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getD(), RobotMap.kTimeoutMs);
    m_wrist.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, RobotMap.kTimeoutMs);
    m_wrist.enableCurrentLimit(false);
    m_wrist.configPeakCurrentDuration(0, RobotMap.kTimeoutMs); // 10
    m_wrist.configPeakCurrentLimit(0, RobotMap.kTimeoutMs); // 30
  }
  public void setSpeed(double intakeSpeed) {
    m_intake.set(ControlMode.PercentOutput, intakeSpeed);
  }

  public void hatchOut(){
    m_hatchLeft.set(true);
    //m_hatchRight.set(true);

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
    m_hatchLeft.set(false);
    //m_hatchRight.set(false);
    m_intake.set(ControlMode.PercentOutput, 0.00);
    m_wrist.set(ControlMode.Position, m_wrist.getSelectedSensorPosition());
  }

  public void reset() {
    m_intake.set(ControlMode.PercentOutput, 0.00);
  }

  public double getTarget() {
    return m_wrist.getClosedLoopTarget();
  }

  public void setTarget(double position) {
    m_wrist.set(ControlMode.Position, position);
  }

   @Override
   public void initDefaultCommand() {
   setDefaultCommand(new CollectorDefault());
  }

}