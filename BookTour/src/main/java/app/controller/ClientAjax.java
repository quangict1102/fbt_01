package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.bean.PlaceInfo;
import app.service.PlaceService;

@Controller
@RequestMapping(value = "/clientAjax")
public class ClientAjax {

	@Autowired
	PlaceService placeService;

	@GetMapping(path = "getAllPlaceByCity", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<PlaceInfo> getAllPlaceByCity(@RequestParam int id) {
		List<PlaceInfo> arr = new ArrayList<>();
		arr = placeService.getAllPlaceByIdCity(id);
		return arr;
	}
}
