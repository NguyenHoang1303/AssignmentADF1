package assignment.controller;

import assignment.entity.Oder;
import assignment.model.OderModel;
import assignment.model.OderModelImplement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class OderControllerImplement implements OderController {
    private OderModel oderModel;
    private Scanner scanner;

    public OderControllerImplement() {
        this.oderModel = new OderModelImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void creatNewOder() {
        System.out.println("Please enter ID Oder");
        String id = scanner.nextLine();

        System.out.println("Please enter user Name");
        String userName = scanner.nextLine();

        System.out.println("Please enter products");
        String products = scanner.nextLine();

        System.out.println("Please enter total price");
        int totalPrice = scanner.nextInt();

        System.out.println("Please enter ID Oder");
        int status = scanner.nextInt();

        Oder newOder =new Oder(id, userName,products, totalPrice, status);

       if ( oderModel.save(newOder)){
           System.out.println("Success");
       } else {
           System.out.println("Fails");
//           creatNewOder();
       }

    }

    @Override
    public void showList() {
        System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%20s | %5s%10s%10s | %5s%5s%5s | %5s%10s%5s |\n",
                "", "ID", "",
                "", "Name", "",
                "", "Products", "",
                "", "Total", "",
                "", "Status", "",
                "", "CreatAt", ""
        );
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Oder> list = oderModel.findAll();
        for (Oder o: list
             ) {
            System.out.println(o.toString());
        }

    }

    @Override
    public void searchOderById() {
        System.out.println("Please enter ID Oder:");
        String id = scanner.nextLine();
        Oder result = oderModel.findById(id);
        if(result == null){
            System.out.println("Not found!!");
        } else {
            System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%20s | %5s%10s%10s | %5s%5s%5s | %5s%10s%5s |\n",
                    "", "ID", "",
                    "", "Name", "",
                    "", "Products", "",
                    "", "Total", "",
                    "", "Status", "",
                    "", "CreatAt", ""
            );
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(result.toString());
        }


    }

    @Override
    public void RevenueByTime() {

        System.out.println("Please enter start time follow (yyyy/mm/dd)-(ex: 2021/06/28):");
        System.out.println("Please enter year");
        int yStar = scanner.nextInt();
        System.out.println("Please enter month");
        int mStar = scanner.nextInt();
        System.out.println("Please enter day");
        int dStar = scanner.nextInt();
        LocalDate dateStart = LocalDate.of(yStar,mStar,dStar);

        System.out.println("Please enter end time follow (yyyy/mm/dd)-(ex: 2021/06/28):");
        System.out.println("Please enter year");
        int yEnd = scanner.nextInt();
        System.out.println("Please enter month");
        int mEnd = scanner.nextInt();
        System.out.println("Please enter day");
        int dEnd = scanner.nextInt();
        LocalDate dateEnd = LocalDate.of(yEnd,mEnd,dEnd);

         List<Oder> list = oderModel.findByTime(dateStart,dateEnd);
        System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%20s | %5s%10s%10s | %5s%5s%5s | %5s%10s%5s |\n",
                "", "ID", "",
                "", "Name", "",
                "", "Products", "",
                "", "Total", "",
                "", "Status", "",
                "", "CreatAt", ""
        );
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Oder oder: list
             ) {
            System.out.println(oder.toString());
        }

    }
}
