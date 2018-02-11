package org.usfirst.frc.team1250.robot.drive;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_PneumaticShift extends Command {

	public Cmd_PneumaticShift() {
		requires(Robot.s_shifter);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.s_shifter.setShiftState(Robot.shiftState);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
