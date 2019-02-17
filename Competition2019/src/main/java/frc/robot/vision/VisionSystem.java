package frc.robot.vision;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.VisionAlignTarget;

public class VisionSystem extends Subsystem {
  NetworkTableEntry contours;

  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("Contours");

  private final Object imgLock = new Object();
	private final VisionThread visionFind;
	public double centerX;
	public boolean current;
	public static boolean targetFound;
  private Rect r;
  private Rect r2;
	public double alignRate;
	public static double rate;
	
	private int WIDTH = 320;
	public double widthInches;
	public static double distance;
	public static double angle;
	private double alpha = 0.70;
	public static double previousAngle1 = 0;
	public static double outputAngle;
	
	public double lowPassFiltering(double rawAngle, double previousAngle) {
		
		
		double angle = previousAngle * alpha + rawAngle * (1 - alpha);
		double output = angle + 90;
    return output;
  }

  public VisionSystem() {
  visionFind = new VisionThread(Robot.m_camera.getUsbCameraDown(), new VisionPipelineGenerated(), pipeline -> {
    if (!pipeline.filterContoursOutput().isEmpty()) {
      r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
      r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
      synchronized (imgLock) {
        
        //centerX = r.x + (r.width / 2);
        //rate = (centerX - (RobotMap.Vision.IMG_WIDTH))
        
        double halfWidth1 = (double) r.width / 2.0;
        double halfWidth = (double) r2.width/ 2.0;
    
        //rate = (((double) r.x - halfWidth) / halfWidth);

        double pos = ((double) r.x - halfWidth);
        angle = (pos - (WIDTH/2)) * 1.96;
        
        outputAngle = lowPassFiltering(angle, previousAngle1);
        previousAngle1 = outputAngle;
        
        SmartDashboard.putNumber("Angle Out", outputAngle);		
        
      } 
    } 
  });
  }
  


  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new VisionAlignTarget());
  }
}
