package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 18/11/14.
 *
 * @invariant solidSurface should only be true with liquid water
 */
public class WaterdropTechnique
{
	private boolean solidSurface;
	private Liquid liquid;
	private boolean smoke;
	private boolean soapFilm;

	/**
	 * @methodtype constructor
	 */
	public WaterdropTechnique()
	{}

	/**
	 *
	 * @pre solidSurface should only be true with liquid water
	 * @post no null or wrong values will be set
	 * @methodtype constructor
	 */
	public WaterdropTechnique(boolean solidSurface, Liquid liquid, boolean smoke, boolean soapFilm)
	{
		setSolidSurface(solidSurface);
		setLiquid(liquid);
		setSmoke(smoke);
		setSoapFilm(soapFilm);

		assert(this.liquid != null);
	}

	public boolean isSolidSurface()
	{
		return solidSurface;
	}

	/**
	 *
	 * @pre solidSurface should only be true with liquid water or liquid hasn't been specified yet
	 * @post no null value will be set
	 */
	public void setSolidSurface(boolean solidSurface)
	{
		assert(solidSurface && liquid.equals(Liquid.water) || solidSurface && (liquid == null) || !solidSurface);
		this.solidSurface = solidSurface;
		assert(solidSurface == this.solidSurface);
	}

	public Liquid getLiquid()
	{
		return liquid;
	}

	/**
	 *
	 * @pre if solidSurface is true, only water should be set as liquid
	 * @post correct value will be set
	 */
	public void setLiquid(Liquid liquid)
	{
		assert(solidSurface && liquid.equals(Liquid.water) || !solidSurface);
		this.liquid = liquid;
		assert this.liquid.equals(liquid);
	}

	public boolean isSmoke()
	{
		return smoke;
	}

	/**
	 *
	 * @methodtype set
	 */
	public void setSmoke(boolean smoke)
	{
		this.smoke = smoke;
	}

	/**
	 *
	 *
	 */
	public boolean isSoapFilm()
	{
		return soapFilm;
	}

	/**
	 *
	 * @methodtype set
	 */
	public void setSoapFilm(boolean soapFilm)
	{
		this.soapFilm = soapFilm;
	}
}
