package org.wahlzeit.model;

/**
 * Created by fertigt on 03/11/14.
 */
public interface Location
{
	double getLatitude();
	double getLongitude();
	double[] getPoint();
	String getMapcode();
	void setMapcode(String mapcode);
	void setPoint(double[] point);
	void setPoint(double x, double y);

	String asString();
}
