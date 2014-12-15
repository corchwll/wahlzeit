package org.wahlzeit.model.waterdrops;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by fertigt on 02/12/14.
 */
public class WaterdropManagerTests
{
	private final String techniqueAsString = WaterdropTechniqueEnum.WATER_SOLID_SMOKE_SOAPFILM.name();
	private final String formAsString = WaterdropFormEnum.DOUBLE_HIGH_FONTAIN.name();
	private final String influenceAsString = Influence.blow.name();

	@Test
	public void testCreateWaterdrop_CorrectParameters_CorrectWaterdrop()
	{
		Waterdrop waterdrop = WaterdropManager.getInstance()
											  .createWaterdrop(techniqueAsString, formAsString, influenceAsString);

		WaterdropTechniqueEnum techniqueEnum = waterdrop.getTechnique();
		WaterdropFormEnum formEnum = waterdrop.getForm();
		Influence influence = waterdrop.getInfluence();

		assertTrue("Technique of waterdrop must not be null and was " + techniqueEnum + "; Form of waterdrop must not" +
				" be null and was " + formEnum + "; influence must not be null and was " + influence,
				techniqueEnum.equals(WaterdropTechniqueEnum.valueOf(techniqueAsString)) &&
						formEnum.equals(WaterdropFormEnum.valueOf(formAsString)) &&
						influence.equals(Influence.valueOf(influenceAsString)));
	}

	@Test
	public void testSaveWaterdrop_WaterdropNotNullAndOpenRSet_correctValuesSet()
	{
		Waterdrop waterdrop = WaterdropManager.getInstance()
											  .createWaterdrop(techniqueAsString, formAsString, influenceAsString);

		Map<String,String> rsetValues = new HashMap<>();
		rsetValues.put(WaterdropPhoto.TECHNIQUE, techniqueAsString);
		rsetValues.put(WaterdropPhoto.FORM, formAsString);
		rsetValues.put(WaterdropPhoto.INFLUENCE, influenceAsString);

		boolean exceptionThrown = false;
		TestResultSet rset = null;
		try
		{
			rset = new TestResultSet();
			WaterdropManager.getInstance()
							.saveWaterdrop(rset, waterdrop);
		} catch(Exception e)
		{
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown == false && rsetValues.equals(rset.rsetValues));
	}
}