import java.util.Scanner;

public class SelectOperations {
    public void SelectOperations()
    {
        System.out.println("\n\n\n\n+++++++++++++++++++++++++++++++");
        System.out.println("-----------------------------------");
        System.out.println("Please Select operation to perform : ");
        System.out.println("Enter : ");
        System.out.println("1 : Insert data");
        System.out.println("2 : Select data");
        System.out.println("3 : Delete data");
        System.out.println("4 : update data");
        System.out.println("-----------------------------------");

        System.out.print("Enter your choise : ");

        Scanner sc = new Scanner(System.in);
        int userInput=sc.nextInt();

      PerformOperations PO=new PerformOperations() ;
      switch (userInput)
        {
            case 1:
                PO.insertData();
                break;
            case 2:
                PO.selectData();
                break;
            case 3:
                PO.deleteData();
                break;
            case 4:
                PO.updateData();
                break;
            default:
                new SelectOperations().SelectOperations();
        }
        new SelectOperations().SelectOperations();

    }
}
