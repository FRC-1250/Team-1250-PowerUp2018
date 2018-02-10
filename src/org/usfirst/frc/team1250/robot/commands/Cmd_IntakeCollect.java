package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_IntakeCollect extends Command {

    public Cmd_IntakeCollect() {
    	requires(Robot.s_claw);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_claw.collect();
    }

    protected boolean isFinished() {
    	if (!Robot.s_claw.isIn()){
    		return true; }
    	else {	
    		return false;
    }
    }
    protected void end() {
    	Robot.s_claw.stop();
    }
    

    protected void interrupted() {
    }
}
