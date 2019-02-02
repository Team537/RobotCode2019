package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Manipulate;

public class Manipulator extends Subsystem {

    public WPI_TalonSRX sholder = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_SHOULDER);
    public WPI_TalonSRX wrist = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_WRIST);
    public static int curr = 0;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Manipulate(Manipulate.DOWN));
    }

}