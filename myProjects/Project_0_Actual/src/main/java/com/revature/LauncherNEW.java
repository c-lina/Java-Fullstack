package com.revature;

import com.revature.Controllers.CardController;
import com.revature.Controllers.DuelistController;
import io.javalin.Javalin;

public class LauncherNEW {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7700);

        app.get("", ctx -> ctx.result("Connection Achieved"));

        DuelistController dc = new DuelistController();
        CardController cc = new CardController();

        //Print out all duelist
        app.get("/Duelists", dc.SelectAllDuelistHandler);

        //Print out the duelist through their duelist id
        app.get("/Duelists/{id}", dc.SelectDuelistByIdHandler);

        //Insert a new duelist
        app.post("/Duelists", dc.InsertNewDuelistHandler);

        //Print out the duelist through their name (either first or last or both)
        app.get("/DuelistsByName/", dc.getDuelistByNameHandler);

        //Print out all the cards
        app.get("/Cards", cc.SelectAllCardsHandler);

        //Print out the card based on their id
        app.get("/Cards/{id}", cc.SelectCardByIdHandler);

        //Change the attack points of a card by id
        app.patch("/Cards/UpdateAtk/{id}", cc.UpdateAtkHandler);

        //Change the defense points of a card by id
        app.patch("/Cards/UpdateDef/{id}", cc.UpdateDefHandler);

        //Print out all the cards through the duelist id
        app.get("/CardsByDuelist/{id}", cc.getAllCardsByDuelistId);

        //Assign a card to a new duelist
        app.patch("/Cards/Transfer/{id}", cc.AssignToNewDuelistHandler);

        //Get all the indexes of the cards matching the name
        app.get("/CardsByName", cc.ChangeNametoIDsHandler);

        //Insert a new card
        app.post("/Cards", cc.InsertCardHandler);

        //Delete card
        app.delete("/Cards", cc.DeleteCardHandler);
    }
}
