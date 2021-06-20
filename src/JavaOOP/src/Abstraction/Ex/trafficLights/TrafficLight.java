package Abstraction.Ex.trafficLights;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color light) {
        this.color = light;
    }

    public void update() {
        switch (color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
        }
    }

    public Color getColor() {
        return color;
    }
}
