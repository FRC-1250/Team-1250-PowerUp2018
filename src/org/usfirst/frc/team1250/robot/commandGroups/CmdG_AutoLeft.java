package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_AutoLeft extends CommandGroup {

    public CmdG_AutoLeft() {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleHigh());
    	 addSequential(new Cmd_AutoDrive(264, 1, .6));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(45 , .8 , .6));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(28, 1 , .6));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new CmdG_Droper());
    	 addSequential(new Cmd_Reset());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
       
    }
}
