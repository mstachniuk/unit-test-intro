package com.example.task08;

import com.example.universum.Gas;
import com.example.universum.Planet;
import com.example.universum.RotationDirection;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;

public class PlanetAssert extends AbstractAssert<PlanetAssert, Planet> {

    public static PlanetAssert assertThat(Planet actual) {
        Assertions.assertThat(actual).isNotNull();
        return new PlanetAssert(actual);
    }

    private PlanetAssert(Planet actual) {
        super(actual, PlanetAssert.class);
    }

    public PlanetAssert hasName(String expectedName) {
        Assertions.assertThat(actual.getName()).isEqualTo(expectedName);
        return this;
    }

    public PlanetAssert hasRotation(RotationDirection expectedDirection) {
        Assertions.assertThat(actual.getRotationDirection()).isEqualTo(expectedDirection);
        return this;
    }

    public PlanetAssert hasDiameterInMeter(String expectedDiameterInMeter) {
        Assertions.assertThat(actual.getDiameter().getMeter())
                .isEqualTo(new BigDecimal(expectedDiameterInMeter));
        return this;
    }

    public PlanetAssert containsOnlyGases(Gas... expectedGases) {
        Assertions.assertThat(actual.getAtmosphereGases()).containsOnly(expectedGases);
        return this;
    }
}
