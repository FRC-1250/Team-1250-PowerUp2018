/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1250.robot.commands.Auto_PosA;
import org.usfirst.frc.team1250.robot.commands.Auto_PosB;
import org.usfirst.frc.team1250.robot.commands.Auto_PosC;
import org.usfirst.frc.team1250.robot.subsystems.*;
import edu.wpi.first.wpilibj.SPI;
//import org.usfirst.frc.team1250.robot.commands.ExampleCommand;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Joystick Arcadepad = new Joystick(1);
	public static final Sub_DriveTrain s_drivtrain 
			= new Sub_DriveTrain();
	public static final Sub_Shifter s_shifter
			= new Sub_Shifter();
	public static final Sub_Claw s_claw
			= new Sub_Claw();
	public static final Sub_Elevator s_elevator
			= new Sub_Elevator();
	public static OI m_oi;
	
	static DriverStation driverStation;
	
	public static boolean shiftState = false;
	public static Timer robotTimer= new Timer();
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public Robot() {
		
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Auto_PosB", new Auto_PosB());
		m_chooser.addObject("Auto_PosA", new Auto_PosA());
		m_chooser.addObject("Auto_PosC", new Auto_PosC());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
//		Robot.s_elevator.setTicksToHome();
	}

	@Override
	public void disabledPeriodic() {
		//Scheduler.getInstance().run();
		this.log();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/ADXL345_SPI.html
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = (Command) m_chooser.getSelected();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
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
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();

		}
		
		
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
		SmartDashboard.putNumber("test", s_elevator.getLiftPosInTicks());
		SmartDashboard.putNumber("Joystick Val", m_oi.getArcadepad().getRawAxis(1));
		SmartDashboard.putNumber("sensor Pos", s_elevator.eleMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("error", s_elevator.eleMotor.getClosedLoopError(0));
		SmartDashboard.putNumber("Gyro POS", s_drivtrain.getGyroAngle());
		SmartDashboard.putNumber("Right Encoder Ticks", s_drivtrain.getRightSideSensorPosInTicks());
		SmartDashboard.putNumber("Left Encoder Ticks", s_drivtrain.getLeftSideSensorPosInTicks());
		SmartDashboard.putNumber("Right Encoder Inches", s_drivtrain.getRightSideSensorPosInInches());
		SmartDashboard.putNumber("Left Encoder Inches", s_drivtrain.getLeftSideSensorPosInInches());
		SmartDashboard.putNumber("Setpoint", s_drivtrain.driveSetpoint);
		SmartDashboard.putNumber("Joystick Left", m_oi.Gamepad.getY());
		SmartDashboard.putNumber("Joystick Right", m_oi.Gamepad.getThrottle());
	}
	
	public static String getAutoMessage()
	{
		return DriverStation.getInstance().getGameSpecificMessage().substring(0, 1); 
	}
	
}
