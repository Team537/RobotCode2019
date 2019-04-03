/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.LEDChannel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LEDRainbow;

/**
 * Add your docs here.
 */
public class LED extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANifier m_canifier = new CANifier(RobotMap.CAN.CANIFIER);

  public void setColor(double r, double g, double b) {
    m_canifier.setLEDOutput(RobotMap.ROBOT.LED_BRIGHTNESS * r, LEDChannel.LEDChannelA);
    m_canifier.setLEDOutput(RobotMap.ROBOT.LED_BRIGHTNESS * g, LEDChannel.LEDChannelB);
    m_canifier.setLEDOutput(RobotMap.ROBOT.LED_BRIGHTNESS * b, LEDChannel.LEDChannelC);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LEDRainbow());
  }
}
