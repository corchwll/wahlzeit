package org.waterdropzeit.model.location;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MapcodeLocationTests extends AbstractLocationTests
{
	@Override
	@Before
	public void setUp()
	{
		super.setUp();
	}

	@Test
	public void testGetPoint_ValuesFromConstructor_CorrectValues()
	{
		final double[] newPoint = mapcodeLocation.getPoint();
		assertTrue("Latitude should be " + mapLat + " but was " + newPoint[0] + " and Longitude should be " +
				mapLon + " but was " + newPoint[1], (mapLat == newPoint[0]) && (mapLon == newPoint[1]));
	}

	@Test
	public void testGetMapcode_ValuesFromConstructor_CorrectValues()
	{
		final String mapcode = mapcodeLocation.getMapcode();
		assertTrue("Mapcode should be '" + this.mapcode + "' but was '" + mapcode + "'", this.mapcode.equals(mapcode));
	}

	@Test
	public void testSetMapcode_ValidValues_SetCorrect()
	{
		final String mapcode = "KJ3J5.W78B";
		final double lat = 7.235007;
		final double lon = 8.62449;

		mapcodeLocation.setMapcode(mapcode);
		final double newLat = mapcodeLocation.getLatitude();
		final double newLon = mapcodeLocation.getLongitude();

		assertTrue("Latitude should be " + lat + " but was " + newLat + " and Longitude should be " +
				lon + " but was " + newLon, (lat == newLat) && (lon == newLon));
	}

	@Test
	public void testAsString_ValuesFromConstructor_CorrectValues()
	{
		final String mapcode = mapcodeLocation.getMapcode();
		assertTrue("Mapcode should be '" + this.mapcode + "' but was '" + mapcode + "'",
				this.mapcode.contains(mapcode));
	}
}