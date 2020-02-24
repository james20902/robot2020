package org.usfirst.frc.team449.robot._2020.shooter;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;

/**
 * A subsystem with a flywheel and feeder.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.CLASS,
    include = JsonTypeInfo.As.WRAPPER_OBJECT,
    property = "@class")
public interface SubsystemFlywheel {

  /**
   * Turn the flywheel on to the speed passed to the constructor.
   */
  void turnFlywheelOn();

  /**
   * Turn the flywheel off.
   */
  void turnFlywheelOff();

  /**
   * Start feeding balls into the flywheel.
   */
  void turnFeederOn();

  /**
   * Stop feeding balls into the flywheel.
   */
  void turnFeederOff();

  /**
   * @return The current state of the flywheel.
   */
  @NotNull
  FlywheelState getFlywheelState();

  /**
   * @param state The state to switch the flywheel to.
   */
  void setFlywheelState(@NotNull FlywheelState state);

  /**
   * @return Time from giving the flywheel voltage to being ready to fire, in seconds.
   */
  double getSpinUpTimeoutSecs();

  /**
   * @return Whether the flywheel has met its requirements for shooting such as attaining a certain
   * speed.
   */
  default boolean isReadyToShoot() {
    return true;
  }

  /**
   * The possible states of the flywheel.
   */
  enum FlywheelState {
    /** Both flywheel and feeder off. */
    OFF,
    /** Feeder off, flywheel on. */
    SPINNING_UP,
    /** Both flywheel and feeder on. */
    SHOOTING
  }
}
