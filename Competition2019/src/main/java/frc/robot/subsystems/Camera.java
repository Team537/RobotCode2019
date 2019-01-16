package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Camera extends Subsystem {
  public UsbCamera m_targetCam;

  public Camera() {
    setName("Target Cam");
    m_targetCam = CameraServer.getInstance().startAutomaticCapture(RobotMap.VISION.TARGET_CAM_PORT);

    m_targetCam.setResolution(RobotMap.VISION.TARGET_CAM_WIDTH, RobotMap.VISION.TARGET_CAM_HEIGHT);
    m_targetCam.setFPS(30);
  }

  public UsbCamera getUsbCamera() {
    return m_targetCam;
  }

  @Override
  public void initDefaultCommand() {
  }
}
