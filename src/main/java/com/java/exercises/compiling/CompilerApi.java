package com.java.exercises.compiling;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.List;

public class CompilerApi {
    private final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public void compileHelloWorld() {
        //var compiler = ToolProvider.getSystemJavaCompiler();

        if (compiler == null) {
            System.out.println("ERROR compiler instance is null");
        }
        else {
            int result = compiler.run(null, null, null,
                    "src\\main\\java\\com\\java\\exercises\\compiling\\CompileHelloWorld.java");
            System.out.println("RESULT is: " + result);
        }
    }

    public void compileSimpleFile() {
        DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(collector, null, null);
        Iterable<JavaFileObject> sources = (Iterable<JavaFileObject>) fileManager.getJavaFileObjectsFromStrings(
                List.of("src\\main\\java\\com\\java\\exercises\\compiling\\File1.java",
                        "src\\main\\java\\com\\java\\exercises\\compiling\\File2.java")
        );

        processSimpleTask(fileManager, collector, sources);

        List<StringSource> sources2 = List.of(
                new StringSource("ClassX", "class ClassX { ClassX() { System.out.println(\"hello from compiling API on the fly\"); } }")
        );

        processTask2(fileManager, collector, sources2);

        for (Diagnostic<? extends JavaFileObject> d: collector.getDiagnostics()) {
            System.out.println("Output of diagnosis: " + d);
        }
    }

    public void processSimpleTask(StandardJavaFileManager fileManager, DiagnosticCollector<JavaFileObject> collector, Iterable<JavaFileObject> sources) {
        var task = compiler.getTask(
                null,
                fileManager,
                collector,
                null,
                null,
                sources
        );

        if (task.call()) {
            System.out.println("OK");
        }
        else {
            System.out.println("NOK");
        }
    }

    public void processTask2(StandardJavaFileManager fileManager, DiagnosticCollector<JavaFileObject> collector, List<StringSource> sources) {
        var task = compiler.getTask(
                null,
                fileManager,
                collector,
                null,
                null,
                sources
        );

        if (task.call()) {
            System.out.println("OK 2");
        }
        else {
            System.out.println("NOK 2");
        }
    }
}
