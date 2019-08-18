package reflect;

/**
 * @author chenwei
 * @createTime 2019-08-18 21:02
 * @description
 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


public class ReflectTest {
    public static void main(String[] args) throws IOException {

        ReflectTest reflectTest = new ReflectTest();
//        System.out.println(reflectTest.getInstance());
        //反射生成对象
        Object o = reflectTest.getInstance();
        ((ReflectServiceImpl) o).sayHello("张");

        //反射调度方法
        reflectTest.reflectMethod();

        //一步到位，首先通过反射方法构建对象，然后反射方法
        reflectTest.reflect();

        //带参数的反射方法
        Object o2 = reflectTest.getInstance2();
        ((ReflectServiceImpl2) o2).sayHello();

    }



    //通过反射方法去构建对象
    public Object getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    public Object getInstance2(){
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    //反射方法,在方法里面new了一个对象
    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    //一步到位，首先通过反射方法构建对象，然后反射方法，没有在方法里面new对象
    public  Object reflect(){
        ReflectServiceImpl object = null;

        try {
            object = (ReflectServiceImpl) Class.forName("reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"zhang");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;

    }

}
