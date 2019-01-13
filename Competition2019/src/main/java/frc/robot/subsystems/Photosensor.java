package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.LineTrack;

public class Photosensor extends Subsystem {

  public DigitalInput DIOsensor = new DigitalInput(2);

  public void white(boolean isWhite){
      SmartDashboard.putBoolean("White?", isWhite);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LineTrack());
  }
}
