package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sub_ClimberLeft extends Subsystem {

	WPI_VictorSPX climberMotorLeft = new WPI_VictorSPX(RobotMap.CLB_LEFT);
	Servo climberServoLeft = new Servo(RobotMap.SRV_LEFT);
	
	public Sub_ClimberLeft() {
		
		climberMotorLeft.setNeutralMode(NeutralMode.Brake);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetServo() {
    	climberServoLeft.set(0.9);
	}
	
	public void toggleServo() {
		if (climberServoLeft.get() > 0.1)
			climberServoLeft.set(0.05);
		else
			climberServoLeft.set(0.9);
	}
	public void runMotorOut() {
		climberMotorLeft.set(0.5);
	}
	
	public void runMotorIn() {
		climberMotorLeft.set(-0.5);
	}
	
	public void stopMotor() {
		climberMotorLeft.set(0);
	}
    
}

