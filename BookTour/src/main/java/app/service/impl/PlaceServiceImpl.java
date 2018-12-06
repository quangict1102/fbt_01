package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartFile;

import app.bean.PlaceInfo;
import app.helper.PlaceConvertHelper;
import app.helper.UpLoadFileHelper;
import app.model.Place;
import app.model.Placeimage;
import app.service.PlaceService;

public class PlaceServiceImpl extends BaseServiceImpl implements PlaceService {
	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;

	@Override
	public List<PlaceInfo> getAllPlace() {
		try {
			return PlaceConvertHelper.convertPlaceToPlaceInfo(getPlaceDAO().getAllPlace());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<PlaceInfo> getAllPlaceByIdCity(int id) {
		try {
			return PlaceConvertHelper.convertPlaceToPlaceInfo(getPlaceDAO().getAllPlaceByIdCity(id));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Place findById(Serializable key) {
		return getPlaceDAO().findById(key);
	}

	@Override
	public Place saveOrUpdate(Place entity) {
		try {
			if (entity.getId() == null) {
				return getPlaceDAO().saveOrUpdate(entity);
			}
			getPlaceDAO().findByIdLock(entity.getId());
			return getPlaceDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean delete(Place entity) {
		try {
			getPlaceDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deletePlace(Integer id) {
		try {
			Place place = getPlaceDAO().findByIdLock(id);
			if (place == null) {
				return false;
			}
			return delete(place);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Place saveOrUpdate(Place entity, MultipartFile[] files) {
		try {
			if (entity.getId() == null) {
				List<Placeimage> listPlaceImage = new ArrayList<>();
				files[files.length - 1] = null;
				for (MultipartFile uploadedFile : files) {
					if (uploadedFile != null) {
						Placeimage placeimage = new Placeimage();
						placeimage.setUrlImage(UpLoadFileHelper.upFile(uploadedFile,
								messageSource.getMessage("cloud.cloud_name", null, LocaleContextHolder.getLocale()),
								messageSource.getMessage("cloud.api_key", null, LocaleContextHolder.getLocale()),
								messageSource.getMessage("cloud.api_secret", null, LocaleContextHolder.getLocale())));
						listPlaceImage.add(placeimage);
					}

				}
				getPlaceDAO().saveOrUpdate(entity);
				Place place = getPlaceDAO().findPlaceLast();
				for (Placeimage placeimage : listPlaceImage) {
					placeimage.setPlace(place);
					getPlaceimageDAO().saveOrUpdate(placeimage);

				}
			}
			getPlaceDAO().findByIdLock(entity.getId());
			return getPlaceDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		}
	}

}
