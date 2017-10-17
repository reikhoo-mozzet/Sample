package com.mozzet.sample.model.network;

import java.util.List;

public class Data {
        private List<String> live_counts;
        private List<Section> sections;
        private int remain_time;
        private boolean is_live_on;

        public List<String> getLive_counts() {
            return live_counts;
        }

        public void setLive_counts(List<String> live_counts) {
            this.live_counts = live_counts;
        }

        public List<Section> getSections() {
            return sections;
        }

        public void setSections(List<Section> sections) {
            this.sections = sections;
        }

        public int getRemain_time() {
            return remain_time;
        }

        public void setRemain_time(int remain_time) {
            this.remain_time = remain_time;
        }

        public boolean isIs_live_on() {
            return is_live_on;
        }

        public void setIs_live_on(boolean is_live_on) {
            this.is_live_on = is_live_on;
        }
    }