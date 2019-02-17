package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Camera extends Subsystem {
  public UsbCamera m_upCam;
  public UsbCamera m_downCam;

  public Camera() {
    setName("Target Cam");
    m_upCam = CameraServer.getInstance().startAutomaticCapture(RobotMap.VISION.UP_CAM_PORT);
    m_downCam = CameraServer.getInstance().startAutomaticCapture(RobotMap.VISION.DOWN_CAM_PORT);
    m_upCam.setResolution(RobotMap.VISION.UP_CAM_WIDTH, RobotMap.VISION.UP_CAM_HEIGHT);
    m_upCam.setFPS(30);
  }

  public UsbCamera getUsbCameraUp() {
    return m_upCam;
  }

  public UsbCamera getUsbCameraDown() {
    return m_downCam;
  }

  @Override
  public void initDefaultCommand() {
  }
}
