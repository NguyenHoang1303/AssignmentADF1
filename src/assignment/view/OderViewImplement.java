package assignment.view;

import assignment.controller.OderController;
import assignment.controller.OderControllerImplement;

import java.util.Scanner;

public class OderViewImplement implements OderView {
    private OderControllerImplement oderController;
    private Scanner scanner;

    public OderViewImplement() {
        this.oderController = new OderControllerImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void Menu() {
        Boolean isMenu = true;
       while (isMenu){
           System.out.println("Oder Manager Nguyen-Mart");
           System.out.println("-------------------------");
           System.out.println("1.Add new order");
           System.out.println("2.Show.");
           System.out.println("3.Search order by id.");
           System.out.println("4.Revenue by time.");
           System.out.println("0.Exist.");
           System.out.println("-------------------------");
           System.out.println("Please choice 0-4");
           int choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice){
               case 1:
                   oderController.creatNewOder();
                   break;
               case 2:
                   oderController.showList();
                   break;
               case 3:
                   oderController.searchOderById();
                   break;
               case 4:
                   oderController.RevenueByTime();
                   break;
               case 0:
                   System.out.println("Bye bye!");
                   isMenu = false;
                   break;
               default:
                   System.out.println("Invalid choice! 1-4");
                   break;
           }
           if (isMenu){
               System.out.println("Please Enter continue!!");
               scanner.nextLine();
           }

       }

    }
}
