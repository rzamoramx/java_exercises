package com.java.exercises.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptingEngine {
    public void supportedEngines() {
        var manager = new ScriptEngineManager();
        System.out.println("Available engines...");
        for (ScriptEngineFactory factory : manager.getEngineFactories())
            System.out.println(factory.getEngineName());
    }

    public ScriptEngine getEngine(String name) {
        var manager = new ScriptEngineManager();
        var engine = manager.getEngineByName(name);
        if (engine == null) {
            System.out.println("No engine for: " + name);
        }

        return engine;
    }

    public void testEngine() throws ScriptException {
        String script = "print('hello world')";
        this.supportedEngines();
        var engine = this.getEngine("nashorn");
        engine.eval(script);
    }
}
