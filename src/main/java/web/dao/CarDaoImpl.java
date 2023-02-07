package web.dao;
import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Lada", "black", "A111AA"));
        carList.add(new Car("BMW", "pink", "A222AA"));
        carList.add(new Car("Mercedes", "yellow", "A333AA"));
        carList.add(new Car("Nissan", "blue", "A444AA"));
        carList.add(new Car("YAZ", "green", "A555AA"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
