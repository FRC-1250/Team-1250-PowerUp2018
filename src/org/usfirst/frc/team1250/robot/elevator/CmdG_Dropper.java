package org.usfirst.frc.team1250.robot.elevator;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Pancake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_Dropper extends CommandGroup {

    public CmdG_Dropper() {
 
    	 addSequential(new Cmd_ElePinch());
    	 addSequential(new Cmd_DoNothing(.1));
         addSequential(new Cmd_Pancake(.1));
 
      
    }
}
