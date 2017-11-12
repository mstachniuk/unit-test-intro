package com.example.task09;

import com.example.universum.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class PlanetLifeValidatorTest {

    @Test
    public void shouldThrowExceptionWhenAvgOrbitalSpeedIsGreaterThanLightSpeed() {
        // given
        PlanetLifeValidator validator = new PlanetLifeValidator();
        Planet planet = examplePlanet();
        planet.setAvgOrbitalSpeed(Speed.createKmPerSecond("310000")); // Greater Than 299 792 458 m/s

        // sugerowane rozwiaznie
        Assertions.assertThatThrownBy(() -> validator.canBeLife(planet))
                .isInstanceOf(InvalidPlanetSpeed.class)
                .hasMessage("Speed ist greater than light speed");
    }

    private Planet examplePlanet() {
        return new Planet("Very Speed Planet", RotationDirection.LEFT,
                Distance.createFromMeter(new BigDecimal("4879400")),
                new SiderealYear(new BigDecimal("87.96935")));
    }
}
