package com.java.exercises;

import com.java.exercises.scripting.ScriptingEngine;

import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws ScriptException {
        var scripting = new ScriptingEngine();
        scripting.testEngine();
    }
}
