package com.gmail.chernii.oleksii.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Space on 17.03.2019.
 */
public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton1 == singleton2 -> " + (singleton1 == singleton2));

        Singleton singleton3 = newSingleton();
        if (singleton3 != null) {
            System.out.println("singleton1 == singleton3 -> " + (singleton1 == singleton3));
            System.out.println("singleton2 == singleton3 -> " + (singleton2 == singleton3));
        }

    }

    public static Singleton newSingleton() {
        Singleton singleton = null;
        try {
            Class cl = Singleton.class;
            Constructor<Singleton> constructor = cl.getDeclaredConstructor();
            constructor.setAccessible(Boolean.TRUE);
            singleton = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return singleton;
    }
}
