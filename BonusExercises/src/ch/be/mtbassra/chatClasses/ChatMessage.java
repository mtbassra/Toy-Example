package ch.be.mtbassra.chatClasses;

import java.io.Serializable;

public class ChatMessage<T> implements Serializable {
	
	
	/*
	 * Declaring serialVersionUID, to verify that the sender and receiver of a serialized object have loaded classes.
	 *  Eclipse requested it.
	 */
	private static final long serialVersionUID = -1041013198570731751L;

	
	
	
	
    /*
     * Declaring the Variables, for further use.
     * - Message Type
     * - payload
     * - Sender
     */
    
    public enum MessageType {

        TEXT,
        NEW_ONLINE,
        NEW_OFFLINE,
        HISTORY;
    }

    private MessageType messageType;
    private T payload;
    private String sender;
    
    
    
    // Creating the object
    public ChatMessage() {
    }

    public ChatMessage(MessageType type, T payload) {
        this.messageType = type;
        this.payload = payload;
    }
    
    
    
    
    /*
     * Getters and Setters Methods
     */
    
    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
