package org.wahlzeit.model.waterdrops;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by fertigt on 18/11/14.
 */
public class WaterdropFormTests
{
	@Test
	public void testSetDoublePillar_DoublePillarTrueBubbleFalse_OK()
	{
		WaterdropForm form = new WaterdropForm();

		boolean exceptionNotThrown = true;
		try
		{
			form.setDoublePillar(true);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(form.isDoublePillar() && exceptionNotThrown);
	}

	@Test
	public void testSetDoublePillar_DoublePillarTrueBubbleTrue_False()
	{
		WaterdropForm form = new WaterdropForm();
		form.setBubble(true);

		boolean exceptionThrown = false;
		try
		{
			form.setDoublePillar(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetBubble_BubbleTrueDoublePillarFalseCrownFalse_OK()
	{
		WaterdropForm form = new WaterdropForm();

		boolean exceptionNotThrown = true;
		try
		{
			form.setBubble(true);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(form.isBubble() && exceptionNotThrown);
	}

	@Test
	public void testSetBubble_BubbleTrueDoublePillarTrueCrownFalse_False()
	{
		WaterdropForm form = new WaterdropForm();
		form.setDoublePillar(true);

		boolean exceptionThrown = false;
		try
		{
			form.setBubble(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetBubble_BubbleTrueDoublePillarTrueCrownTrue_False()
	{
		WaterdropForm form = new WaterdropForm();
		form.setDoublePillar(true);
		form.setCrown(true);

		boolean exceptionThrown = false;
		try
		{
			form.setBubble(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetBubble_BubbleTrueDoublePillarFalseCrownTrue_False()
	{
		WaterdropForm form = new WaterdropForm();
		form.setCrown(true);

		boolean exceptionThrown = false;
		try
		{
			form.setBubble(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetBubble_BubbleFalse_OK()
	{
		WaterdropForm form = new WaterdropForm();

		boolean exceptionNotThrown = true;
		try
		{
			form.setBubble(false);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(!form.isBubble() && exceptionNotThrown);
	}

	@Test
	public void testSetCrown_CrownTrueBubbleFalse_OK()
	{
		WaterdropForm form = new WaterdropForm();

		boolean exceptionNotThrown = true;
		try
		{
			form.setCrown(true);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(form.isCrown() && exceptionNotThrown);
	}

	@Test
	public void testSetCrown_CrownTrueBubbleTrue_False()
	{
		WaterdropForm form = new WaterdropForm();
		form.setBubble(true);

		boolean exceptionThrown = false;
		try
		{
			form.setCrown(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}
}
