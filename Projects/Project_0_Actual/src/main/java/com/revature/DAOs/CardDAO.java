package com.revature.DAOs;

import com.revature.models.Card;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardDAO implements CardDaoInterface{

    @Override
    public String assignNewPerson(String cardName, int duelistID) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET duelist_id_fk = ? WHERE card_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, duelistID);
            ps.setString(2, cardName);

            ps.executeUpdate();

            return cardName;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't assign this card to another duelist!");
        }
        return null;
    }

    @Override
    public int updateAtk(String name, int newAtk) {
        return 0;
    }

    @Override
    public int updateDef(String name, int newDef) {
        return 0;
    }

    @Override
    public Card getCardByID(int id, Card details) {
        return null;
    }

    @Override
    public ArrayList<Card> selectAllCards() {
        return null;
    }

    @Override
    public Card newCard(Card card) {
        return null;
    }

    @Override
    public Card deleteCard(Card card) {
        return null;
    }
}
