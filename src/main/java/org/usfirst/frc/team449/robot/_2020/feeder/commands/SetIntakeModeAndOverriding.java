package org.usfirst.frc.team449.robot._2020.feeder.commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.wpi.first.wpilibj2.command.Subsystem;
import io.github.oblarg.oblog.annotations.Log;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot._2020.intake.commands.SetIntakeMode;
import org.usfirst.frc.team449.robot._2020.multiSubsystem.SubsystemIntake;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "@class")
public class SetIntakeModeAndOverriding<T extends Subsystem & SubsystemIntake> extends SetIntakeMode<T> {

    /** The subsystem to execute this command on. */
    @NotNull @Log.Exclude private final T subsystem;

    /**
     * Default constructor
     *
     * @param subsystem The subsystem to execute this command on.
     * @param mode      The mode to set the intake to.
     */
    @JsonCreator
    public SetIntakeModeAndOverriding(
            @NotNull T subsystem,
            SubsystemIntake.@NotNull IntakeMode mode) {
        super(subsystem, mode);
        this.subsystem = subsystem;
    }

    /** Set the intake to the given mode. */
    @Override
    public void execute() {
        super.execute();

    }
}
