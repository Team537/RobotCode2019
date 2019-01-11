/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SubsystemGyro extends Subsystem implements PIDSource{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private AHRS m_ahrs;

  public SubsystemGyro() {
    try {
      m_ahrs = new AHRS(SPI.Port.kMXP);
      reset();
    } catch (RuntimeException e) {
      DriverStation.reportError("Error instantiating navX MXP: " + e.getMessage(), true);
    }
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public double getAngle() {
		return m_ahrs.getAngle();
	}
	
	public void setAngle(double angle) {
		m_ahrs.setAngleAdjustment(angle);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return m_ahrs.getPIDSourceType();
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		m_ahrs.setPIDSourceType(pidSource);
	}

	@Override
	public double pidGet() {
		return getAngle();
}

  public void reset() {
    m_ahrs.reset();
  }
}
