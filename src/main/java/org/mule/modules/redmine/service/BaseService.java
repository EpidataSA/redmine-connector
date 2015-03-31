package org.mule.modules.redmine.service;

public interface BaseService {

	void buildNewManager(String apiAccessKey);

	void changeUser(String login, String password);
}
