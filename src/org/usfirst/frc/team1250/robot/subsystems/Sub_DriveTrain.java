package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.drive.*;
import org.usfirst.frc.team1250.robot.commands.*;

/**
 *
 */
public class Sub_DriveTrain extends Subsystem {

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
	
	private final double SHIFTER_TIMEOUT = 1;
	
	// High and Low RPM thresholds for shifting
	private final double THRESH_RPM_HI= 2000;
	private final double THRESH_RPM_LO = 1400;
	
	
	public Sub_DriveTrain(){
		fLeftMotor.setInverted(true);
		fRightMotor.setInverted(true);

	}
    
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
}
