package com.ua.stomat.appservices.validator;

public class Procedure {
        private String name;
        private String price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Procedure(String name, String price) {
            this.name = name;
            this.price = price;
        }

        public Procedure() {
        }
    }