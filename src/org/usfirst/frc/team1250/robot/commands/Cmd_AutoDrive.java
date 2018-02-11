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
    
    public Cmd_AutoDrive()
    {
    	distance = 24;
    	
    	requires(Robot.s_drivtrain);
    }

    protected void initialize() {
    	Robot.s_drivtrain.resetSensorPos();
    	Robot.s_drivtrain.resetGyro();
    	Robot.s_drivtrain.setSetpointPos(distance);
    	setTimeout(5);
    }

    protected void execute() {
    	Robot.s_drivtrain.driveToPos();
    }

    protected boolean isFinished() {
    	//Check encoder distance or timeout
    	return isTimedOut()|| Robot.s_drivtrain.isDoneDriving();
    }

    protected void end() {
    	//Robot.s_drivtrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
