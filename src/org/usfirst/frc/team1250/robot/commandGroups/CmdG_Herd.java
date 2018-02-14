package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_Intake;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakePinch;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeTest;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeUnPinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_Herd extends CommandGroup {

    public CmdG_Herd() {
    	requires(Robot.s_claw);
    	requires(Robot.s_elevator);

    	addSequential(new Cmd_IntakePinch());
    	addParallel(new Cmd_IntakeTest());
    }
}
