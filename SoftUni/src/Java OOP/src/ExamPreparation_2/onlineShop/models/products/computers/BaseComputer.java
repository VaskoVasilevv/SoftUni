package ExamPreparation_2.onlineShop.models.products.computers;

import ExamPreparation_2.onlineShop.models.products.BaseProduct;
import ExamPreparation_2.onlineShop.models.products.components.Component;
import ExamPreparation_2.onlineShop.models.products.peripherals.Peripheral;

import java.util.LinkedList;
import java.util.List;

import static ExamPreparation_2.onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new LinkedList<>();
        this.peripherals = new LinkedList<>();
    }

    @Override
    public double getOverallPerformance() {
        return this.components.isEmpty()
                ?super.getOverallPerformance()
                :super.getOverallPerformance() + getComponentsAveragePerformance();

    }

    @Override
    public double getPrice() {
        double totalPrice = this.components.stream().mapToDouble(e -> e.getPrice()).sum();
        double totalPricePeripheral = this.peripherals.stream().mapToDouble(e -> e.getPrice()).sum();

        return super.getPrice() + totalPrice + totalPricePeripheral;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(e -> e.getClass().getSimpleName()
                .equals(component.getClass().getSimpleName()))) {

            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.components.add(component);

    }

    @Override
    public Component removeComponent(String componentType) {

        Component component = this.components.stream().filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        if (component == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }
        components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.stream().anyMatch(e -> e.getClass().getSimpleName()
                .equals(peripheral.getClass().getSimpleName()))) {

            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream().filter(e -> e.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);

        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        peripherals.remove(peripheral);
        return peripheral;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(" Components (").append(components.size()).append("):").append(System.lineSeparator());

        for (Component component : components) {
            sb.append(component).append(System.lineSeparator());
        }

        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):"
                , peripherals.size()
                , peripherals.stream().map(Peripheral::getOverallPerformance).mapToDouble(Double::doubleValue).average().orElse(0.00)));
        sb.append(System.lineSeparator());
        peripherals.stream().forEach(e -> sb.append(" ").append(e.toString()).append(System.lineSeparator()));

        return sb.toString();
    }

    private double getComponentsAveragePerformance() {

        return this.getComponents().stream()
                .mapToDouble(Component::getOverallPerformance).average().orElse(0);
    }
}
