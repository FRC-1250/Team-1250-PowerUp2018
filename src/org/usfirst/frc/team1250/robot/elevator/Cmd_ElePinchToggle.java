package org.usfirst.frc.team1250.robot.elevator;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_ElePinchToggle extends InstantCommand {

    public Cmd_ElePinchToggle() {
        super();
        requires(Robot.s_elevator);
    }

    // Called once when the command executes
    protected void initialize() {
    	if (!Robot.s_elevator.checkSoloLift())
    		Robot.s_elevator.soloLiftPinch();
    	else
    		Robot.s_elevator.soloLiftUnPinch();
    }

}
