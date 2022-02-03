package com.apistudent.alex.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	
private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	
	public static String createJson(Object obj) throws JsonProcessingException {
		LOGGER.error("INICIO createJson");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(obj);
    }
	
	public static Object parseJsonToObject(final String json, final Class<?> returnType) {
		ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.USE_ANNOTATIONS, true);
		
		try {
			return objectMapper.readValue(json, returnType);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
