package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleHome extends Command {

    public Cmd_EleHome() {
    	requires(Robot.s_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_elevator.setLiftPosition();
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Robot.s_elevator.getLiftPosTicks() == Robot.s_elevator.HOME_POS_TEMP) || (!Robot.s_elevator.getEleSensor() || isTimedOut());
        	
   
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (!Robot.s_elevator.getEleSensor()){
    		Robot.s_elevator.setTicksToHome();
    	}
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
