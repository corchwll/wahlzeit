package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 24/11/14.
 */
public enum WaterdropFormEnum
{
	DOUBLE_HIGH_FONTAIN(true, false, true, false, true),
	DOUBLE_HIGH(true, false, true, false, false),
	DOUBLE_FONTAIN(true, false, false, false, true),
	DOUBLE(true, false, false, false, false),
	BUBBLE_FONTAIN(false, true, false, false, true),
	BUBBLE(false, true, false, false, false),
	HIGH_FONTAIN(false, false, true, false, true),
	HIGH(false, false, true, false, false),
	CROWN(false, false, false, true, false),
	FONTAIN(false, false, false, false, true),
	NONE(false, false, false, false, false);

	private boolean doublePillar;
	private boolean bubble;
	private boolean highPillar;
	private boolean crown;
	private boolean fontain;

	WaterdropFormEnum(boolean doublePillar, boolean bubble, boolean highPillar, boolean crown, boolean fontain)
	{
		this.doublePillar = doublePillar;
		this.bubble = bubble;
		this.highPillar = highPillar;
		this.crown = crown;
		this.fontain = fontain;
	}

	public boolean isDoublePillar()
	{
		return doublePillar;
	}

	public boolean isBubble()
	{
		return bubble;
	}

	public boolean isHighPillar()
	{
		return highPillar;
	}

	public boolean isCrown()
	{
		return crown;
	}

	public boolean isFontain()
	{
		return fontain;
	}

	public String asString()
	{
		String form = "";
		if(isDoublePillar())
			form += "Double Pillar;";
		if(isBubble())
			form += "Bubble;";
		if(isHighPillar())
			form += "High Pillar;";
		if(isCrown())
			form += "Crown;";
		if(isFontain())
			form += "Fontain;";

		return form;
	}
}
