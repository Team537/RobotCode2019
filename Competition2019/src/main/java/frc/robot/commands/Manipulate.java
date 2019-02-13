package frc.robot.commands;

import static frc.robot.Robot.m_manipulator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Maths;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Manipulate extends Command {

    public static int setting = 0;

    public long lastMillis;

    public Manipulate() { // possible dir error
        requires(Robot.m_manipulator);
        lastMillis = System.currentTimeMillis();
    }

    public static double calcFromRaw(double rawTenBit) {
        return rawTenBit / 1023D;
    }

    public static double[] getRange() {
        if (setting == 0)
            return new double[] {0D, 0.01D};
        else if (setting == 1)
            return new double[] {0.49D, 0.51D};
        else
            return new double[] {0.99D, 1D};
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

    public static double dstFrmRange(double val, double[] range) {
        try {
            double min = range[0];
            double max = range[1];
            if (val < min)
                return min - val;
            else if (val > max) {
                return val - max;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    @Override
    protected void execute() {
        if (lastMillis + 400 > System.currentTimeMillis()) {
            if (m_manipulator.armTriggerRight.getRawButton(6)) {
                setting++;
                lastMillis = System.currentTimeMillis();
            }
            if (m_manipulator.armTriggerRight.getRawButton(5)) {
                setting--;
                lastMillis = System.currentTimeMillis();
            }
        }
        setting = Maths.clampInt(setting, 0, 2);
        {
            double d = calcFromRaw(m_manipulator.wrist.getSensorCollection().getAnalogInRaw());
            System.out.println("Wrist: " + d);
            if (!isInRange(d, getRange())) {
                m_manipulator.wrist.set(ControlMode.PercentOutput, 0D);
            } else {
                m_manipulator.wrist.set(ControlMode.PercentOutput, Maths.clamp(dstFrmRange(d, getRange()) * RobotMap.ROBOT.MANIPULATOR_SPEED, 0.05D, 1D));
            }
        }
        {
            double d = calcFromRaw(m_manipulator.shoulder.getSensorCollection().getAnalogInRaw());
            System.out.println("Shoulder: " + d);
            if (!isInRange(d, getRange())) {
                m_manipulator.shoulder.set(ControlMode.PercentOutput, 0D);
            } else {
                m_manipulator.shoulder.set(ControlMode.PercentOutput, Maths.clamp(dstFrmRange(d, getRange()) * RobotMap.ROBOT.MANIPULATOR_SPEED, 0.05D, 1D));
            }
        }
        /*if (m_manipulator.armTriggerRight.getRawButton(6))
            m_manipulator.armTriggerRight.set(ControlMode.PercentOutput, JoystickF310.Keys.BUMPER_RIGHT * RobotMap.ROBOT.MANIPULATOR_SPEED); //manipulator
        if (m_manipulator.armTriggerLeft.getRawButton(5))
            m_manipulator.armTriggerLeft.set(ControlMode.PercentOutput, JoystickF310.Keys.BUMPER_LEFT * -RobotMap.ROBOT.MANIPULATOR_SPEED); //manipulator
        if (m_manipulator.wristTriggerRight.getRawAxis(3) > 0)
            m_manipulator.wristTriggerRight.set(ControlMode.PercentOutput, JoystickF310.Axis.RIGHT_TRIGGER * RobotMap.ROBOT.MANIPULATOR_SPEED); // wrist
        if (m_manipulator.wristTriggerLeft.getRawAxis(2) > 0)
            m_manipulator.wristTriggerLeft.set(ControlMode.PercentOutput, JoystickF310.Axis.LEFT_TRIGGER * -RobotMap.ROBOT.MANIPULATOR_SPEED); // wrist
        */
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
}

