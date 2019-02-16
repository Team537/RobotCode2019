package frc.robot.joysticks;

/**
 * Represents a Logitech F310 hand-held controller.
 */
public class JoystickBox extends IJoystick {
	public class Keys {
		public static final int CLIMB_LEVEL_2 = 1;
		public static final int ARM_UP = 2;
		public static final int HATCH_LEVEL_1 = 3;
		public static final int HATCH_LEVEL_2 = 4;
		public static final int HATCH_LEVEL_3 = 5;
		public static final int ARM_DOWN = 6;
		public static final int COLLECTOR_LEVEL_1 = 7;
		public static final int COLLECTOR_LEVEL_2 = 8;
		public static final int COLLECTOR_LEVEL_3 = 9;
		public static final int CLIMB_LEVEL_1 = 10;
		public static final int COLLECTOR_OUT = 11;
		public static final int COLLECTOR_IN = 12;
		public static final int COLLECTOR_HATCH_OUT = 13;
	
		
	}
	
	public JoystickBox(int port) {
        super(port);
        
        add("Climb Level 2", new ValueUsage(Keys.CLIMB_LEVEL_2, false));
        add("Climb Level 1", new ValueUsage(Keys.CLIMB_LEVEL_1, false));
        add("Hatch Out", new ValueUsage(Keys.COLLECTOR_HATCH_OUT, false));
        add("Hatch Level 1", new ValueUsage(Keys.HATCH_LEVEL_1, false));
        add("Hatch Level 2", new ValueUsage(Keys.HATCH_LEVEL_2, false));
        add("Hatch Level 3", new ValueUsage(Keys.HATCH_LEVEL_3, false));
        add("Arm Up", new ValueUsage(Keys.ARM_UP, false));
        add("Arm Down", new ValueUsage(Keys.ARM_DOWN, false));
        add("Collector Level 1", new ValueUsage(Keys.COLLECTOR_LEVEL_1));
        add("Collector Level 2", new ValueUsage(Keys.COLLECTOR_LEVEL_2));
        add("Collector Lavel 3", new ValueUsage(Keys.COLLECTOR_LEVEL_3));
        add("CollectIn", new ValueUsage(Keys.COLLECTOR_IN, false));
        add("CollectOut", new ValueUsage(Keys.COLLECTOR_OUT, false));
    
     
       
	}

	@Override
	public String getJoystickType() {
		return "Box";
	}
}