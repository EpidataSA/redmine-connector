
### Redmine Anypoint™ Connector
 
The Anypoint™ Connector for Redmine allows Mule applications to retrieve and manipulate data from a Redmine project using a common integration interface known as web services.

### Supported Mule runtime versions

3.6 or higher

### Redmine API supported versions

2.6.0 or higher

### Installation 

For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio.

For released connectors you can download them from the update site in Studio. Open MuleStudio, go to Help → Install New Software and select MuleStudio Cloud Connectors Update Site where you’ll find all avaliable connectors.

### Usage

For information about usage our documentation below.


[Purpose](#purpose)  

[Prerequisites](#prerequisites)  

[Step 1: Install Redmine Connector](#step-1-install-redmine-connector)    

[Step 2: Create Demo project](#step-2-create-demo-project)   

[Step 3: Add Global Elements](#step-3-add-global-elements)  

[Step 4: Create a New Flow](#step-4-create-a-new-flow)   

[Step 4.1: Get available properties flow](#step-4-1-get-available-properties-flow)   

[Step 4.2: Get group detail flow](#step-4-2-get-group-detail-flow)   

[Step 4.3: Get groups flow](#step-4-3-get-groups-flow)   

[Step 4.4: Get project detail flow](#step-4-4-get-project-detail-flow)   

[Step 4.5: Get project issues flow](#step-4-5-get-project-issues-flow)   

[Step 4.6: Get project members flow](#step-4-6-get-project-members-flow)   

[Step 4.7: Get role detail flow](#step-4-7-get-role-detail-flow)   

[Step 4.8: Get roles flow](#step-4-8-get-roles-flow)   

[Step 4.9: Get user detail flow](#step-4-9-get-user-detail-flow)   

[Step 4.10: Get users flow](#step-4-10-get-users-flow)   

[Step 4.11: Create Issue flow](#step-4-11-get-users-flow)   

[Step 5: Add an Object to XML transformer](#step-5-add-an-object-to-xml-transformer)    

[Step 6: Run Demo project](#step-6-run-demo-project)      

[Other Resources](#other-resources)    

### Purpose



This document provides detailed instructions on how to install Redmine connector and demonstrates how to build and run simple demo application that uses this connector.



### Prerequisites



In order to build and run this project you'll need:



* [Anypoint Studio](https://www.mulesoft.com/platform/mule-studio).

*  Java 7: Redmine connector does not work unless you are using Java 1.7.0_x as your JRE. 

* Web browser.

*  A project configuration in Redmine: Configuring the Redmine connector requires configuring a Project configured in Redmine, and provide the valid credentials to set the connection strategy of this connector: an URI and API access key. As optional parameters, you can set the username and the password to access the Redmine instance.



### Compatibility

Redmine connector is compatible with:


Application/Service | Versión
------------ | -------------
Redmine API | 2.6.0 or higher
Mule Runtime | 3.6 or higher
Java | 1.7.0_x


### Step 1: Install Redmine Connector


Because this is a connector in the beta version, you can download the source code cloning the source code from:  [GitHub Repository](https://github.com/EpidataSA/redmine-connector.git) and build it with Anypoint Connector DevKit to find it available on your local repository. Then you can add it to Anypoint Studio following the next steps:

* In **Anypoint Studio**, to import an existing connector project, click **File \> Import \> Anypoint Studio \> Anypoint Connector Project from External Location**, browse the path location where you have the root directory for the Redmine Connector and complete the wizard to locate and import the project.

* Click to accept terms and conditions of the product, then click **Finish**.

* Click **Restart Now** to complete the installation. After you install the connector and restart Studio, the Redmine connector is available in the palette in the Connectors category.


### Step 2: Create Demo project



*    Run Mule Studio and select **File \> New \> Mule Project** menu item.  

*    Type **Demo** as a project name, accept default values on this screen of project creation wizard and click **Finish**.


![Create Demo project](doc/images/Step3-1.png)


### Step 3: Add Global Elements   



*    Double click on **src/main/app/Demo.xml** to open it, select **Global Elements** tab in view.

 

Add two Global Elements.  



*    Click on **Create** button and add **HTTP Listener Configuration** to the configuration.   



![Add HTTP Listener](doc/images/Step3-2.png)



*    In HTTP Listener Configuration set a name for this HTTP Listener Configurator, set **localhost** on the **Host** field, and set in your **port** field the value **8081**. Finally accept the default values as you can see in the following image:



![Configure HTTP Listener](doc/images/Step3-3.png)



*       Similarly, add **Redmine: Configuration type strategy**.



![Add Redmine: Configuration type strategy](doc/images/Step3-4.png)



*       In the **general** tab, set the Redmine Configuration type strategy parameters according to your Redmine account configuration:



Field | Description
------------ | -------------
**Name:** | Enter a name you prefer.
**Username (Optional):** | Enter your Redmine username.
**Password (Optional):** | Enter your Redmine password.
**Uri:** | Enter the URL of your Redmine instance.
**Api Access Key:** | Enter the access key of your Redmine.instance.



*       Click on the **Test Connection** button to confirm that Mule can connect with the Redmine instance. If the connection is successful, click OK to save the configurations. If unsuccessful, revise or correct any incorrect parameters, then test again.



### Step 4. Create a new flow.



*       Add **HTTP Endpoint** to your flow by dragging it from the palette. 
This action drops an HTTP Listener in a new flow. You can change the name of this flow by right-clicking on flow's header and selecting **Rename** from context menu.  



![New Flow](doc/images/Step4-1.png)



*       Set the **HTTP Endpoint** connector configuration with the global property previously configured and write a path for the URL of this endpoint and accept the default values of the other settings: 

![HTTP Endpoint](doc/images/Step4-2.png)



*       Add **Redmine Connector** to the flow by dragging it from the palette. 

![Redmine Connector](doc/images/Step4-3.png)



*       Click it to show connector properties and select **Redmine_Configuration_type_strategy** in **Connector Configuration** drop-down.

![Redmine Connector Configuration](doc/images/Step4-4.png)



*       We need to select an operation for this connector, we start showing you an example of each operation of this connector using the configuration defined before.

### Step 4.1. Get available properties flow.




*       Select **Get Available Projects** in the **Operation** configuration. This operation will get a collection of all the project of the Redmine instance configured previously.

![Get Available Projects](doc/images/Step4-1-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */projects* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.2: Get group detail flow.



*       Select **Get Group Detail** in the **Operation** configuration. This operation will return an object of the group especified by the group Id of the Redmine instance configured previously. Note that you must set a group Id to get the group detail and this must correspond to an existing group Id in the instance, else the request send and error message notifing that the source was not found.

![Get Group Detail](doc/images/Step4-2-1.png)


*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */group-detail* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.3: Get groups flow.



*       Select **Get Groups** in the **Operation** configuration. This operation will get a collection of all the groups of the Redmine instance configured previously.



![Get Groups](doc/images/Step4-3-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */groups* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.4: Get project detail flow.




*       Select **Get Project Detail** in the **Operation** configuration. This operation will return an object of the project especified by the project key of the Redmine instance configured previously. Note that you must set a project key to get the project detail and this must correspond to an existing project key in the instance, else the request send and error message notifing that the source was not found.



![Get Project Detail](doc/images/Step4-4-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */project-detail* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.5: Get project issues flow.



*       Select **Get Project Issues** in the **Operation** configuration. This operation will return a collection of the issues of an existing project especified by the project key of the Redmine instance configured previously. Note that you must set a project key to get the project detail and this must correspond to an existing project key in the instance, else the request send and error message notifing that the source was not found.



![Get Project Issues](doc/images/Step4-5-1.png)


*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */project-issues* as your path configuration.


*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.


### Step 4.6: Get project members flow.



*       Select **Get Project Members** in the **Operation** configuration. This operation will return a collection of the members involved in existing project especified by the project key of the Redmine instance configured previously. Note that you must set a project key to get the project detail and this must correspond to an existing project key in the instance, else the request send and error message notifing that the source was not found.



![Get Project Members](doc/images/Step4-6-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */project-members* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.7: Get role detail flow.



*       Select **Get Role Detail** in the **Operation** configuration. This operation will return an object of the role especified by the role ID of the Redmine instance configured previously. Note that you must set a role ID to get the role detail and this must correspond to an existing role in the instance, else the request send and error message notifing that the source was not found.



![Get Role Detail](doc/images/Step4-7-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */role-detail* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.8: Get roles flow.



*       Select **Get Roles** in the **Operation** configuration. This operation will get a collection of all the roles of the Redmine instance configured previously.



![Get Roles](doc/images/Step4-8-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */roles* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.9: Get user detail flow.




*       Select **Get User Detail** in the **Operation** configuration. This operation will return an object of the user especified by the user ID of the Redmine instance configured previously. Note that you must set a user ID to get the user detail and this must correspond to an existing user in the instance, else the request send and error message notifing that the source was not found.



![Get User Detail](doc/images/Step4-9-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */user-detail* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.10: Get users flow.



*       Select **Get Users** in the **Operation** configuration. This operation will get a collection of all the users of the Redmine instance configured previously.



![Get Users](doc/images/Step4-10-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */users* as your path configuration.



*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 4.11: Create Issue flow.



*       Select **Create Issue** in the **Operation** configuration. This operation will create a new issue in a project especified by the project Key the Redmine instance configured previously. This method also will returns the new issue created. You need to set the following parameters:



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

![Create new Issue](doc/images/Step4-11-1.png)



*	Select the HTTP Endpoint in your canvas editor, then in **Basic Settings**, set */create-issue* as your path configuration.


*   Follow the [Step 5](#step-5-add-an-object-to-xml-transformer) and [Step 6](##step-6-run-demo-project) to show the data in XML format and run the project.



### Step 5: Add an Object to XML transformer



*       Add **Object to XML** transformer to the flow by dragging it from the palette. It will show the payload of the flow in XML format.

![Object to XML](doc/images/Step5-1.png)


### Step 6: Run Demo project



*     In **Package Explorer** window, right Click on your mule project **demo \> Run As/Mule Application**.

![Run Demo project](doc/images/Step6-1.png)



*     Check the console to see when the application starts. If the application starts succesfully, you will see that the application was deployed as you can see in this image, else check the flow configuration again following the previously steps:

![Console](doc/images/Step6-2.png)



*     Finally check the results in your favorite browser, opening an URL according to the path defined in the HTTP Endpoints of the operations defined previously: 
**http://localhost:8081/<path of the operation>**. The final flow XML should look like that:

![Get Available Projects on Browser](doc/images/Step6-3.png)



*    Stop mule server by clicking **Terminate** icon in console.



### Other Resources



For more information on:

- Mule AnyPoint™ connectors, please visit [http://www.mulesoft.org/connectors](http://www.mulesoft.org/connectors)

- Mule platform and how to build Mule apps, please visit [http://www.mulesoft.org/documentation/display/current/Home](http://www.mulesoft.org/documentation/display/current/Home)