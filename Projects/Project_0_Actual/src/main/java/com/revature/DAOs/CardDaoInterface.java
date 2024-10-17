package com.revature.DAOs;

import com.revature.models.Card;

import java.util.ArrayList;

public interface CardDaoInterface {
    int assignNewPerson(int cardID, int duelist);
    int updateAtk(int id, int newAtk);
    int updateDef(int id, int newDef);
    Card getCardByID(int id);
    ArrayList<Integer> changeNameToIDs(String name);
    ArrayList<Card> selectAllCards();
    ArrayList<Card> selectCardsByDuelist(int id);
    Card newCard(Card card);
    Card deleteCard(int id);
}
