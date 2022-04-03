package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static String password = "chaletsProprio21";
    public static boolean isConnected = false;

    public static void mainMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("Bonjour et bienvenue sur le site de l'association Chalets Proprio: choisissez votre action");
        System.out.println("\t1-Menu Propriétaire");
        System.out.println("\t2-Menu employé");
    }

    public static void employeeMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("\nBonjour et bienvenue sur le menu des employés: choisissez votre action");
        System.out.println("\t1-Consulter mes disponibilités");
        System.out.println("\t2-Modifier mes disponibilités");
        System.out.println("\t3-Consulter mes chalets associés");
        System.out.println("\t4-Consulter mon Salaire");
        System.out.println("\t5-Retour");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Vous avez choisi de consulter vos disponibilités");
                    System.out.println("Veuillez entrer votre identifiant !");
                    int id = sc.nextInt();
                    if(Employee.employeeList.containsKey(id)){
                        System.out.println("Voici vos disponibilités :");
                        System.out.println(Employee.employeeList.get(id).getAvailability().getAvailabilityString());
                    }else {
                        System.out.println("Cet identifiant n'existe pas !");
                    }
                }
                case 2 -> {
                    System.out.println("Vous avez choisi de modifier vos disponibilités");
                    System.out.println("Veuillez entrer votre identifiant !");
                    int id = sc.nextInt();
                    if(Employee.employeeList.containsKey(id)){
                        System.out.println("Veuillez entrer vos nouvelles disponibilités !");
                        String availability = sc.next();
                        boolean availabilityBool = sc.nextBoolean();
                        Employee.employeeList.get(id).getAvailability().setAvailability(availability, availabilityBool);
                        System.out.println("Vos disponibilités ont bien été modifiées !");
                    }
                }
                case 3 -> {
                    System.out.println("Vous avez choisi de consulter vos chalets associés");
                    System.out.println("Veuillez entrer votre identifiant !");
                    int id = sc.nextInt();
                    if(Employee.employeeList.containsKey(id)){
                        System.out.println("Voici vos chalets associés :");
                        Employee.employeeList.get(id).getChaletString();
                    }
                }
                case 4 -> {
                    System.out.println("Vous avez choisi de consulter votre salaire");
                    System.out.println("Veuillez entrer votre identifiant !");
                    int id = sc.nextInt();
                    if(Employee.employeeList.containsKey(id)){
                        System.out.println("Votre salaire est de : " + Employee.employeeList.get(id).getSalary());
                    }
                }
                case 5 -> {
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    employeeMenu();
                }
                default -> {
                    System.out.println("Vous avez choisi une option invalide");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Veuillez entrer un chiffre: 1, 2, 3, 4 ou 5 !");
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Voulez vous retourner au menu principal ou au menu précédant ? (O/N)");
        String choice = sc.next();
        if(choice.equals("O") || choice.equals("o")){
            mainMenu();
        }else if(choice.equals("N") || choice.equals("n")){
            employeeMenu();
        }else {
            System.out.println("Au revoir !");
            exit(0);
        }
    }

    public static void shoOptions(){
        mainMenu();
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Vous êtes un propriétaire");
                        if (!isConnected) {
                            System.out.println("Veuillez entrer votre mot de passe");
                            String password = sc.next();
                            if (password.equals(Main.password)) {
                                System.out.println("Vous avez été authentifié");
                                isConnected = true;
                            } else {
                                System.out.println("Mot de passe incorrect");
                            }
                        }
                    }
                    case 2 -> {
                        employeeMenu();
                    }
                    default -> {
                        System.out.println("Veuillez choisir une option valide");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un chiffre: 1 ou 2 !");
            }

            Scanner sc2 = new Scanner(System.in);
            System.out.println("Voulez-vous quitter le programme ? (O/N)");
            try {
                String answer = sc2.next();
                if (answer.equals("O") || answer.equals("o")) {
                    System.out.println("Au revoir");
                    exit(0);
                } else {
                    shoOptions();
                }
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un caractère: O ou N !");
            }
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Amina", "Diallo", 450000, new District(), new Availability());
        Employee employee2 = new Employee("Sokhna", "FALL", 200000, new District(), new Availability());
        Employee employee3 = new Employee("Oumar", "DIOP", 300000, new District(), new Availability());
        Chalet chalet1 = new Chalet("Chalet1", employee3, 6, new District());
        Chalet chalet2 = new Chalet("Chalet2", employee3, 8, new District());
        //Employee.printEmployeeList();
        shoOptions();
    }
}
