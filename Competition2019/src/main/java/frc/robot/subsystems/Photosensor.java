package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.LineTrack;

public class Photosensor extends Subsystem {

  public DigitalInput sensorRight = new DigitalInput(2);
  public DigitalInput sensorLeft = new DigitalInput(3);

  public void onWhiteLine(boolean right, boolean left){
    SmartDashboard.putBoolean("Right On line?", right);
    SmartDashboard.putBoolean("Left On line?", left);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LineTrack());
  }
}
