// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DriveStraight extends CommandBase {

  public DriveBase m_driveBase;
  private double m_speed1;
  private double m_speed2;

  /** Creates a new DriveStraight. */
  public DriveStraight(DriveBase driveBase, double speed1, double speed2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveBase = driveBase;
    m_speed1 = speed1;
    m_speed2 = speed2;

    addRequirements(m_driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveBase.drive(m_speed1, m_speed2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveBase.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
