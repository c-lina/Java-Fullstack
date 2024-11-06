package com.revature.DTOs;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
public class OutoingTicketDTO {
    private String description;
    private int amount;
    private String status;
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private OutgoingUserDTO outgoingUserDTO;

    public OutoingTicketDTO() {
    }

    public OutoingTicketDTO(String description, int amount, String status, String username, OutgoingUserDTO outgoingUserDTO) {
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.username = username;
        this.outgoingUserDTO = outgoingUserDTO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OutgoingUserDTO getOutgoingUserDTO() {
        return outgoingUserDTO;
    }

    public void setOutgoingUserDTO(OutgoingUserDTO outgoingUserDTO) {
        this.outgoingUserDTO = outgoingUserDTO;
    }

    @Override
    public String toString() {
        return "OutoingTicketDTO{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", outgoingUserDTO=" + outgoingUserDTO +
                '}';
    }
}
