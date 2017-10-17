package com.mozzet.sample.model.network;

import java.util.List;

public class Section {
        private List<Card> cards;
        private String created_time;

        public List<Card> getCards() {
            return cards;
        }

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }
    }