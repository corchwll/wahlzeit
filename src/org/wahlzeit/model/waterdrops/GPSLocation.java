package org.wahlzeit.model.waterdrops;

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

	/**
	 *
	 * @methodtype constructor
	 */
	public GPSLocation()
	{
		point = new double[]{0.0, 0.0};
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public GPSLocation(double[] point)
	{
		this.point = point;
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public GPSLocation(double latitude, double longitude)
	{
		point = new double[]{latitude, longitude};
	}

	/**
	 *
	 * @methodtype get method
	 */
	@Override
	public double[] getPoint()
	{
		return point;
	}

	/**
	 *
	 * @methodtype get method
	 */
	@Override
	public String getMapcode()
	{
		Mapcode mapcode = MapcodeCodec.encodeToInternational(point[0], point[1]);
		return mapcode.toString();
	}

	/**
	 *
	 * @methodtype set method
	 */
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

	/**
	 *
	 * @methodtype set method
	 */
	@Override
	protected void doSetPoint(double[] point)
	{
		this.point = point;
	}

	/**
	 *
	 * @methodtype conversion method
	 */
	@Override
	public String asString()
	{
		return point[0] + " " + point[1];
	}
}
