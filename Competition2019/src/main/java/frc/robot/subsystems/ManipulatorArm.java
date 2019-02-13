package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Maths;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Manipulate;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;

public class ManipulatorArm extends Subsystem {
    
    public static final int LOW = 0;
    public static final int MEDIUM = 1;
    public static final int HIGH = 2;

    public static int currSetting = LOW;
	public static int curr;
    public boolean dir;
    public WPI_TalonSRX shoulder = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_SHOULDER);
    public WPI_TalonSRX wrist = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_WRIST);
    public IJoystick armTriggerLeft = new JoystickExtreme(JoystickF310.Keys.BUMPER_LEFT);
    public IJoystick armTriggerRight = new JoystickExtreme(JoystickF310.Keys.BUMPER_RIGHT);
    public IJoystick wristTriggerRight = new JoystickExtreme(JoystickF310.Axis.RIGHT_TRIGGER);
    public IJoystick wristTriggerLeft = new JoystickExtreme(JoystickF310.Axis.LEFT_TRIGGER);
        
    public ManipulatorArm() {
            if (dir) // possible dir error
                ManipulatorArm.curr--;
            else
            ManipulatorArm.curr++;
                ManipulatorArm.curr = Maths.clampInt(ManipulatorArm.curr, 0, 0);
            Robot.m_manipulator.armTriggerRight.set(ControlMode.PercentOutput, 0.5D * ManipulatorArm.curr);
        }
    
    

    @Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Manipulate());
	}


}