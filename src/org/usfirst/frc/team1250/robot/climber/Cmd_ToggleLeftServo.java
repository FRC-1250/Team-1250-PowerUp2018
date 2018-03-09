package org.usfirst.frc.team1250.robot.climber;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_ToggleLeftServo extends InstantCommand {

    public Cmd_ToggleLeftServo() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.s_climberleft);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_climberleft.toggleServo();
    }

}
