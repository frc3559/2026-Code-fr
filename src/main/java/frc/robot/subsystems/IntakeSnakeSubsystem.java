package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSnakeSubsystem extends SubsystemBase {
    public SparkMax intakeFloor;
    public SparkMax intakeSnake;
    public static final int  kIntakeFloorMotorCanId = 25;
    public static final int  kIntakeSnakeMotorCanId = 24;

    public IntakeSnakeSubsystem() {
        intakeSnake = new SparkMax(kIntakeFloorMotorCanId, MotorType.kBrushless);
    }

    public void intakeSnake(double speed) {
        intakeFloor.set(speed);
        intakeSnake.set(speed);
    }
}
