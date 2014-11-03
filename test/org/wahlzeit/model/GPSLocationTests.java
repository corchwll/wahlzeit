package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GPSLocationTests extends AbstractLocationTests
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
		final double[] newPoint = gpsLocation.getPoint();
		assertTrue("Latitude should be " + lat + " but was " + newPoint[0] + " and Longitude should be " +
				lon + " but was " + newPoint[1], (lat == newPoint[0]) && (lon == newPoint[1]));
	}

	@Test
	public void testGetMapcode()
	{
		final String mapcode = gpsLocation.getMapcode();
		assertTrue("Mapcode should be 'JHSBH.FWKR' but was '" + mapcode + "'", mapcode.contains("JHSBH.FWKR"));
	}

	@Test
	public void testSetMapcode_ValidValues_SetCorrect()
	{
		final String mapcode = "KJ3J5.W78B";
		final double lat = 8.62449;
		final double lon = 7.235007;

		gpsLocation.setMapcode(mapcode);
		final double newLat = gpsLocation.getLatitude();
		final double newLon = gpsLocation.getLongitude();

		assertTrue("Latitude should be " + lat + " but was " + newLat + " and Longitude should be " +
				lon + " but was " + newLon, (lat == newLat) && (lon == newLon));
	}

	@Test
	public void testAsString_ValuesFromConstructor_CorrectValues()
	{
		final String locationAsString = gpsLocation.asString();
		assertTrue("Location as string should be '" + lat + " " + lon + "' but was '" + locationAsString + "'",
				locationAsString.equals(lat + " " + lon));
	}
}