package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHome;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_Eat extends CommandGroup {

    public CmdG_Eat() {
    	addSequential(new Cmd_EleHome());
    	addSequential(new Cmd_EleUnpinch());
    	addParallel(new Cmd_IntakePinch());
    	addParallel(new Cmd_IntakeCollectTimed(0.5));
    	addSequential(new Cmd_ElePinch());
    	addSequential(new Cmd_IntakeUnPinch());

    }
}
