package com.sample.test.demo.tests;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
interface BaseI {void method();}

class BaseC{
    public void method (){
        System.out.println("Inside BaseC:method");
    }
}

class ImplC extends BaseC implements BaseI
{
    public static void main(String []s)
    {
        (new ImplC()).method();
    }
}