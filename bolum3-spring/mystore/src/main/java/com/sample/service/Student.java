package com.sample.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@RequestScope
@Scope("prototype")
public class Student {
	private String name="esma";
	public String getName() {
		return name;
	}

	public String setName(String name) {
		return this.name=name;
	}
}

