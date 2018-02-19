package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleManual;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.commands.Cmd_Unpinch;
import org.usfirst.frc.team1250.robot.drive.Cmd_ManualDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class Sub_Elevator extends Subsystem {

	public WPI_TalonSRX eleMotor = new WPI_TalonSRX(RobotMap.ELE_MOTOR);
	private Solenoid eleSol = new Solenoid(RobotMap.ELE_CLAW_SOL);
	private Solenoid panSol = new Solenoid(RobotMap.ELE_PAN_SOL);
	private Solenoid popSol = new Solenoid(RobotMap.ELE_POP_SOL);

	private DigitalInput eleLowSensor = new DigitalInput(RobotMap.ELE_LIMIT_SW);

	// In inches from ground
	public final int SCALE_POS = 72;
	public final int SWITCH_POS = 23;
	public final double HOME_POS = 4.25;
	public final double ELE_TICKS = 31;
			
	public static int eleSetpoint;

	public Sub_Elevator() {
		eleSetpoint = (int)(ELE_TICKS * HOME_POS);
		eleMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);

		eleMotor.configNominalOutputForward(0, 10);
		eleMotor.configNominalOutputReverse(0, 10);
		eleMotor.configPeakOutputForward(.8, 10);
		eleMotor.configPeakOutputReverse(-.3, 10);
		eleMotor.setNeutralMode(NeutralMode.Brake);
		eleMotor.config_kF(0, 0.0, 10);
		eleMotor.config_kP(0, 1, 10);
		eleMotor.config_kI(0, .0001, 10);
		eleMotor.config_kD(0, 0, 10);
		eleMotor.config_IntegralZone(0, 0, 10);
		//eleMotor.set(ControlMode.Position,eleSetpoint);
		//eleMotor.setSelectedSensorPosition(eleSetpoint, 0, 10);
//		eleMotor.configClosedloopRamp(0, 10);
//		eleMotor.configAllowableClosedloopError(0, 0, 10);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Cmd_EleManual());
	}

	public void soloLiftPinch() {
		eleSol.set(true);
	}
	public void soloPop() {
		popSol.set(true);
	}
	public void eleUp() {
		eleMotor.set(ControlMode.PercentOutput,1);
		//eleMotor.setSelectedSensorPosition(eleMotor.getSelectedSensorPosition(0), 0, 10);
	}
	public void eleDown() {
		eleMotor.set(ControlMode.PercentOutput,-0.5);
		//eleMotor.setSelectedSensorPosition(eleMotor.getSelectedSensorPosition(0), 0, 10);
	}
	public void eleStop() {
		eleMotor.set(ControlMode.PercentOutput,0);
//		eleMotor.set(ControlMode.Position, eleMotor.getSelectedSensorPosition(0));
		//eleMotor.setSelectedSensorPosition(eleMotor.getSelectedSensorPosition(0), 0, 10);
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
	 public void soloPancakePop() {
			panSol.set(true);
		}
	
	 public void soloPancakeUnPop() {
			panSol.set(false);
		}
	 public void solPop() {
			popSol.set(true);
		}
	 public void solUnPop() {
			popSol.set(false);
		}


	public void setTicksToHome() {
		// Default Lift position is home
		eleSetpoint = (int) (HOME_POS * ELE_TICKS);
		eleMotor.setSelectedSensorPosition(eleSetpoint, 0, 10);
	}
	
	public void setLiftPosition(double pos) {
		eleSetpoint = (int)(ELE_TICKS * pos);
		eleMotor.set(ControlMode.Position,eleSetpoint);
	}	
	
	public void setBump(int val) {
		eleSetpoint = (int)(val * 24 * ELE_TICKS + (getLiftPosInTicks()));

		eleMotor.set(ControlMode.Position, eleSetpoint);
	}
}
