package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Maths;
import frc.robot.Robot;
import frc.robot.subsystems.Manipulator;

public class Manipulate extends Command {

    public static boolean UP = true;
    public static boolean DOWN = false;

    public boolean finished = false;
    public boolean dir;

    public Manipulate(boolean dir) {
        requires(Robot.m_manipulator);
        this.dir = dir;
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }

    @Override
    protected void execute() {
        if (dir)
            Manipulator.curr--;
        else
            Manipulator.curr++;
        Manipulator.curr = Maths.clampInt(Manipulator.curr, 0, 0);
        Robot.m_manipulator.sholder.set(ControlMode.PercentOutput, 0.5D * Manipulator.curr);
    }

}