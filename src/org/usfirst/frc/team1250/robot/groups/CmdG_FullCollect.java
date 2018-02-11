package org.usfirst.frc.team1250.robot.groups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_Intake;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_FullCollect extends CommandGroup {

    public CmdG_FullCollect() {
    	requires(Robot.s_intake);
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
