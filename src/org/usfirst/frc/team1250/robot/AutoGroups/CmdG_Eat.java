package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHome;
import org.usfirst.frc.team1250.robot.elevator.Cmd_ElePinch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleUnpinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeCollectTimed;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakePinch;
import org.usfirst.frc.team1250.robot.intake.Cmd_IntakeUnPinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_Eat extends CommandGroup {

    public CmdG_Eat() {
    	addSequential(new Cmd_EleHome());
    	addSequential(new Cmd_EleUnpinch());
    	addParallel(new Cmd_IntakePinch());
    	addParallel(new Cmd_IntakeCollectTimed(0.5));
    	addSequential(new Cmd_ElePinch());
    	addSequential(new Cmd_IntakeUnPinch());
    	
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
