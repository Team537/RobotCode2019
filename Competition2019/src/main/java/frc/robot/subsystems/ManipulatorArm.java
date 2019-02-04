package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.WPI_MotorSafetyImplem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.sun.javadoc.RootDoc;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArmDefault;

/**
 * Add your docs here.p
 */
public class ManipulatorArm extends Subsystem {

  private WPI_TalonSRX m_wrist = new WPI_TalonSRX(11);
  private WPI_TalonSRX m_shoulder = new WPI_TalonSRX(12);

  private double m_wristPositionCurrent;
  private PIDController m_wristPID;

  public ManipulatorArm() {
    m_shoulder.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    m_shoulder.setInverted(false);
    m_shoulder.config_kP(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getP(), RobotMap.kTimeoutMs);
		m_shoulder.config_kI(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getI(), RobotMap.kTimeoutMs);
		m_shoulder.config_kD(RobotMap.kPIDLoopIdx, RobotMap.PIDs.ARM_SHOULDER.getD(), RobotMap.kTimeoutMs);
    m_shoulder.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, RobotMap.kTimeoutMs);
    m_shoulder.enableCurrentLimit(false);
    m_shoulder.configPeakCurrentDuration(0, RobotMap.kTimeoutMs); // 10
    m_shoulder.configPeakCurrentLimit(0, RobotMap.kTimeoutMs); // 30

  }

  public void dashboard() {
    SmartDashboard.putNumber("Wrist Encoder", m_wrist.getSelectedSensorPosition());
  }

  public void wristMovement(ControlMode mode, double posit) {
    m_wrist.set(ControlMode.Position, posit);
  }

  public void shoulderMovement(ControlMode mode, double output) {
    m_shoulder.set(mode, output);
  }
  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArmDefault());
  }

}
