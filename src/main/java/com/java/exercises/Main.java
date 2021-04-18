package com.java.exercises;

import com.java.exercises.compiling.CompilerApi;
import com.java.exercises.scripting.ScriptingEngine;

import javax.script.ScriptException;
import javax.tools.StandardJavaFileManager;

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
