package com.example.task08;

import com.example.task07.SolarSystemFactory;
import com.example.universum.Gas;
import com.example.universum.Planet;
import com.example.universum.RotationDirection;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolarSystemFactoryTest {

    @Test
    public void shouldVerifyMercury() {
        // given
        SolarSystemFactory factory = new SolarSystemFactory();

        // when
        List<Planet> innerPlanets = factory.createInnerPlanets();

        // then
        Planet mercury = innerPlanets.get(0);
        Set<Gas> gass = new HashSet<>();
        gass.add(Gas.OXYGEN);
        gass.add(Gas.HYDROGEN);
        PlanetAssert.assertThat(mercury).hasName("Mercury")
                .hasRotation(RotationDirection.LEFT)
                .hasDiameterInMeter("4879400")
                .containsOnlyGases(Gas.OXYGEN, Gas.SODIUM)
                .containsOnlyGases(new Gas [] {Gas.OXYGEN, Gas.SODIUM, Gas.HYDROGEN});
    }
}
