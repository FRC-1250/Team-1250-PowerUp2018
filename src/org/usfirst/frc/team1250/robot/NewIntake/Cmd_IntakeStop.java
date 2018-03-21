package org.usfirst.frc.team1250.robot.NewIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_IntakeStop extends InstantCommand {

    public Cmd_IntakeStop() {
        super();
    	requires(Robot.s_newintake);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_newintake.stop();
    }

}
