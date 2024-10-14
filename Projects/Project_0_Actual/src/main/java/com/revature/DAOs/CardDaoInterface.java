package com.revature.DAOs;

import com.revature.models.Card;

import java.util.ArrayList;

public interface CardDaoInterface {
    String assignNewPerson(String cardName, int duelist);
    int updateAtk(String name, int newAtk);
    int updateDef(String name, int newDef);
    Card getCardByID(int id);
    int changeNameToID(String name);
    ArrayList<Card> selectAllCards();
    ArrayList<Card> selectCardsByDuelist(String first_name, String last_name);
    Card newCard(Card card);
    Card deleteCard(int id);
}
