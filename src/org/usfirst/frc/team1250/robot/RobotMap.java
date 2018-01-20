/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Drive Train Motor Control IDs
	public static final int Drv_LEFT_FRONT  = 10;
	public static final int Drv_LEFT_MID    = 12;
	public static final int Drv_LEFT_BACK   = 14;
	public static final int Drv_RIGHT_FRONT = 11;
	public static final int Drv_RIGHT_MID   = 13;
	public static final int Drv_RIGHT_BACK  = 15;
	
	// Elevator Motor Control IDs
	public static final int Elv_RIGHT       = 21;
	public static final int Elv_LEFT        = 20;
	
	// Claw Motor Control IDs
	public static final int Clw_RIGHT       = 31;
	public static final int Clw_LEFT        = 30;
	
	// Climber Motor Control IDs
	public static final int Clb__RIGHT		= 41;
	public static final int Clb__LEFT		= 40;
}
