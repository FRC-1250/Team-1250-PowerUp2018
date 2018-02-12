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
	public static final int DRV_LEFT_MID    = 11;
	public static final int DRV_LEFT_BACK   = 12;
	public static final int DRV_RIGHT_FRONT = 25;
	public static final int DRV_RIGHT_MID   = 24;
	public static final int DRV_RIGHT_BACK  = 23;
	
	//Pneumatic Shifter Solenoid
	public static final int SOL_SHIFTER		=  0;
	
	// Intake Motor Control IDs
	public static final int INTAKE_RIGHT       = 21;
	public static final int INTAKE_LEFT        = 14;
	
	// Solenoids for Intake
	public static final int INTAKE_PINCH_SOL   = 1;
		
	// Sensors for Intake
	public static final int INTAKE_SENS_RIGHT  = 1;
	public static final int INTAKE_SENS_LEFT   = 0;
	public static final int INTAKE_SENS_FINAL  = 2;
	
	//Elevator Motor Control IDs
	public static final int ELE_MOTOR 		= 20;

	//Elevator Sensor Control IDs
	public static final int ELE_LIMIT_SW    = 3;

	//Elevator Solenoids
	public static final int ELE_POP_SOL 	= 4;
	public static final int ELE_PINCH_SOL    = 5;
	
	// Climber Motor Control IDs
	public static final int CLB_RIGHT		= 22;
	public static final int CLB_LEFT		= 13;
}
