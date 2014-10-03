public class Balloon {
    private double lift; // грузоподъемность шарика
    private double volume; // объем гелия
    private double diameter;

    private static final double PI = 3.1415;
    private static final double HELIUM_CM3_LIFT_KG = 0.000001; // сколько кг поднимет один см^3 гелия

    /**
     * Конструктор шарика
     * @param diameter диаметр в сантиметрах
     */
    public Balloon(int diameter) {
        this.diameter = diameter;

        //calculateLift(diameter);
        calculateDebugLift(diameter); // испольуем упрощенный расчет грузоподъемности,
                                      // чтобы число шаров для примитивов не отличалось
    }

    /**
     * "Научный" рассчет грузоподъемности шарика
     */
    private void calculateLift(int diameter) {
        double r = diameter / 2;
        volume = 4.0 / 3.0 * PI * (r * r * r);

        lift = volume * HELIUM_CM3_LIFT_KG;
    }

    /**
     * Упрощенный рассчет грузоподъемности шарика для отладки
     */
    private void calculateDebugLift(int diameter) {
        double r = diameter / 2;
        volume = 4.0 / 3.0 * PI * (r * r * r);

        lift = (4.0 / 27 * diameter) / 1000;
    }

    /**
     * Мутатор диаметра (для надувания шаров)
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;

        calculateLift(diameter);
    }

    /**
     * Аксессор грузоподъемности шара
     */
    public double getLift() {
        return lift;
    }

    /**
     * Аксессор объема гелия
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Аксессор диаметра шара
     */
    public double getDiameter() {
        return diameter;
    }
}
