package dev.bread.nmap.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.bread.nmap.mapper.BreadNmapMapper;
import dev.bread.nmap.service.BreadNmapService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("breadNmapService")
public class BreadNmapServiceImpl implements BreadNmapService {
	
	@Resource(name="breadNmapMapper")
	private BreadNmapMapper breadNmapMapper;
	
	
	public List<Map<String, Object>> selectBreadStore(){
		log.info("breadNmapService !!!");
		return breadNmapMapper.selectBreadStore();
	}

}
