package org.usfirst.frc.team1250.robot.climber;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_ClimberOut extends Command {

    public Cmd_ClimberOut() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.s_climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.s_climber.runMotorIn();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.m_oi.getButtonState(7);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.s_climber.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
