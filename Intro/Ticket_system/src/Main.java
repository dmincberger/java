
import java.util.Scanner;


public class Main {

    public static Ticket chosen_ticket = null;
    public static Scanner scanner = new Scanner(System.in);

    public static void help(){
        System.out.println("Welcome to the ticket system!");
        System.out.println("You can add a ticket by typing add");
        System.out.println("You can view a ticket by typing view <id>");
        System.out.println("You can delete a ticket by typing delete <id>");
        System.out.println("You can edit a ticket by typing edit <id>");
        System.out.println("You can view the commands by typing help");
    }

    public static void main(String[] args) {
        Main.help();
        while (true){
            System.out.println("Waiting for input: ");
            String input = scanner.nextLine();
            switch (input) {

                case "add":

                    System.out.println("Adding a ticket");
                    System.out.println("Enter topic of ticket you wish to add: ");

                    String topic = scanner.nextLine();

                    System.out.println("Enter description of ticket you wish to add: ");

                    String problem_description = scanner.nextLine();

                    System.out.println("Enter additional information of ticket you wish to add: ");

                    String additional_information = scanner.nextLine();

                    System.out.println("Enter the severity of your ticket: ");

                    int severity = scanner.nextInt();

                    scanner.nextLine();

                    new Ticket(topic,problem_description,severity,additional_information);
                    break;

                case "remove":

                    if (chosen_ticket != null){

                        System.out.println("Removing a ticket");
                        Backlog.removeTicket(chosen_ticket.getId());
                        chosen_ticket = null;
                        break;
                    } else {

                        System.out.println("Please specify the id of the ticket you would like to remove: ");
                        int id = scanner.nextInt();
                        Backlog.removeTicket(id);
                        break;

                    }

                case "view":
                    if (chosen_ticket != null){
                        System.out.println("Would you like to view your chosen ticket (t), or the backlog? (b)");
                        String choice = scanner.nextLine();

                        if (choice.equals("b")){

                            Backlog.View_backlog();
                            break;
                        }

                        if (choice.equals("t")){

                        chosen_ticket.print_Info();
                        break;
                        }

                    }
                    Backlog.View_backlog();
                    break;

                case "edit":
                    if (chosen_ticket != null){
                        Backlog.Edit_backlog(chosen_ticket.getId());
                        break;
                    } else {
                        System.out.println("Please specify the id of the ticket you would like to edit: ");
                        int ticket_id = scanner.nextInt();
                        Backlog.Edit_backlog(ticket_id);
                        break;
                    }

                case "get":
                    System.out.println("Please specify the id of the ticket you would like to choose: ");
                    chosen_ticket = Backlog.getTicket(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Now you can view the ticket, edit it, or remove it.");
                    break;

                case "h":
                    if (chosen_ticket != null){
                        System.out.println("Would you like to print the history of the chosen_ticket or an another ticket?");
                        if (scanner.nextLine().equals("y")) {
                            chosen_ticket.print_history();
                            break;
                        }
                    } else {
                        System.out.println("Please specify the id of the ticket you would like to choose: ");
                        int ticket_id = scanner.nextInt();
                        Ticket fetched_ticket = Backlog.getTicket(ticket_id);
                        if (fetched_ticket != null){
                            fetched_ticket.print_history();
                            break;
                        } else {
                            System.out.println("There is no such ticket");
                            break;
                        }
                    }

                case "d":
                    chosen_ticket = null;
                    break;

                case "quit":
                    System.exit(0);
                    break;

                case "help":
                    Main.help();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}