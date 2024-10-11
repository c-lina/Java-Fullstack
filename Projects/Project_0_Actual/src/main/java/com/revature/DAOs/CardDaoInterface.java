package com.revature.DAOs;

import com.revature.models.Card;

import java.util.ArrayList;

public interface CardDaoInterface {
    String assignNewPerson(String cardName, int duelist);
    int updateAtk(String name, int newAtk);
    int updateDef(String name, int newDef);
    Card getCardByID(int id, Card details);
    ArrayList<Card> selectAllCards();
    Card newCard(Card card);
    Card deleteCard(Card card);
}