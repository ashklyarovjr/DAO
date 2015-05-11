package Entities;

import java.util.Date;

/**
 * Created by Anton on 5/11/2015.
 */
public class Letter  extends Entity {
    private String sender;
    private String reciever;
    private String letterText;
    private String letterSubject;
    private Date sendDate;

    public Letter() {
        super();
    }

    public Letter(int id) {
        super(id);
    }

    public Letter(String sender, String reciever, String letterText, String letterSubject, Date sendDate) {
        this.sender = sender;
        this.reciever = reciever;
        this.letterText = letterText;
        this.letterSubject = letterSubject;
        this.sendDate = sendDate;
    }

    public Letter(int id, String sender, String reciever, String letterText, String letterSubject, Date sendDate) {
        super(id);
        this.sender = sender;
        this.reciever = reciever;
        this.letterText = letterText;
        this.letterSubject = letterSubject;
        this.sendDate = sendDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }

    public String getLetterSubject() {
        return letterSubject;
    }

    public void setLetterSubject(String letterSubject) {
        this.letterSubject = letterSubject;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
