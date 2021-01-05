package frc.robot.subsystems;

import static frc.robot.Constants.DriveTrainConstants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private final WPI_TalonFX leftParent;
    private final WPI_TalonFX leftChild;
    private final WPI_TalonFX rightParent;
    private final WPI_TalonFX rightChild;

    private final DifferentialDrive driveBase;

    public DriveTrain() {

        leftParent = new WPI_TalonFX(LEFT_PARENT_ID);
        leftChild = new WPI_TalonFX(LEFT_CHILD_ID);
        rightParent = new WPI_TalonFX(RIGHT_PARENT_ID);
        rightChild = new WPI_TalonFX(RIGHT_CHILD_ID);

        configureMotor(leftParent, false);
        configureMotor(rightParent, true);
        configureMotor(leftChild, false);
        configureMotor(rightChild, true);

        leftChild.set(ControlMode.Follower, leftParent.getDeviceID());
        rightChild.set(ControlMode.Follower, rightParent.getDeviceID());

        driveBase = new DifferentialDrive(leftParent, rightParent);
        driveBase.setDeadband(DEADBAND);
        

    }

    private void configureMotor(WPI_TalonFX motor, boolean right) {

        motor.configFactoryDefault(); // Resetting the motors to make sure there's no junk on there before configuring
        motor.configVoltageCompSaturation(VOLTAGE_COMPENSATION); // only use 12.3 volts regardless of battery voltage
        motor.enableVoltageCompensation(true); // enable ^
        motor.setNeutralMode(NeutralMode.Brake); // set it so that when the motor is getting no input, it stops
        motor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor); // configure the encoder (it's inside)
        motor.setSelectedSensorPosition(0); // reset the encoder to have a value of 0
        motor.configOpenloopRamp(RAMP_RATE); // how long it takes to go from 0 to the set speed
        motor.setSensorPhase(right);
      // Make sure that both sides' encoders are getting positive values when going
      // forward

    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        driveBase.tankDrive(leftSpeed, rightSpeed);
    }

}