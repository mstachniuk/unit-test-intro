package com.example.task09;

import com.example.universum.*;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.Java6Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class PlanetLifeValidatorTest {

    @Test
    public void shouldThrowExceptionWhenAvgOrbitalSpeedIsGreaterThanLightSpeed() throws Exception {
        // given
        PlanetLifeValidator validator = new PlanetLifeValidator();
        Planet planet = examplePlanet();
        planet.setAvgOrbitalSpeed(Speed.createKmPerSecond("310000")); // Greater Than 299 792 458 m/s

        // sugerowane rozwiaznie
        Assertions.assertThatThrownBy(() -> validator.canBeLife(planet))
                .isInstanceOf(InvalidPlanetSpeed.class)
                .hasMessage("Speed ist greater than light speed");

        // jezeli powyzsza ^ wersja nie dziala
        AssertionsForClassTypes.assertThatThrownBy(() -> validator.canBeLife(planet))
                .isInstanceOf(InvalidPlanetSpeed.class)
                .hasMessage("Speed ist greater than light speed");

        // DLa komatybilnosci z Androidem
        Java6Assertions.assertThatThrownBy(() -> validator.canBeLife(planet))
                .isInstanceOf(InvalidPlanetSpeed.class)
                .hasMessage("Speed ist greater than light speed");
    }

    private Planet examplePlanet() throws InvalidPlanetSpeed {
        return new Planet("Very Speed Planet", RotationDirection.LEFT,
                Distance.createFromMeter(new BigDecimal("4879400")),
                new SiderealYear(new BigDecimal("87.96935")));
    }
}
