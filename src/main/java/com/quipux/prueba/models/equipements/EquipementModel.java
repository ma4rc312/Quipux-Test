package com.quipux.prueba.models.equipements;

import java.util.List;
public class EquipementModel {
        private String name;
        private int titles;
        private String stadium;
        private List<PlayerModel> players;
        private List<PlayerModel> substitutes;

        // Getters y setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTitles() {
            return titles;
        }

        public void setTitles(int titles) {
            this.titles = titles;
        }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public List<PlayerModel> getPlayers() {
            return players;
        }

        public void setPlayers(List<PlayerModel> players) {
            this.players = players;
        }

        public List<PlayerModel> getSubstitutes() {
            return substitutes;
        }

        public void setSubstitutes(List<PlayerModel> substitutes) {
            this.substitutes = substitutes;
        }
    }