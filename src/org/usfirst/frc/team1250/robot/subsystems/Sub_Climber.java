/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Servo;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Sub_Climber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	WPI_VictorSPX climberMotorRight = new WPI_VictorSPX(RobotMap.CLB_RIGHT);
	WPI_VictorSPX climberMotorLeft = new WPI_VictorSPX(RobotMap.CLB_LEFT);
	Servo climberServoRight = new Servo(RobotMap.SRV_RIGHT);
	Servo climberServoLeft = new Servo(RobotMap.SRV_LEFT);
	
	public Sub_Climber() {
		climberMotorRight.setNeutralMode(NeutralMode.Brake);
		climberMotorLeft.setNeutralMode(NeutralMode.Brake);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void resetServo() {
		climberServoRight.set(0.9);
	}
	
	public void toggleServo() {
		if (climberServoRight.get() > 0.1)
			climberServoRight.set(0.05);
		else
			climberServoRight.set(0.9);
	}
	public void runMotorOut() {
		climberMotorRight.set(0.5);
	}
	
	public void runMotorIn() {
		climberMotorRight.set(-0.5);
	}
	
	public void stopMotor() {
		climberMotorRight.set(0);
	}
}
