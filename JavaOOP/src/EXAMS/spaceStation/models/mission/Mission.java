package EXAMS.spaceStation.models.mission;

import EXAMS.spaceStation.models.astronauts.Astronaut;
import EXAMS.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
