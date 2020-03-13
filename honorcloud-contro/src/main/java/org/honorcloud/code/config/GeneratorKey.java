package org.honorcloud.code.config;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class GeneratorKey implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		return Arrays.toString(params);
	}

}
