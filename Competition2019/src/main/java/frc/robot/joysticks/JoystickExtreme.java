package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class JoystickExtreme{

    public static Joystick IJoystickExtreme = new Joystick(RobotMap.IO.JOYSTICK_PORT_MAIN);

    public static class Interface {
        public static final int X = 0;
        public static final int Y = 1;
        public static  final int Z = 2;

        public static final int button1 = 1;
        public static  final int button2 = 2;
        public static final int button3 = 3;
    }

    public static class getValues{
        public static boolean trigger;
    }

    public class Axis{
        public double X_Axis = IJoystickExtreme.getRawAxis(Interface.X);
        public  double Y_Axis = IJoystickExtreme.getRawAxis(Interface.Y);
        public double Z_Axis = IJoystickExtreme.getRawAxis(Interface.Z);
    }

    public class Buttons{
        public boolean trigger = IJoystickExtreme.getRawButton(Interface.button1);
        //public boolean button2 = IJoystickExtreme.getRawButton(Interface.button2);

    }
}