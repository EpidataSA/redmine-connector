= Redmine Connector Demo - Project Flows

== Introduction

This Redmine connector demo project consists of the five flows:

. getAvailableProjects - Provides an example on how to get all projects for the configured Redmine instance.
. projectDetail - Provides an example on how to get the detail of a specified project, this flow will return an object of the project especified by the project key of the configured Redmine instance.
. projectIssues - This flow example will return a collection of the issues of an existing project especified by the project key of the Redmine instance configured previously.
. projectMembers -  This flow example will return a collection of the members involved in existing project especified by the project key of the configured Redmine instance.
. createIssue -  This operation will create a new issue in a project especified by the project Key the Redmine instance configured previously. This method also will returns the new issue created. 


== How to run the Demo

=== Prerequisites

In order to build run this demo project you'll need;

. Anypoint Studio with Mule ESB 3.6.1 Runtime.
. Java Runtime Environment: 1.7.0_x
. Redmine Connector v1.0.0.
. A Redmine instance Credentials.
. A web browser.

== Test the flows


With Anypoint Studio up and running, open the Import wizard from the File menu. A pop-up wizard will offer you the chance to pick Anypoint Studio Project from External Location. On the next wizard window point Project Root to the location of the demo project and select the Server Runtime as Mule Server 3.6.1 EE. Once successfully imported the studio will automatically present the Mule Flows.

From the Package Explorer view, expand the demo project and open the mule-app.properties file. Fill in the credentials of your Redmine instance.

**Note: ** some operations are available depending on the redmine credentials configuration.

getAvailableProjects : Run the demo project and with in the browser hit - **http://localhost:8081/projects**, The result would be a list of all the projects of the redmine instance following the specified list in XML format.


projectDetail : Set the project key by clicking the redmine connector, you can see some projects keys by running the **getAvailableProjects** flow. Run the demo project and with in the browser hit - **http://localhost:8081/project-detail**, The result would be an object of the project especified by the project key of the configured Redmine instance following the specified object in XML format..

projectIssues : Set the project key by clicking the redmine connector, you can see some projects keys by running the **getAvailableProjects** flow. Run the demo project and with in the browser hit - **http://localhost:8081/project-issues**, the result would be a collection of the issues of an existing project especified by the project key of the Redmine instance configured previously following the specified list in XML format.

projectMembers - Set the project key by clicking the redmine connector, you can see some projects keys by running the **getAvailableProjects** flow. Run the demo project and with in the browser hit - **http://localhost:8081/project-members**, the result would be a collection of the members involved in existing project especified by the project key of the confiigured Redmine instance following the specified list in XML format.

createIssue -  To ejecute this flow, you need to configure the following parameters:

Field | Description
------------ | -------------
projectKey	|	Key for the project needed to set the new issue.
subject	|	Subject for the new issue to create.
description	|	(Optional). A description of the new issue.
priorityId	|	Id for set the priority for the new issue to create.
statusId	|	Id for the status for the new issue to create.
statusName	|	Name for the status for the new issue to create.
assigneeId	|	(Optional). Id for for the user needed to set the assignee.
categoryId	|	(Optional). Id for the category needed to set the issue category.
versionId	|	(Optional). Id for the version needed to set the version in the new issue.
parentId	|	(Optional). Id for the parent needed to set the parent in the new issue.
startDate	|	The Date for the start date of the new issue.
dueDate	|	The Date for the start date of the new issue, this date need must be set after the start date.
estimatedTime	|	(Optional). Estimated time of the new issue.
doneRatio	|	(Optional). The percent of the done ratio for the new issue.

 Run the demo project and with in the browser hit - **http://localhost:8081/create-issue**, the result would be a new issue in a project especified by the project Key the Redmine instance configured previously. This method also will returns the new issue created in XML format. 

== Summary

Congratulations! You have imported the Redmine Demo project and used the Redmine Connector to obtain project details for your redmine instance and also created a new issue in the especified project. 