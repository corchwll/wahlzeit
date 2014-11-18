package org.wahlzeit.model.waterdrops;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by fertigt on 18/11/14.
 */
public class WaterdropTechniqueTests
{
	@Test
	public void testSetSolidSurface_LiquidIsWater_OK()
	{
		WaterdropTechnique technique = new WaterdropTechnique();

		boolean exceptionNotThrown = true;
		try
		{
			technique.setSolidSurface(true);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(technique.isSolidSurface() && exceptionNotThrown);
	}

	@Test
	public void testSetSolidSurface_LiquidIsNotWater_False()
	{
		WaterdropTechnique technique = new WaterdropTechnique();
		technique.setLiquid(Liquid.milk);

		boolean exceptionThrown = false;
		try
		{
			technique.setSolidSurface(true);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetLiquid_SolidSurfaceTrueAndWater_OK()
	{
		WaterdropTechnique technique = new WaterdropTechnique();
		technique.setSolidSurface(true);

		boolean exceptionNotThrown = true;
		try
		{
			technique.setLiquid(Liquid.water);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(technique.getLiquid().equals(Liquid.water) && exceptionNotThrown);
	}

	@Test
	public void testSetLiquid_SolidSurfaceTrueNoWater_False()
	{
		WaterdropTechnique technique = new WaterdropTechnique();
		technique.setSolidSurface(true);

		boolean exceptionThrown = false;
		try
		{
			technique.setLiquid(Liquid.paint);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	@Test
	public void testSetLiquid_SolidSurfaceFalseAndWater_OK()
	{
		WaterdropTechnique technique = new WaterdropTechnique();
		technique.setSolidSurface(false);

		boolean exceptionNotThrown = true;
		try
		{
			technique.setLiquid(Liquid.water);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(technique.getLiquid().equals(Liquid.water) && exceptionNotThrown);
	}

	@Test
	public void testSetLiquid_SolidSurfaceFalseNoWater_OK()
	{
		WaterdropTechnique technique = new WaterdropTechnique();
		technique.setSolidSurface(false);

		boolean exceptionNotThrown = true;
		try
		{
			technique.setLiquid(Liquid.milk);
		} catch(Exception e)
		{
			exceptionNotThrown = false;
		}

		assertTrue(technique.getLiquid().equals(Liquid.milk) && exceptionNotThrown);
	}
}
