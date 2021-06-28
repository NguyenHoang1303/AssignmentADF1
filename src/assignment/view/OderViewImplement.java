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
           System.out.println("2.Search order by id.");
           System.out.println("3.Revenue by time.");
           System.out.println("5.Show.");
           System.out.println("4.Exist.");
           System.out.println("-------------------------");
           int choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice){
               case 1:
                   oderController.creatNewOder();
                   break;
               case 2:
                   oderController.searchOderById();
                   break;
               case 3:
                   oderController.RevenueByTime();
                   break;
               case 5:
                   oderController.showList();
                   break;
               case 4:
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
