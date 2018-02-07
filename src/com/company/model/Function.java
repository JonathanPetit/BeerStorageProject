package com.company.model;

public enum Function {
    BEER {
        public String toString() {
            return "Brand";
        }
    },

    BRAND {
        public String toString() {
            return "Brewer";
        }
    },

    BREWER {
        public String toString() {
            return "Inventory";
        }
    }
}