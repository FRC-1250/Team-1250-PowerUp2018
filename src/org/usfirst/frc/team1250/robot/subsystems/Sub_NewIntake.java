package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sub_NewIntake extends Subsystem {

	private WPI_VictorSPX leftClaw = new WPI_VictorSPX(RobotMap.CLW_LEFT);
	private WPI_VictorSPX rightClaw = new WPI_VictorSPX(RobotMap.CLW_RIGHT);
	
	private DigitalInput backSensor = new DigitalInput(RobotMap.INTAKE_SENS_FINAL);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setIntakeSpeed(double speed) {
		leftClaw.set(speed);
		rightClaw.set(speed);
	}
    
	public void stop() {

		leftClaw.set(0);
		rightClaw.set(0);	

	}
	
	public boolean getSensorValue() {
		return backSensor.get();
	}
    
	
    
}

