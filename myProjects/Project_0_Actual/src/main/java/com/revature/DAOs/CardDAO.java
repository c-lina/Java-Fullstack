package com.revature.DAOs;

import com.revature.models.Card;
import com.revature.utils.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class CardDAO implements CardDaoInterface{

    @Override
    public void assignNewPerson(int cardID, int duelistID) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET duelist_id_fk = ? WHERE card_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, duelistID);
            ps.setInt(2, cardID);

            ps.executeUpdate();

            System.out.println("Card ownership changed successfully!");

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't assign this card to another duelist!");
        }
    }

    @Override
    public int updateAtk(int id, int newAtk) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET atk = ? WHERE card_id = ?";

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
    public int updateDef(int id, int newDef) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cards SET def = ? WHERE card_id = ?";

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
                        rs.getInt("card_id"),
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
    public ArrayList<Integer> changeNameToIDs(String name) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards WHERE card_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            ArrayList<Integer> nums = new ArrayList<Integer>();

            while(rs.next()) {
                nums.add(rs.getInt("card_id"));
            }
            return nums;


        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't change the card name to ID!");
        }
        return null;
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
    public ArrayList<Card> selectCardsByDuelist(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cards WHERE duelist_id_fk = ?";

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
            String sql = "INSERT into cards(stars, card_name, atk, def, duelist_id_fk) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, card.getStars());
            ps.setString(2, card.getCard_name());
            ps.setInt(3, card.getAtk());
            ps.setInt(4, card.getDef());
            ps.setInt(5, card.getDuelist_id_fk());

            ps.executeUpdate();

            return card;
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
