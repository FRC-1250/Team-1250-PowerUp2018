package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntantPinch extends InstantCommand {

    public Cmd_IntantPinch() {
        super();
        // Use requires() here to declare subsystem dependencies
         requires(Robot.s_elevator);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_elevator.soloLiftUnPinch();
    }

}
