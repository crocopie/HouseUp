public class HouseUp {
    public static void main(String[] args) {
        double length = Double.parseDouble(args[0]);
        double width = Double.parseDouble(args[1]);
        int floors = Integer.parseInt(args[2]);


        House house = new House(length, width, floors);
        Balloon balloon;

        long time = System.currentTimeMillis();

        // Пробуем создать кучу объектов
        while (!house.isFlying()) {
            balloon = new Balloon(27);
            house.addBalloons(balloon);
        }

        time = System.currentTimeMillis() - time;

        System.out.format("Понадобилось %d шаров чтобы поднять дом массой %f кг \n",
                house.getBalloonCount(), house.getWeight());

        System.out.println("Время выполнения программы c объектами: " + time);

        house = new House(length, width, floors);
        time = System.currentTimeMillis();

        // Пробуем создать кучу примитивов
        while (!house.isFlying()) {
            int intBalloon = 4;
            house.addBalloons(intBalloon);
        }

        time = System.currentTimeMillis() - time;

        System.out.format("Понадобилось %d шаров чтобы поднять дом массой %f кг \n",
                house.getBalloonCount(), house.getWeight());

        System.out.println("Время выполнения программы c примитивами int: " + time);

    }

}
