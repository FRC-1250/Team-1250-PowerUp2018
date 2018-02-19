package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc.team1250.robot.drive.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogGyro;


import com.kauailabs.navx.frc.AHRS;


/**
 *
 */
public class Sub_DriveTrain extends Subsystem {
	
	// Motor Controllers
	WPI_TalonSRX fLeftMotor = new WPI_TalonSRX(RobotMap.DRV_LEFT_FRONT);
	WPI_VictorSPX bLeftMotor = new WPI_VictorSPX(RobotMap.DRV_LEFT_BACK);
	WPI_VictorSPX mLeftMotor = new WPI_VictorSPX(RobotMap.DRV_LEFT_MID);
	WPI_VictorSPX bRightMotor = new WPI_VictorSPX(RobotMap.DRV_RIGHT_BACK);
	WPI_TalonSRX fRightMotor = new WPI_TalonSRX(RobotMap.DRV_RIGHT_FRONT);
	WPI_VictorSPX mRightMotor = new WPI_VictorSPX(RobotMap.DRV_RIGHT_MID);
	

	// Motor Control groups
	private SpeedController gLeftMotor = new SpeedControllerGroup(fLeftMotor, bLeftMotor, mLeftMotor);
	private SpeedController gRightMotor = new SpeedControllerGroup(fRightMotor, bRightMotor, mRightMotor);
	private DifferentialDrive diffDriveGroup = new DifferentialDrive(gLeftMotor, gRightMotor);



	// Shift variables
	private final double THRESH_RPM_HI = 1500;
	private final double THRESH_RPM_LO = 1000;
	private final double SHIFTER_TIMEOUT = 1;

	
	//Constants for Closed Loop Feedback
	public static double accumError = 0;
	private final double AUTO_TURN_RATE = 0.3;
	private final double KP_SIMPLE_STRAIT = 0.01;
	private final double KP_SIMPLE = 0.05;
	private final double KI_SIMPLE = 0.03;
	
//	AHRS gyro = new AHRS(SPI.Port.kMXP);	
	AnalogGyro gyro = new AnalogGyro(RobotMap.GYRO);
	
	public int driveSetpoint = 0;
	private final double DRIVE_TICKS = 325.94;
	double WHEELBASE_RADIUS = 23 / 2;

	public Sub_DriveTrain() {
		fLeftMotor.setInverted(true);
		fRightMotor.setInverted(true);
		fLeftMotor.configOpenloopRamp(0.1, 10);
		mLeftMotor.configOpenloopRamp(0.1, 10);
		bLeftMotor.configOpenloopRamp(0.1, 10);
		fRightMotor.configOpenloopRamp(0.1, 10);
		mRightMotor.configOpenloopRamp(0.1, 10);
		bRightMotor.configOpenloopRamp(0.1, 10);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Cmd_ManualDrive());
	}

	public void drive(double left, double right) {
		diffDriveGroup.tankDrive(left, right);
	}

	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getThrottle());
	}

	public boolean getState(Joystick joy, boolean state) {

		double leftJoy = 0;
		double rightJoy = 0;

		// Button OverRide for shifting low
		if (Robot.m_oi.getButtonState(8)) {
			return false;
		}

		leftJoy = -joy.getY();
		rightJoy = -joy.getThrottle();

		if (Robot.robotTimer.get() > SHIFTER_TIMEOUT && state == false) {
			if ((int) Math.signum(leftJoy) != (int) Math.signum(rightJoy)) {
				state = false;
			} else if (Math.abs(fLeftMotor.getSelectedSensorVelocity(0)) > THRESH_RPM_HI
					&& Math.abs(fRightMotor.getSelectedSensorVelocity(0)) > THRESH_RPM_HI) {
				state = true;
			}
			Robot.robotTimer.reset();
		} else {
			if (Math.abs(fLeftMotor.getSelectedSensorVelocity(0)) < THRESH_RPM_LO
					|| Math.abs(fRightMotor.getSelectedSensorVelocity(0)) < THRESH_RPM_LO) {
				state = false;
			}
		}
		return state;	
    }
    
    public void pause() {
    	drive(0,0);
    }
    
 public double ticksToInches(int ticks) {
    	
    	return ticks/(double)DRIVE_TICKS;
    }
    
    public int inchesToTicks(double inches) {
    	return (int)(inches*DRIVE_TICKS);
    }
    
//    public void driveToPos() {
//    	
//    	double offset = getGainP(0,this.getGyroAngle(),KP_SIMPLE_STRAIT);
//    	
//    	int sign = (int) Math.signum(driveSetpoint);
//    	
//    	if((Math.abs(driveSetpoint) - Math.abs(getRightSideSensorPosInTicks())) / Math.abs(driveSetpoint) < 0.25)
//    		diffDriveGroup.arcadeDrive(0.2 * sign, 0);
//    	else
//    		diffDriveGroup.arcadeDrive(0.8 * sign, 0);
////    	diffDriveGroup.arcadeDrive(0.8 * sign, 0 + offset);
//    }
 public void driveToPos( double upperSpeed, double lowerSpeed) {
    	
    	
		
    	
    	double offset = getGainP(0,this.getGyroAngle(),KP_SIMPLE_STRAIT);
    	
    	double sign = Math.signum(driveSetpoint);
    	
    	diffDriveGroup.arcadeDrive(linearRamp(upperSpeed,lowerSpeed) * sign, 0 + offset);
    	
    }
    
    private double linearRamp( double upperSpeed, double lowerSpeed) {
    	double diff = (driveSetpoint - (double)Math.abs(getRightSideSensorPosInTicks()));
    	double corrected = .005 * diff;
    	double upperBound = Math.min(upperSpeed , corrected);
    	double lowerBound = Math.max(lowerSpeed , upperBound);
    	
    	SmartDashboard.putNumber("correctedoutput", corrected);
    	return lowerBound;
    	
    			
//    	if (percentDiff > .2) {
//    		return .9;
//    	}
//    	else if ();
//    		return .5;
//    	else
    }
    
    public void setSetpointPos(int distance) {
    	driveSetpoint = (int)DRIVE_TICKS * distance;
    }
    
    public void turn (double angle, double upperSpeed, double lowerSpeed) {
//    	double rotation = AUTO_TURN_RATE * getGainPI(angle,this.getGyroAngle(),KP_SIMPLE, KI_SIMPLE);
    	//rotation  = rotation * (int)Math.signum(angle);
    	double corrected;
		//double upperBound; 
		// double lowerBound;
    	
		double rotation = angle - getGyroAngle();
//    	int sign = (int)Math.signum(getGyroAngle());
    	double sign = Math.signum(rotation);
    	
		corrected = 0.005 * rotation;
    	
    	if (sign > 0){
    		 corrected = Math.min(upperSpeed * sign, corrected);
    		 corrected = Math.max(lowerSpeed * sign, corrected);
    	}
    		
    	else {
    		 corrected = Math.max(upperSpeed * sign, corrected);
			 corrected = Math.min(lowerSpeed * sign, corrected);    	    		
    	}

    	diffDriveGroup.arcadeDrive(0, corrected);
    }
    
    public double getGyroAngle() {
    	return gyro.getAngle();
    }
    
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public int getLeftSideSensorPosInTicks() {
    	return fLeftMotor.getSelectedSensorPosition(0);
    }
    
    public int getRightSideSensorPosInTicks() {
    	return fRightMotor.getSelectedSensorPosition(0);
    }
    
    public double getLeftSideSensorPosInInches() {
    	return ticksToInches(getLeftSideSensorPosInTicks());
    }
    
    public double getRightSideSensorPosInInches() {
    	return ticksToInches(getRightSideSensorPosInTicks());
    }
    
    public void resetSensorPos() {
    	fRightMotor.setSelectedSensorPosition(0, 0, 10);
    	fLeftMotor.setSelectedSensorPosition(0, 0, 10);
    }
    
    public boolean isDoneDriving() {
    	return ((Math.abs(this.getRightSideSensorPosInTicks()) - driveSetpoint) >= 0);
    }
    	
    public boolean isDoneTurning(double angle) {
    	return (Math.abs(angle - this.getGyroAngle()) < 2);
    }
    
    private double getGainP(double setpoint, double current, double kP) {
    	
    	double error = setpoint - current;  		
    	return KP_SIMPLE * error;
    }
    
    private double getGainPI(double setpoint, double current,double kP, double kI) {
    	
    	double error = setpoint - current; 
    	double p = KP_SIMPLE * error;
    	accumError = accumError + error;
    	double i = KI_SIMPLE * error;
    	return p + i;
    }
}
