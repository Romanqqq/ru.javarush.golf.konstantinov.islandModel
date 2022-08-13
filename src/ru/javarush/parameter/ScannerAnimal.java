package ru.javarush.parameter;
import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class ScannerAnimal {
    private static Set<Class> predatorAnimal;
    private static Set<Class> herbivoreAnimal;

    static {
        try {
            predatorAnimal = scanPackageAnimal("ru.javarush.animal.predator");
            herbivoreAnimal = scanPackageAnimal("ru.javarush.animal.herbivore");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Set<Class> scanPackageAnimal(String namePackage) throws IOException{
        return ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream().filter(classPackage->
                classPackage.getPackageName().equalsIgnoreCase(namePackage)).map(classPackage->classPackage.load()).
                collect(Collectors.toSet());
    }
    public static Set<Class> getPredatorAnimal() {
        return predatorAnimal;
    }

    public static Set<Class> getHerbivoreAnimal() {
        return herbivoreAnimal;
    }
}

