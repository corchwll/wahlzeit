package org.waterdropzeit.handlers;

import org.wahlzeit.handlers.PartUtil;
import org.wahlzeit.handlers.UploadPhotoFormHandler;
import org.wahlzeit.model.*;
import org.wahlzeit.services.SysConfig;
import org.wahlzeit.services.SysLog;
import org.wahlzeit.utils.StringUtil;
import org.waterdropzeit.model.*;
import org.waterdropzeit.model.location.GPSLocation;
import org.waterdropzeit.model.location.Location;

import java.io.File;
import java.util.Map;

/**
 * Created by fertigt on 06/12/14.
 */
public class UploadWaterdropPhotoFormHandler extends UploadPhotoFormHandler
{
	/**
	 * @methodtype command method
	 */
	@Override
	protected String doHandlePost(UserSession us, Map args)
	{
		String tags = us.getAndSaveAsString(args, Photo.TAGS);

		double lat;
		double lon;

		try
		{
			lat = Double.parseDouble(us.getAndSaveAsString(args, Photo.LAT));
			lon = Double.parseDouble(us.getAndSaveAsString(args, Photo.LON));
		} catch(Exception e)
		{
			lat = 0.0;
			lon = 0.0;
		}

		String mapcode = us.getAndSaveAsString(args, Photo.MAPCODE);
		Location location;
		location = new GPSLocation(lat, lon);

		if(lat == 0.0 && lon == 0.0 && mapcode != "")
		{
			location.setMapcode(mapcode);
		}

		if (!StringUtil.isLegalTagsString(tags)) {
			us.setMessage(us.cfg().getInputIsInvalid());
			return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
		}

		try {
			PhotoManager pm = PhotoManager.getInstance();
			String sourceFileName = us.getAsString(args, "fileName");
			File file = new File(sourceFileName);
			Photo photo = pm.createPhoto(file);

			String targetFileName = SysConfig.getBackupDir().asString() + photo.getId().asString();
			createBackup(sourceFileName, targetFileName);

			User user = (User) us.getClient();
			user.addPhoto(photo);

			photo.setTags(new Tags(tags));
			photo.setLocation(location);

			doHandleWaterdropPhoto(photo, us, args);
			pm.savePhoto(photo);

			StringBuffer sb = UserLog.createActionEntry("UploadPhoto");
			UserLog.addCreatedObject(sb, "Photo", photo.getId().asString());
			UserLog.log(sb);

			us.setTwoLineMessage(us.cfg().getPhotoUploadSucceeded(), us.cfg().getKeepGoing());
		} catch (Exception ex) {
			SysLog.logThrowable(ex);
			us.setMessage(us.cfg().getPhotoUploadFailed());
		}

		return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
	}

	/**
	 * @methodtype command method
	 */
	private void doHandleWaterdropPhoto(Photo photo, UserSession us, Map args)
	{
		String typeName = us.getAndSaveAsString(args, WaterdropType.NAME);
		double size = Double.parseDouble(us.getAndSaveAsString(args, WaterdropType.SIZE));
		String tool = us.getAndSaveAsString(args, WaterdropType.TOOL);

		WaterdropPhoto wdPhoto = (WaterdropPhoto)photo;

		String technique = us.getAndSaveAsString(args, WaterdropPhoto.TECHNIQUE);
		String form = us.getAndSaveAsString(args, WaterdropPhoto.FORM);
		String influence = us.getAndSaveAsString(args, WaterdropPhoto.INFLUENCE);

		wdPhoto.setWaterdrop(WaterdropManager.getInstance().createWaterdrop(technique, form, influence, typeName,
				size, tool));
	}
}
