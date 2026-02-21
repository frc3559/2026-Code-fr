package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SoftLimitConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class HookSubsystem extends SubsystemBase {
    public SparkMax hook;
    public static final int  kHookMotorCanId = 25;

    public HookSubsystem() {
        hook = new SparkMax(kHookMotorCanId, MotorType.kBrushless);
        SoftLimitConfig hookLimitConfig = new SoftLimitConfig(); //The soft limit code should stop the motor when it hits one of the specified values.
        hookLimitConfig.forwardSoftLimit(100); //We do not know whether the limit value is degrees or rotations
        hookLimitConfig.reverseSoftLimit(0); //These lines make no forward and reverse limits. tweak values based on testing.
        SparkMaxConfig hookConfig = new SparkMaxConfig();
        hookConfig.apply(hookLimitConfig); //applies the hooklimitconfig's limits to the spark max config called hookconfig
        hook.configure(hookConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters); //Change persist and reset paramaters to no or blank based on what we want
    } //the above line configures the motor hook based on hookConfig

    public void hookOn(double speed) {
        hook.set(speed);
    }
    public void hookOff(double speed) {
        hook.set(speed);
    }
} //new intake floor code