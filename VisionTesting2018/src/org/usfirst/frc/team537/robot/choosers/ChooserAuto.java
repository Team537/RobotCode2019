package org.usfirst.frc.team537.robot.choosers;

import org.usfirst.frc.team537.robot.autos.AutoCross;
import org.usfirst.frc.team537.robot.autos.AutoSwitch;
import org.usfirst.frc.team537.robot.autos.AutoTesting;
import org.usfirst.frc.team537.robot.autos.AutoVision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChooserAuto {
	private SendableChooser<String> modeChooser;
	private SendableChooser<Integer> locationChooser;
	private SendableChooser<Double> delayChooser;
	
	public ChooserAuto() {
		modeChooser = new SendableChooser<>();
		modeChooser.addObject("Cross Forward", "CF");
		modeChooser.addObject("Cross Reversed", "CR");
		modeChooser.addObject("Switch Forward", "SF");
		modeChooser.addDefault("Switch Reversed", "SR");
		modeChooser.addObject("Testing", "ZF");
		modeChooser.addObject("Vision", "VV");
		modeChooser.addObject("None", "NF");
		SmartDashboard.putData("Auto-Mode", modeChooser);
		
		locationChooser = new SendableChooser<>();
		locationChooser.addObject("Left", 1);
		locationChooser.addDefault("Center", 2);
		locationChooser.addObject("Right", 3);
		SmartDashboard.putData("Auto-Location", locationChooser);

		delayChooser = new SendableChooser<>();
		delayChooser.addDefault("0.0s", 0.0);
		delayChooser.addObject("1.0s", 1.0);
		delayChooser.addObject("2.0s", 2.0);
		delayChooser.addObject("3.0s", 3.0);
		delayChooser.addObject("4.0s", 4.0);
		SmartDashboard.putData("Auto-Delay", delayChooser);
	}

	private String fixSelected(String string, String normal) {
		if (string == null || string.isEmpty()) {
			DriverStation.reportError("Invalid chooser string: " + string, false);
			return normal;
		}
		
		return string;
	}

	public Command getSelected() {
		int location = locationChooser.getSelected();
		String mode = fixSelected(modeChooser.getSelected(), "CR").toUpperCase();
		double delay = delayChooser.getSelected();
		
	//	Alliance alliance = DriverStation.getInstance().getAlliance();
		String gameData = fixSelected(DriverStation.getInstance().getGameSpecificMessage(), "RRR").toUpperCase();
		boolean isSwitchLeft = gameData.charAt(0) == 'L';
		
		boolean reversed = mode.charAt(1) == 'R';

		DriverStation.reportWarning("Chooser location: " + location, false);
		DriverStation.reportWarning("Chooser switch left: " + isSwitchLeft, false);
		DriverStation.reportWarning("Chooser mode-reversed: " + reversed, false);
		DriverStation.reportWarning("Chooser mode: " + mode.charAt(0), false);

		if (mode.charAt(0) == 'C') {
			return new AutoCross(location, isSwitchLeft, delay, reversed);
		} else if (mode.charAt(0) == 'S') {
			return new AutoSwitch(location, isSwitchLeft, delay, reversed);
		} else if (mode.charAt(0) == 'Z') {
			return new AutoTesting();
		} else if (mode.charAt(0) == 'V') {
			return new AutoVision();
		}
		
		return null;
	}
}
