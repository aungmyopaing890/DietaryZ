package com.example.dietaryz;

public class MainActivity {
    private static final MainActivity ourInstance = new MainActivity();

    public static MainActivity getInstance() {
        return ourInstance;
    }

    private MainActivity() {
    }
}
