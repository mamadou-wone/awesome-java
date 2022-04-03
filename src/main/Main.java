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
        System.out.println("\t6-Menu principal");
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
                case 6 -> {
                    mainMenu();
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

    public static void proprioMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("\nBonjour et bienvenue sur le menu du Propriétaire: choisissez votre action");
        System.out.println("\t1-Afficher la liste des employés");
        System.out.println("\t2-Afficher la liste des chalets");
        System.out.println("\t3-Afficher le nombre de chalets");
        System.out.println("\t4-Ajouter un employé");
        System.out.println("\t5-Supprimer un employé");
        System.out.println("\t6-Modifier le salaire d'un employé");
        System.out.println("\t7-Comparer le salaire de deux employés");
        System.out.println("\t8-Afficher les disponibilité d'un employé");
        System.out.println("\t9-Afficher les chalets associés à un employé");
        System.out.println("\t10-Affecter un chalet à un employé");
        System.out.println("\t11-Retirer un chalet à un employé");
        System.out.println("\t12-Retourner au menu principal");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Vous avez choisi de consulter la liste des employés");
                    System.out.println("Voici la liste des employés :");
                    Employee.employeeList.forEach((k, v) -> System.out.println(v.toString()));
                }
                case 2 -> {
                    System.out.println("Vous avez choisi de consulter la liste des chalets");
                    System.out.println("Voici la liste des chalets :");
                    Chalet.chaletList.forEach((k, v) -> System.out.println(v.toString()));
                }
                case 3 -> {
                    System.out.println("Vous avez choisi de consulter le nombre de chalets");
                    System.out.println("Le nombre de chalets est de : " + Chalet.chaletList.size());
                }
                case 4 -> {
                    System.out.println("Vous avez choisi d'ajouter un employé");
                    System.out.println("Veuillez entrer le nom !");
                    String name = sc.next();
                    System.out.println("Veuillez entrer le prénom !");
                    String firstName = sc.next();
                    System.out.println("Veuillez entrer le salaire salaire !");
                    int salary = sc.nextInt();
                    Employee newEmployee = new Employee(name, firstName, salary, new District(), new Availability());
                    System.out.println("Vous avez ajouté l'employé : " + newEmployee.toString());
                }
                case 5 -> {
                    System.out.println("Vous avez choisi de supprimer un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à supprimer !");
                    int id = sc.nextInt();
                    Employee.employeeList.remove(id);
                    System.out.println("L'employé a bien été supprimé !");
                }
                case 6 -> {
                    System.out.println("Vous avez choisi de modifier le salaire d'un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à modifier !");
                    int id = sc.nextInt();
                    System.out.println("Veuillez entrer le nouveau salaire !");
                    int newSalary = sc.nextInt();
                    Employee.employeeList.get(id).setSalary(newSalary);
                    System.out.println("Le salaire de l'employé a bien été modifié !");
                }
                case 7 -> {
                    System.out.println("Vous avez choisi de comparer le salaire de deux employés");
                    System.out.println("Veuillez entrer l'identifiant de l'employé 1 !");
                    int id1 = sc.nextInt();
                    System.out.println("Veuillez entrer l'identifiant de l'employé 2 !");
                    int id2 = sc.nextInt();
                    if (Employee.employeeList.get(id1).compareTo(Employee.employeeList.get(id2)) > 0) {
                        System.out.println("L'employé 1 a un salaire plus élevé que l'employé 2");
                    }
                    else if (Employee.employeeList.get(id1).compareTo(Employee.employeeList.get(id2)) < 0) {
                        System.out.println("L'employé 2 a un salaire plus élevé que l'employé 1");
                    }
                    else {
                        System.out.println("Les deux employés ont le même salaire");
                    }
                }
                case 8 -> {
                    System.out.println("Vous avez choisi de consulter les disponibilité d'un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à consulter !");
                    int id = sc.nextInt();
                    System.out.println("Voici les disponibilités de l'employé :");
                    System.out.println(Employee.employeeList.get(id).getAvailability().getAvailabilityString());
                }
                case 9 -> {
                    System.out.println("Vous avez choisi de consulter les chalets associés à un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à consulter !");
                    int id = sc.nextInt();
                    System.out.println("Voici les chalets de l'employé :");
                    Employee.employeeList.get(id).getChaletString();
                }
                case 10 -> {
                    System.out.println("Vous avez choisi d'affecter un chalet à un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à modifier !");
                    int id = sc.nextInt();
                    System.out.println("Veuillez entrer l'identifiant du chalet à affecter !");
                    int chaletId = sc.nextInt();
                    Employee.employeeList.get(id).getChalet().add(Chalet.chaletList.get(chaletId));
                    System.out.println("Le chalet a bien été affecté !");
                }
                case 11 -> {
                    System.out.println("Vous avez choisi de supprimer un chalet d'un employé");
                    System.out.println("Veuillez entrer l'identifiant de l'employé à modifier !");
                    int id = sc.nextInt();
                    System.out.println("Veuillez entrer l'identifiant du chalet à supprimer !");
                    int chaletId = sc.nextInt();
                    Employee.employeeList.get(id).getChalet().remove(Chalet.chaletList.get(chaletId));
                    System.out.println("Le chalet a bien été supprimé !");
                }
                case 12 -> {
                    System.out.println("Vous avez choisi de retourner au menu principal");
                    proprioMenu();
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
            proprioMenu();
        }else {
            System.out.println("Au revoir !");
            exit(0);
        }
    }

    public static void showOption(){
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
                                proprioMenu();
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
                    showOption();
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
        Employee.printEmployeeList();
        showOption();
    }
}
