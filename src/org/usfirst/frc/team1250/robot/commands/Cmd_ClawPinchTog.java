package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_ClawPinchTog extends Command {

    public Cmd_ClawPinchTog() {
    	requires(Robot.s_claw);
    }


    protected void initialize() {
    }


    protected void execute() {
    }


    protected boolean isFinished() {
        return true;
    }


    protected void end() {
    	if (!Robot.s_claw.CheckSoloClaw())
    		Robot.s_claw.pinch();
    	else
    		Robot.s_claw.unpinch();
    }


    protected void interrupted() {
    }
}
