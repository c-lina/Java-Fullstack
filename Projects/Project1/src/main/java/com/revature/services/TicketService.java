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
            throw new IllegalArgumentException("The user does not exist");
        }

        ticket.setUser(user.get());
        ticketDAO.save(ticket);
        return ticket;

    }

    public List<Ticket> getListByUserId(int id) {
        Optional<User> user = userDAO.findById(id);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("Cannot find employee id: " + id);
        }

        return user.get().getTicketList();
    }


}
