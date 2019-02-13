package frc.robot;

public class RobotMap {

	public static final int kSlotIdx = 0;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 10;

	public static class INTERFACE {
  		public static final int JOYSTICK_MAIN = 0;
		public static final int JOYSTICK_SECONDARY = 1;
	}

	public static class SUBSYSTEMS {
		public static final boolean ARM = false;
		public static final boolean COLLECTOR = false;
		public static final boolean CAMERA = true;
		public static final boolean PHOTOSENSOR = false;
		public static final boolean GYRO = false;
		public static final boolean DRIVE = true;
	}

	public static class ROBOT {
		public static final double LED_BRIGHTNESS = 0.5;

		public static final double WHEEL_DIAMETER = 0.1016; // m
		public static final double WIDTH = 0.26; // m 
		public static final double DEPTH = 0.207; // m
		public static final double RATIO = Math.sqrt((DEPTH * DEPTH) + (WIDTH * WIDTH));

		public static final double DRIVE_M_TO_ENCODER = 1984.4878; // ticks/m
		public static final double DRIVE_SPEED = 0.3; // % 0-1.0
		
		public static final double DRIVE_PATH_SCALE = 0.4; // % -1.0-1.0 speed scale for the pathfinder

		public static final double MAX_VELOCITY = 1.7; // m/s (maximum robot velocity the robot is capable of)
		public static final double MAX_ACCELERATION = 2.0; // m/s/s
  		public static final double MAX_JERK = 60.0; // m/s/s/s
  

		//public static final Trajectory.Config TRAJECTORY_CONFIG = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
  	}

	public static class PIDs {
		//public static final PID DRIVE_ANGLE_FRONT_LEFT = new PID(4.9, 0.0, 4.0, "PID Front Left");
		public static final PID DRIVE_ANGLE_FRONT_LEFT = new PID(3.0, 0.0, 2.3, "PID Front Left");
		public static final PID DRIVE_ANGLE_FRONT_RIGHT = new PID(3.8, 0.0, 4.0, "PID Front Right");
		public static final PID DRIVE_ANGLE_BACK_LEFT = new PID(5.4, 0.0, 4.3, "PID Back Left");
		public static final PID DRIVE_ANGLE_BACK_RIGHT = new PID(5.4, 0.0, 4.3, "PID Back Right");

		public static final PID DRIVE_PATH = new PID(1.0, 0.0, 0.0, "PID Path");

		public static final PID DRIVE_ROTATE = new PID(0.01, 0.0, 0.002, "PID Rotate");
		public static final PID DRIVE_MODE_SPEED = new PID(0.0, 0.0, 0.0, "PID Mode Speed");
		public static final PID DRIVE_MODE_RATE = new PID(0.05, 0.0, 0.025, 0.3, "PID Mode Rate");
		public static final PID DRIVE_MODE_DISTANCE = new PID(0.22, 0.0, 0.0, "PID Front Distance");

		public static final PID ARM_WRIST = new PID(0.00, 0.00, 0.00, "PID Arm Wrist");
		public static final PID ARM_SHOULDER = new PID(0.00, 0.00, 0.00, "PID Arm Shoulder");
  	}

	public static class CAN {
  		public static final int CANIFIER = 0;

		public static final int DRIVE_FRONT_LEFT_DRIVE = 1;
		public static final int DRIVE_FRONT_LEFT_ANGLE = 2;
		public static final int DRIVE_BACK_LEFT_DRIVE = 3;
		public static final int DRIVE_BACK_LEFT_ANGLE = 4;

		public static final int DRIVE_BACK_RIGHT_ANGLE = 5;
		public static final int DRIVE_BACK_RIGHT_DRIVE = 6;
		public static final int DRIVE_FRONT_RIGHT_ANGLE = 7;
		public static final int DRIVE_FRONT_RIGHT_DRIVE = 8;


		public static final int MANIPULATOR_WRIST = 9;
		public static final int MANIPULATOR_SHOULDER = 10;

		public static final int COLLECTOR_INTAKE = 11;
	}

	public static class DIO {
		public static final int COLLECTOR_LIMIT = 1;
	}

	public static class VISION {
		public static final int TARGET_CAM_PORT = 0;
		public static final int TARGET_CAM_WIDTH = 320;
		public static final int TARGET_CAM_HEIGHT = 240;
	}
	
	public static class PNEUMATICS {
		public static final int COMPRESSOR = 1;
		public static final int SOLENOID1 = 0;
		public static final int SOLENOID2 = 1;
		public static final int SOLENOID3 = 2;
	}

	public static class ANALOG_INPUT {
		public static final int FRONT_LEFT = 0;
		public static final int FRONT_RIGHT = 1;
		public static final int BACK_LEFT = 2;
		public static final int BACK_RIGHT = 3;

	}

}
