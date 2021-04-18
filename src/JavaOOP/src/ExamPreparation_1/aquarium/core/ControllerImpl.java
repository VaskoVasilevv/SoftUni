package ExamPreparation_1.aquarium.core;

import ExamPreparation_1.aquarium.common.ConstantMessages;
import ExamPreparation_1.aquarium.common.ExceptionMessages;
import ExamPreparation_1.aquarium.models.aquariums.Aquarium;
import ExamPreparation_1.aquarium.models.aquariums.FreshwaterAquarium;
import ExamPreparation_1.aquarium.models.aquariums.SaltwaterAquarium;
import ExamPreparation_1.aquarium.models.decorations.Decoration;
import ExamPreparation_1.aquarium.models.decorations.Ornament;
import ExamPreparation_1.aquarium.models.decorations.Plant;
import ExamPreparation_1.aquarium.models.fish.Fish;
import ExamPreparation_1.aquarium.models.fish.FreshwaterFish;
import ExamPreparation_1.aquarium.models.fish.SaltwaterFish;
import ExamPreparation_1.aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {


    private DecorationRepository decorationRepository;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        decorationRepository = new DecorationRepository();
        aquariums = new LinkedHashMap<>();

    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {

        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.putIfAbsent(aquariumName, aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        this.decorationRepository.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);

    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        String output;
        Decoration byType = this.decorationRepository.findByType(decorationType);

        if (byType == null) {
            output = String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType);
            throw new IllegalArgumentException(output);
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.addDecoration(byType);
        this.decorationRepository.remove(byType);

        output = String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
        return output;
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        Fish fish;

        if (fishType.equals("FreshwaterFish")) {

            fish = new FreshwaterFish(fishName, fishSpecies, price);

        } else if (fishType.equals("SaltwaterFish")) {


            fish = new SaltwaterFish(fishName, fishSpecies, price);

        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);

        if (!aquarium.getClass().getSimpleName().substring(0, 5).equals(fishType.substring(0, 5))) {
            return ConstantMessages.WATER_NOT_SUITABLE;
        }

        aquarium.addFish(fish);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.feed();
        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        double sumFishPrices = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double sumDecorationsPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        double value = sumFishPrices + sumDecorationsPrice;

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, value);

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        for (Aquarium value : aquariums.values()) {
            sb
                    .append(value.getInfo());
        }

        return sb.toString();
    }
}
