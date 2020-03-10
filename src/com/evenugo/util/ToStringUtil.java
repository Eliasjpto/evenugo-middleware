package com.evenugo.util;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

	public class ToStringUtil {
		
		public static String toString(Object o) {
			return ToStringBuilder.reflectionToString(o);
		}
	}

