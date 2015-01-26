package org.waterdropzeit.model.location;

import org.junit.Before;
import org.junit.Test;
import org.waterdropzeit.model.location.GPSLocation;
import org.waterdropzeit.model.location.Location;
import org.waterdropzeit.model.location.MapcodeLocation;

import static org.junit.Assert.assertTrue;

public abstract class AbstractLocationTests
{
	protected double lat = 4.5;
	protected double lon = 3.4;
	protected Location gpsLocation;
	protected double mapLat = 11.425797;
	protected double mapLon = 9.622416;
	protected String mapcode = "KJGTM.84VT";
	protected Location mapcodeLocation;

	@Before
	public void setUp()
	{
		gpsLocation = new GPSLocation(lat, lon);
		mapcodeLocation = new MapcodeLocation(mapcode);
	}

	@Test
	public void testGetLatitude_ValuesFromConstructor_CorrectValue()
	{
		double latitude = gpsLocation.getLatitude();
		assertTrue("Latitude should be " + lat + " but was " + latitude, latitude == lat);
	}

	@Test
	public void testGetLongitude_ValuesFromConstructor_CorrectValue()
	{
		double longitude = gpsLocation.getLongitude();
		assertTrue("Longitude should be " + lon + " but was " + longitude, longitude == lon);
	}

	@Test
	public void testSetPoint_ArrayAsArgument_CorrectValues()
	{
		final double lat = 7.093;
		final double lon = 8.242;
		double[] point = new double[]{lat, lon};

		gpsLocation.setPoint(point);

		final double newLat = gpsLocation.getLatitude();
		final double newLon = gpsLocation.getLongitude();

		assertTrue("Latitude should be " + lat + " but was " + newLat + " and Longitude should be " +
				lon + " but was " + newLon, (lat == newLat) && (lon == newLon));
	}

	@Test
	public void testSetPoint_TwoDoublesAsArgument_CorrectValues()
	{
		final double lat = 7.093;
		final double lon = 8.242;

		gpsLocation.setPoint(lat, lon);

		final double newLat = gpsLocation.getLatitude();
		final double newLon = gpsLocation.getLongitude();

		assertTrue("Latitude should be " + lat + " but was " + newLat + " and Longitude should be " +
				lon + " but was " + newLon, (lat == newLat) && (lon == newLon));
	}
}