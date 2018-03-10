package org.usfirst.frc.team1250.robot.climber;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_RetractRightMotor extends Command {

	public Cmd_RetractRightMotor() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.s_climberright);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.s_climberright.runMotorOut();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !Robot.m_oi.getButtonState(6);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.s_climberright.stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.s_climberright.stopMotor();
	}
}
