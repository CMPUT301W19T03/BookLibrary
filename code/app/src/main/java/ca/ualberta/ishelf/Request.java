package ca.ualberta.ishelf;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

/**
 * A request object represents one user requesting to borrow a book from its owner
 * A request will always be stored under the owners User object, so we only need
 * to store the requesters username
 * Status is used to represent whether a request has been accepted, declined, or
 * if no action has been taken yet
 * Since these objects are not directly stored in firebase, they don't need a unique id
 */
public class Request implements Parcelable {
    // id of book to be borrowed
    private UUID bookId;
    // username of requester
    private String requester;
    // when the book was requested
    private Date timeRequested;
    private int status;
    // 1: accepted
    // -1: declined
    // 0: neither accepted nor declined

    /**
     * Empty initializer
     */
    public Request(){
    }

    /**
     * Request initializer
     * timeRequested is automatically set to when the request object is created
     * but can be manually set afterwards
     * @param bookId
     * @param requester
     */
    public Request(UUID bookId, String requester) {
        this.bookId = bookId;
        this.requester = requester;
        this.timeRequested = new Date();
    }

    protected Request(Parcel in) {
        requester = in.readString();
        status = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(requester);
        dest.writeInt(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Request> CREATOR = new Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };

    /**
     * get the id of the book to be borrowed
     * @return
     */
    public UUID getBookId() {
        return bookId;
    }

    /**
     * set the id of the book to be borrowed
     * @param bookId
     */
    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    /**
     * Get the username of the user requesting the book
     * @return
     */
    public String getRequester() {
        return requester;
    }

    /**
     * set the username of the user requesting the book
     * @param requester
     */
    public void setRequester(String requester) {
        this.requester = requester;
    }

    /**
     * get the time that the book was requested
     * @return
     */
    public Date getTimeRequested() {
        return timeRequested;
    }

    /**
     * set the time that the book was requested
     * @param timeRequested
     */
    public void setTimeRequested(Date timeRequested) {
        this.timeRequested = timeRequested;
    }

    /**
     * Set the status of the request to accepted, reprented by a 1
     * This means that the owner has accepted the request
     */
    public void accept() {
        this.status = 1;
    }

    /**
     * Set the status of the request to declined, represented by -1
     * This means that the owner has declined the request
     */
    public void decline() {
        this.status = -1;
    }

    /**
     * Get the status of the request
     * If the status is 0, then the owner has taken no action on the request
     * If the status is 1, then the owner has accepted the request
     * If the status is -1, then the owner has declined the request
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * Return a string representation of the request
     * This is a very simple toSting method which may or may not be useful
     * @return
     */
    @Override
    public String toString() {
        String message = "User " + requester + "requested to borrow a book at "
                + timeRequested.toString();
        return message;
    }
}
