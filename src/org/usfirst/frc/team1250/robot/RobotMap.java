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

	
	// Drive Train Motor Control IDs
	public static final int DRV_LEFT_FRONT  = 10;
	public static final int DRV_LEFT_MID    = 12;
	public static final int DRV_LEFT_BACK   = 14;
	public static final int DRV_RIGHT_FRONT = 11;
	public static final int DRV_RIGHT_MID   = 13;
	public static final int DRV_RIGHT_BACK  = 15;
	
	// Elevator Motor Control IDs
	public static final int ELV_RIGHT       = 21;
	public static final int ELV_LEFT        = 20;
	
	// Claw Motor Control IDs
	public static final int CLW_RIGHT       = 31;
	public static final int CLW_LEFT        = 30;
	
	// Climber Motor Control IDs
	public static final int CLB_RIGHT		= 41;
	public static final int CLB_LEFT		= 40;
	
	//Pneumatic Shifter Solenoid
	public static final int SOL_SHIFTER		=  0;
}
