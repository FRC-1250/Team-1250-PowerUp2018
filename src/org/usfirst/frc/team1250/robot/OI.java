/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team1250.robot.commandGroups.CmdG_AutoLeft;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_Droper;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_FullCollect;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_AutonSwitch;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_ScaleWhip;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_StriaghtScale;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_TimedCollect;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeSpitFast;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeSpit;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeCollectTimed;
import org.usfirst.frc.team1250.robot.commands.*;
import org.usfirst.frc.team1250.robot.drive.*;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHome;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakePinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeStop;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeToggle;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;
import org.usfirst.frc.team1250.robot.test.Cmd_IntakeTest;
import org.usfirst.frc.team1250.robot.test.deletethis;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;;

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

	JoystickButton lb = new JoystickButton(Gamepad, 5);
	JoystickButton rb = new JoystickButton(Gamepad, 6);
	JoystickButton lt = new JoystickButton(Gamepad, 7);
	JoystickButton rt = new JoystickButton(Gamepad, 8);

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
	JoystickButton btn2 = new JoystickButton(Arcadepad, 2);

	

	public OI() {
		// Drivers controller
		lb.whenPressed(new CmdG_Droper());
		 
		//OPs controller
		
		
		btn12.whenInactive(new Cmd_IntakeTest());
		btn11.whenInactive(new CmdG_FullCollect());
		//btn10.whenInactive(new CmdG_Droper());	
		btn9.whenInactive(new Cmd_IntakeSpit(1));
		btn8.whenInactive(new Cmd_IntakeSpitFast(1));
		btn7.whenInactive(new Cmd_IntakeUnPinch());
		btn6.whenInactive(new Cmd_IntakePinch());
		btn5.whenInactive(new Cmd_EleUnpinch());	
		btn4.whenInactive(new Cmd_Popper(.5));
		btn3.whenInactive(new Cmd_EleHigh());
//		btn4.whenInactive(new Cmd_EleHigh());
//		btn3.whenInactive(new Cmd_EleSwitch());
		btn2.whenInactive(new Cmd_EleHome());	



		


// Auto Buttons for Testing
		
		y.whenPressed(new Cmd_AutoTurn(180 , 1 , 1));
		x.whenPressed(new CmdG_StriaghtScale(1));
//		b.whenPressed(new CmdG_LeftSwitch());
//		a.whenPressed(new Cmd_AutoTurn(-45 , .5,.3));
//		y.whenPressed(new CmdG_ScaleWhip());
//		rb.whenPressed(new Cmd_AutoDrive(25));	
//
//		// OPs controller
//		// btn11.whenInactive(new CmdG_TimedCollect());
//		btn10.whenInactive(new Cmd_ElePinch());
//		btn9.whenInactive(new Cmd_EleUnpinch());
//		// btn8.whenInactive(new CmdG_Herd());
//		btn7.whenInactive(new Cmd_IntakeStop());
//		btn6.whenInactive(new Cmd_IntakeTest());
//		btn3.whenInactive(new Cmd_IntakePinch());
//		btn4.whenInactive(new Cmd_IntakeUnPinch());

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
