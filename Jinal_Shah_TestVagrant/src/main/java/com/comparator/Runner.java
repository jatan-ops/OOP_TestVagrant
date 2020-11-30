package com.comparator;

public class Runner {

    SecondaryRunner secondaryRunner = new SecondaryRunner();

    public static void main(String[] args) {

        Runner runner = new Runner();

        runner.secondaryRunner.init();

        runner.secondaryRunner.execute();

    }
}
