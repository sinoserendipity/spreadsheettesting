package com.comp5541.spreadsheet.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.comp5541.spreadsheet.exceptions.InvalidFormulaException;
import com.comp5541.spreadsheet.exceptions.InvalidValueException;
import com.comp5541.spreadsheet.model.SpreadsheetTableModel;

public class SpreadsheetTableModelTest {

	/**
	 * isCellEditable Tests
	 */
	@Test
	public void testIsCellEditable() {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		assertFalse(modeltest.isCellEditable(0, 0));
		assertFalse(modeltest.isCellEditable(1, 1));
	}
	
	
	/**
	 * setValue & getValue Tests
	 * @throws InvalidFormulaException
	 * @throws InvalidValueException
	 */
	@Test
	public void testSetValue() throws InvalidFormulaException, InvalidValueException {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		modeltest.setValue("1.0", 1, 1);
		assertEquals("1.0",modeltest.getValue(1, 1));
		modeltest.setValue("2.99", 0, 0);
		assertEquals("2.99",modeltest.getValue(0, 0));
		modeltest.setValue("100", 9, 10);
		assertEquals("100.0",modeltest.getValue(9, 10));
		
	}

		
	/**
	 * test setValue with invalid value
	 * @throws InvalidFormulaException
	 * @throws InvalidValueException
	 */
	@Test(expected = InvalidValueException.class)
	public void testSetValueInvalidValueException() throws InvalidFormulaException, InvalidValueException  {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		modeltest.setValue("A", 1, 1);
		modeltest.setValue("00000", 1, 1);
	}
	
	/**
	 * test setValue with invalid formula
	 * @throws InvalidFormulaException
	 * @throws InvalidValueException
	 */
	@Test(expected = InvalidFormulaException.class )
	public void testSetValueInvalidFormulaException() throws InvalidFormulaException, InvalidValueException  {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		modeltest.setValue("=M1", 1, 1);
		modeltest.setValue("=AA", 1, 1);
		modeltest.setValue("=P100", 5, 3);
		modeltest.setValue("=A1A2", 0, 0);
		
	}
		

	/**
	 * getColumnName Tests
	 */
	@Test
	public void testGetColumnNameInt() {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		assertEquals("A",modeltest.getColumnName(0));
		assertEquals("B",modeltest.getColumnName(1));
		assertEquals("K",modeltest.getColumnName(10));
	}
	
	
    /**
     * getColumnCount Tests
     */
	@Test
	public void testGetColumnCount() {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		assertEquals(11,modeltest.getColumnCount());
	}

	/**
	 * getRowCount Tests
	 */
	@Test
	public void testGetRowCount() {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		assertEquals(10,modeltest.getRowCount());
	}

	/**
	 * setValueAt & getValueAt Tests
	 */
	@Test
	public void testSetValueAtObjectIntInt() {
		SpreadsheetTableModel modeltest = SpreadsheetTableModel.getInstance();
		modeltest.setValueAt("11", 1, 1);
		assertEquals("11.0",modeltest.getValueAt(1, 1));
		modeltest.setValueAt("11.1", 0, 0);
		assertEquals("11.1" , modeltest.getValueAt(0, 0));
		modeltest.setValueAt("999", 9, 10);
		assertEquals("999.0" , modeltest.getValueAt(9, 10));
	}

}
