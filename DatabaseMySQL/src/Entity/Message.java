/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Timestamp;

/**
 *
 * @author Johnny
 */
public class Message {

    private int id;
    private User owner;
    private User to;
    private String text;
    private Timestamp when;
    private boolean read;

    public Message(int id, User owner, User to, String text, Timestamp when, boolean read) {
        this.id = id;
        this.owner = owner;
        this.to = to;
        this.text = text;
        this.when = when;
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getWhen() {
        return when;
    }

    public void setWhen(Timestamp when) {
        this.when = when;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
