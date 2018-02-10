package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_Intake extends Command {

    public Cmd_Intake() {
    	requires(Robot.s_claw);

    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_claw.collect();
    	if (!Robot.s_claw.isSeenRight() & !Robot.s_claw.isSeenLeft()){
    		Robot.s_claw.pinch();
    	}
	}

    protected boolean isFinished() {
			return !Robot.s_claw.isIn();
    	}

    protected void end() {
    	Robot.s_claw.stop();
    	Robot.s_claw.unpinch();
    }


    protected void interrupted() {
    }
}
