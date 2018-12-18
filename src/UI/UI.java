package UI;

import Entity.domain.Gender;
import java.util.List;
import java.util.Scanner;

public class UI {

    final static Scanner sc = new Scanner(System.in);
//
    private static int choice;

    public static int mainMenu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Student");
                System.out.println("2. Teacher");
                System.out.println("3. Education");
                System.out.println("4. Course");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public int studentMenu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Register student");
                System.out.println("2. Add Education to student");
                System.out.println("3. Find student by id");
                System.out.println("4. Find student by name");
                System.out.println("5. Find all students");
                System.out.println("6. Delete student");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public int teacherMenu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Register teacher");
                System.out.println("2. Add a teacher as supervisor for a course");
                System.out.println("3. Find teacher by id");
                System.out.println("4. Find teacher by name");
                System.out.println("5. Find all teachers");
                System.out.println("6. Update teacher's salary");
                System.out.println("7. Delete teacher");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public int educationMenu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Register a education");
                System.out.println("2. Add a course to the education");
                System.out.println("3. Find a education by id");
                System.out.println("4. Find education by name");
                System.out.println("5. Find all educations");
                System.out.println("6. Delete a education");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public int courseMenu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Register a education");
                System.out.println("2. Add a course to the education");
                System.out.println("3. Find a education by id");
                System.out.println("4. Find education by name");
                System.out.println("5. Delete a education");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public String enterName(String type) {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Enter the" + type + "name");
                String name = sc.nextLine();
                return name;
            } catch (Exception e) {
                System.out.println("wrong choice try again");

            }
        }
        return null;
    }

    public int enterSalary() {
        boolean loop = true;
        int salary = 0;
        while (loop) {

            try {
                System.out.println("Enter the salary");
                salary = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong choice");
            }
        }
        return salary;
    }

    public <T> void printList(List<T> a) {
        if (a.isEmpty()) {
            System.out.println("Is empty!");
        } else {
            a.forEach(System.out::println);
        }
    }

    public long enterId(String name) {
        boolean loop = true;
        long id = 0;
        while (loop) {
            try {
                System.out.println("Enter the " + name + " id: ");
                id = sc.nextLong();
                sc.nextLine();
                loop = false;
            } catch (Exception e) {
                System.out.println("Wrong choice!");
            }
        }
        return id;
    }

    public Gender enterGender() {
        boolean loop = true;
        int id = 0;
        while (loop) {
            try {
                System.out.println("Enter the gender by pressing 1. Female or 2. Male: ");
                int genderNum = sc.nextInt();
                sc.nextLine();
                if (genderNum == 1) {
                    return Gender.FEMALE;
                } else if (genderNum == 2) {
                    return Gender.MALE;
                }

            } catch (Exception e) {
                System.out.println("Wrong choice!");
            }
        }
        return null;
    }

    public int enterPoints() {
        boolean loop = true;
        int points = 0;
        while (loop) {

            try {
                System.out.println("Enter the points");
                points = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong choice");
            }
        }
        return points;
    }

}