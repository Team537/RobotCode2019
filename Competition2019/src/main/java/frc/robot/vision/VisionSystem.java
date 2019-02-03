package frc.robot.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.VisionAlignTarget;

public class VisionSystem extends Subsystem {
  NetworkTableEntry contours;

  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("Contours");
  


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new VisionAlignTarget());
  }
}
