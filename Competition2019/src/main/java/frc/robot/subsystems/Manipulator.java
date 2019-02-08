package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Manipulate;
import frc.robot.joysticks.IJoystick;
import frc.robot.joysticks.JoystickExtreme;
import frc.robot.joysticks.JoystickF310;

public class Manipulator extends Subsystem {
    
    public static final int LOW = 0;
    public static final int MEDIUM = 1;
    public static final int HIGH = 2;

    public static int currSetting = LOW;
    
    public WPI_TalonSRX shoulder = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_SHOULDER);
    public WPI_TalonSRX wrist = new WPI_TalonSRX(RobotMap.CAN.MANIPULATOR_WRIST);
<<<<<<< HEAD
    public IJoystick armTriggerLeft = new JoystickExtreme(JoystickF310.Keys.BUMPER_LEFT);
    public IJoystick armTriggerRight = new JoystickExtreme(JoystickF310.Keys.BUMPER_RIGHT);
    public IJoystick wristTriggerRight = new JoystickExtreme(JoystickF310.Axis.RIGHT_TRIGGER);
    public IJoystick wristTriggerLeft = new JoystickExtreme(JoystickF310.Axis.LEFT_TRIGGER);
        
    public Manipulator() {
        
    }

    @Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Manipulate());
	}

=======
    public static int curr = 0;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Manipulate(Manipulate.DOWN));
    }
>>>>>>> 4e80565e7afc4de3b175e4447a6fc307056b130a

}