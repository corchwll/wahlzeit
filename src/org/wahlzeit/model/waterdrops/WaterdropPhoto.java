package org.wahlzeit.model.waterdrops;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 18/11/14.
 */
public class WaterdropPhoto extends Photo
{
	public static final String TECHNIQUE = "technique";
	public static final String SOLID_SURFACE = "solid_surface";
	public static final String LIQUID = "liquid";
	public static final String SMOKE = "smoke";
	public static final String SOAP_FILM = "soap_film";

	public static final String FORM = "form";
	public static final String DOUBLE_PILLAR = "double_pillar";
	public static final String BUBBLE = "bubble";
	public static final String HIGH_PILLAR = "high_pillar";
	public static final String CROWN = "crown";
	public static final String FONTAIN = "fontain";

	public static final String INFLUENCE = "influence";

	protected WaterdropTechnique technique = new WaterdropTechnique();
	protected WaterdropForm form = new WaterdropForm();
	protected Influence influence = Influence.none;

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto() {
		super();
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto(PhotoId myId) {
		super(myId);
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto(ResultSet rset) throws SQLException
	{
		super(rset);
	}

	/**
	 *
	 * @methodtype initialization method
	 */
	@Override
	public void readFrom(ResultSet rset) throws SQLException
	{
		super.readFrom(rset);

		boolean solidSurface = rset.getBoolean(SOLID_SURFACE);
		Liquid liquid = Liquid.valueOf(rset.getString(LIQUID));
		boolean smoke = rset.getBoolean(SMOKE);
		boolean soapFilm = rset.getBoolean(SOAP_FILM);
		this.technique = new WaterdropTechnique(solidSurface, liquid, smoke, soapFilm);

		boolean doublePillar = rset.getBoolean(DOUBLE_PILLAR);
		boolean bubble = rset.getBoolean(BUBBLE);
		boolean highPillar = rset.getBoolean(HIGH_PILLAR);
		boolean crown = rset.getBoolean(CROWN);
		boolean fontain = rset.getBoolean(FONTAIN);
		this.form = new WaterdropForm(doublePillar, bubble, highPillar, crown, fontain);

		this.influence = Influence.valueOf(rset.getString(INFLUENCE));
	}

	/**
	 *
	 * @methodtype command method
	 */
	@Override
	public void writeOn(ResultSet rset) throws SQLException
	{
		super.writeOn(rset);

		rset.updateBoolean(SOLID_SURFACE, technique.isSolidSurface());
		rset.updateString(LIQUID, technique.getLiquid()
										   .name());
		rset.updateBoolean(SMOKE, technique.isSmoke());
		rset.updateBoolean(SOAP_FILM, technique.isSoapFilm());

		rset.updateBoolean(DOUBLE_PILLAR, form.isDoublePillar());
		rset.updateBoolean(BUBBLE, form.isBubble());
		rset.updateBoolean(HIGH_PILLAR, form.isHighPillar());
		rset.updateBoolean(CROWN, form.isCrown());
		rset.updateBoolean(FONTAIN, form.isFontain());

		rset.updateString(INFLUENCE, influence.name());
	}

	/**
	 *
	 * @methodtype get method
	 */
	public WaterdropTechnique getTechnique()
	{
		return technique;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setTechnique(WaterdropTechnique technique)
	{
		this.technique = technique;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public WaterdropForm getForm()
	{
		return form;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setForm(WaterdropForm form)
	{
		this.form = form;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public Influence getInfluence()
	{
		return influence;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setInfluence(Influence influence)
	{
		this.influence = influence;
	}
}
