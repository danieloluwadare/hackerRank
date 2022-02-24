package com.company.DesignPattern.Creational.Builder;

public class LunchOrder {

    private final String bread;
    private final  String egg;
    private final String tea;
    private final String beef;




    private LunchOrder(Builder builder){
        this.bread = builder.bread;
        this.egg = builder.egg;
        this.tea = builder.tea;
        this.beef = builder.beef;
    }

    public static class Builder{
        private  String bread;
        private  String egg;
        private String tea;
        private String beef;

        public LunchOrder build(){
            return new LunchOrder(this);
        }

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder setEgg(String egg) {
            this.egg = egg;
            return this;
        }

        public Builder setTea(String tea) {
            this.tea = tea;
            return this;
        }

        public Builder setBeef(String beef) {
            this.beef = beef;
            return this;
        }
    }

    public String getBread() {
        return bread;
    }

    public String getEgg() {
        return egg;
    }

    public String getTea() {
        return tea;
    }

    public String getBeef() {
        return beef;
    }
}
