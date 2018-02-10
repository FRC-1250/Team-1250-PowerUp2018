package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeToggle extends InstantCommand {

    public Cmd_IntakeToggle() {
        super();
    	requires(Robot.s_claw);

    }

    // Called once when the command executes
    protected void initialize() {
    	if (!Robot.s_claw.CheckSoloClaw())
    		Robot.s_claw.pinch();
    	else
    		Robot.s_claw.unpinch();

    }

}
