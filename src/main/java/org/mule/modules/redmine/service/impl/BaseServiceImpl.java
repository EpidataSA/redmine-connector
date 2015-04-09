/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.redmine.service.impl;

import org.mule.modules.redmine.service.BaseService;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;

public class BaseServiceImpl implements BaseService {

	protected RedmineManager manager;
	private String uri;

	public BaseServiceImpl(String uri, String apiAccessKey) {
		this.uri = uri;
		this.manager = RedmineManagerFactory.createWithApiKey(this.uri, apiAccessKey);
	}
	
	@Override
	public void buildNewManager(String apiAccessKey) {
		this.manager.shutdown();
		this.manager = RedmineManagerFactory.createWithApiKey(this.uri, apiAccessKey);
	}

	@Override
	public void changeUser(String username, String password) {
		this.manager.shutdown();
		this.manager = RedmineManagerFactory.createWithUserAuth(this.uri, username, password);
	}
}
