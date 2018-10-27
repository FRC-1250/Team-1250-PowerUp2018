//package org.usfirst.frc.team1250.robot.intake;
//
//import org.usfirst.frc.team1250.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.TimedCommand;
//
///**
// *
// */
//public class Cmd_IntakeSpit extends TimedCommand {
//
//    public Cmd_IntakeSpit(double timeout) {
//        super(timeout);
//    	requires(Robot.s_intake);
//    }
//
//    protected void initialize() {
//    }
//
//    protected void execute() {
//    	Robot.s_intake.dump();
//    }
//
//    protected void end() {
//    	Robot.s_intake.stop();
//    }
//    
//    protected void interrupted() {
//    }
//}
