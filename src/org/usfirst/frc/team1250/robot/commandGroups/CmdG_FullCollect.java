package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_Intake;
import org.usfirst.frc.team1250.robot.commandIntake.Cmd_IntakeUnPinch;
import org.usfirst.frc.team1250.robot.commands.Cmd_ElePinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_FullCollect extends CommandGroup {

    public CmdG_FullCollect() {
    	requires(Robot.s_claw);
    	requires(Robot.s_elevator);
    	
    	addSequential(new Cmd_IntakeUnPinch());
    	addSequential(new Cmd_Intake());
    	addSequential(new Cmd_ElePinch());
    	addSequential(new Cmd_IntakeUnPinch());

    	
   
    	
    	
    	

       
    	// e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());

    }
}
