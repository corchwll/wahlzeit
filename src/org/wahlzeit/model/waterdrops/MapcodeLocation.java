package org.wahlzeit.model.waterdrops;

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

	/**
	 *
	 * @methodtype constructor
	 */
	public MapcodeLocation()
	{
		mapcode = "";
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public MapcodeLocation(String mapcode)
	{
		this.mapcode = mapcode;
	}

	/**
	 * @collaboration serializer, Photo
	 * @methodtype get method
	 */
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

	/**
	 * @collaboration serializer, Photo
	 * @methodtype get method
	 */
	@Override
	public String getMapcode()
	{
		return mapcode;
	}

	/**
	 * @collaboration creation, UploadPhotoHandler
	 * @methodtype set method
	 */
	@Override
	public void setMapcode(String mapcode)
	{
		this.mapcode = mapcode;
	}

	/**
	 * @collaboration creation, UploadPhotoHandler
	 * @methodtype set method
	 */
	@Override
	protected void doSetPoint(double[] point)
	{
		Mapcode mapcode = MapcodeCodec.encodeToInternational(point[0], point[1]);
		this.mapcode = mapcode.toString();
	}

	/**
	 * @collaboration location, Photo
	 * @methodtype conversion method
	 */
	@Override
	public String asString()
	{
		return mapcode;
	}
}
