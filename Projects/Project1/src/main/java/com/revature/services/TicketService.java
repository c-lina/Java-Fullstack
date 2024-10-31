package com.revature.services;

import com.revature.DAOs.TicketDAO;
import com.revature.DAOs.UserDAO;
import com.revature.DTOs.IncomingTicketDTO;
import com.revature.DTOs.IncomingTicketDTO;
import com.revature.models.Ticket;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private UserDAO userDAO;
    private TicketDAO ticketDAO;

    @Autowired
    public TicketService(UserDAO userDAO, TicketDAO ticketDAO) {
        this.userDAO = userDAO;
        this.ticketDAO = ticketDAO;
    }

    public List<Ticket> getTickets() {
        return ticketDAO.findAll();
    }

    public Ticket addTicket(IncomingTicketDTO newticketDTO) {
        Ticket ticket = new Ticket(0, newticketDTO.getDescription(), newticketDTO.getAmount(), newticketDTO.getStatus(), null);
        Optional<User> user = userDAO.findById(newticketDTO.getUserIdFK());
        if(user.isEmpty()) {
            throw new IllegalArgumentException("That user does not exist");
        }
        ticket.setUser(user.get());
        ticketDAO.save(ticket);
        return ticket;

    }

    public String changeStatus(int id, String newStatus) {
        Optional<Ticket> ticket = ticketDAO.findById(id);
        if(ticket.isEmpty()) {
            throw new IllegalArgumentException("That ticket does not exist");
        }
        //Not needed but wanted to make casing irrelevant
        newStatus = newStatus.toUpperCase();
        String newStats = "" + newStatus.charAt(0);
        newStatus = newStatus.toLowerCase();
        for(int i = 1; i < newStatus.length(); i++) {
            newStats = newStats + newStatus.charAt(i);
        }
        //Check to see if the input was either accepted or denied
        if(newStats.equals("Accepted") || newStats.equals("Denied")) {
            //Change the status
            ticket.get().setStatus(newStats);
            ticketDAO.save(ticket.get());
            return "Ticket ID: " + ticket.get().getTicketId() + "'s status has been updated to " + ticket.get().getStatus();
        }
        else {
            throw new IllegalArgumentException("That is not a valid status type!");
        }
    }

    public List<Ticket> allPendingTickets() {
        List<Ticket> ticketList = ticketDAO.findAllByStatus("Pending");
        return ticketList;
    }





}
