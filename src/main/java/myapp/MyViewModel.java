package myapp;

import myapp.model.Car;
import myapp.service.CarService;
import myapp.service.servImplementation.CarServImplementation;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.ListModelList;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {
    private String keyword;
    private List<Car> carList = new ListModelList<Car>();
    private Car selectedCar;

    private CarService carService = new CarServImplementation();

    @Command
    @NotifyChange("carList")
    public void search() {
        carList.clear();
        carList.addAll(carService.search(keyword));
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<Car> getCarList(){
        return carList;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    public Car getSelectedCar() {
        return selectedCar;
    }
}
