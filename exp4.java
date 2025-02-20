import java.util.ArrayList;
import java.util.Scanner;

class emp {
    int id;
    String name;
    double sal;

    emp(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String toString() {
        return "id: " + id + ", name: " + name + ", salary: " + sal;
    }
}

class emp_mgmt {
    private ArrayList<emp> emps = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    void add_emp() {
        System.out.print("enter emp id: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("enter emp name: ");
        String name = sc.nextLine();
        System.out.print("enter emp salary: ");
        double sal = sc.nextDouble();
        emps.add(new emp(id, name, sal));
        System.out.println("emp added successfully!");
    }

    void update_emp() {
        System.out.print("enter emp id to update: ");
        int id = sc.nextInt();
        for (emp e : emps) {
            if (e.id == id) {
                sc.nextLine();
                System.out.print("enter new name: ");
                e.name = sc.nextLine();
                System.out.print("enter new salary: ");
                e.sal = sc.nextDouble();
                System.out.println("emp updated successfully!");
                return;
            }
        }
        System.out.println("emp not found!");
    }

    void remove_emp() {
        System.out.print("enter emp id to remove: ");
        int id = sc.nextInt();
        emps.removeIf(e -> e.id == id);
        System.out.println("emp removed successfully!");
    }

    void search_emp() {
        System.out.print("enter emp id to search: ");
        int id = sc.nextInt();
        for (emp e : emps) {
            if (e.id == id) {
                System.out.println("emp found: " + e);
                return;
            }
        }
        System.out.println("emp not found!");
    }

    void display_emps() {
        if (emps.isEmpty()) {
            System.out.println("no emps available.");
        } else {
            System.out.println("\nemp list:");
            for (emp e : emps) {
                System.out.println(e);
            }
        }
    }

    void run() {
        while (true) {
            System.out.println("\nemp management system");
            System.out.println("1. add emp");
            System.out.println("2. update emp");
            System.out.println("3. remove emp");
            System.out.println("4. search emp");
            System.out.println("5. display all emps");
            System.out.println("6. exit");
            System.out.print("choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> add_emp();
                case 2 -> update_emp();
                case 3 -> remove_emp();
                case 4 -> search_emp();
                case 5 -> display_emps();
                case 6 -> {
                    System.out.println("exiting...");
                    return;
                }
                default -> System.out.println("invalid option! try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new emp_mgmt().run();
    }
}
