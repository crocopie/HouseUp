public class House {
    private double length;
    private double width;

    private double floors;
    private double weight;

    /*
               width
        |--------|--------|
        |        |        |
        |--------|        |  length
        |        |        |
        |--------|--------|
     */

    private double floorArea; //площадь одного пола/потолка
    private double wallArea; //площадь стен на одном этаже

    static final double WALL_SQUARE_KG = 250; // вес 1 м^2 стены
    static final double FLOOR_SQUARE_KG = 150; // вес 1 м^2 пола/потолка
    static final double FLOOR_HEIGHT = 2.5; // высота этажа

    private long balloonCount; // число шариков
    private double balloonLift; // грузоподъемность шаров

    public House(double length, double width, int floors) {
        this.length = length;
        this.width = width;
        this.floors = floors;
        balloonCount = 0;
        balloonLift = 0;

        floorArea = length * width;
        calculateWallArea(length, width);

        weight = (WALL_SQUARE_KG * wallArea) * floors +
                (FLOOR_SQUARE_KG * floorArea) * (floors + 1);
    }

    /**
     * Метод для расчета площади всех стен на одном этаже
     */
    private void calculateWallArea(double length, double width) {
        wallArea += 2 * (width * FLOOR_HEIGHT);
        wallArea += 3 * (length * FLOOR_HEIGHT);
        wallArea += (width / 2) * FLOOR_HEIGHT;
    }

    /**
     * Мутатор числа этажей
     */
    public void setFloors(int floors) {
        this.floors = floors;
    }

    /**
     * Мутатор длины дома
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Мутатор ширины дома
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Аксессор массы дома
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Аксессор площади этажей
     */
    public double getAllFloorsArea() {
        return floorArea * (floors + 1);
    }

    /**
     * Добавить один шарик
     * @param balloon объект шарика
     */
    public void addBalloons(Balloon balloon) {
        balloonLift += balloon.getLift();
        ++balloonCount;
    }

    /**
     * Добавить один шарик
     * @param balloon сколько грамм поднимет один шар
     */
    public void addBalloons(int balloon) {
        balloonLift += (double) balloon / 1000;
        ++balloonCount;
    }

    /**
     * Добавить один шарик
     * @param balloon сколько грамм поднимет один шар
     */
    public void addBalloons(double balloon) {
        balloonLift += balloon / 1000;
        ++balloonCount;
    }

    /**
     * Аксессор количества шаров
     */
    public long getBalloonCount() {
        return balloonCount;
    }

    /**
     * Взлетел ли дом?
     */
    public boolean isFlying() {
        return (balloonLift > weight);
    }
}
