package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.*;
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
	
	private SpeedController m_leftMotor
	= new SpeedControllerGroup(fLeftMotor, bLeftMotor, mLeftMotor);
	
	private SpeedController m_rightMotor
	= new SpeedControllerGroup(fRightMotor, bRightMotor, mRightMotor);
	
	private DifferentialDrive m_drive
	= new DifferentialDrive(m_leftMotor, m_rightMotor);
	
	// High and Low RPM thresholds for shifting
	private final double THRESH_RPM_HI= 0;
	private final double THRESH_RPM_LO = 0;
    
	public void initDefaultCommand() {
		
    	
    }
}

