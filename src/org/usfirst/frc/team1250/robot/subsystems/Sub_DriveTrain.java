package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.drive.*;
import org.usfirst.frc.team1250.robot.commands.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;


/**
 *
 */
public class Sub_DriveTrain extends Subsystem {
	
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	WPI_TalonSRX fLeftMotor = new WPI_TalonSRX( RobotMap.DRV_LEFT_FRONT);
	WPI_TalonSRX bLeftMotor = new WPI_TalonSRX( RobotMap.DRV_LEFT_BACK);
	WPI_TalonSRX mLeftMotor = new WPI_TalonSRX( RobotMap.DRV_LEFT_MID);
	WPI_TalonSRX bRightMotor = new WPI_TalonSRX( RobotMap.DRV_RIGHT_BACK);
	WPI_TalonSRX fRightMotor = new WPI_TalonSRX( RobotMap.DRV_RIGHT_FRONT);
	WPI_TalonSRX mRightMotor = new WPI_TalonSRX( RobotMap.DRV_RIGHT_MID);
	
	private SpeedController gLeftMotor
	= new SpeedControllerGroup(fLeftMotor, bLeftMotor, mLeftMotor);
	
	private SpeedController gRightMotor
	= new SpeedControllerGroup(fRightMotor, bRightMotor, mRightMotor);
	
	private DifferentialDrive diffDriveGroup
	= new DifferentialDrive(gLeftMotor, gRightMotor);
	
	static int driveSetpoint = 0;
	
	// High and Low RPM thresholds for shifting
	private final double THRESH_RPM_HI= 2000;
	private final double THRESH_RPM_LO = 1400;
	private final double DRIVE_TICKS = 310.5;
	private final double SHIFTER_TIMEOUT = 1;
	double WHEELBASE_RADIUS = 23 / 2;

	// Initial Commands Loaded on Robot
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
    	if (Robot.m_oi.getButtonState(8)){
    		return false;
    	}
    	
		leftJoy = -joy.getY();
		rightJoy = -joy.getThrottle();
		
		if (Robot.robotTimer.get() > SHIFTER_TIMEOUT && state == false) {
			
			if((int)Math.signum(leftJoy) != (int)Math.signum(rightJoy))
				state= false;
			else if (Math.abs(fLeftMotor.getSelectedSensorVelocity(0)) > THRESH_RPM_HI && Math.abs(fRightMotor.getSelectedSensorVelocity(0)) > THRESH_RPM_HI)
				state =  true;
			
			Robot.robotTimer.reset();
		}
		else {
			
			if (Math.abs(fLeftMotor.getSelectedSensorVelocity(0)) < THRESH_RPM_LO || Math.abs(fRightMotor.getSelectedSensorVelocity(0)) < THRESH_RPM_LO )
				state =  false;

		}
		
		return state;
	
    }
    
    public void pause() {
    	drive(0,0);
    }
    
    public void driveToPos (int distance) {
		//Need to set others as slaves
		mRightMotor.set(ControlMode.Follower, RobotMap.DRV_RIGHT_FRONT);
		bRightMotor.set(ControlMode.Follower, RobotMap.DRV_RIGHT_FRONT);
		mLeftMotor.set(ControlMode.Follower, RobotMap.DRV_LEFT_FRONT);
		bLeftMotor.set(ControlMode.Follower, RobotMap.DRV_LEFT_FRONT);
    	//Distance in inches
    	driveSetpoint = (int)DRIVE_TICKS * distance;
    	//Negate one side
		fRightMotor.set(ControlMode.Position, driveSetpoint);
		fLeftMotor.set(ControlMode.Position, -driveSetpoint);		
    }
    
    public void turn (double angle) {
		//Need to set others as slaves
    	mRightMotor.set(ControlMode.Follower, RobotMap.DRV_RIGHT_FRONT);
		bRightMotor.set(ControlMode.Follower, RobotMap.DRV_RIGHT_FRONT);
		mLeftMotor.set(ControlMode.Follower, RobotMap.DRV_LEFT_FRONT);
		bLeftMotor.set(ControlMode.Follower, RobotMap.DRV_LEFT_FRONT);
		
    	double currentAngle = getGyroAngle();
    	
    	//Need to confirm that this works...
    	driveSetpoint = (int)((((currentAngle - angle) * Math.PI * WHEELBASE_RADIUS) / 180) * DRIVE_TICKS);
    	
    	//No negate
    	fRightMotor.set(ControlMode.Position, driveSetpoint);
		fLeftMotor.set(ControlMode.Position, driveSetpoint);
    }
    
    public double getGyroAngle() {
    	return gyro.getAngle();
    }
    
    public int getLeftSideSensorPosInTicks() {
    	return fLeftMotor.getSelectedSensorPosition(0);
    }
    
    public int getRightSideSensorPosInTicks() {
    	return fRightMotor.getSelectedSensorPosition(0);
    }
    
    public void resetSensorPos() {
    	fRightMotor.setSelectedSensorPosition(0, 0, 10);
    	fLeftMotor.setSelectedSensorPosition(0, 0, 10);
    }
    
    public boolean isDoneDriving() {
    	return (getLeftSideSensorPosInTicks() >= driveSetpoint + 250 || getLeftSideSensorPosInTicks() <= driveSetpoint - 250 ) && 
    			(getRightSideSensorPosInTicks() >= driveSetpoint + 250 || getRightSideSensorPosInTicks() <= driveSetpoint - 250);
    }
}
