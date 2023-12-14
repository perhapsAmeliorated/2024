// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobotFront; //This used to just be m_myRobot.  We made it Left and added a Right.  Will it work?  No-one knowws
  private DifferentialDrive m_myRobotBack;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
 // private final Joystick stick = new Joystick(0);


  //PWM channel 0 is broken on our current RoboRio.  Would not recommend trying to use it
  Spark leftMotor1 = new Spark(1);
  Spark leftMotor2 = new Spark(2);
  Spark rightMotor1 = new Spark(3);
  Spark rightMotor2 = new Spark(4);


  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //Also something like this happens at the bottom so we might not need this at all


    m_myRobotFront = new DifferentialDrive(leftMotor1, leftMotor1);
    m_myRobotBack = new DifferentialDrive(rightMotor2, rightMotor2);
    m_leftStick = new Joystick(1);
    m_rightStick = new Joystick(1);
  }




  @Override
  public void teleopPeriodic() {
    m_myRobotFront.arcadeDrive(m_leftStick.getRawAxis(1), m_rightStick.getRawAxis(1));
    m_myRobotBack.arcadeDrive(m_leftStick.getRawAxis(5), m_rightStick.getRawAxis(5));

  }
}
