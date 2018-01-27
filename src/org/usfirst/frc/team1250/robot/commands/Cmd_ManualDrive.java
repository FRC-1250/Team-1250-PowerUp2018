package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Cmd_ManualDrive extends Command {
	
	private static Timer cluthTimer= new Timer();
	private final double CLUTCH_DELAY = 0.2;
	private boolean prevClutchState = false;
    public Cmd_ManualDrive() {
    	requires(Robot.s_drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Checks clutch state by running shiftState Method 
    protected void execute() {
    	this.prevClutchState = Robot.shiftState;
    	
    	Robot.s_drivetrain.drive(Robot.m_oi.getGamepad());
    	
    	Robot.shiftState=Robot.s_drivetrain.getState(Robot.m_oi.getGamepad(), Robot.shiftState);
    	
    	if (this.prevClutchState != Robot.shiftState ) {
    		cluthTimer.start();
    		while(cluthTimer.get() <= CLUTCH_DELAY) {
    			Robot.s_drivetrain.pause();
    		}
    	}
    	cluthTimer.stop();
		cluthTimer.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
