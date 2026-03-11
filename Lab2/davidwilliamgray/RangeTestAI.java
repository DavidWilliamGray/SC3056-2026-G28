package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class RangeTestAI {

    /*
     * Method 1: contains(double value)
     */

    @Test
    public void testContainsValueInsideRange() {
        Range range = new Range(0.0, 10.0);
        assertTrue(range.contains(5.0));
    }

    @Test
    public void testContainsValueAtLowerBoundary() {
        Range range = new Range(0.0, 10.0);
        assertTrue(range.contains(0.0));
    }

    @Test
    public void testContainsValueAtUpperBoundary() {
        Range range = new Range(0.0, 10.0);
        assertTrue(range.contains(10.0));
    }

    @Test
    public void testContainsValueBelowRange() {
        Range range = new Range(0.0, 10.0);
        assertFalse(range.contains(-1.0));
    }

    @Test
    public void testContainsValueAboveRange() {
        Range range = new Range(0.0, 10.0);
        assertFalse(range.contains(11.0));
    }


    /*
     * Method 2: constrain(double value)
     */

    @Test
    public void testConstrainValueInsideRange() {
        Range range = new Range(0.0, 10.0);
        assertEquals(5.0, range.constrain(5.0), 0.0001);
    }

    @Test
    public void testConstrainValueBelowRange() {
        Range range = new Range(0.0, 10.0);
        assertEquals(0.0, range.constrain(-5.0), 0.0001);
    }

    @Test
    public void testConstrainValueAboveRange() {
        Range range = new Range(0.0, 10.0);
        assertEquals(10.0, range.constrain(20.0), 0.0001);
    }


    /*
     * Method 3: combine(Range range1, Range range2)
     */

    @Test
    public void testCombineTwoValidRanges() {
        Range r1 = new Range(1.0, 5.0);
        Range r2 = new Range(3.0, 10.0);

        Range result = Range.combine(r1, r2);

        assertEquals(1.0, result.getLowerBound(), 0.0001);
        assertEquals(10.0, result.getUpperBound(), 0.0001);
    }

    @Test
    public void testCombineFirstRangeNull() {
        Range r2 = new Range(2.0, 8.0);

        Range result = Range.combine(null, r2);

        assertEquals(r2, result);
    }

    @Test
    public void testCombineSecondRangeNull() {
        Range r1 = new Range(2.0, 8.0);

        Range result = Range.combine(r1, null);

        assertEquals(r1, result);
    }


    /*
     * Method 4: expandToInclude(Range range, double value)
     */

    @Test
    public void testExpandToIncludeValueInsideRange() {
        Range range = new Range(0.0, 10.0);

        Range result = Range.expandToInclude(range, 5.0);

        assertEquals(0.0, result.getLowerBound(), 0.0001);
        assertEquals(10.0, result.getUpperBound(), 0.0001);
    }

    @Test
    public void testExpandToIncludeValueBelowRange() {
        Range range = new Range(0.0, 10.0);

        Range result = Range.expandToInclude(range, -5.0);

        assertEquals(-5.0, result.getLowerBound(), 0.0001);
        assertEquals(10.0, result.getUpperBound(), 0.0001);
    }

    @Test
    public void testExpandToIncludeValueAboveRange() {
        Range range = new Range(0.0, 10.0);

        Range result = Range.expandToInclude(range, 20.0);

        assertEquals(0.0, result.getLowerBound(), 0.0001);
        assertEquals(20.0, result.getUpperBound(), 0.0001);
    }


    /*
     * Method 5: intersects(double lower, double upper)
     */

    @Test
    public void testIntersectsOverlappingRange() {
        Range range = new Range(0.0, 10.0);

        assertTrue(range.intersects(5.0, 15.0));
    }

    @Test
    public void testIntersectsExactBoundaryOverlap() {
        Range range = new Range(0.0, 10.0);

        assertTrue(range.intersects(10.0, 20.0));
    }

    @Test
    public void testIntersectsNoOverlap() {
        Range range = new Range(0.0, 10.0);

        assertFalse(range.intersects(11.0, 20.0));
    }

}