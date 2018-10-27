package org.usfirst.frc.team1250.robot.NewIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_TestRoutine extends CommandGroup {

    public CmdG_TestRoutine() {
    	requires(Robot.s_newintake);
    	
    	addSequential(new Cmd_TestRoutine2());
    	addSequential(new Cmd_IntakeStopTimed(1));
    	addSequential(new Cmd_IntakeCollectTimed(1));
    	
    	
    	
    		//addSequential(new Cmd_IntakeCollect());
    	
    	
    

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
