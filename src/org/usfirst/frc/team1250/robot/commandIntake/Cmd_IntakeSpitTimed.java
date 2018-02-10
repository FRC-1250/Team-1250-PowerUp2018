package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_IntakeSpitTimed extends TimedCommand {

    public Cmd_IntakeSpitTimed(double timeout) {
        super(timeout);
    	requires(Robot.s_claw);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_claw.dump();
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_claw.stop();
    }


    protected void interrupted() {
    }
}
