package org.wahlzeit.model;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

/**
 * Created by fertigt on 03/11/14.
 */
public class GPSLocation extends AbstractLocation
{
	private double[] point;

	public GPSLocation()
	{
		point = new double[]{0.0, 0.0};
	}

	public GPSLocation(double[] point)
	{
		this.point = point;
	}

	public GPSLocation(double latitude, double longitude)
	{
		point = new double[]{latitude, longitude};
	}

	@Override
	public double[] getPoint()
	{
		return point;
	}

	@Override
	public String getMapcode()
	{
		Mapcode mapcode = MapcodeCodec.encodeToInternational(point[0], point[1]);
		return mapcode.toString();
	}

	@Override
	public void setMapcode(String mapcode)
	{
		Point p;
		try
		{
			p = MapcodeCodec.decode(mapcode);
			point = new double[]{p.getLatDeg(), p.getLonDeg()};
		} catch(UnknownMapcodeException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void doSetPoint(double[] point)
	{
		this.point = point;
	}

	@Override
	public String asString()
	{
		return point[0] + " " + point[1];
	}
}
