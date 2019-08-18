package reflect;

/**
 * @author chenwei
 * @createTime 2019-08-18 15:46
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


public class ReflectServiceImpl {
    public static void main(String[] args) throws IOException {

//        ReflectServiceImpl reflectService = new ReflectServiceImpl();
////        reflectService.reflectMethod();
        Object o = this.reflectMethod();
        System.out.println(o);
    }

    //需要反射的方法
    public void sayHello(String name){
        System.out.println("Hello "+name);
    }


    //通过反射方法去构建对象
    public ReflectServiceImpl getInstance(){
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

    //反射方法
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

}
