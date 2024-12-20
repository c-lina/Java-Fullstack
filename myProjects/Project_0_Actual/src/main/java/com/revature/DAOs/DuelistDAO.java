package com.revature.DAOs;

import com.revature.models.Duelist;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class DuelistDAO implements DuelistDAOInterface{
    @Override
    public Duelist insertNewDuelist(Duelist duelist) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO duelists(first_name, last_name) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, duelist.getFirst_name());
            ps.setString(2, duelist.getLast_name());

            ps.executeUpdate();

            return duelist;
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't insert new duelist!");
        }
        return null;
    }

    @Override
    public ArrayList<Duelist> selectAllDuelists() {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM duelists";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Duelist> duelistsList = new ArrayList<>();

            while(rs.next()) {
                Duelist duelist = new Duelist(
                        rs.getInt("duelist_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                duelistsList.add(duelist);
            }
            return duelistsList;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't print out all duelists!");
        }
        return null;
    }

    @Override
    public ArrayList<Duelist> getDuelistbyName(String first_name, String last_name) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM duelists WHERE first_name LIKE ? OR last_name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, first_name);
            ps.setString(2, last_name);

            ResultSet rs = ps.executeQuery();

            ArrayList<Duelist> duelistList = new ArrayList<>();

            while(rs.next()) {
                Duelist duelist = new Duelist(
                        rs.getInt("duelist_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                duelistList.add(duelist);
            }
            return duelistList;
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't get duelist id by name!");
        }
        return null;
    }

    @Override
    public Duelist getDuelistByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM duelists WHERE duelist_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Duelist duelist = new Duelist(
                        rs.getInt("duelist_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                return duelist;
            }


        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get duelist by ID!");
        }
        return null;
    }
}
