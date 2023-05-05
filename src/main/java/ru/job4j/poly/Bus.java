package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Интервал движения автобуса: 30 минут");
    }

    @Override
    public void countPassengers(int numbers) {
        System.out.println("Вместимость автобуса: " + numbers);
    }

    @Override
    public double refill(double fuelVolume) {
        double price = 55.5;
        return fuelVolume * price;
    }
}
