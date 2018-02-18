package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Sub_Intake extends Subsystem {
	private WPI_VictorSPX leftClaw = new WPI_VictorSPX(RobotMap.CLW_LEFT);
	private WPI_VictorSPX rightClaw = new WPI_VictorSPX(RobotMap.CLW_RIGHT);
	private Solenoid intakeSol = new Solenoid(RobotMap.INTAKE_PINCH_SOL);

	private DigitalInput lightSens = new DigitalInput(RobotMap.INTAKE_SENS_RIGHT);
	private DigitalInput lightSensTwo = new DigitalInput(RobotMap.INTAKE_SENS_LEFT);
	private DigitalInput finalSens = new DigitalInput(RobotMap.INTAKE_SENS_FINAL);

	

public Sub_Intake() {


}
	public void collect() {
		leftClaw.set(-1);
		rightClaw.set(-1);
	}
	public void dump() {
		leftClaw.set(1);
		rightClaw.set(1);
	}
	public void dumpslow() {
		leftClaw.set(.5);
		rightClaw.set(.5);
	}
	public void leftCollect() {
		leftClaw.set(.5);
	}
	public void rightCollect() {
		rightClaw.set(.5);
	}
	public void stopleftCollect() {
		leftClaw.set(0);
	}
	public void stoprightCollect() {
		rightClaw.set(0);
	}
	public void stop() {
		leftClaw.set(0);
		rightClaw.set(0);	
	}
	public void pinch() {
	
		intakeSol.set(true);
	}
	public void unpinch() {
		
		intakeSol.set(false);
	}
	public boolean CheckSoloClaw() {
		return intakeSol.get();
	}
	public boolean isIn() {
		return finalSens.get();
	}
	public boolean isSeenLeft() {
		return lightSens.get();
	}
	public boolean isSeenRight() {
		return lightSensTwo.get();
	}
	
		@Override
		protected void initDefaultCommand() {
//			setDefaultCommand(new Cmd_PassiveClawCollect());
		}
}

