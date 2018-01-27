package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_ClawCollect extends Command {

    public Cmd_ClawCollect() {
    	requires(Robot.s_claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_claw.collect();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (!Robot.s_claw.isIn()){
    		return true; }
    	else {	
    		return false;
    }
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.s_claw.stop();
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
