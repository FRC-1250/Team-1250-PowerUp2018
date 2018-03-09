package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_Popper;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_Fallback extends CommandGroup {

    public Auto_Fallback() {
    	
    	addSequential(new Cmd_AutoDrive(70,0.8,0.6));

    }
}
