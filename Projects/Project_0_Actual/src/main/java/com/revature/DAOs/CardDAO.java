package com.revature.DAOs;

import com.revature.models.Card;
import com.revature.utils.ConnectionUtil;

import javax.xml.transform.Result;
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
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards ORDER BY card_id ASC";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Card> CardList = new ArrayList<>();

            while(rs.next()) {
                Card card = new Card(
                        rs.getInt("card_id"),
                        rs.getInt("stars"),
                        rs.getString("card_name"),
                        rs.getInt("atk"),
                        rs.getInt("def"),
                        rs.getInt("duelist_id_fk")
                );
                CardList.add(card);
            }
            return CardList;
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't select all the cards!");
        }
        return null;
    }

    @Override
    public ArrayList<Card> selectCardsByDuelist(String first_name, String last_name) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards WHERE duelist_id_fk = ?";

            DuelistDAO dDAO = new DuelistDAO();
            int id = dDAO.getDuelistIDbyName(first_name, last_name);

            System.out.println(id);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Card> cardList = new ArrayList<>();

            while(rs.next()) {
                Card card = new Card(
                        rs.getInt("card_id"),
                        rs.getInt("stars"),
                        rs.getString("card_name"),
                        rs.getInt("atk"),
                        rs.getInt("def"),
                        rs.getInt("duelist_id_fk")
                );
                cardList.add(card);
            }

            return cardList;


        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't select all cards belonging to that duelist!");
        }
        return null;
    }

    @Override
    public Card newCard(Card card) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT into cards(card_id, stars, card_name, atk, def, duelist_id_fk) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, card.getCard_id());
            ps.setInt(2, card.getStars());
            ps.setString(3, card.getCard_name());
            ps.setInt(4, card.getAtk());
            ps.setInt(5, card.getDef());
            ps.setInt(6, card.getDuelist_id_fk());

            ps.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't add new card!");
        }
        return null;
    }

    @Override
    public Card deleteCard(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM cards WHERE card_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the card");
        }
        return null;
    }
}
