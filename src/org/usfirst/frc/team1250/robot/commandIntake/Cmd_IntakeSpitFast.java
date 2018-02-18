package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_IntakeSpitFast extends TimedCommand {

    public Cmd_IntakeSpitFast(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_elevator.soloLiftUnPinch();
    	Robot.s_intake.dump();
    	Robot.s_intake.pinch();
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_elevator.soloLiftPinch();
    	Robot.s_intake.stop();
    	Robot.s_intake.unpinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
