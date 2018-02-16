package org.usfirst.frc.team1250.robot.drive;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Cmd_AutoTurn extends Command {

	double angle = 0;
	
    public Cmd_AutoTurn(double angle) {
    	requires(Robot.s_drivetrain);
    	this.angle = angle;
    	Robot.s_drivetrain.resetGyro();
    	Robot.s_drivetrain.accumError = 0;
    }
    
    public Cmd_AutoTurn() {
    	angle = 90;
    	
    	requires(Robot.s_drivetrain);
    	Robot.s_drivetrain.resetGyro();
    	Robot.s_drivetrain.accumError = 0;
    }

    protected void initialize() {
    	Robot.s_drivetrain.resetGyro();
    	setTimeout(5);
    	
    }

    protected void execute() {
    	Robot.s_drivetrain.turn(angle);
    }

    protected boolean isFinished() {
    	//Check Gyro and Encorder distance or timeout
    	return Robot.s_drivetrain.isDoneTurning(angle) || isTimedOut();
    }

    protected void end() {
    	Robot.s_drivetrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
