package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_IntakeCollectTimed extends TimedCommand {

    public Cmd_IntakeCollectTimed(double timeout) {
        super(timeout);
    	requires(Robot.s_claw);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_claw.collect();
    	Robot.s_claw.unpinch();
    	
    	
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_claw.stop();
    	Robot.s_claw.pinch();

    	
    }


    protected void interrupted() {
    }
}
