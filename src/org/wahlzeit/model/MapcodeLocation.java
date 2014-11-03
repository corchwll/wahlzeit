package org.wahlzeit.model;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

/**
 * Created by fertigt on 03/11/14.
 */
public class MapcodeLocation extends AbstractLocation
{
	private String mapcode;

	public MapcodeLocation()
	{
		mapcode = "";
	}

	public MapcodeLocation(String mapcode)
	{
		this.mapcode = mapcode;
	}

	@Override
	public double[] getPoint()
	{
		Point p;
		double[] result = new double[2];

		try
		{
			p = MapcodeCodec.decode(mapcode);
			result = new double[]{p.getLonDeg(), p.getLatDeg()};
		} catch(UnknownMapcodeException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getMapcode()
	{
		return mapcode;
	}

	@Override
	public void setMapcode(String mapcode)
	{
		this.mapcode = mapcode;
	}

	@Override
	public String asString()
	{
		return mapcode;
	}

	@Override
	protected void doSetPoint(double[] point)
	{
		Mapcode mapcode = MapcodeCodec.encodeToInternational(point[0], point[1]);
		this.mapcode = mapcode.toString();
	}
}
