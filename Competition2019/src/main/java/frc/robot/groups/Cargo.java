/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ArmLevel;
import frc.robot.commands.CollectorTilt;

public class Cargo extends CommandGroup {
  /**
   * Add your docs here.
   */
  private String level;
  public Cargo(String modeLevel) {
    this.level = modeLevel;

  addParallel(new CollectorTilt(0.05));
  addSequential(new ArmLevel(level));
  }
}
