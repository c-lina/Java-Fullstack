package com.revature.Controllers;

import com.revature.DAOs.DuelistDAO;
import com.revature.models.Duelist;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class DuelistController {
    DuelistDAO dDAO = new DuelistDAO();

    public Handler SelectAllDuelistHandler = ctx -> {
        ArrayList<Duelist> duelists =  dDAO.selectAllDuelists();

        ctx.json(duelists);
        ctx.status(200);
    };

    public Handler SelectDuelistByIdHandler = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if(id <= 0) {
            ctx.result("Please enter a id greater than 0!");
            ctx.status(404);
        }
        else if (id > dDAO.selectAllDuelists().size()) {
            ctx.result("Please enter a valid id!");
            ctx.status(404);
        }
        else {

            Duelist duelist = dDAO.getDuelistByID(id);

            ctx.json(duelist);
            ctx.status(200);
        }
    };

    public Handler getDuelistByNameHandler = ctx -> {
        Duelist duelist = ctx.bodyAsClass(Duelist.class);

        if(duelist.getFirst_name().isBlank() && duelist.getLast_name().isBlank()) {
            ctx.result("Both parameters cannot be empty");
            ctx.status(404);
        }
        else if(duelist.getFirst_name() == null && duelist.getLast_name() == null) {
            ctx.result("Invalid parameters!");
            ctx.status(404);
        }
        else {
            ctx.json(dDAO.getDuelistbyName(duelist.getFirst_name(), duelist.getLast_name()));
            ctx.status(200);
        }
    };

    public Handler InsertNewDuelistHandler = ctx -> {
        Duelist duelist = ctx.bodyAsClass(Duelist.class);

        if(duelist.getFirst_name() == null || duelist.getFirst_name().isBlank()) {
            ctx.result("Please enter a valid first name");
            ctx.status(400);
        }
        else if(duelist.getLast_name() == null || duelist.getLast_name().isBlank()) {
            ctx.result("Please enter a valid last name");
            ctx.status(400);
        }
        else {
            Duelist newDuelist = dDAO.insertNewDuelist(duelist);
            ctx.json(newDuelist);
            ctx.status(200);
        }
    };
}
