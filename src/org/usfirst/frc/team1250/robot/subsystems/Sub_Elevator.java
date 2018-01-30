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
	public boolean CheckSoloLift() {
		return liftSol.get();
	}
	public void LiftTop() {
		double liftTop = 1157.06 * 81;
		eleMotor.set(ControlMode.Position, liftTop);
		SmartDashboard.putNumber("test", eleMotor.getSelectedSensorPosition(0));
	}
	public void LiftSwitch() {
		double liftSwitch = 1157.06 * 19;
		eleMotor.set(ControlMode.Position, liftSwitch);
	}
	public void LiftHome() {
		eleMotor.set(ControlMode.Position, -1);
		SmartDashboard.putNumber("test", eleMotor.getSelectedSensorPosition(0));
	}
	public double GetLiftPos() {
		return eleMotor.getSelectedSensorPosition(0);
	}
    
    
}

