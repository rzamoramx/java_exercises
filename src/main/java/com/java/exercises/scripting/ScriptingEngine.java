package com.java.exercises.scripting;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ScriptingEngine {
    void supportedEngines() {
        var manager = new ScriptEngineManager();
        System.out.println("Available engines...");
        for (ScriptEngineFactory factory : manager.getEngineFactories())
            System.out.println(factory.getEngineName());
    }

    ScriptEngine getEngine(String name) {
        var manager = new ScriptEngineManager();
        var engine = manager.getEngineByName(name);
        if (engine == null) {
            System.out.println("No engine for: " + name);
        }

        return engine;
    }

    public void testEngine() throws ScriptException, NoSuchMethodException {
        String script = "print('hello world')";
        this.supportedEngines();
        var engine = this.getEngine("nashorn");
        engine.eval(script);

        // Retaining and accessing variables
        engine.eval("n = 10");
        engine.eval("n + 10");
        Object result = engine.get("n");
        System.out.println("Result of n = 10 and n + 10 is: " + result);

        // Accessing Java object inside scripts
        Foo foo = new Foo();
        engine.put("x", foo);
        engine.eval("x.bar()");
        engine.eval("java.lang.System.out.println(\"hello\");");

        // Redirect output for script
        var writer = new StringWriter();
        engine.getContext().setWriter(new PrintWriter(writer, true));

        // Calling methods without knowing the specific syntax of a language chosen
        // Define function
        engine.eval("function greet(how, whom) { return how + ', ' + whom + '!' }");

        // Call function
        result = ((Invocable) engine).invokeFunction("greet", "saludito", "yo merengues");
        System.out.println(result);
    }

    public static class Foo {
        public void bar() {
            System.out.println("Printing inside Foo.bar()");
        }
    }
}
