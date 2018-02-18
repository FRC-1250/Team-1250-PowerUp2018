package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeCollectTimed;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleTimedPinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleUnpinchTimed;
import org.usfirst.frc.team1250.robot.commands.Cmd_IntantPinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_FullCollect extends CommandGroup {

    public CmdG_FullCollect() {
    	requires(Robot.s_intake);
    	requires(Robot.s_elevator);
    	
//    	addParallel(new Cmd_IntantPinch());
    	addParallel(new Cmd_IntakeCollectTimed(1));
    	addParallel(new Cmd_EleUnpinchTimed(.5));
    	
    	

    	
   
    	
    	
    	

       
    	// e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // e.g. addParallel(new Command1());
        //      add(new Command2());

    }
}
