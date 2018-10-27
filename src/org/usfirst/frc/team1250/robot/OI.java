/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team1250.robot.NewIntake.CmdG_TestRoutine;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpit;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpitSlow;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeStop;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_LowIn;
import org.usfirst.frc.team1250.robot.commands.*;
import org.usfirst.frc.team1250.robot.drive.*;
import org.usfirst.frc.team1250.robot.elevator.CmdG_Dropper;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import edu.wpi.first.wpilibj.buttons.JoystickButton;;

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
		lb.whenPressed(new Cmd_IntakeSpit(1));	
		y.whenPressed(new Cmd_AutoTurn(180 , 1 , 1));
		rb.whenPressed(new Cmd_IntakeSpitSlow(1));	
		b.whileHeld(new Cmd_ClimbUp());
		a.whileHeld(new Cmd_ClimbExtend());
		x.whileHeld(new Cmd_ClimbStop());
		 
		//OPs controller
		
		btn12.whenInactive(new CmdG_TestRoutine());
		btn11.whenInactive(new Cmd_LowIn());
//		btn12.whenInactive(new Cmd_IntakeTest());
//		btn11.whenInactive(new CmdG_FullCollect());
		btn10.whenInactive(new Cmd_IntakeStop());	
		//btn9.whenInactive(new Cmd_RetractLeftMotor());
	    btn8.whenInactive(new Cmd_ClimbUp());
//		btn7.whenInactive(new Cmd_ClimbExtend());
//		btn7.whileHeld(new Cmd_ClimbExtend());
//		btn6.whenInactive(new Cmd_IntakePinch());
		btn5.whenInactive(new Cmd_EleUnpinch());	
		btn4.whenInactive(new Cmd_Popper(.5));
		btn3.whenInactive(new Cmd_TimedEleUp(1.8));
//		btn4.whenInactive(new Cmd_EleHigh());
		//btn2.whenInactive(new Cmd_ToggleLeftServo());	





// Auto Buttons for Testing
		
		
//		b.whenPressed(new CmdG_LeftSwitch());
//		a.whenPressed(new Cmd_AutoTurn(-45 , .5,.3));
		//x.whenPressed(new CmdG_StriaghtScale(1));
//		y.whenPressed(new CmdG_ScaleWhip());
//		rb.whenPressed(new Cmd_AutoDrive(25));	


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
	
	
	public boolean getArcadePadButton(int btn) {
		return Arcadepad.getRawButton(btn);
	}
	
}
