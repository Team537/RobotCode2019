package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CompressorOn;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {

  private Compressor compressor = new Compressor(RobotMap.PNEUMATICS.COMPRESSOR);
  boolean enabled = compressor.enabled();
  boolean pressureSwitch = compressor.getPressureSwitchValue();
  double current = compressor.getCompressorCurrent();

  public Pneumatics(){
    compressor.setClosedLoopControl(true);
  }

  public void CompressorOn() {
    compressor.start();
  }

  public void Stop() {
    compressor.stop();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CompressorOn());
  }
}
