package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CollectorTilt;

public class Collector extends Subsystem {

    private Compressor m_compressor = new Compressor(0);
    
    private Solenoid m_tilt1 = new Solenoid(1);
    private Solenoid m_titl2 = new Solenoid(2);
    private Solenoid m_tilt3 = new Solenoid(3);

    private WPI_TalonSRX m_intake = new WPI_TalonSRX(RobotMap.CAN.COLLECTOR_INTAKE);
    private DigitalInput m_collectLimit = new DigitalInput(RobotMap.DIO.COLLECTOR_LIMIT);

    public void intake(double intakeSpeed) {
        boolean ballIn = m_collectLimit.get();

        if(ballIn) {
            m_intake.set(ControlMode.PercentOutput, 0.00);
        } 
        else { 
            m_intake.set(ControlMode.PercentOutput, intakeSpeed);
        }
    }

    public void startCompressor() {
        m_compressor.start();
    }

    public void tilt(){
        m_tilt1.set(true);
        m_titl2.set(true);
        m_tilt3.set(true);
    }

    public void disable() {
        m_tilt1.set(false);
        m_titl2.set(false);
        m_tilt3.set(false);
        m_intake.set(ControlMode.PercentOutput, 0.00);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new CollectorTilt());
    }

}
