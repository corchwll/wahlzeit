package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 03/11/14.
 */
public abstract class AbstractLocation implements Location
{
	public abstract double[] getPoint();
	public abstract String getMapcode();
	public abstract void setMapcode(String mapcode);
	public abstract String asString();

	protected abstract void doSetPoint(double[] point);

	public double getLatitude()
	{
		double[] point = getPoint();
		return point[0];
	}

	public double getLongitude()
	{
		double[] point = getPoint();
		return point[1];
	}

	public void setPoint(double[] point)
	{
		doSetPoint(point);
	}

	public void setPoint(double x, double y)
	{
		doSetPoint(new double[]{x, y});
	}
}
