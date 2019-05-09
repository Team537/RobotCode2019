package frc.robot.joysticks;

/**
 * Represents a Logitech F310 hand-held controller.
 */
public class JoystickBox extends IJoystick {
	public class Keys {
		public static final int CLIMB_LEVEL_2 = 1;
		public static final int WRIST_DOWN = 2;
		public static final int WRIST_UP = 3;
		public static final int HATCH_LEVEL_2 = 4;
		public static final int HATCH_LEVEL_3 = 5;
		public static final int ARM_DOWN = 6;
		public static final int ARM_UP = 7;
		public static final int COLLECTOR_LEVEL_2 = 8;
		public static final int PISTON_OUT = 9;
		public static final int COLLECTOR_OUT = 11;
		public static final int COLLECTOR_IN = 12;
		public static final int HOOK_OUT = 13;
	
		
	}
	
	public JoystickBox(int port) {
        super(port);
        
		add("WristUp", new ValueUsage(Keys.WRIST_UP, false));
		add("WristDown", new ValueUsage(Keys.WRIST_DOWN, false));
		add("HookOut", new ValueUsage(Keys.HOOK_OUT, false));
		add("PistonOut", new ValueUsage(Keys.PISTON_OUT, false));
		add("ArmUp", new ValueUsage(Keys.ARM_UP, false));
		add("ArmDown", new ValueUsage(Keys.ARM_DOWN, false));		
		add("CollectIn", new ValueUsage(Keys.COLLECTOR_IN, false));
        add("CollectOut", new ValueUsage(Keys.COLLECTOR_OUT, false));
    
     
       
	}

	@Override
	public String getJoystickType() {
		return "Box";
	}
}
