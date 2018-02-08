package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.usfirst.frc.team1250.robot.commands.Cmd_PassiveClawCollect;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Sub_Claw extends Subsystem {
	private WPI_VictorSPX LeftClaw = new WPI_VictorSPX(RobotMap.CLW_LEFT);
	private WPI_VictorSPX RightClaw = new WPI_VictorSPX(RobotMap.CLW_RIGHT);
	private Solenoid SolRight = new Solenoid(RobotMap.CLW_RIGHT_SOL);
	private Solenoid SolLeft = new Solenoid(RobotMap.CLW_LEFT_SOL);

	private DigitalInput LightSens = new DigitalInput(RobotMap.CLW_SENS_RIGHT);
	private DigitalInput LightSensTwo = new DigitalInput(RobotMap.CLW_SENS_LEFT);
	private DigitalInput FinalSens = new DigitalInput(RobotMap.CLW_SENS_LIFT);

	

public Sub_Claw() {


}
	public void collect() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	public void dump() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	public void leftCollect() {
		LeftClaw.set(.5);
	}
	public void rightCollect() {
		RightClaw.set(-.5);
	}
	public void stopleftCollect() {
		LeftClaw.set(0);
	}
	public void stoprightCollect() {
		RightClaw.set(0);
	}
	public void stop() {
		LeftClaw.set(0);
		RightClaw.set(0);	
	}
	public void pinch() {
		SolLeft.set(true);
		SolRight.set(true);
	}
	public void unpinch() {
		SolLeft.set(false);
		SolRight.set(false);
	}
	public boolean CheckSoloClaw() {
		return SolLeft.get();
	}
	public boolean isIn() {
		return FinalSens.get();
	}
	public boolean isSeenLeft() {
		return LightSens.get();
	}
	public boolean isSeenRight() {
		return LightSensTwo.get();
	}
	
		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new Cmd_PassiveClawCollect());
		}
}

