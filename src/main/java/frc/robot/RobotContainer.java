// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import static frc.robot.Constants.JOYSTICK.*;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.OpenToSuck;
import frc.robot.commands.Auto;

import frc.robot.subsystems.BallSucker;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static final Joystick joystick = new Joystick(JOYSTICK_ID);

  private final DriveBase driveBase = new DriveBase();
  private final BallSucker ballSucker = new BallSucker();

  Command driveStraightCommand = new DriveStraight(driveBase, 0.8, 0.8); // 0.8 la cong suat cua dong co
  Command openToSuck = new OpenToSuck(ballSucker, 0.8);
  Command autoCommand = new Auto(ballSucker, driveBase);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(joystick, JOYSTICK_BUTTON).whenActive(driveStraightCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return autoCommand;
  }
}