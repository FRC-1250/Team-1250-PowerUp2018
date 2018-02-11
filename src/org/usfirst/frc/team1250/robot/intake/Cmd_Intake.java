package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_Intake extends Command {

	public Cmd_Intake() {
		requires(Robot.s_intake);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.s_intake.collect();
		if (!Robot.s_intake.isSeenRight() & !Robot.s_intake.isSeenLeft()) {
			Robot.s_intake.pinch();
		}
	}

	protected boolean isFinished() {
		return !Robot.s_intake.isIn();
	}

	protected void end() {
		Robot.s_intake.stop();
		Robot.s_intake.unpinch();
	}

	protected void interrupted() {
	}
}
