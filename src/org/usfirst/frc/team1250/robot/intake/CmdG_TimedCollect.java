package org.usfirst.frc.team1250.robot.intake;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleTimedPinch;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_TimedCollect extends CommandGroup {

    public CmdG_TimedCollect() {
    	requires(Robot.s_intake);
    	requires(Robot.s_elevator);
    	
    	addSequential(new Cmd_IntakeUnPinch());
    	addParallel(new Cmd_IntakeCollectTimed(1));
    	addSequential(new Cmd_EleTimedPinch(.5));
    	addSequential(new Cmd_IntakePinch());
    	
    }
}
