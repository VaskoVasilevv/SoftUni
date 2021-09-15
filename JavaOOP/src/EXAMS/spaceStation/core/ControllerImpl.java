package EXAMS.spaceStation.core;

import EXAMS.spaceStation.common.ConstantMessages;
import EXAMS.spaceStation.common.ExceptionMessages;
import EXAMS.spaceStation.models.astronauts.Astronaut;
import EXAMS.spaceStation.models.astronauts.Biologist;
import EXAMS.spaceStation.models.astronauts.Geodesist;
import EXAMS.spaceStation.models.astronauts.Meteorologist;
import EXAMS.spaceStation.models.mission.Mission;
import EXAMS.spaceStation.models.mission.MissionImpl;
import EXAMS.spaceStation.models.planets.Planet;
import EXAMS.spaceStation.models.planets.PlanetImpl;
import EXAMS.spaceStation.repositories.AstronautRepository;
import EXAMS.spaceStation.repositories.PlanetRepository;
import EXAMS.spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static EXAMS.spaceStation.common.ConstantMessages.*;
import static EXAMS.spaceStation.common.ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS;


public class ControllerImpl implements Controller {
    public static int plCounter = 0;
    public static int counter = 0;
    private Repository<Astronaut> astronauts;
    private Repository<Planet> planets;

    public ControllerImpl() {
        astronauts = new AstronautRepository();
        planets = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronauts.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }


    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        Collection<String> planetItems = planet.getItems();
        planetItems.addAll(Arrays.asList(items));

        this.planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronauts.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            astronauts.remove(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planets.findByName(planetName);
        Mission mission = new MissionImpl();
        List<Astronaut> astronauts =
                this.astronauts.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());
        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(planet, astronauts);
        List<Astronaut> survivedAstronauts = astronauts.stream().filter(a -> a.getOxygen() > 0.0).collect(Collectors.toList());
        plCounter++;
        return String.format(PLANET_EXPLORED, planetName, astronauts.size() - survivedAstronauts.size());

    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_PLANET_EXPLORED, plCounter));
        builder.append(System.lineSeparator());

        List<Astronaut> astronauts = new ArrayList<>(this.astronauts.getModels());
        for (Astronaut aliveAstronaut : astronauts) {
            builder.append(aliveAstronaut.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
