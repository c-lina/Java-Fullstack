package com.revature.DAOs;

import com.revature.models.Duelist;

import java.util.ArrayList;

public interface DuelistDAOInterface {
    Duelist insertNewDuelist(Duelist duelist);
    ArrayList<Duelist> selectAllDuelists();
    int getDuelistIDbyName(String first_name, String last_name);
}
