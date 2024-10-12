package com.revature.DAOs;

import com.revature.models.Card;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
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
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET atk = ? WHERE card_id = ?";

            CardDAO cDAO = new CardDAO();
            int id = cDAO.changeNameToID(name);

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newAtk);
            ps.setInt(2, id);

            ps.executeUpdate();

            return newAtk;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update the card's atk!");
        }
        return 0;
    }

    @Override
    public int updateDef(String name, int newDef) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET def = ? WHERE card_id = ?";

            CardDAO cDAO = new CardDAO();
            int id = cDAO.changeNameToID(name);

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newDef);
            ps.setInt(2, id);

            ps.executeUpdate();

            return newDef;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update the card's atk!");
        }
        return 0;
    }

    @Override
    public Card getCardByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards WHERE card_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Card card = new Card(
                        rs.getInt("stars"),
                        rs.getString("card_name"),
                        rs.getInt("atk"),
                        rs.getInt("def"),
                        rs.getInt("duelist_id_fk")
                );
                return card;
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't figure out which card it was by the id!");
        }
        return null;
    }

    @Override
    public int changeNameToID(String name) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards WHERE card_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Card card = new Card(
                        rs.getInt("card_id"),
                        rs.getInt("stars"),
                        rs.getString("card_name"),
                        rs.getInt("atk"),
                        rs.getInt("def"),
                        rs.getInt("duelist_id_fk")
                );
                return card.getCard_id();
            }


        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't change the card name to ID!");
        }
        return 0;
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
