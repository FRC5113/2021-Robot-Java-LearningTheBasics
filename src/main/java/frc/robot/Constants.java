/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final static class DriveTrainConstants {

        public final static int LEFT_PARENT_ID = 22;
        public final static int LEFT_CHILD_ID = 21;
        public final static int RIGHT_PARENT_ID = 12;
        public final static int RIGHT_CHILD_ID = 11;

        public final static double RAMP_RATE = 0.5;
        public final static double VOLTAGE_COMPENSATION = 12.3;
        public final static double DEADBAND = 0.02;

    }

}
