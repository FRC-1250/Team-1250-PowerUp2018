package org.usfirst.frc.team1250.robot.drive;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_AutoTurn extends Command {

	double angle = 0;
	
    public Cmd_AutoTurn(double angle) {
    	requires(Robot.s_drivtrain);
    	this.angle = angle;
    }

    protected void initialize() {
    	setTimeout(2);
    }

    protected void execute() {
    	Robot.s_drivtrain.turn(angle);
    }

    protected boolean isFinished() {
    	//Check Gyro and Encorder distance or timeout
    	return Robot.s_drivtrain.isDoneDriving() || isTimedOut();
    }

    protected void end() {
    	Robot.s_drivtrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
