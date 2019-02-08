package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
<<<<<<< HEAD
import frc.robot.RobotMap;
import frc.robot.joysticks.JoystickF310;

import static frc.robot.Robot.m_manipulator;

import com.ctre.phoenix.motorcontrol.ControlMode;
=======
import frc.robot.Maths;
import frc.robot.Robot;
import frc.robot.subsystems.Manipulator;
>>>>>>> 4e80565e7afc4de3b175e4447a6fc307056b130a

public class Manipulate extends Command {

    public static boolean UP = true;
    public static boolean DOWN = false;

    public boolean finished = false;
    public boolean dir;

    public Manipulate(boolean dir) {
        requires(Robot.m_manipulator);
        this.dir = dir;
    }

    public Manipulate() {
        
    }

    public static double calcFromRaw(double rawTenBit) {
        return rawTenBit / 1023D;
    }

    public static int check(double rawRatio) {
        if (isInRange(rawRatio, getRange(m_manipulator.currSetting)))
            return 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

    public static double[] getRange(int setting) {
        if (setting == 0)
            return new double[] {0D, 0.02D};
        else if (setting == 1)
            return new double[] {0.49D, 0.51D};
        else
            return new double[] {0.98D, 1D};
    }

    public static boolean isInRange(double val, double[] range) {
        try {
            double min = range[0];
            double max = range[1];
            if (val <= max && val >= min)
                return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    protected void execute() {
        double d = calcFromRaw(m_manipulator.wrist.getSensorCollection().getAnalogInRaw());
        System.out.println(d);
        if (m_manipulator.armTriggerRight.getRawButton(6))
            m_manipulator.armTriggerRight.set(ControlMode.PercentOutput, JoystickF310.Keys.BUMPER_RIGHT * RobotMap.ROBOT.MANIPULATOR_SPEED); //manipulator
        if (m_manipulator.armTriggerLeft.getRawButton(5))
            m_manipulator.armTriggerLeft.set(ControlMode.PercentOutput, JoystickF310.Keys.BUMPER_LEFT * -RobotMap.ROBOT.MANIPULATOR_SPEED); //manipulator
        if (m_manipulator.wristTriggerRight.getRawAxis(3) > 0)
            m_manipulator.wristTriggerRight.set(ControlMode.PercentOutput, JoystickF310.Axis.RIGHT_TRIGGER * RobotMap.ROBOT.MANIPULATOR_SPEED); // wrist
        if (m_manipulator.wristTriggerLeft.getRawAxis(2) > 0)
            m_manipulator.wristTriggerLeft.set(ControlMode.PercentOutput, JoystickF310.Axis.LEFT_TRIGGER * -RobotMap.ROBOT.MANIPULATOR_SPEED); // wrist
        
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