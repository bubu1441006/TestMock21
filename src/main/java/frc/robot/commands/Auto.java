// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.BallSucker;

import static frc.robot.Constants.AUTO_CONSTANTS.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto extends ParallelCommandGroup {
  public Auto(BallSucker ballSucker, BallShooter ballShooter, DriveBase driveBase) {

    addCommands(
      
    new OpenToSuck(ballSucker, SUCK_STRENGTH).withTimeout(SUCK_TIME_OUT), 
    new Shoot(ballShooter, SHOOT_STRENGTH),
    new DriveStraight(driveBase, SPEED1, SPEED2)
    
    );
  }
}
