package com.company.Generics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Predicate;

public class MyGenericTest {

//    0
//
//Second option will work only if T is declared as a class generic type. If class doesn't define any generic type and only its member
// function accepts/returns generic type , you need to explicitly declare it in function declaration.
    public <T> T doSomething(Class<T> T) throws IllegalAccessException, InstantiationException {
        return T.newInstance();
    }


    public <R,T> T doSomething(Class<T> T, Class<R> R) throws IllegalAccessException, InstantiationException {
        return T.newInstance();
    }
}

class GraphBasics2 {
    private static Map<Integer, LinkedList<Integer>> graph;

    public static void main(String[] args) {

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        PredicateRemoveIfImpl predicateRemoveIf = new PredicateRemoveIfImpl();
//        list.removeIf(predicateRemoveIf);
//        for (int a: list) {
//            System.out.println(a);
//        }


        MyGenericKlass<SoccerPlayer> soccerPlayerMyGenericKlass = new MyGenericKlass<>();
        SoccerPlayer soccerPlayer = soccerPlayerMyGenericKlass.createInstance(SoccerPlayer.class);
        System.out.println(soccerPlayer.getPlayerName());
    }
}

class MyGenericKlass<T extends Player> {

    T createInstance(Class<T> t){
        T E = null;
        try {
           E= t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return E;
    }
}

class PredicateRemoveIfImpl implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        if(integer==3){
            return true;
        }
        return false;
    }
}

interface PlayerInterface{
    String getPlayerName();
}

class Player implements PlayerInterface{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getPlayerName() {
        return name;
    }
}

class SoccerPlayer extends Player{

    public SoccerPlayer(){
        super("initial playerName");
    }
    public SoccerPlayer(String name) {
        super(name);
    }
}

class TennisPlayer extends Player{

    public TennisPlayer(){
        super("initial playerName");
    }

    public TennisPlayer(String name) {
        super(name);
    }
}