package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Manipulate extends Command {

    public boolean finished = false;

    @Override
    protected boolean isFinished() {
        return finished;
    }

}