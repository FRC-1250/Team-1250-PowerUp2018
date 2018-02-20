package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_AutonSwitch extends CommandGroup {

    public CmdG_AutonSwitch() {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleSwitch());
    	 addSequential(new Cmd_AutoDrive(48, .6 , .3));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(-45 , .8 , .7));  
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(72, .6 , .3));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(45, .8 , .7)); 
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(6, .6 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new CmdG_Droper());
    	 }
}
