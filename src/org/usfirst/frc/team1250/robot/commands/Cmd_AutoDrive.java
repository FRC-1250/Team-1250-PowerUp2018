package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_AutoDrive extends Command {
	
	int distance = 0;

    public Cmd_AutoDrive(int distance) {
    	requires(Robot.s_drivtrain);
    	this.distance = distance;
    }
    
    public Cmd_AutoDrive() {
    	requires(Robot.s_drivtrain);
    	distance = 12;
    	
    }

    protected void initialize() {
    	setTimeout(2);
    }

    protected void execute() {
    	Robot.s_drivtrain.driveToPos(distance);
    }

    protected boolean isFinished() {
    	//Check encoder distance or timeout
    	return Robot.s_drivtrain.isDoneDriving() || isTimedOut();
    }

    protected void end() {
    	Robot.s_drivtrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
