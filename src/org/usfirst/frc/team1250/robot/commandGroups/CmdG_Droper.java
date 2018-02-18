package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.commands.Cmd_Pancake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_Droper extends CommandGroup {

    public CmdG_Droper() {
 
    	 addSequential(new Cmd_ElePinch());
    	 addSequential(new Cmd_DoNothing(.1));
         addSequential(new Cmd_Pancake(.1));
         addSequential(new Cmd_DoNothing(1));
         addSequential(new Cmd_EleUnpinch());
      
    }
}
