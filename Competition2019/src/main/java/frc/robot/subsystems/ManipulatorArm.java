package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
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
  public DigitalInput m_armLimit = new DigitalInput(RobotMap.DIO.ARM_LIMIT);
  public DigitalInput m_armBottomLimit = new DigitalInput(RobotMap.DIO.ARM_LIMIT_BOTTOM);

  private double m_armCurrentPostion;
  private double m_targetPosition;
  private double m_armError;
  //private PIDController m_wristPID;
  
  public ManipulatorArm() {
    m_shoulder.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    m_shoulder.setInverted(true);
    m_shoulder.setSensorPhase(true);
    m_shoulder.config_kP(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getP(), RobotMap.kTimeoutMs);
		m_shoulder.config_kI(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getI(), RobotMap.kTimeoutMs);
		m_shoulder.config_kD(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getD(), RobotMap.kTimeoutMs);
    m_shoulder.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, RobotMap.kTimeoutMs);
    //m_shoulder.enableCurrentLimit(false);
   // m_shoulder.configPeakCurrentDuration(0, RobotMap.kTimeoutMs); // 10
    //m_shoulder.configPeakCurrentLimit(0, RobotMap.kTimeoutMs); // 30
    m_shoulder.configForwardSoftLimitThreshold(3000, RobotMap.kTimeoutMs);
    m_shoulder.configReverseSoftLimitThreshold(0, RobotMap.kTimeoutMs);
    m_shoulder.configForwardSoftLimitEnable(false);
    m_shoulder.configReverseSoftLimitEnable(false);
    m_shoulder.configPeakOutputReverse(-1.00);

    m_shoulder2.configReverseSoftLimitEnable(false);
    m_shoulder2.set(ControlMode.Follower, m_shoulder.getDeviceID());
    m_shoulder2.setInverted(InvertType.OpposeMaster);
  }

  public void reset() {
    //m_shoulder.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
  }

  public void disable() {
    //m_shoulder.set(ControlMode.Velocity, 0.00);
    //m_shoulder2.set(ControlMode.PercentOutput, 0.00);
    //m_shoulder.stopMotor();
    //m_shoulder2.stopMotor();
    //m_shoulder.set(ControlMode.PercentOutput, 0.10);

    m_armCurrentPostion = getCurrentPosition();
    m_shoulder.set(ControlMode.Position, m_armCurrentPostion);
  }

  public void dashboard() {
    SmartDashboard.putNumber("Arm Position", m_shoulder.getSelectedSensorPosition());
  }

  public void setLevel(String level) {
    
    //m_armCurrentPostion = m_shoulder.getSelectedSensorPosition();
    //SmartDashboard.putNumber("Arm Position", m_armCurrentPostion);
    
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

  public double getCurrentPosition() {
    return m_shoulder.getSelectedSensorPosition();
  }

  public void setTarget(double position) {
    SmartDashboard.putNumber("Arm Position: ", getCurrentPosition());
    SmartDashboard.putNumber("Arm Target: ", getTarget());
    m_armError = getTarget() - getCurrentPosition();

    SmartDashboard.putNumber("Arm Error: ", m_armError);
    
    //if(m_armLimit.get()) {
    //  disable();
    //} else {
    m_shoulder.set(ControlMode.Position, position);
    m_shoulder2.set(ControlMode.Follower, m_shoulder.get());
    //}
  }
  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArmDefault());
  }

}
