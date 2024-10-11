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

            Duelist Yami_yugi = new Duelist(6, "Yami", "Yugi");

            System.out.println(cDAO.assignNewPerson("Dark Magician Girl", dDAO.getDuelistIDbyName("Yami", " ")));

            //System.out.println(dDAO.importNewDuelist(Yami_yugi));
            System.out.println(dDAO.getDuelistIDbyName("Seto", " "));
            System.out.println(dDAO.selectAllDuelists());
            for(Duelist duelist: dDAO.selectAllDuelists()) {
                System.out.println(duelist);
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't open connection D:");
        }
    }
}
