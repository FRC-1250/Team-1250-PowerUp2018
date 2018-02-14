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
    }
    
    public Cmd_AutoTurn() {
    	angle = SmartDashboard.getNumber("Input Angle", 0);
    	requires(Robot.s_drivetrain);
    }

    protected void initialize() {
    	setTimeout(2);
    }

    protected void execute() {
    	Robot.s_drivetrain.turn(angle);
    }

    protected boolean isFinished() {
    	//Check Gyro and Encorder distance or timeout
    	return Robot.s_drivetrain.isDoneDriving() || isTimedOut();
    }

    protected void end() {
    	Robot.s_drivetrain.resetSensorPos();
    }

    protected void interrupted() {
    }
}
