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
import edu.wpi.first.wpilibj.Servo;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Sub_Climber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	WPI_TalonSRX climberMotor = new WPI_TalonSRX(RobotMap.CLB_RIGHT);
	Servo climberServo = new Servo(0);
	
	public Sub_Climber() {
		climberMotor.setNeutralMode(NeutralMode.Brake);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void resetServo() {
		climberServo.set(0.9);
	}
	
	public void toggleServo() {
		if (climberServo.get() > 0.1)
			climberServo.set(0.05);
		else
			climberServo.set(0.9);
	}
	public void runMotorOut() {
		climberMotor.set(0.5);
	}
	
	public void runMotorIn() {
		climberMotor.set(-0.5);
	}
	
	public void stopMotor() {
		climberMotor.set(0);
	}
}
