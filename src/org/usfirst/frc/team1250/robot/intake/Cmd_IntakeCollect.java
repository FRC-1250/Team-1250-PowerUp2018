package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_IntakeCollect extends Command {

    public Cmd_IntakeCollect() {
    	requires(Robot.s_intake);
    }

    protected void initialize() {
    }

    protected void execute() {
		Robot.s_intake.collect(-1);
    }

    protected boolean isFinished() {
		return (!Robot.s_intake.isSeenRight() && !Robot.s_intake.isSeenLeft());
    }

    protected void end() {
    	Robot.s_intake.stop();
    }

    protected void interrupted() {
    	Robot.s_intake.stop();
    }
}
