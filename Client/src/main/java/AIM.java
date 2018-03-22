/**
 * @TODO
 * Getters and setters for my Instant messenger class
 * If she doesn't remember "America Online" (AOL)
 * She's too young for you bro
 */

public class AIM {
    //fields
    private String message;
    private String timeStamp;
    private String toId;
    private String fromId;
    private String sequence;
    //constructor
    public AIM(String sequence, String fromId, String toId, String message) {
        this.sequence = sequence;
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}