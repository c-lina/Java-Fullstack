package com.revature.models.DTOs;

import org.springframework.stereotype.Component;

@Component
public class IncomingTicketDTO {
    private String description;
    private double amount;
    private String status;
    private int userIdFK;

    public IncomingTicketDTO() {
        this.status = "Pending";
    }

    public IncomingTicketDTO(String description, double amount, String status, int userIdFK) {
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.userIdFK = userIdFK;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserIdFK() {
        return userIdFK;
    }

    public void setUserIdFK(int userIdFK) {
        this.userIdFK = userIdFK;
    }

    @Override
    public String toString() {
        return "IncomingTicketDTO{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", userIdFK=" + userIdFK +
                '}';
    }
}
