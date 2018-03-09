/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1250.robot.AutoGroups.Auto_Fallback;
import org.usfirst.frc.team1250.robot.AutoGroups.Auton_Scheduler;
import org.usfirst.frc.team1250.robot.AutoGroups.Cmd_SendCenterPos;
import org.usfirst.frc.team1250.robot.AutoGroups.Cmd_SendLeftPos;
import org.usfirst.frc.team1250.robot.AutoGroups.Cmd_SendRightPos;
import org.usfirst.frc.team1250.robot.commands.Cmd_CrossMidFalse;
import org.usfirst.frc.team1250.robot.commands.Cmd_CrossMidTrue;
import org.usfirst.frc.team1250.robot.subsystems.*;
//import org.usfirst.frc.team1250.robot.commands.ExampleCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	//Subsystems
	public static final Sub_DriveTrain s_drivetrain = new Sub_DriveTrain();
	public static final Sub_Shifter s_shifter = new Sub_Shifter();
	public static final Sub_Intake s_intake = new Sub_Intake();
	public static final Sub_Elevator s_elevator = new Sub_Elevator();
	public static final Sub_ClimberRight s_climberright = new Sub_ClimberRight();
	public static final Sub_ClimberLeft s_climberleft = new Sub_ClimberLeft();
	public static final Sub_LimeLight s_limelight = new Sub_LimeLight();
	
	
	
	//Controls
	Joystick Arcadepad = new Joystick(1);
	public static OI m_oi;
	
	static DriverStation driverStation;
	
	//Robot wide variable
	public static boolean shiftState = false;
	public static Timer robotTimer = new Timer();
	public static String StartPos= "None";
	public static String DS_Msg;
	public static boolean CrossMid = false;
	
	//Auto
	Command m_autonomousCommand;
	Command m_autonomousScheduler;
	Command m_crosspick;
	SendableChooser<Command> m_fieldPosition = new SendableChooser<>();
	SendableChooser<Command> m_crossmid = new SendableChooser<>();
	
	public static boolean doubleCube = false;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_fieldPosition.addDefault("Auto_Center", new Cmd_SendCenterPos());
		m_fieldPosition.addObject("Auto_Left", new Cmd_SendLeftPos());
		m_fieldPosition.addObject("Auto_Right", new Cmd_SendRightPos());
		m_fieldPosition.addObject("Drive Forward", new Auto_Fallback());
		
		m_crossmid.addDefault("Cross_Mid_True", new Cmd_CrossMidTrue());
		m_crossmid.addObject("Cross_Mid_False", new Cmd_CrossMidFalse());
		
		
		SmartDashboard.putString("Command Selected", Robot.StartPos);
		
		SmartDashboard.putData("Auto mode", m_fieldPosition);
		SmartDashboard.putString("GameSpecific Message", "UNINIT");
		SmartDashboard.putBoolean("Are We Crossing", false);
		SmartDashboard.putBoolean("Cross Toggle", CrossMid);
		SmartDashboard.putString("Robot Position Message", "UN_INIT");
		
		CameraServer.getInstance().startAutomaticCapture();
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
	}

	/**
	 * 
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
		s_elevator.setTicksToHome();
		s_drivetrain.setToCoast();
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
		SmartDashboard.putNumber("DS_Message length", -1);
		//DS_Msg = getAutoMessage();
	}

	@Override
	public void disabledPeriodic() {
		// Scheduler.getInstance().run();
		DS_Msg = getAutoMessage();
		SmartDashboard.putString("Command Selected", Robot.StartPos);
		m_crosspick = (Command) m_crossmid.getSelected();
		String select_cross = m_crosspick.toString();
		
		if (select_cross.equals("Cmd_CrossMidTrue")) {
			CrossMid = true;
		}
		else {
			CrossMid = false;
		}
		
		
		
		this.log();
	}
	
	@Override
	public void autonomousInit() {
		//s_elevator.soloPop();
		
		DS_Msg = getAutoMessage();
		SmartDashboard.putString("Robot Position Message", "AUTO_INIT");
		SmartDashboard.putNumber("DS_Message length", DS_Msg.length());
		while(DS_Msg.length() < 2) {
			DS_Msg = getAutoMessage();
			SmartDashboard.putNumber("DS_Message length", DS_Msg.length());
		}
		SmartDashboard.putNumber("DS_Message length", DS_Msg.length());
		
		SmartDashboard.putString("DS_Message", DS_Msg);
		SmartDashboard.putString("Robot Position Message", "AFTER_WHILE");
		
		m_autonomousCommand = (Command) m_fieldPosition.getSelected();

		SmartDashboard.putString("m_autonomousCommand.toString()", m_autonomousCommand.toString());
		
		String Cmd_Selected = m_autonomousCommand.toString();
			
		if (Cmd_Selected.equals("Cmd_SendRightPos")) {
			StartPos = "Right";
		} else if (Cmd_Selected.equals("Cmd_SendCenterPos")) {
			StartPos = "Center";
		} else if (Cmd_Selected.equals("Cmd_SendLeftPos")) {
			StartPos = "Left";
		}
		
			
		
		
		
		if (m_autonomousCommand != null) {
			SmartDashboard.putString("Robot Position Message", "Selector");
			m_autonomousCommand.start();
			
			
			SmartDashboard.putString("Command Selected", StartPos);
			
			SmartDashboard.putString("Robot Position Message", "Scheduler Start");
			m_autonomousScheduler = new Auton_Scheduler(StartPos);
			m_autonomousScheduler.start();
			//SmartDashboard.putString("Robot Position Message", "Scheduler");
		}
		
		
		
		s_drivetrain.setToBrake();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
			Scheduler.getInstance().run();
	}

	
	@Override
	public void teleopInit() {
		s_elevator.solUnPop();
		s_elevator.setTicksToHome();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
			

		}
		
		s_drivetrain.resetGyro();
		s_drivetrain.setToCoast();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		this.log();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		this.log();
	}

	public void log() {
		SmartDashboard.putBoolean("Is Limit Seen???????", s_elevator.getEleSensor());
//		SmartDashboard.putNumber("test", s_elevator.getLiftPosInTicks());
		SmartDashboard.putNumber("Joystick Val", m_oi.getArcadepad().getRawAxis(1));
		SmartDashboard.putNumber("sensor Pos", s_elevator.eleMotor.getSelectedSensorPosition(0));
//		SmartDashboard.putNumber("Motor V", s_elevator.eleMotor.getMotorOutputPercent());
		SmartDashboard.putNumber("Gyro POS", s_drivetrain.getGyroAngle());
//		SmartDashboard.putNumber("Right Encoder Ticks", s_drivetrain.getRightSideSensorPosInTicks());
//		SmartDashboard.putNumber("Left Encoder Ticks", s_drivetrain.getLeftSideSensorPosInTicks());
//		SmartDashboard.putNumber("Right Encoder Inches", s_drivetrain.getRightSideSensorPosInInches());
//		SmartDashboard.putNumber("Left Encoder Inches", s_drivetrain.getLeftSideSensorPosInInches());
//		SmartDashboard.putNumber("Setpoint", s_drivetrain.driveSetpoint);
//		SmartDashboard.putNumber("Joystick Left", m_oi.Gamepad.getY());
//		SmartDashboard.putNumber("Joystick Right", m_oi.Gamepad.getThrottle());
//		SmartDashboard.putNumber("LeftSpeed", s_drivetrain.leftVelocity());
//		SmartDashboard.putNumber("RightSpeed", s_drivetrain.rightVelocity());
//		SmartDashboard.putString("GameSpecific Message", getAutoMessage());
//		doubleCube = SmartDashboard.getBoolean("Two Cubes?", false);
//		SmartDashboard.putBoolean("Cubes?", doubleCube);
//		SmartDashboard.putNumber("Cube X", s_limelight.getCubeX());
//		SmartDashboard.putNumber("Cube Area", s_limelight.getCubeArea());
		
	}
	
	public static String getAutoMessage() {
		
		String DS_Message = DriverStation.getInstance().getGameSpecificMessage();
		
		SmartDashboard.putString("GameSpecific Message", DS_Message);
		
		if(DS_Message != null && DS_Message.length() >= 2)
			return DS_Message.substring(0, 2); 
		else
			return "";
	}

	public Robot() {
		// double yStick = A	rcadepad.getY();
		// SmartDashboard.putNumber("yin", yStick);
		// if (yStick > 0){
		// Robot.s_elevator.bumpUp();
		// }
		// if (yStick < 0){
		// Robot.s_elevator.bumpDown();
		// }
	}
	

}