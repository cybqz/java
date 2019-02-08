package com.cyb.blog.service;

import java.util.List;
import java.util.Map;

public interface EmoticonServices {

	public List<Map<String,String[]>> getEmoticonList(String basePath);
}
