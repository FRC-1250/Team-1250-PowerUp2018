package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeUnPinch extends InstantCommand {

	public Cmd_IntakeUnPinch() {
		super();
		requires(Robot.s_intake);
	}

	protected void initialize() {
		Robot.s_intake.unpinch();
	}
}
