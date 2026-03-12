package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(1.0, 5.0);
	}

	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest = null;
	}

	@Test
	public void testGetLowerBoundForSharedRangeShouldBeLowerValue() {
		assertEquals("getLowerBound should return the lower bound of the range.",
				1.0, rangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testGetLowerBoundForEqualBoundsShouldBeSameValue() {
		Range range = new Range(3.0, 3.0);
		assertEquals("getLowerBound should return the only bound value when lower equals upper.",
				3.0, range.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testGetUpperBoundForSharedRangeShouldBeUpperValue() {
		assertEquals("getUpperBound should return the upper bound of the range.",
				5.0, rangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testGetUpperBoundForEqualBoundsShouldBeSameValue() {
		Range range = new Range(3.0, 3.0);
		assertEquals("getUpperBound should return the only bound value when lower equals upper.",
				3.0, range.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testContainsForValueInsideRangeShouldBeTrue() {
		assertTrue("contains should return true for a value strictly inside the range.",
				rangeObjectUnderTest.contains(3.0));
	}

	@Test
	public void testContainsForLowerBoundaryValueShouldBeTrue() {
		assertTrue("contains should return true for the lower boundary value.",
				rangeObjectUnderTest.contains(1.0));
	}

	@Test
	public void testContainsForUpperBoundaryValueShouldBeTrue() {
		assertTrue("contains should return true for the upper boundary value.",
				rangeObjectUnderTest.contains(5.0));
	}

	@Test
	public void testContainsForValueBelowLowerBoundShouldBeFalse() {
		assertFalse("contains should return false for a value below the lower bound.",
				rangeObjectUnderTest.contains(0.9));
	}

	@Test
	public void testContainsForValueAboveUpperBoundShouldBeFalse() {
		assertFalse("contains should return false for a value above the upper bound.",
				rangeObjectUnderTest.contains(5.1));
	}

	@Test
	public void testConstrainForValueInsideRangeShouldBeSameValue() {
		assertEquals("constrain should return the same value when the value is inside the range.",
				3.0, rangeObjectUnderTest.constrain(3.0), 0.000000001d);
	}

	@Test
	public void testConstrainForValueBelowRangeShouldBeLowerBound() {
		assertEquals("constrain should return the lower bound when the value is below the range.",
				1.0, rangeObjectUnderTest.constrain(0.0), 0.000000001d);
	}

	@Test
	public void testConstrainForValueAboveRangeShouldBeUpperBound() {
		assertEquals("constrain should return the upper bound when the value is above the range.",
				5.0, rangeObjectUnderTest.constrain(7.0), 0.000000001d);
	}

	@Test
	public void testIntersectsForContainedSubRangeShouldBeTrue() {
		assertTrue("intersects should return true when the specified range is fully inside the range.",
				rangeObjectUnderTest.intersects(2.0, 4.0));
	}

	@Test
	public void testIntersectsForLeftPartialOverlapShouldBeTrue() {
		assertTrue("intersects should return true when the specified range overlaps from the left.",
				rangeObjectUnderTest.intersects(-2.0, 2.0));
	}

	@Test
	public void testIntersectsForUpperBoundaryTouchShouldBeFalse() {
		assertFalse("intersects should return false when the specified range only touches the upper boundary.",
				rangeObjectUnderTest.intersects(5.0, 8.0));
	}

	@Test
	public void testIntersectsForRangeCompletelyLeftShouldBeFalse() {
		assertFalse("intersects should return false when the specified range is completely to the left.",
				rangeObjectUnderTest.intersects(-5.0, 0.0));
	}

	@Test
	public void testIntersectsForRangeCompletelyRightShouldBeFalse() {
		assertFalse("intersects should return false when the specified range is completely to the right.",
				rangeObjectUnderTest.intersects(6.0, 9.0));
	}
}