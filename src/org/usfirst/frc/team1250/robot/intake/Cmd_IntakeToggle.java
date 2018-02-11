package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeToggle extends InstantCommand {

    public Cmd_IntakeToggle() {
        super();
    	requires(Robot.s_intake);
    }

    // Called once when the command executes
    protected void initialize() {
    	if (!Robot.s_intake.CheckSoloClaw())
    		Robot.s_intake.pinch();
    	else
    		Robot.s_intake.unpinch();
    }

}
