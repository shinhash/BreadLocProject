package dev.bread.nmap.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadNmapMapper {
	List<Map<String, Object>> selectBreadStore();
}
