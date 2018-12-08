package org.usfirst.frc.team537.robot.subsystems;

import org.usfirst.frc.team537.robot.Robot;
import org.usfirst.frc.team537.robot.RobotMap;
import org.usfirst.frc.team537.robot.RobotMap.Camera;
import org.usfirst.frc.team537.robot.vision.NewVision;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SubsystemCamera extends Subsystem {
	private UsbCamera usbCamera;
	private CvSink contours;
	
	public SubsystemCamera() {
		setName("Camera");
		usbCamera = CameraServer.getInstance().startAutomaticCapture("CAM", 0);
		usbCamera.setResolution(320, 240);
		usbCamera.setFPS(30);
		
		usbCamera.setBrightness(RobotMap.Camera.BRIGHTNESS);
		usbCamera.setExposureManual(RobotMap.Camera.EXPOSURE);
		
		
		NewVision vision = new NewVision();
		vision.filterContoursOutput();
		
		contours = CameraServer.getInstance().getVideo(getUsbCamera());
		
	}
	
	public UsbCamera getUsbCamera() {
		return usbCamera;
	}

	@Override
	protected void initDefaultCommand() {
		
		
	}
}
