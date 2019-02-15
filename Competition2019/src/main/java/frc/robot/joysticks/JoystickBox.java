package frc.robot.joysticks;

/**
 * Represents a Logitech F310 hand-held controller.
 */
public class JoystickBox extends IJoystick {
	public class Keys {
		public static final int COLLECTOR_TILT = 1;
		public static final int COLLECTOR_DOWN = 2;
		public static final int COLLECTOR_IN = 3;
		public static final int COLLECTOR_OUT = 4;
		public static final int COLLECTOR_HATCH_OUT = 5;
		public static final int ARM_LEVEL_1 = 6;
		public static final int ARM_LEVEL_2 = 7;
		public static final int ARM_LEVEL_3 = 8;
		public static final int ARM_RESET = 9;
		public static final int STICK_RIGHT = 10;
	}
	
	public JoystickBox(int port) {
        super(port);
        
		add("CollectTilt", new ValueUsage(Keys.COLLECTOR_TILT, false));
        add("CollectIn", new ValueUsage(Keys.COLLECTOR_IN, false));
        add("CollectOut", new ValueUsage(Keys.COLLECTOR_OUT, false));
        add("CollectHatchOut", new ValueUsage(Keys.COLLECTOR_HATCH_OUT, false));
        add("ArmLevel1", new ValueUsage(Keys.ARM_LEVEL_1, false));
        add("ArmLevel2", new ValueUsage(Keys.ARM_LEVEL_2, false));
        add("ArmLevel3", new ValueUsage(Keys.ARM_LEVEL_3, false));
        add("ArmReset", new ValueUsage(Keys.ARM_RESET, false));
	}

	@Override
	public String getJoystickType() {
		return "Box";
	}
}
