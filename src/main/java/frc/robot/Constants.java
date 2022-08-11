// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //steer ratio 1.2:1
    //Drive gear ratio 6.67:1
    public static final class ModuleConstants {
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        public static final double kDriveMotorGearRatio = 1/6.67;
        public static final double kTurningMotorGearRatio = 1/1.2;
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter/60;
        public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad/60;
        public static final double kPTurning = 0.5;
    }

    public static final class DriveConstants {

        public static final double kTrackWidth = Units.inchesToMeters(13);

        public static final double kWheelBase = Units.inchesToMeters(16);

        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, - kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2)
        );


        public static final int kFrontLeftDriveMotorPort;
        public static final int kFrontLeftTurningMotorPort;
        public static final Boolean kFrontLeftDriveMotorReversed;
        public static final Boolean kFrontLeftTurningMotorReversed;
        public static final int kFrontLeftTurningEncoderIDA;
        public static final int kFrontLeftTurningEncoderIDB;

        public static final int kFrontRightDriveMotorPort;
        public static final int kFrontRightTurningMotorPort;
        public static final Boolean kFrontRightDriveMotorReversed;
        public static final Boolean kFrontRightTurningMotorReversed;
        public static final int kFrontRightTurningEncoderIDA;
        public static final int kFrontRightTurningEncoderIDB;
        
        public static final int kBackLeftDriveMotorPort;
        public static final int kBackLeftTurningMotorPort;
        public static final Boolean kBackLeftDriveMotorReversed;
        public static final Boolean kBackLeftTurningMotorReversed;
        public static final int kBackLeftTurningEncoderIDA;
        public static final int kBackLeftTurningEncoderIDB;

        public static final int kBackRightDriveMotorPort;
        public static final int kBackRightTurningMotorPort;
        public static final Boolean kBackRightDriveMotorReversed;
        public static final Boolean kBackRightTurningMotorReversed;
        public static final int kBackRightTurningEncoderIDA;
        public static final int kBackRightTurningEncoderIDB;

        public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
        public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

        public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = 
                kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final boolean kDriverFieldOriented = true;
        public static final double kDeadband = 0.05;
    }
}
