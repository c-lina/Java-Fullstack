package com.revature.Controllers;

import com.revature.DAOs.CardDAO;
import com.revature.DAOs.DuelistDAO;
import com.revature.models.Card;
import com.revature.models.Duelist;
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
            ctx.result("Please enter a card ID greater than 0!");
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
            ctx.result("Please enter a card ID greater than 0!");
            ctx.status(404);
        }
        else {
            if(atk < 0) {
                ctx.result("The attack points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                int card = cDAO.updateAtk(id, atk);
                ctx.json("The attack points of " + cDAO.getCardByID(id).getCard_name() + " have successfully changed into " + card);
                ctx.status(200);
            }

        }
    };

    public Handler UpdateDefHandler = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int def = Integer.parseInt(ctx.body());

        if(id <= 0) {
            ctx.result("Please enter a card ID greater than 0!");
            ctx.status(404);
        }
        else {
            if(def < 0) {
                ctx.result("The defense points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                int card = cDAO.updateDef(id, def);
                ctx.json("The defense points of " + cDAO.getCardByID(id).getCard_name() + " have successfully changed into " + card);
                ctx.status(200);
            }
        }
    };

    public Handler getAllCardsByDuelistId = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if(id <= 0) {
            ctx.result("Please enter a card ID greater than 0!");
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
            ctx.result("Please enter a card ID greater than 0!");
            ctx.status(404);
        }
        else {
            if(duelist_id < 0) {
                ctx.result("The defense points cannot be less than 0!");
                ctx.status(400);
            }
            else {
                cDAO.assignNewPerson(card_id, duelist_id);
                String card_name = cDAO.getCardByID(card_id).getCard_name();

                DuelistDAO dDAO = new DuelistDAO();
                String first_name = dDAO.getDuelistByID(duelist_id).getFirst_name();
                String last_name = dDAO.getDuelistByID(duelist_id).getLast_name();

                ctx.result("Card ownership changed successfully! " + card_name + " has been" +
                        " given to " + first_name + " " + last_name);
                ctx.status(200);
            }
        }
    };

    public Handler ChangeNametoIDsHandler = ctx -> {
        String name = ctx.body();
        if(name.isBlank()) {
            ctx.result("You cannot enter a blank card name!");
            ctx.status(401);
        }
        else {
            ArrayList<Integer> cardIdList = cDAO.changeNameToIDs(name);
            ctx.json(cardIdList);
            ctx.status(200);
        }
    };

    public Handler InsertCardHandler = ctx -> {
        Card card = ctx.bodyAsClass(Card.class);

        if(card.getCard_name().isBlank()) {
            ctx.result("You cannot enter a blank card name!");
            ctx.status(400);
        }
        else {
            if(card.getDuelist_id_fk() == 0) {
                ctx.result("You have to assign this card to a duelist!");
                ctx.status(400);
            }
            else {
                Card newCard = cDAO.newCard(card);
                ctx.json(newCard);
                ctx.status(200);
            }
        }
    };

    public Handler DeleteCardHandler = ctx -> {
        int id = Integer.parseInt(ctx.body());

        if(id <= 0) {
            ctx.result("Please enter a card ID greater than 0!");
            ctx.status(404);
        }
        else {
            String name = cDAO.getCardByID(id).getCard_name();
            int index = cDAO.getCardByID(id).getCard_id();
            cDAO.deleteCard(id);
            ctx.result(name + " at position " + index + " has been deleted!");
            ctx.status(200);
        }
    };
}
