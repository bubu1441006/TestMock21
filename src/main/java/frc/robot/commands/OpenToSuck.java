// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.BallSucker;

public class OpenToSuck extends CommandBase {
  public BallSucker m_ballSucker;
  public double m_strength;
  
  public OpenToSuck(BallSucker ballSucker, double strength) {
    m_ballSucker = ballSucker;
    m_strength = strength;
    addRequirements(m_ballSucker);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_ballSucker.suck(m_strength);
  }

  @Override
  public void end(boolean interrupted) {
    m_ballSucker.suck(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
