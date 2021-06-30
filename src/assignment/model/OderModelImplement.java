package assignment.model;

import assignment.entity.Oder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OderModelImplement implements OderModel {
    private List<Oder> list;

    public OderModelImplement() {
//        this.list = new ArrayList<>();
    }

    {
        list = new ArrayList<>();
        list.add(new Oder("001", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 1), 100000, 0));
        list.add(new Oder("002", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 2), 200000, 1));
        list.add(new Oder("003", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 3), 300000, 2));
        list.add(new Oder("004", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 4), 400000, 1));
        list.add(new Oder("005", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 5), 500000, 0));
        list.add(new Oder("006", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 6), 600000, 2));
        list.add(new Oder("007", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 7), 700000, 1));
        list.add(new Oder("008", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 8), 800000, 2));
        list.add(new Oder("009", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 9), 900000, 2));
        list.add(new Oder("010", "Nguyen9", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 05, 10), 150000, 1));
        list.add(new Oder("011", "Nguyen10", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 11), 250000, 2));
        list.add(new Oder("012", "Nguyen11", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 12), 350000, 0));
        list.add(new Oder("013", "Nguyen12", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 13), 450000, 2));
        list.add(new Oder("014", "Nguyen13", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 14), 550000, 0));
        list.add(new Oder("015", "Nguyen14", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 15), 650000, 2));
        list.add(new Oder("016", "Nguyen15", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 16), 750000, 1));
        list.add(new Oder("017", "Nguyen16", "gà,xả,ớt,lá chanh,", LocalDate.of(2021, 06, 17), 850000, 1));
    }

    @Override
    public boolean save(Oder obj) {
        list.add(obj);
        return true;
    }

    @Override
    public List<Oder> findAll() {
        return list;
    }

    @Override
    public Oder findById(String id) {
        for (Oder oder : list
        ) {
            if (oder.getOrderId().equals(id)) return oder;

        }
        return null;
    }

    @Override
    public List<Oder> findByTime(LocalDate startTime, LocalDate endTime) {

        List<Oder> newList = new ArrayList<>();
        for (Oder oder : list
        ) {
            if (startTime.compareTo(oder.getCreatAt()) <= 0
                    && endTime.compareTo(oder.getCreatAt()) >= 0 && oder.getStatus() == 2) {
                newList.add(oder);
            }
        }
        if (newList.size() > 0) return newList;
        return null;
    }
}
