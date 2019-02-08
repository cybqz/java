package com.cyb.blog.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cyb.blog.service.EmoticonServices;

@Service(value="emoticonServices")
public class EmoticonServicesImpl implements EmoticonServices {

	public List<Map<String, String[]>> getEmoticonList(String basePath) {
		List<Map<String, String[]>> list = new ArrayList<Map<String,String[]>>();
		String relativePath = "biaoqing/";
		File file = new File(basePath + relativePath);
		File[] listFile = file.listFiles();
		for(File f : listFile) {
			Map<String, String[]> map = new HashMap<String, String[]>();
			String name = f.getName();
			String[] strs = f.list();
			int length = strs.length;
			String[] bqList = new String[strs.length];
			for(int i = 0; i < length; i++) {
				bqList[i] = relativePath + name + "/" + strs[i];
			}
			map.put(name, bqList);
			list.add(map);
		}
		return list;
	}
}
