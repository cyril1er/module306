/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emiage.module306;

import junit.framework.*;
import static org.junit.Assert.*;

/**
 *
 * @author cyril
 */
public class DemoClassTest extends TestCase {

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    @Override
    public void setUp() throws Exception {
    }

    @org.junit.After
    @Override
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testTabCreation() {
        int[] tab1;
        int size = 6;

        tab1 = DemoClass.randomTab(size);

        assertEquals(tab1.length, size);
    }

    /**
     * Test of bubbleSort method, of class DemoClass.
     */
    @org.junit.Test
    public void testBubbleSort() {
        System.out.println("bubbleSort");
        int[] tab1 = {2, 1, 0};
        int[] tab2 = {0, 1, 2};

        DemoClass.bubbleSort(tab1);
        assertArrayEquals(tab2, tab1);

    }

    /**
     * Test of selectSort method, of class DemoClass.
     */
    @org.junit.Test
    public void testSelectSort() {
        System.out.println("selectSort");

        int[] tab1 = {2, 1, 0};
        int[] tab2 = {0, 1, 2};

        DemoClass.selectSort(tab1);
        assertArrayEquals(tab2, tab1);
    }

    /**
     * Test of rapideSort method, of class DemoClass.
     */
    @org.junit.Test
    public void testQuickSort() {
        System.out.println("rapideSort");

        int[] tab1 = {2, 1, 0};
        int[] tab2 = {0, 1, 2};

        DemoClass.rapideSort(tab1);
        assertArrayEquals(tab2, tab1);
    }

    /**
     * Test of mergeSort method, of class DemoClass.
     */
    @org.junit.Test
    public void testMergeSort() {
        System.out.println("mergeSort");

        int[] tab1 = {2, 1, 0};
        int[] tab2 = {0, 1, 2};

        DemoClass.mergeSort(tab1);
        assertArrayEquals(tab2, tab1);
    }

    @org.junit.Test
    public void testSortsEmptyArray() {

        System.out.println("testSortsEmptyArray");

        int[] a1 = new int[0];
        int[] a2 = new int[0];

        DemoClass.rapideSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.bubbleSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.mergeSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.selectSort(a1);
        assertArrayEquals(a2, a1);

    }

    @org.junit.Test
    public void testSortsArraySorted() {

        System.out.println("testSortsArraySorted");

        int[] a1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        DemoClass.rapideSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.bubbleSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.mergeSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.selectSort(a1);
        assertArrayEquals(a2, a1);

    }

    @org.junit.Test
    public void testSortsArrayInverseSorted() {

        System.out.println("testSortsArrayInverseSorted");

        int[] a1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        DemoClass.rapideSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.bubbleSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.mergeSort(a1);
        assertArrayEquals(a2, a1);

        DemoClass.selectSort(a1);
        assertArrayEquals(a2, a1);
    }

    @org.junit.Test
    public void testSortsArrayUnSorted() {

        System.out.println("testSortsArrayInverseSorted");

        int[] a1 = {3, 2, 5, 6, 7, 10, 1, 4, 9, 8, 0};
        int[] a2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("rapideSort");
        DemoClass.rapideSort(a1);
        assertArrayEquals(a2, a1);

        System.out.println("bubbleSort");
        DemoClass.bubbleSort(a1);
        assertArrayEquals(a2, a1);

        System.out.println("mergeSort");
        DemoClass.mergeSort(a1);
        assertArrayEquals(a2, a1);

        System.out.println("selectSort");
        DemoClass.selectSort(a1);
        assertArrayEquals(a2, a1);
    }

    @org.junit.Test
    public void testAnalysisMethods() {

        int i;
        int[] tab1;
        long a, b , c ,d ,e ,f , g, h ;
        int[] sizes = {100, 1000, 10000, 100000 };

        
        for (i = 0; i < sizes.length; i++) {
            tab1 = DemoClass.randomTab(sizes[i]);

            a = System.currentTimeMillis();
            DemoClass.rapideSort(tab1);
            b = System.currentTimeMillis();
            System.out.println("rapideSort with size " + sizes[i]  + " => " + (b - a) + " millisec" );

            c = System.currentTimeMillis();
            DemoClass.bubbleSort(tab1);
            d = System.currentTimeMillis();
            System.out.println("bubbleSort with size " + sizes[i]  + " => " + (d - c) + " millisec ");

            e = System.currentTimeMillis();
            DemoClass.mergeSort(tab1);
            f = System.currentTimeMillis();
            System.out.println("MergeSort with size " + sizes[i]  + " => " + (f - e) + " millisec");

            g = System.currentTimeMillis();
            DemoClass.selectSort(tab1);
            h = System.currentTimeMillis();
            System.out.println("selectSort with size " + sizes[i]  + " => " + ( h - g ) + " millisec");

        }

    }
}
