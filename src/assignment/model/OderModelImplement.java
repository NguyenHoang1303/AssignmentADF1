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
        list.add(new Oder("001","Nguyen","gà,xả,ớt,lá chanh,chanh",100000, 1));
        list.add(new Oder("002","Nguyen1","gà,xả,ớt,lá chanh,chanh",200000, 2));
        list.add(new Oder("003","Nguyen2","gà,xả,ớt,lá chanh,chanh",300000, 3));
        list.add(new Oder("004","Nguyen3","gà,xả,ớt,lá chanh,chanh",400000, 1));
        list.add(new Oder("005","Nguyen4","gà,xả,ớt,lá chanh,chanh",500000, 2));
        list.add(new Oder("006","Nguyen5","gà,xả,ớt,lá chanh,chanh",600000, 3));
        list.add(new Oder("007","Nguyen6","gà,xả,ớt,lá chanh,chanh",700000, 1));
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
        List<Oder> newOder = new ArrayList<>();
        for (Oder oder: list
             ) {
            if(startTime.compareTo(oder.getCreatAt()) <= 0 && endTime.compareTo(oder.getCreatAt()) >= 0){
                newOder.add(oder);
            }
        }
        return newOder;
    }
}