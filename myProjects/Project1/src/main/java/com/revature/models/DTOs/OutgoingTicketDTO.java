package com.revature.models.DTOs;

import org.springframework.stereotype.Component;

@Component
public class OutgoingTicketDTO {
    private int ticketId;
    private String description;
    private double amount;
    private String status;
    private OutgoingUserDTO user;

    public OutgoingTicketDTO() {
    }

    public OutgoingTicketDTO(int ticketId, String description, double amount, String status, OutgoingUserDTO user) {
        this.ticketId = ticketId;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.user = user;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OutgoingUserDTO getUser() {
        return user;
    }

    public void setUser(OutgoingUserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OutoingTicketDTO{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", outgoingUserDTO=" + user +
                '}';
    }
}
