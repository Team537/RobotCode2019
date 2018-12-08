package org.usfirst.frc.team537.robot.autos;

import org.usfirst.frc.team537.robot.Robot;
import org.usfirst.frc.team537.robot.commands.CommandCollectSpeed;
import org.usfirst.frc.team537.robot.commands.CommandDriveDistance;
import org.usfirst.frc.team537.robot.commands.CommandDriveRate;
import org.usfirst.frc.team537.robot.commands.CommandDriveReset;
import org.usfirst.frc.team537.robot.commands.CommandDriveRotate;
import org.usfirst.frc.team537.robot.commands.CommandFindCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoVision extends CommandGroup {

    public AutoVision() {
 
    	boolean straight = CommandFindCube.targetFound;
    	SmartDashboard.putNumber("RateDrive", CommandFindCube.rate);
    	SmartDashboard.putBoolean("TargetFound?", CommandFindCube.targetFound);
    	
    	
    	if(straight) {
    		addParallel(new CommandCollectSpeed(-0.30));
    		addSequential(new CommandDriveRate(0.0, 0.10, 0.10));
    	} else {
    		addSequential(new CommandFindCube());
    	}
    	
    	addSequential(new CommandDriveReset());
    	
    	//addSequential(new CommandDriveDistance(0.0, 0.20f));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
