package org.usfirst.frc.team1250.robot.climber;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_ToggleServo extends InstantCommand {

    public Cmd_ToggleServo() {
        super();
        requires(Robot.s_climber);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_climber.toggleServo();
    }

}
