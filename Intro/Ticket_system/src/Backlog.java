
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Backlog {

    public static Scanner scanner = new Scanner(System.in);
    private static int ticket_count = 0;

private static ArrayList<Ticket> Template = new ArrayList<>();

static public int getTicket_count(){
    return ticket_count;
}

static public void addTicket(Ticket ticket){
    Template.add(ticket);
    ticket_count++;
}

static public void removeTicket(int id){

    boolean removed = false;

    for (int i = 0; i < Template.size(); i++){

        Ticket ticket = Template.get(i);
        int ticket_id = ticket.getId();

        if (ticket_id == id){

            Template.remove(i);
            removed = true;
            ticket_count--;
            break;

        }
    }

    if (!removed) {

        System.out.println("There is no such ticket with this ID");

    }
}

static public Ticket getTicket(int id){
    for(Ticket ticket : Template){
        int curr_id = ticket.getId();
        if(curr_id == id){
            return ticket;
        }
    }
    return null;
}

static public void View_backlog(){
    for (Ticket ticket : Template) {
        System.out.println("Ticket ID: " + ticket.getId());
        System.out.println("Ticket Topic: " + ticket.getTopic());
        System.out.println("Ticket Problem_description: " + ticket.getProblem_description());
        System.out.println("Ticket Severity: "+ ticket.getSeverity());
        System.out.println("Ticket Status: "+ ticket.getStatus());
        System.out.println("Ticket Additional_information: "+ ticket.getAdditional_information());
        System.out.println("--------------------------------------------------------------------------");
    }
}

static public void Edit_backlog(int id){
    int ticket_index = -1;
    int counter = 0;
    for (Ticket ticket : Template) {
        if (ticket.getId() == id) {
            ticket_index = counter;
            break;
        } else {
            counter++;
        }
    }


    if (ticket_index != -1){
        Ticket ticket = Template.get(ticket_index);
        while(true){

            System.out.println("What would you like to edit?\n Additional_information,\n Severity,\n Status\n To exit edit mode, type q");
            String field_to_edit = scanner.nextLine();

            if ( field_to_edit.equals("Severity") ){

                int new_severity = Integer.parseInt(scanner.nextLine());
                ticket.setSeverity(new_severity);

            }

            else if ( field_to_edit.equals("Additional_information") ){

                String new_additional_information = scanner.nextLine();
                ticket.setAdditional_information(new_additional_information);

            }

            else if ( field_to_edit.equals("Status") ){

                String new_status = scanner.nextLine();
                ticket.setStatus(new_status);

            }

            else if ( field_to_edit.equals("q") ){
                break;
            }

        }
    } else {
        System.out.println("There is no such ticket with this ID");
    }

}

}


