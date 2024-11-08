package com.revature.controllers;

import com.revature.models.DTOs.IncomingTicketDTO;
import com.revature.models.DTOs.OutgoingTicketDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.Ticket;
import com.revature.services.TicketService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private UserService userService;
    private TicketService ticketService;

    @Autowired
    public TicketController(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    //This would be for managers to view only
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> ticketList = ticketService.getTickets();
        return ResponseEntity.ok().body(ticketList);
    }

    @PostMapping
    public ResponseEntity<OutgoingTicketDTO> registerTicket(@RequestBody IncomingTicketDTO newTicket) {
        System.out.println(newTicket);
        return ResponseEntity.ok().body(ticketService.addTicket(newTicket));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OutgoingTicketDTO>> getTicketsById(@PathVariable int id) {
        return ResponseEntity.ok().body(ticketService.getTicketListByUserId(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable int id, @RequestBody String newStatus) {
        return ResponseEntity.status(202).body(ticketService.changeStatus(id, newStatus));
    }

    @GetMapping("/status/pending")
    public ResponseEntity<List<OutgoingTicketDTO>> getAllPending() {
        List<OutgoingTicketDTO> ticketList = ticketService.allPendingTickets();
        return ResponseEntity.ok().body(ticketList);
    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
