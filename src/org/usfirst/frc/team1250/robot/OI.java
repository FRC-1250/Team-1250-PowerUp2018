/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import org.usfirst.frc.team1250.robot.commands.Cmd_ClawCollect;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleUnpinch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick Gamepad = new Joystick(0);

	JoystickButton x = new JoystickButton(Gamepad, 1);
	JoystickButton a = new JoystickButton(Gamepad, 2);
	JoystickButton b = new JoystickButton(Gamepad, 3);
	JoystickButton y = new JoystickButton(Gamepad, 4);
	JoystickButton lt = new JoystickButton(Gamepad, 6);
	JoystickButton rt = new JoystickButton(Gamepad, 5);
	JoystickButton lb = new JoystickButton(Gamepad, 7);
	JoystickButton rb = new JoystickButton(Gamepad, 8);
	
	
	public OI(){
		x.whenPressed(new Cmd_ClawCollect());
		a.whenPressed(new Cmd_EleUnpinch());
	}
	
	public Joystick getGamepad() {
		return Gamepad;
	}
	
}
