package frc.robot.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ArmLevel;
import frc.robot.commands.CollectorBalltoHatch;

public class Hatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  private String level;
  public Hatch(String modeLevel) {
    this.level = modeLevel;

  addParallel(new CollectorBalltoHatch());
  addSequential(new ArmLevel(level));
  }
  
}
