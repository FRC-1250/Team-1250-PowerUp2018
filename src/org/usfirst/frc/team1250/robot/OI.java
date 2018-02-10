/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team1250.robot.commandGroups.CmdG_FullCollect;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_Herd;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeStop;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeToggle;
import org.usfirst.frc.team1250.robot.commands.*;

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
	
	
	
	public OI(){
		//Drivers controller
		x.whenPressed(new Cmd_ElePinch());		
		a.whenPressed(new Cmd_EleHome());
		b.whenPressed(new Cmd_EleSwitch());
		y.whenPressed(new Cmd_EleHigh());
		
		//OPs controller
		
		btn12.whenInactive(new Cmd_EleHome());;
		btn11.whenInactive(new Cmd_EleSwitch());
		btn10.whenInactive(new Cmd_EleHigh());
		btn9.whenInactive(new CmdG_FullCollect());	
		btn8.whenInactive(new CmdG_Herd());

		
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
