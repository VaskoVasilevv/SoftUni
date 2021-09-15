package EXAMS.spaceStation.models.astronauts;

import EXAMS.spaceStation.common.ExceptionMessages;
import EXAMS.spaceStation.models.bags.Backpack;
import EXAMS.spaceStation.models.bags.Bag;

import static EXAMS.spaceStation.common.ConstantMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;
    private boolean canBreath;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        bag = new Backpack();
        this.canBreath = true;

    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.canBreath;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen -= 10;
        if (oxygen <= 0) {
            this.canBreath = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_ASTRONAUT_NAME, this.name)).append(System.lineSeparator());
        builder.append(String.format(REPORT_ASTRONAUT_OXYGEN, this.oxygen)).append(System.lineSeparator());
        String res = "";
        if (this.bag.getItems().size() == 0) {
            res = "none";
        } else {
            res = String.join(", ", this.bag.getItems());
        }
        builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, res));
        builder.append(System.lineSeparator());
        return builder.toString().trim();
    }
}
