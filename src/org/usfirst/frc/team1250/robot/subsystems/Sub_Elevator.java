package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleManual;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class Sub_Elevator extends Subsystem {

	public WPI_TalonSRX eleMotor = new WPI_TalonSRX(RobotMap.ELE_MOTOR);
	private Solenoid eleSol = new Solenoid(RobotMap.ELE_PINCH_SOL);
	private Solenoid elePop = new Solenoid(RobotMap.ELE_POP_SOL);
	private DigitalInput eleLowSensor = new DigitalInput(RobotMap.ELE_LIMIT_SW);

	// In inches from ground
	public final int SCALE_POS = 50;
	public final int SWITCH_POS = 19;
	public final int HOME_POS = 15;
	public final double ELE_TICKS = 1157.06 / 9;
	public static int eleSetpoint;

	public Sub_Elevator() {
		eleSetpoint = (int) (ELE_TICKS * HOME_POS);
		eleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		eleMotor.configNominalOutputForward(0, 10);
		eleMotor.configNominalOutputReverse(0, 10);
		eleMotor.configPeakOutputForward(1, 10);
		eleMotor.configPeakOutputReverse(-1, 10);
		eleMotor.setNeutralMode(NeutralMode.Brake);
		eleMotor.config_kF(0, 0.0, 10);
		eleMotor.config_kP(0, 0.15, 10);
		eleMotor.config_kI(0, 0, 10);
		eleMotor.config_kD(0, 0, 10);
		eleMotor.set(ControlMode.Position, eleSetpoint);
		eleMotor.setSelectedSensorPosition(eleSetpoint, 0, 10);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Cmd_EleManual());
	}

	public void soloLiftPinch() {
		eleSol.set(true);
	}
	public void soloPop() {
		elePop.set(true);
	}
	public void soloLiftUnPinch() {
		eleSol.set(false);
	}

	public boolean checkSoloLift() {
		return eleSol.get();
	}

	public boolean getEleSensor() {
		return eleLowSensor.get();
	}

	public int getLiftPosInTicks() {
		return eleMotor.getSelectedSensorPosition(0);
	}

	public void setTicksToHome() {
		// Default Lift position is home
		eleSetpoint = (int) (HOME_POS * ELE_TICKS);
		eleMotor.setSelectedSensorPosition(eleSetpoint, 0, 10);
	}

	public void setLiftPosition(int pos) {
		eleSetpoint = (int) (ELE_TICKS * pos);
		eleMotor.set(ControlMode.Position, eleSetpoint);
	}

	public void setBump(int val) {
		eleSetpoint = (int) (val * 12 * ELE_TICKS + (getLiftPosInTicks()));
		eleMotor.set(ControlMode.Position, eleSetpoint);
	}
}
