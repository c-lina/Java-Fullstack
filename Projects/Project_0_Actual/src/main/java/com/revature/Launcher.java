package com.revature;

import com.revature.DAOs.CardDAO;
import com.revature.DAOs.DuelistDAO;
import com.revature.models.Card;
import com.revature.models.Duelist;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("Opened connection :D");

            DuelistDAO dDAO = new DuelistDAO();
            CardDAO cDAO = new CardDAO();

            //add Yami Yugi to duelist
            Duelist Yami_yugi = new Duelist(6,"Yami", "Yugi");

            System.out.println(dDAO.importNewDuelist(Yami_yugi));

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
            System.out.println(cDAO.changeNameToID("Dark Magician"));

            System.out.println(cDAO.changeNameToID("Blue Eyes White Dragon"));

            System.out.println(cDAO.getCardByID(cDAO.changeNameToID("Blue Eyes White Dragon")));

            System.out.println(cDAO.updateAtk("Blue Eyes White Dragon", 3000));

            System.out.println(cDAO.updateDef("Blue Eyes White Dragon", 2500));

            System.out.println(cDAO.getCardByID(cDAO.changeNameToID("Blue Eyes White Dragon")));

            System.out.println(cDAO.selectAllCards());
            System.out.print("\n");
            for(Card card : cDAO.selectAllCards()) {
                System.out.println(card);
            }

            System.out.println(cDAO.selectCardsByDuelist("Joey", ""));
            for(Card card: cDAO.selectCardsByDuelist("Joey", "")) {
                System.out.println(card);
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't open connection D:");
        }
    }
}
