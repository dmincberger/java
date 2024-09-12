import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private int severity;
private final int id;
private final String topic;
private final String problem_description;
private String status;
private ArrayList<String> history;
private String additional_information;

public Ticket(String topic, String problem_description, int severity, String additional_information) {

    this.severity = severity;
    this.id = Backlog.getTicket_count()+1;
    this.topic = topic;
    this.problem_description = problem_description;
    this.status = "opened";
    this.history = new ArrayList<>();
    this.additional_information = additional_information;
    Backlog.addTicket(this);

}

public int getId() {
    return id;
}

public String getTopic() {
    return topic;
}

public String getProblem_description() {
    return problem_description;
}

public String getStatus() {
    return status;
}

public int getSeverity() {
    return severity;
}

public String getAdditional_information() {
    return additional_information;
}

public void setStatus(String status) {
    LocalDateTime now = LocalDateTime.now();

    String new_status = dtf.format(now) + " - Changed status from "+this.status+" to "+status;
    this.status = status;
    this.history.add(new_status);
}

public void setSeverity(int severity) {
    LocalDateTime now = LocalDateTime.now();

    String new_severity = dtf.format(now) + " - Changed severity from "+this.severity+" to "+severity;
    this.severity = severity;
    this.history.add(new_severity);
}

public void setAdditional_information(String additional_information) {
    LocalDateTime now = LocalDateTime.now();

    String new_information = dtf.format(now) + " - Changed additional_information from "+this.additional_information+" to "+additional_information;
    this.additional_information = additional_information;
    this.history.add(new_information);
}

public void print_Info(){
    System.out.println("Ticket ID: " + id);
    System.out.println("Ticket topic: " + topic);
    System.out.println("Ticket problem_description: " + problem_description);
    System.out.println("Severity: " + severity);
    System.out.println("Status: " + status);
    System.out.println("Additional information: " + additional_information);
}

public void print_history(){
    for (String history : history) {
        System.out.println(history);
        System.out.println("-----------------------------------------");
    }
}

}
