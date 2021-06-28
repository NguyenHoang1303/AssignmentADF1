package assignment.model;

import assignment.entity.Oder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public interface OderModel {
    boolean save(Oder obj);
    List<Oder> findAll();
    Oder findById(String id);
    List<Oder> findByTime(LocalDate startTime, LocalDate endTime);

}
