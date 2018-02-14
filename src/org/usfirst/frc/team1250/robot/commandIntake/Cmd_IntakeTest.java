package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeTest extends InstantCommand {

    public Cmd_IntakeTest() {
        super();
    	requires(Robot.s_claw);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_claw.collect();
    	Robot.s_claw.pinch();
    	Robot.s_elevator.soloLiftPinch();
    	
    }

}
