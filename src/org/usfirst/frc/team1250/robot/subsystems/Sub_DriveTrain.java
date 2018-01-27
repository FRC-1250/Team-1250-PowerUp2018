package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.OI;
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
	
	// High and Low RPM thresholds for shifting
	private final double THRESH_RPM_HI= 0;
	private final double THRESH_RPM_LO = 0;
    
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
    
//
// NEEDS WORK TO FIX    
//    
    public boolean getState(Joystick joy, boolean state) {
    	
    	boolean joyCompare = false;
    	double lJoy = 0;
    	double rJoy = 0;

    	if (Robot.m_oi.getButtonState(8)){
    		System.out.print("Button 8 Pressed");
    		return false;
    	}
    	
		lJoy = -joy.getY();
		rJoy = -joy.getThrottle();
		
//		SmartDashboard.putNumber("Left Joy", fLeftMotor.getSelectedSensorVelocity(0));
//		SmartDashboard.putNumber("Right Joy", fRightMotor.getSelectedSensorVelocity(0));
		
		//RIP Ruiqi
		//SmartDashboard.putNumber("Left Joy", lJoy);
		//SmartDashboard.putNumber("Right Joy", rJoy);
		
		// Signs of the inputs
		//int lJoySign = (int)Math.signum(lJoy);
		//int rJoySign = (int)Math.signum(rJoy);
//		int lRPMSign = (int)Math.signum(lRPM);
//		int rRPMSign = (int)Math.signum(rRPM);
		
		
		// Check for joystick direction change and RPM Change
		joyCompare = ((int)Math.signum(lJoy) != (int)Math.signum(rJoy));
		
//		if((int)Math.signum(lJoy) != (int)Math.signum(rJoy))
//			return false;
//		else if ( fLeftMotor.getSelectedSensorVelocity(0) < kLowRPMThresh || fRightMotor.getSelectedSensorVelocity(0) < kLowRPMThresh )
//			return false;
//		else if (fLeftMotor.getSelectedSensorVelocity(0) > kHighRPMThresh && fRightMotor.getSelectedSensorVelocity(0) > kHighRPMThresh)
//			return true;
//		else 
//			return false;
			
		//RIP Ruiqi
		if (joyCompare) {	
			return false;		
		}
		else if(!state && (Math.abs(lJoy)< this.THRESH_RPM_LO || Math.abs(rJoy)<this.THRESH_RPM_LO )) {
			return false;
		}
		else if (Math.abs(lJoy) > this.THRESH_RPM_HI && Math.abs(rJoy) > this.THRESH_RPM_HI) {
			return false; // should be true to shift high
		}
		 else  {
			return false;
		} 
 	}
    
    public void pause() {
    	drive(0,0);
    }
}
