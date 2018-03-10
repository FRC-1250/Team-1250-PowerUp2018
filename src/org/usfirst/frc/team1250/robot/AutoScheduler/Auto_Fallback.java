package org.usfirst.frc.team1250.robot.AutoScheduler;

import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto_Fallback extends CommandGroup {

    public Auto_Fallback() {
    	
    	//addSequential(new Cmd_Popper(0.5));
    	SmartDashboard.putString("Robot Position Message", "fALLBACK 1");
    	addSequential(new Cmd_AutoDrive(237, 1 , .3));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
