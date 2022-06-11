package singleton;

/**
 * Одиночка – это порождающий паттерн проектирования,
 * который гарантирует, что у класса есть только один экземпляр,
 * и предоставляет к нему глобальную точку доступа.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}