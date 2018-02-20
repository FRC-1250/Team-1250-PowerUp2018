package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_IntakeCollectTimed extends TimedCommand {

    public Cmd_IntakeCollectTimed(double timeout) {
        super(timeout);
    	requires(Robot.s_intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_intake.collect(-1);
    	Robot.s_intake.unpinch();
    	
    	
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_intake.stop();
    	Robot.s_intake.pinch();

    }


    protected void interrupted() {
    }
}
