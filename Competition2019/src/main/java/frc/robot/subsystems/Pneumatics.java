package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.CompressorOn;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {

  private Compressor m_compressor = new Compressor(22);
  public Solenoid m_hatches = new Solenoid(22, 0);
  
  public void CompressorOn() {
    m_compressor.start();
    m_compressor.setClosedLoopControl(true);
    SmartDashboard.putBoolean("Compressor Status", m_compressor.enabled());
  }

  public void hatchOut() {
    m_hatches.set(true);
  }
  public void hatchIn(){
    m_hatches.set(false);
  }

  public void Stop() {
    m_compressor.stop();
  }

  @Override
  public void initDefaultCommand() {
    SmartDashboard.putBoolean("Hatch Solenoids", m_hatches.get());
    // Set the default command for a subsystem here.
    setDefaultCommand(new CompressorOn());
  }
}
