package reflect;

/**
 * @author chenwei
 * @createTime 2019-08-18 21:16
 * @description
 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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


public class ReflectServiceImpl2 {
//    public static void main(String[] args) throws IOException {
//
//    }

    private String name;

    public ReflectServiceImpl2(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("heeLL+"+name);
    }



}
