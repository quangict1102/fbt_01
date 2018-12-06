package app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import app.bean.PlaceInfo;
import app.model.Place;

public interface PlaceService extends BaseService<Integer,Place>{
	List<PlaceInfo> getAllPlace();

	List<PlaceInfo> getAllPlaceByIdCity(int id);
	
	boolean deletePlace(Integer id);

	Place saveOrUpdate(Place entity,MultipartFile[] files);
}
