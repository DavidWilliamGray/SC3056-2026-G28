package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;

public class DataUtilitiesTest {

	private Values2D createSampleValues2D() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();

		data.addValue(1.0, "R1", "C1");
		data.addValue(2.0, "R1", "C2");
		data.addValue(3.0, "R1", "C3");

		data.addValue(4.0, "R2", "C1");
		data.addValue(5.0, "R2", "C2");
		data.addValue(6.0, "R2", "C3");

		return data;
	}

	private KeyedValues createSampleKeyedValues() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("A", 5.0);
		data.addValue("B", 9.0);
		data.addValue("C", 2.0);
		return data;
	}

	@Test
	public void testCalculateColumnTotalForFirstColumnReturnsCorrectSum() {
		Values2D data = createSampleValues2D();
		assertEquals("calculateColumnTotal should return the correct total for column 0.",
				5.0, DataUtilities.calculateColumnTotal(data, 0), 0.000000001d);
	}

	@Test
	public void testCalculateColumnTotalForSecondColumnReturnsCorrectSum() {
		Values2D data = createSampleValues2D();
		assertEquals("calculateColumnTotal should return the correct total for column 1.",
				7.0, DataUtilities.calculateColumnTotal(data, 1), 0.000000001d);
	}

	@Test
	public void testCalculateColumnTotalWithNullDataThrowsException() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was IllegalArgumentException.");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCalculateRowTotalForFirstRowReturnsCorrectSum() {
		Values2D data = createSampleValues2D();
		assertEquals("calculateRowTotal should return the correct total for row 0.",
				6.0, DataUtilities.calculateRowTotal(data, 0), 0.000000001d);
	}

	@Test
	public void testCalculateRowTotalForSecondRowReturnsCorrectSum() {
		Values2D data = createSampleValues2D();
		assertEquals("calculateRowTotal should return the correct total for row 1.",
				15.0, DataUtilities.calculateRowTotal(data, 1), 0.000000001d);
	}

	@Test
	public void testCalculateRowTotalWithNullDataThrowsException() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was IllegalArgumentException.");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCreateNumberArrayReturnsArrayWithSameLengthAndValues() {
		double[] input = {1.5, -2.0, 0.0};
		Number[] result = DataUtilities.createNumberArray(input);

		assertNotNull("createNumberArray should not return null for a valid input array.", result);
		assertEquals("Returned array should have the same length as the input array.",
				3, result.length);

		assertNotNull("First boxed value should not be null.", result[0]);
		assertNotNull("Second boxed value should not be null.", result[1]);
		assertNotNull("Third boxed value should not be null.", result[2]);

		assertEquals("First boxed value should match the input.",
				1.5, result[0].doubleValue(), 0.000000001d);
		assertEquals("Second boxed value should match the input.",
				-2.0, result[1].doubleValue(), 0.000000001d);
		assertEquals("Third boxed value should match the input.",
				0.0, result[2].doubleValue(), 0.000000001d);
	}

	@Test
	public void testCreateNumberArrayForEmptyInputReturnsEmptyArray() {
		double[] input = {};
		Number[] result = DataUtilities.createNumberArray(input);

		assertNotNull("createNumberArray should not return null for an empty input array.", result);
		assertEquals("Returned array should be empty when the input array is empty.",
				0, result.length);
	}

	@Test
	public void testCreateNumberArrayWithNullInputThrowsException() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was IllegalArgumentException.");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testCreateNumberArray2DReturnsMatrixWithSameShapeAndValues() {
		double[][] input = {
				{1.0, 2.0},
				{3.0, 4.0}
		};

		Number[][] result = DataUtilities.createNumberArray2D(input);

		assertNotNull("createNumberArray2D should not return null for a valid input matrix.", result);
		assertEquals("Returned matrix should have the same number of rows as the input matrix.",
				2, result.length);

		assertNotNull("First row should not be null.", result[0]);
		assertNotNull("Second row should not be null.", result[1]);

		assertEquals("First row should have the same number of columns as the input matrix.",
				2, result[0].length);
		assertEquals("Second row should have the same number of columns as the input matrix.",
				2, result[1].length);

		assertNotNull("Element [0][0] should not be null.", result[0][0]);
		assertNotNull("Element [0][1] should not be null.", result[0][1]);
		assertNotNull("Element [1][0] should not be null.", result[1][0]);
		assertNotNull("Element [1][1] should not be null.", result[1][1]);

		assertEquals("Element [0][0] should match the input value.",
				1.0, result[0][0].doubleValue(), 0.000000001d);
		assertEquals("Element [0][1] should match the input value.",
				2.0, result[0][1].doubleValue(), 0.000000001d);
		assertEquals("Element [1][0] should match the input value.",
				3.0, result[1][0].doubleValue(), 0.000000001d);
		assertEquals("Element [1][1] should match the input value.",
				4.0, result[1][1].doubleValue(), 0.000000001d);
	}

	@Test
	public void testCreateNumberArray2DWithNullInputThrowsException() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was IllegalArgumentException.");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void testGetCumulativePercentagesReturnsCorrectRunningPercentages() {
		KeyedValues data = createSampleKeyedValues();
		KeyedValues result = DataUtilities.getCumulativePercentages(data);

		assertNotNull("getCumulativePercentages should not return null for valid input.", result);
		assertNotNull("First cumulative percentage should not be null.", result.getValue(0));
		assertNotNull("Second cumulative percentage should not be null.", result.getValue(1));
		assertNotNull("Third cumulative percentage should not be null.", result.getValue(2));

		assertEquals("First cumulative percentage should be 5/16.",
				5.0 / 16.0, result.getValue(0).doubleValue(), 0.000000001d);
		assertEquals("Second cumulative percentage should be 14/16.",
				14.0 / 16.0, result.getValue(1).doubleValue(), 0.000000001d);
		assertEquals("Third cumulative percentage should be 16/16.",
				1.0, result.getValue(2).doubleValue(), 0.000000001d);
	}

	@Test
	public void testGetCumulativePercentagesForSingleValueReturnsOne() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("Only", 7.0);

		KeyedValues result = DataUtilities.getCumulativePercentages(data);

		assertNotNull("getCumulativePercentages should not return null for single-value input.", result);
		assertNotNull("Single cumulative percentage value should not be null.", result.getValue(0));

		assertEquals("Single-value cumulative percentage should be 1.0.",
				1.0, result.getValue(0).doubleValue(), 0.000000001d);
	}

	@Test
	public void testGetCumulativePercentagesWithNullDataThrowsException() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was IllegalArgumentException.");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown.",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
}