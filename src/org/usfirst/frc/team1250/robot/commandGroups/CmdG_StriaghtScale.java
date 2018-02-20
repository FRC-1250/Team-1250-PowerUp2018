package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_StriaghtScale extends CommandGroup {

    public CmdG_StriaghtScale() {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleHigh());
    	 addSequential(new Cmd_AutoDrive(250, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new CmdG_Droper());
    }
}
