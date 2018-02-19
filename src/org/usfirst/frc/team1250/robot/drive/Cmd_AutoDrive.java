package org.usfirst.frc.team1250.robot.drive;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_AutoDrive extends Command {
	
	int distance = 0;

    public Cmd_AutoDrive(int distance) {
    	requires(Robot.s_drivetrain);
    	this.distance = distance;
    }
    

    protected void initialize() {
    	Robot.s_drivetrain.resetSensorPos();
    	Robot.s_drivetrain.resetGyro();
    	Robot.s_drivetrain.setSetpointPos(distance);
    	setTimeout(5);
    }

    protected void execute() {
    	Robot.s_drivetrain.driveToPos();
    }

    protected boolean isFinished() {
    	//Check encoder distance or timeout
    	return Robot.s_drivetrain.isDoneDriving();
//    	return isTimedOut()|| Robot.s_drivetrain.isDoneDriving();
    }

    protected void end() {
    	//Robot.s_drivtrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
