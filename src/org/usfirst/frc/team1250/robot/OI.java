/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team1250.robot.drive.*;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHome;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.groups.CmdG_Herd;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakePinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeStop;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeToggle;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;
import org.usfirst.frc.team1250.robot.test.Cmd_IntakeTest;
import org.usfirst.frc.team1250.robot.test.deletethis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick Gamepad = new Joystick(0);
	Joystick Arcadepad = new Joystick(1);

	JoystickButton x = new JoystickButton(Gamepad, 1);
	JoystickButton a = new JoystickButton(Gamepad, 2);
	JoystickButton b = new JoystickButton(Gamepad, 3);
	JoystickButton y = new JoystickButton(Gamepad, 4);
	JoystickButton lt = new JoystickButton(Gamepad, 6);
	JoystickButton rt = new JoystickButton(Gamepad, 5);
	JoystickButton lb = new JoystickButton(Gamepad, 7);
	JoystickButton rb = new JoystickButton(Gamepad, 8);

	JoystickButton btn12 = new JoystickButton(Arcadepad, 12);
	JoystickButton btn11 = new JoystickButton(Arcadepad, 11);
	JoystickButton btn10 = new JoystickButton(Arcadepad, 10);
	JoystickButton btn9 = new JoystickButton(Arcadepad, 9);
	JoystickButton btn8 = new JoystickButton(Arcadepad, 8);
	JoystickButton btn7 = new JoystickButton(Arcadepad, 7);
	JoystickButton btn6 = new JoystickButton(Arcadepad, 6);
	JoystickButton btn5 = new JoystickButton(Arcadepad, 5);
	JoystickButton btn4 = new JoystickButton(Arcadepad, 4);
	JoystickButton btn3 = new JoystickButton(Arcadepad, 3);

	public OI() {
		// Drivers controller
		x.whenPressed(new deletethis());
		a.whenPressed(new Cmd_EleHome());
		b.whenPressed(new Cmd_EleSwitch());
		y.whenPressed(new Cmd_EleHigh());
		lb.whenPressed(new Cmd_EleUnpinch());
		rb.whenPressed(new Cmd_AutoDrive(25));	

		// OPs controller
		// btn11.whenInactive(new CmdG_TimedCollect());
		btn10.whenInactive(new Cmd_ElePinch());
		btn9.whenInactive(new Cmd_EleUnpinch());
		// btn8.whenInactive(new CmdG_Herd());
		btn7.whenInactive(new Cmd_IntakeStop());
		btn6.whenInactive(new Cmd_IntakeTest());
		btn3.whenInactive(new Cmd_IntakePinch());
		btn4.whenInactive(new Cmd_IntakeUnPinch());
	}

	public boolean getButtonState(int btn) {
		return Gamepad.getRawButton(btn);
	}

	public Joystick getGamepad() {
		return Gamepad;
	}

	public Joystick getArcadepad() {
		return Arcadepad;
	}

}
