package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ArmDefault;

/**
 * Add your docs here.p
 */
public class ManipulatorArm extends Subsystem {

  private WPI_TalonSRX m_shoulder2 = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_SHOULDER_LEFT);
  private WPI_TalonSRX m_shoulder = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_SHOULDER_RIGHT);
  
  private double m_armPositionCurrent;
  //private PIDController m_wristPID;
  
  public ManipulatorArm() {
    m_shoulder.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    m_shoulder.setInverted(false);
    m_shoulder.setSensorPhase(true);
    m_shoulder.config_kP(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getP(), RobotMap.kTimeoutMs);
		m_shoulder.config_kI(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getI(), RobotMap.kTimeoutMs);
		m_shoulder.config_kD(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getD(), RobotMap.kTimeoutMs);
    m_shoulder.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, RobotMap.kTimeoutMs);
    //m_shoulder.enableCurrentLimit(false);
   // m_shoulder.configPeakCurrentDuration(0, RobotMap.kTimeoutMs); // 10
    //m_shoulder.configPeakCurrentLimit(0, RobotMap.kTimeoutMs); // 30

    m_shoulder2.set(ControlMode.Follower, m_shoulder2.getDeviceID());
    m_shoulder2.setInverted(InvertType.OpposeMaster);
  }

  public void reset() {
    //m_shoulder.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
  }

  public void disable() {
    //m_shoulder.set(ControlMode.Velocity, 0.00);
    //m_shoulder2.set(ControlMode.PercentOutput, 0.00);
    m_shoulder.stopMotor();
    //m_shoulder2.stopMotor();

    //m_shoulder.set(, demand0, demand1Type, demand1);)
  }

  public void dashboard() {
    SmartDashboard.putNumber("Arm Position", m_shoulder.getSelectedSensorPosition());
  }

  public void setLevel(String level) {
    /*
    m_shoulder.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    m_shoulder.setInverted(false);
    m_shoulder.setSensorPhase(true);
    m_shoulder.config_kP(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getP(), RobotMap.kTimeoutMs);
		m_shoulder.config_kI(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getI(), RobotMap.kTimeoutMs);
		m_shoulder.config_kD(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getD(), RobotMap.kTimeoutMs);
    m_shoulder.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, RobotMap.kTimeoutMs);
    m_shoulder.enableCurrentLimit(false);
    m_shoulder.configPeakCurrentDuration(0, RobotMap.kTimeoutMs); // 10
    m_shoulder.configPeakCurrentLimit(0, RobotMap.kTimeoutMs); // 30
*/
    m_armPositionCurrent = m_shoulder.getSelectedSensorPosition();
    SmartDashboard.putNumber("Arm Position", m_armPositionCurrent);
    
    if(level.equals("ONE_HATCH")){
      m_shoulder.set(ControlMode.Position, 100);
    }

    if(level.equals("TWO_HATCH")) {
      m_shoulder.set(ControlMode.Position, 200);
    }

    if(level.equals("THREE_HATCH")) {
      m_shoulder.set(ControlMode.PercentOutput, 300);
    }


    if(level.equals("ONE_CARGO")){
      m_shoulder.set(ControlMode.Position, 100);
    }

    if(level.equals("TWO_CARGO")) {
      m_shoulder.set(ControlMode.Position, 200);
    }

    if(level.equals("THREE_CARGO")) {
      m_shoulder.set(ControlMode.PercentOutput, 300);
    }

  }

  public void armManual(double speed){
    
    SmartDashboard.putNumber("Arm Position: ", m_shoulder.getSelectedSensorPosition());
    ///SmartDashboard.putNumber("Arm Position: ",m_shoulder2.getSelectedSensorPosition());
    m_shoulder.set(ControlMode.PercentOutput, speed);
    //m_shoulder2.set(ControlMode.PercentOutput, speed);
  }

  public double getTarget(){
    return m_shoulder.getClosedLoopTarget(); 
  }

  public void setTarget(double position) {
    m_shoulder.set(ControlMode.Position, position);
  }
  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArmDefault());
  }

}
