package frc.robot.subsystems;

import static frc.robot.Constants.DriveTrainConstants.*;
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

        driveBase = new DifferentialDrive(leftParent, rightParent);

    }

}