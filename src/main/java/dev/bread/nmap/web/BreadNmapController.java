package dev.bread.nmap.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.bread.nmap.service.BreadNmapService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BreadNmapController {
	
	@Resource(name="breadNmapService")
	private BreadNmapService breadNmapService;

	@RequestMapping(value="/bread/main", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView breadNmapView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		log.info("this controller is breadNmapView Controller!!!");
		List<Map<String, Object>> breadStore = breadNmapService.selectBreadStore();
		
//		List<JSONObject> jsonList = new ArrayList<JSONObject>();
//		if(breadStore != null && breadStore.size() > 0) {
//			for(Map<String, Object> breadStoreInfo : breadStore) {
//				JSONObject jsonObject = new JSONObject(breadStoreInfo);
//				jsonList.add(jsonObject);
//			}
//		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = "";
		try {
			if(breadStore != null && breadStore.size() > 0) {
				jsonStr = mapper.writeValueAsString(breadStore);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		mv.addObject("breadStore", jsonStr);
		mv.setViewName("bread/main");
		return mv;
	}
}
