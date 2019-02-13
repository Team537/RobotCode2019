/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;                   
/**
 * Add your docs here.
 */
public class Collector extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

private WPI_TalonSRX CollectorTalon = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR);
private DigitalInput BallLimit = new DigitalInput(RobotMap.DIO.COLLECTORLIMIT);


    

    public void reset() {
      CollectorTalon.set(ControlMode.PercentOutput, 0.00);
    }


    public void disable () {
      CollectorTalon.set(ControlMode.PercentOutput, 0.00);
  }

    public void stop() {
      CollectorTalon.set(ControlMode.PercentOutput, 0.0);
  }

  

  @Override
  public void initDefaultCommand() {
    
  }


public static void set(ControlMode percentoutput, double intakeSpeed) {
}


public void setSpeed(double inSpeed) {
  boolean BallIn = BallLimit.get();
  if(BallIn) {
    CollectorTalon.set(ControlMode.PercentOutput, 0.00);
  }else{
    CollectorTalon.set(ControlMode.PercentOutput, inSpeed);}
}
}








