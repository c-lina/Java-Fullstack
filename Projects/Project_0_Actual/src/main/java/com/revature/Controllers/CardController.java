package com.revature.Controllers;

import com.revature.DAOs.CardDAO;
import com.revature.models.Card;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class CardController {
    CardDAO cDAO = new CardDAO();
    public Handler SelectAllCardsHandler = ctx -> {
        ArrayList<Card> cardList = cDAO.selectAllCards();

        ctx.json(cardList);
        ctx.status(200);
    };
    public Handler SelectCardByIdHandler = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if(id <= 0) {
            ctx.result("Please enter a id greater than 0!");
            ctx.status(404);
        }
        else if(id > cDAO.selectAllCards().size()) {
            ctx.result("Please enter a valid ID!");
            ctx.status(404);
        }
        else {
            Card card = cDAO.getCardByID(id);
            ctx.json(card);
            ctx.status(200);
        }
    };

    public Handler UpdateAtkHandler = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int atk = Integer.parseInt(ctx.body());

        if(id <= 0) {
            ctx.result("Please enter a id greater than 0!");
            ctx.status(404);
        }
        else if(id > cDAO.selectAllCards().size()) {
            ctx.result("Please enter a valid ID!");
            ctx.status(404);
        }
        else {
            if(atk < 0) {
                ctx.result("The attack points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                int card = cDAO.updateAtk(id, atk);
                ctx.json(card);
                ctx.status(200);
            }

        }
    };

    public Handler UpdateDefHandler = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int def = Integer.parseInt(ctx.body());

        if(id <= 0) {
            ctx.result("Please enter a id greater than 0!");
            ctx.status(404);
        }
        else if(id > cDAO.selectAllCards().size()) {
            ctx.result("Please enter a valid ID!");
            ctx.status(404);
        }
        else {
            if(def < 0) {
                ctx.result("The defense points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                int card = cDAO.updateDef(id, def);
                ctx.json(card);
                ctx.status(200);
            }
        }
    };

    public Handler getAllCardsByDuelistId = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if(id <= 0) {
            ctx.result("Please enter a id greater than 0!");
            ctx.status(404);
        }
        else if(id > cDAO.selectAllCards().size()) {
            ctx.result("Please enter a valid ID!");
            ctx.status(404);
        }
        else {
            ArrayList<Card> cardList = cDAO.selectCardsByDuelist(id);
            ctx.json(cardList);
            ctx.status(200);
        }
    };

    public Handler AssignToNewDuelistHandler =  ctx -> {
        int card_id = Integer.parseInt(ctx.pathParam("id"));
        int duelist_id = Integer.parseInt(ctx.body());

        if(card_id <= 0) {
            ctx.result("Please enter a card_id greater than 0!");
            ctx.status(404);
        }
        else if(card_id > cDAO.selectAllCards().size()) {
            ctx.result("Please enter a valid ID!");
            ctx.status(404);
        }
        else {
            if(duelist_id < 0) {
                ctx.result("The defense points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                cDAO.assignNewPerson(card_id, duelist_id);
                ctx.result("Card ownership changed successfully!");
                ctx.status(200);
            }
        }
    };
}
