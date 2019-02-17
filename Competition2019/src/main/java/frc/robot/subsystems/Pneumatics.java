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

  public void CompressorOn() {
    compressor.start();
    compressor.setClosedLoopControl(true);
  }

  public void Stop() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CompressorOn());
  }
}
