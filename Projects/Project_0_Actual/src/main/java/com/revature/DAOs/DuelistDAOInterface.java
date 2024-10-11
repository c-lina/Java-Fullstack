package com.revature.DAOs;

import com.revature.models.Duelist;

import java.util.ArrayList;

public interface DuelistDAOInterface {
    Duelist importNewDuelist(Duelist duelist);
    ArrayList<Duelist> selectAllDuelists();
    int getDuelistIDbyName(String first_name, String last_name);
}
