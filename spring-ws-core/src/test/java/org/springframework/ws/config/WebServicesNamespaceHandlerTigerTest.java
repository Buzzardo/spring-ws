/*
 * Copyright 2005-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.config;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.server.endpoint.adapter.GenericMarshallingMethodEndpointAdapter;
import org.springframework.ws.server.endpoint.adapter.XPathParamAnnotationMethodEndpointAdapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WebServicesNamespaceHandlerTigerTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext =
				new ClassPathXmlApplicationContext("webServicesNamespaceHandlerTest-tiger.xml", getClass());
	}

	@Test
	public void testMarshallingEndpoints() throws Exception {
		Map<String, GenericMarshallingMethodEndpointAdapter> result =
				applicationContext.getBeansOfType(GenericMarshallingMethodEndpointAdapter.class);
		Assert.assertFalse("no MarshallingMethodEndpointAdapter found", result.isEmpty());
	}

	@Test
	public void testXpathEndpoints() throws Exception {
		Map<String, XPathParamAnnotationMethodEndpointAdapter> result =
				applicationContext.getBeansOfType(XPathParamAnnotationMethodEndpointAdapter.class);
		Assert.assertFalse("no XPathParamAnnotationMethodEndpointAdapter found", result.isEmpty());
	}
}