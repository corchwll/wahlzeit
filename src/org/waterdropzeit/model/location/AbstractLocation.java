package org.waterdropzeit.model.location;

/**
 * Created by fertigt on 03/11/14.
 */
public abstract class AbstractLocation implements Location
{
	public abstract double[] getPoint();
	public abstract String getMapcode();
	public abstract void setMapcode(String mapcode);
	public abstract String asString();

	/**
	 *
	 * @methodtype set method
	 */
	protected abstract void doSetPoint(double[] point);

	/**
	 *
	 * @methodtype get method
	 */
	public double getLatitude()
	{
		double[] point = getPoint();
		return point[0];
	}

	/**
	 *
	 * @methodtype get method
	 */
	public double getLongitude()
	{
		double[] point = getPoint();
		return point[1];
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setPoint(double[] point)
	{
		doSetPoint(point);
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setPoint(double x, double y)
	{
		doSetPoint(new double[]{x, y});
	}
}
