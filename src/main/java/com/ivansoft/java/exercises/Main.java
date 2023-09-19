package com.ivansoft.java.exercises;

import com.ivansoft.java.exercises.compiling.CompilerApi;
import com.ivansoft.java.exercises.scripting.ScriptingEngine;

import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        //testScriptingEngine();
        testCompilerApi();
    }

    static void testCompilerApi() {
        var compilingApi = new CompilerApi();
        compilingApi.compileHelloWorld();

        compilingApi.compileSimpleFile();
    }

    static void testScriptingEngine() throws ScriptException, NoSuchMethodException {
        var scripting = new ScriptingEngine();
        scripting.testEngine();
    }
}
