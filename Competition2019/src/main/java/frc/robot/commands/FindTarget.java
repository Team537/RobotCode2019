package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.SwerveMode;

public class FindTarget extends Command {

    public FindTarget(){
        requires(Robot.m_drivetrain);
    }

    @Override
    protected void initialize() {
        Robot.m_drivetrain.stop();
        Robot.m_gyro.reset();
        Robot.m_drivetrain.reset();
        Robot.m_drivetrain.setMode(SwerveMode.ModeSpeed);
    }

    @Override
    protected void execute() {
        double gyro = Math.toRadians(Robot.m_gyro.getAngle());

        while (Robot.m_vision.targetFound != true){
            double angle = +1;
            Robot.m_drivetrain.setTarget(gyro, angle, 0);
        }
        Robot.m_drivetrain.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}