package EXAMS.spaceStation.models.mission;

import EXAMS.spaceStation.models.astronauts.Astronaut;
import EXAMS.spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;


public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {

            if (astronaut.canBreath()) {
                while (planet.getItems().size() > 0) {
                    List<String> items = (List<String>) planet.getItems();
                    astronaut.getBag().getItems().add(items.get(0));
                    planet.getItems().remove(items.get(0));
                    astronaut.breath();
                    if (items.isEmpty() || astronaut.getOxygen() <= 0) {
                        break;
                    }
                }
            }
        }

    }
}
