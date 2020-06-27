package com.study.error;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ResolveResultErrors {

	public static List<String> resolveBindingResultErrors(BindingResult bindingResult) {

		return bindingResult.getFieldErrors().stream().map(e -> e.getField() + ":" + e.getDefaultMessage())
				.collect(Collectors.toList());

	}
}
