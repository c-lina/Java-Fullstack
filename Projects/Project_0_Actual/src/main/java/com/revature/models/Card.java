package com.revature.models;

public class Card {
    private int card_id;
    private int stars;
    private String card_name;
    private int atk;
    private int def;
    private int duelist_id_fk;

    public Card() {
    }

    public Card(int card_id, int stars, String card_name, int atk, int def, int duelist_id_fk) {
        this.card_id = card_id;
        this.stars = stars;
        this.card_name = card_name;
        this.atk = atk;
        this.def = def;
        this.duelist_id_fk = duelist_id_fk;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDuelist_id_fk() {
        return duelist_id_fk;
    }

    public void setDuelist_id_fk(int duelist_id_fk) {
        this.duelist_id_fk = duelist_id_fk;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", stars=" + stars +
                ", card_name='" + card_name + '\'' +
                ", atk=" + atk +
                ", def=" + def +
                ", duelist_id_fk=" + duelist_id_fk +
                '}';
    }
}