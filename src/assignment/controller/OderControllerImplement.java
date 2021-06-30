package assignment.controller;

import assignment.Util.Util;
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

        while (true) {
            try {
                System.out.println("Please enter ID Oder(Obligatory):");
                String id = scanner.nextLine();

                System.out.println("Please enter user Name(Obligatory):");
                String userName = scanner.nextLine();

                System.out.println("Please enter products(Obligatory):");
                String products = scanner.nextLine();

                System.out.println("Please enter total price(Obligatory):");
                int totalPrice = scanner.nextInt();

                System.out.println("Please enter status Oder 0-2 (Obligatory):");
                System.out.println("0.Deleted");
                System.out.println("1.Unpaid");
                System.out.println("2.Paid");
                int status = scanner.nextInt();

                Oder newOder = new Oder(id, userName, products, totalPrice, status);
                if (newOder.getUserName() != null && newOder.getOrderId() != null && newOder.getProducts() != null
                        && newOder.getStatus() >= 0 && newOder.getStatus() <= 2) {
                    if (oderModel.save(newOder)) {
                        System.out.println("Success");
                        break;
                    }
                } else {
                    System.out.println("Please enter the correct information!!");
                    scanner.nextLine();
                    continue;
                }

            } catch (Exception ex) {
                System.out.println("Please enter the correct information!!");
                scanner.nextLine();
            }
        }


    }

    @Override
    public void showList() {
        System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%25s%20s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                "", "ID", "",
                "", "Name", "",
                "", "Products", "",
                "", "CreatAt", "",
                "", "Status", "",
                "", "Total", ""
        );
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Oder> list = oderModel.findAll();
        for (Oder o : list
        ) {
            System.out.println(o.toString());
        }

    }

    @Override
    public void searchOderById() {
        System.out.println("Please enter ID Oder:");
        String id = scanner.nextLine();
        Oder result = oderModel.findById(id);
        if (result == null) {
            System.out.println("Not found!! Please double check the information you just entered!!");
        } else {
            System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%25s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                    "", "ID", "",
                    "", "Name", "",
                    "", "Products", "",
                    "", "CreatAt", "",
                    "", "Status", "",
                    "", "Total", ""
            );
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(result.toString());
        }


    }

    @Override
    public void RevenueByTime() {
        while (true) {
            try {
                System.out.println("Please enter start time follow (yyyy-mm-dd)-(ex: 2021-06-28):");
                String date1 = scanner.nextLine();
                LocalDate dateStart = LocalDate.parse(date1);
                System.out.println("Please enter end time follow (yyyy/mm/dd)-(ex: 2021/06/28):");
                String date2 = scanner.nextLine();
                LocalDate dateEnd = LocalDate.parse(date2);
                List<Oder> list = oderModel.findByTime(dateStart, dateEnd);
//
                if (list == null) {
                    System.out.printf("Have no finished order from time %s  to %s\n", dateStart.toString(), dateEnd.toString());
                    break;
                } else {
                    System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%25s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                            "", "ID", "",
                            "", "Name", "",
                            "", "Products", "",
                            "", "CreatAt", "",
                            "", "Status", "",
                            "", "Total", ""
                    );
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    int sum = 0;
                    for (Oder oder : list
                    ) {
                        sum += oder.getTotalPrice();
                        System.out.println(oder.toString());
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%170s%15s%s%s\n", "", "Total money: ", Util.moneyVND(sum), " (VNĐ)");
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Please double check the information you just entered!!");


            }
        }


    }
}
