package org.usfirst.frc.team449.robot.commands.multiSubsystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.jetbrains.annotations.Nullable;
import org.usfirst.frc.team449.robot.subsystem.interfaces.flywheel.SubsystemFlywheel;
import org.usfirst.frc.team449.robot.subsystem.interfaces.flywheel.commands.SpinUpFlywheel;
import org.usfirst.frc.team449.robot.subsystem.interfaces.intake.SubsystemIntake;
import org.usfirst.frc.team449.robot.subsystem.interfaces.intake.commands.SetIntakeMode;
import org.usfirst.frc.team449.robot.subsystem.interfaces.solenoid.SubsystemSolenoid;
import org.usfirst.frc.team449.robot.subsystem.interfaces.solenoid.commands.SolenoidReverse;

/**
 * Command group for preparing the flywheel to fire. Starts flywheel, runs static intake, stops
 * dynamic intake, raises intake, and stops feeder.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class RackShooter<T extends Subsystem & SubsystemIntake & SubsystemSolenoid>
    extends ParallelCommandGroup {

  /**
   * Constructs a RackShooter command group
   *
   * @param subsystemFlywheel flywheel subsystem. Can be null.
   * @param subsystemIntake intake subsystem. Can be null.
   */
  @JsonCreator
  public RackShooter(@Nullable SubsystemFlywheel subsystemFlywheel, @Nullable T subsystemIntake) {
    if (subsystemFlywheel != null) {
      addCommands(new SpinUpFlywheel(subsystemFlywheel, subsystemIntake));
    }
    if (subsystemIntake != null) {
      addCommands(
          new SolenoidReverse(subsystemIntake),
          new SetIntakeMode(subsystemIntake, SubsystemIntake.IntakeMode.IN_SLOW));
    }
  }
}
