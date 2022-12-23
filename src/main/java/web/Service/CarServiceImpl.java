package web.Service;

import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> carList;

    @Override
    public List<Car> returnCars(Integer count) {
        carList = getCarList();
        if (count == null || count >= 5) {
            return carList;
        } else if (count <= 0) {
            return new ArrayList<Car>();
        } else {
            return carList.stream().limit(count).toList();
        }
    }

    public static List<Car> getCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("vaz", "green", "111"));
        cars.add(new Car("gaz", "rose", "222"));
        cars.add(new Car("uaz", "orange", "333"));
        cars.add(new Car("kamaz", "black", "333"));
        cars.add(new Car("belaz", "white", "444"));

        return cars;
    }
}
