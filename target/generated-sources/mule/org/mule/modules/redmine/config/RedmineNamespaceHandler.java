
package org.mule.modules.redmine.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/redmine</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-31T07:38:35-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RedmineNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(RedmineNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [redmine] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [redmine] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config-type", new RedmineConnectorConnectionManagementStrategyConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config-type", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-issues", new GetProjectIssuesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-issues", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-detail", new GetProjectDetailDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-detail", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-available-projects", new GetAvailableProjectsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-available-projects", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-members", new GetProjectMembersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-members", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-users", new GetUsersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-users", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-user-detail", new GetUserDetailDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-user-detail", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-roles", new GetRolesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-roles", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-role-detail", new GetRoleDetailDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-role-detail", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-groups", new GetGroupsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-groups", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-group-detail", new GetGroupDetailDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-group-detail", "@Processor", ex);
        }
    }

}
