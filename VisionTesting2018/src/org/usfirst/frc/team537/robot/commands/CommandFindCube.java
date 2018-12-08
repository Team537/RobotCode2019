package org.usfirst.frc.team537.robot.commands;

import org.usfirst.frc.team537.robot.Robot;
import org.usfirst.frc.team537.robot.RobotMap;
import org.usfirst.frc.team537.robot.subsystems.SubsystemDrive;
import org.usfirst.frc.team537.robot.subsystems.SubsystemGyro;
import org.usfirst.frc.team537.robot.subsystems.SwerveModule;
import org.usfirst.frc.team537.robot.vision.NewVision;
import org.usfirst.frc.team537.robot.vision.NewestVision;
import org.usfirst.frc.team537.robot.vision.Vision;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class CommandFindCube extends Command {

	private final Object imgLock = new Object();
	private final VisionThread visionFind;
	public double centerX;
	public boolean current;
	public static boolean targetFound;
	private Rect r;
	public double alignRate;
	public static double rate;
	
    public CommandFindCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.subsystemDrive);
    	
    	visionFind = new VisionThread(Robot.subsystemCamera.getUsbCamera(), new NewVision(), pipeline -> {
    		if (!pipeline.filterContoursOutput().isEmpty()) {
    			r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
    			synchronized (imgLock) {
    				/*
    				centerX = r.x + (r.width / 2);
    				rate = (centerX - (RobotMap.Vision.IMG_WIDTH / 2)) / 2;
    				*/
    				
    				double halfWidth = (double) r.width / 2.0;
    				rate = (((double) r.x - halfWidth) / halfWidth) / 2;
    				if(rate > 0.60) {
    					targetFound = true;
    				} else {
    					targetFound = false;
    				}
    			} 
    		} else {
				rate = 0.250;
			}
    	});
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	visionFind.start();
    	Robot.subsystemDrive.reset();
    	Robot.subsystemDrive.setMode(SwerveModule.SwerveMode.ModeSpeed);
    	//Robot.subsystemDrive.setTarget(Robot.subsystemGyro.getAngle(),0.00, 0.00, 0.00);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.subsystemDrive.setTarget(0.00, rate, 0.0f, 0.0f);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	visionFind.stop();
    	Robot.subsystemDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.subsystemDrive.stop();
    }
}
