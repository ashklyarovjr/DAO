package Entities;

import java.util.Date;


public class Letter  extends Entity {
    private int senderID;
    private int recieverID;
    private String letterText;
    private String letterSubject;
    private Date sendDate;

    public Letter() {
        super();
    }

    public Letter(int id) {
        super(id);
    }

    public Letter(int senderID, int recieverID, String letterText, String letterSubject, Date sendDate) {
        this.senderID = senderID;
        this.recieverID = recieverID;
        this.letterText = letterText;
        this.letterSubject = letterSubject;
        this.sendDate = sendDate;
    }

    public Letter(int id, int senderID, int recieverID, String letterText, String letterSubject, Date sendDate) {
        super(id);
        this.senderID = senderID;
        this.recieverID = recieverID;
        this.letterText = letterText;
        this.letterSubject = letterSubject;
        this.sendDate = sendDate;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(int recieverID) {
        this.recieverID = recieverID;
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
