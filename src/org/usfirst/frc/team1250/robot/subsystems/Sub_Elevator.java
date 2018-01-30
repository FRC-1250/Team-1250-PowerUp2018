package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sub_Elevator extends Subsystem {

	private WPI_TalonSRX eleMotor = new WPI_TalonSRX(RobotMap.ELE_MOTOR);
	private Solenoid liftSol = new Solenoid(RobotMap.CLW_LIFT_SOL);
	
	// In inches from ground
	public final int SCALE_POS = 81;
	public final int SWITCH_POS = 19;
	
	public final double  ELE_TICKS = 1157.06;
	
	public Sub_Elevator() {
		
		eleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,
				10);
		eleMotor.configNominalOutputForward(0, 10);
		eleMotor.configNominalOutputReverse(0, 10);
		eleMotor.configPeakOutputForward(1, 10);
		eleMotor.configPeakOutputReverse(-1, 10);
		
		eleMotor.config_kF(0, 0.0, 10);
		eleMotor.config_kP(0, 0.1, 10);
		eleMotor.config_kI(0, 0, 10);
		eleMotor.config_kD(0, 0, 10);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void soloLiftPinch() {
		liftSol.set(true);
	}
	public void soloLiftUnPinch() {
		liftSol.set(false);
	}
	public boolean checkSoloLift() {
		return liftSol.get();
	}
	
	public void LiftHome() {
		eleMotor.set(ControlMode.Position, -1);
		SmartDashboard.putNumber("test", eleMotor.getSelectedSensorPosition(0));
	}
	
	public double GetLiftPos() {
		return eleMotor.getSelectedSensorPosition(0);
	}
	
	public void setLiftPosition(int pos) {
		double liftPos = ELE_TICKS * pos;
		eleMotor.set(ControlMode.Position,liftPos);
		this.log();
	}
	
	// Default lift position is home
	public void setLiftPosition() {
		eleMotor.set(ControlMode.Position, -1);
		this.log();
	}
	
	private void log() {
		SmartDashboard.putNumber("test", eleMotor.getSelectedSensorPosition(0));
	}
    
    
}

