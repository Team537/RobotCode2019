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
  public Solenoid m_hook = new Solenoid(22, 0);
  public Solenoid m_piston = new Solenoid(22, 1);
  
  public void CompressorOn() {
    m_compressor.start();
    m_compressor.setClosedLoopControl(true);
    SmartDashboard.putBoolean("Compressor Status", m_compressor.enabled());
  }

  public void hookOut() {
    m_hook.set(true);
  }
  public void hookIn() {
    m_hook.set(false);
  }

  public void pistonOut() {
    m_piston.set(true);
  }

  public void pistonIn() {
    m_piston.set(false);
  }

  public void Stop() {
    m_compressor.stop();
  }

  @Override
  public void initDefaultCommand() {
    SmartDashboard.putBoolean("Hatch Solenoids", m_hook.get());
    // Set the default command for a subsystem here.
    setDefaultCommand(new CompressorOn());
  }
}
