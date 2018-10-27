package org.usfirst.frc.team1250.robot.NewIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_TestRoutine2 extends Command {

    public Cmd_TestRoutine2() {
    	requires(Robot.s_newintake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_newintake.setIntakeSpeedLeft(-1);
    	Robot.s_newintake.setIntakeSpeedRight(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (!Robot.s_newintake.getSensorValue() || !Robot.s_newintake.getSensorValue2()) 
        {
    		 return true;	       
    	}
        return false;
       
    		    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.s_newintake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
