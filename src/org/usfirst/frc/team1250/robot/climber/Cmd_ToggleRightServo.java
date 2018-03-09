package org.usfirst.frc.team1250.robot.climber;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_ToggleRightServo extends InstantCommand {

    public Cmd_ToggleRightServo() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.s_climberright);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_climberright.toggleServo();
    }

}
