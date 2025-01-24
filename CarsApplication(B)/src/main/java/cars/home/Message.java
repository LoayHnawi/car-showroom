package cars.home;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
public class Message {

    private String date;
    private String text;
    private String Email;

    public Message() {
    }

    public Message(String date, String text, String Email) {
        this.date = date;
        this.text = text;
        this.Email = Email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getEmail() {
        return Email;
    }

}
