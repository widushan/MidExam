import java.util.ArrayList;
import java.util.Scanner;


public class Tester {
    private ArrayList<BloodSugar> records = new ArrayList<>();
    
    public static void main(String[] args) {
        Tester bloodSugarApp = new Tester();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            bloodSugarApp.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bloodSugarApp.create();
                    break;
                case 2:
                    bloodSugarApp.index();
                    break;
                case 3:
                    System.out.print("Enter user id: ");
                    int id = scanner.nextInt();
                    bloodSugarApp.view(id);
                    break;
                case 4:
                    bloodSugarApp.delete();
                    break;
                case 5:
                    bloodSugarApp.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("");
        System.out.println("1. Create a record");
        System.out.println("2. Show blood sugar data for all users");
        System.out.println("3. Show blood sugar data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
        System.out.println("Enter your choice: ");
    }

    public void index() {
        for (BloodSugar record : records) {
            record.display();
        }
    }

    public void view(int id) {
        for (BloodSugar record : records) {
            if (record.getId() == id) {
                record.display();
                return;
            }
        }
        System.out.println("Record not found for ID: " + id);
        System.out.println("");
    }

    public void create() {
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year of birth: ");
        int yob = scanner.nextInt();
        System.out.print("Enter blood sugar level: ");
        int sugarLevel = scanner.nextInt();

        BloodSugar newRecord = new BloodSugar(id, name, yob, sugarLevel);
        records.add(newRecord);

        System.out.println("Record created successfully!");
        System.out.println("");
    }

    public void delete() {
        records.clear();
        System.out.println("All records deleted!");
        System.out.println("");
    }

    public void exit() {
        System.out.println("Exiting application. Goodbye!");
        System.out.println("");
        System.exit(0);
    }

    
}





class BloodSugar {
    private int id;
    private String name;
    private int yob;
    private int sugarLevel;

    public BloodSugar(int id, String name, int yob, int sugarLevel) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.sugarLevel = sugarLevel;
    }

    public int getId() {
        return id;
    }


    // Setters and getters

    public void display() {
        System.out.println("--------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Sugar Level: " + sugarLevel);
        System.out.println("--------------------------");
    }

    public int calculate() {
        // calculation logic here
        return sugarLevel;
    }
}


