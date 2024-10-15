package com.revature;

import com.revature.DAOs.CardDAO;
import com.revature.DAOs.DuelistDAO;
import com.revature.models.Card;
import com.revature.models.Duelist;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class LauncherOLD {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("Opened connection :D");

            DuelistDAO dDAO = new DuelistDAO();
            CardDAO cDAO = new CardDAO();

            //add Yami Yugi to duelist
            Duelist Yami_yugi = new Duelist("Yami", "Yugi");

            System.out.println(dDAO.insertNewDuelist(Yami_yugi));

            //change Dark Magician Girl card ownership to Yami (doesn't care about original owner)
            System.out.println(cDAO.assignNewPerson("Dark Magician Girl", dDAO.getDuelistIDbyName("Yami", " ")));

            //Find out which ID Kaiba has
            System.out.println(dDAO.getDuelistIDbyName("Seto", " "));

            //Prints out all the records in Duelists
            System.out.println(dDAO.selectAllDuelists());
            for(Duelist duelist: dDAO.selectAllDuelists()) {
                System.out.println(duelist);
            }

            //Prints out all the data of a card by their card_id
            System.out.println(cDAO.getCardByID(2));

            //Prints the card_id by the name
            System.out.println(cDAO.changeNameToIDs("Dark Magician"));

            //shows the before and after of changing the blue eyes white dragon atk and def
            //to that of the blue eyes ultimate dragon
            System.out.println("Blue Eyes White Dragon");
            System.out.println(cDAO.changeNameToIDs("Blue Eyes White Dragon"));
            System.out.println(cDAO.updateAtk(3, 4500));
            System.out.println(cDAO.updateDef(3, 3800));
            System.out.println(cDAO.getCardByID(3));

            System.out.println(cDAO.selectAllCards());
            System.out.print("\n");
            for(Card card : cDAO.selectAllCards()) {
                System.out.println(card);
            }

            //print out all the cards that belong to joey wheeler
            System.out.println("All Joey's cards");
            System.out.println(cDAO.selectCardsByDuelist(3));
            for(Card card: cDAO.selectCardsByDuelist(3)) {
                System.out.println(card);
            }

//            Card blueEyes = new Card(8, "Blue Eyes White Dragon", 3000, 2500, dDAO.getDuelistIDbyName("", "Kaiba"));
//            System.out.println(blueEyes);
//            cDAO.newCard(blueEyes);
//
//            Card kuriboh = new Card(1, "Kuriboh", 300, 200, dDAO.getDuelistIDbyName("Yugi", ""));
//            System.out.println(kuriboh);
//            cDAO.newCard(kuriboh);

            System.out.println(cDAO.changeNameToIDs("Blue Eyes White Dragon"));
            System.out.println(cDAO.selectCardsByDuelist(2));
            for(Card card: cDAO.selectCardsByDuelist(1)) {
                System.out.println(card);
            }



//            System.out.println(cDAO.changeNameToID("Blue Eyes White Dragon"));
//            System.out.println(cDAO.deleteCard(cDAO.changeNameToID("Blue Eyes White Dragon")));





        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't open connection D:");
        }
    }
}