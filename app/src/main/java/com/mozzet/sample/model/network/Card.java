package com.mozzet.sample.model.network;

public class Card {
        private String idx;
        private int last_access_minute;
        private String age_str;
        private String location_str;
        private String photo_url;
        private String job;
        private int matching_status;
        private String nickname;
        private String modifier;

        public String getIdx() {
            return idx;
        }

        public void setIdx(String idx) {
            this.idx = idx;
        }

        public int getLast_access_minute() {
            return last_access_minute;
        }

        public void setLast_access_minute(int last_access_minute) {
            this.last_access_minute = last_access_minute;
        }

        public String getAge_str() {
            return age_str;
        }

        public void setAge_str(String age_str) {
            this.age_str = age_str;
        }

        public String getLocation_str() {
            return location_str;
        }

        public void setLocation_str(String location_str) {
            this.location_str = location_str;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public int getMatching_status() {
            return matching_status;
        }

        public void setMatching_status(int matching_status) {
            this.matching_status = matching_status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getModifier() {
            return modifier;
        }

        public void setModifier(String modifier) {
            this.modifier = modifier;
        }
    }