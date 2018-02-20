package org.usfirst.frc.team1250.robot.test;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeTest extends InstantCommand {

    public Cmd_IntakeTest() {
        super();
    	requires(Robot.s_intake);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_intake.collect(-0.5);
    	Robot.s_intake.pinch();
    	Robot.s_elevator.soloLiftPinch();

    }

}
