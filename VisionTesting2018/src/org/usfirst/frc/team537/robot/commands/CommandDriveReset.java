package org.usfirst.frc.team537.robot.commands;

import org.usfirst.frc.team537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandDriveReset extends Command {
	public CommandDriveReset() {
		requires(Robot.subsystemDrive);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		//Robot.subsystemDrive.recalibrate();
		//Robot.subsystemGyro.reset();
		Robot.subsystemDrive.setTarget(Robot.subsystemGyro.getAngle(), 0.00, 0.00, 0.00);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}
}
