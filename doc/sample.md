[Purpose](#purpose)  

[Prerequisites](#prerequisites)  

[Step 1: Create Box.com Developer account ](#step-1-create-boxcom-developer-account)    

[Step 2: Install Mule Box Connector from Update Site](#step-2-install-mule-box-***REMOVED***-from-update-site)   

[Step 3: Create Demo Project](#step3)  

[Step 4: Create a new flow](#step4)   

[Step 4.1. Get available properties flow.](#step4.1)   

[Step 5: Add an Object to XML transformer](#step5)    

[Step 6: Run Demo project](#step6)      

[Other Resources](#other)    





### Purpose



This document provides detailed instructions on how to install Redmine ***REMOVED*** and demonstrates how to build and run simple demo application that uses this ***REMOVED***.



### Prerequisites



In order to build and run this project you'll need:



* [Anypoint Studio](https://www.mulesoft.com/platform/mule-studio).

*  Java 7: Redmine ***REMOVED*** does not work unless you are using Java 1.7.0_x as your JRE. 

* Web browser.

*  A project configuration in Redmine: Configuring the Redmine ***REMOVED*** requires configuring a Project configured in Redmine, and provide the valid credentials to set the connection strategy of this ***REMOVED***: an URI and API access key. As optional parameters, you can set the username and the password to access the Redmine instance.


### Step 1: Install Redmine Connector


Because this is a ***REMOVED*** in the beta version, you can download the source code cloning the source code from:  [GitHub Repository](https://github.com/EpidataSA/redmine-***REMOVED***.git) and build it with Anypoint Connector DevKit to find it available on your local repository. Then you can add it to Anypoint Studio following the next steps:

* In **Anypoint Studio**, to import an existing ***REMOVED*** project, click **File \> Import \> Anypoint Studio \> Anypoint Connector Project from External Location**, browse the path location where you have the root directory for the Redmine Connector and complete the wizard to locate and import the project.

* Click to accept terms and conditions of the product, then click **Finish**.

* Click **Restart Now** to complete the installation. After you install the ***REMOVED*** and restart Studio, the PeopleSoft ***REMOVED*** is available in the palette in the Connectors category.


### Step 2: Create Demo project



*    Run Mule Studio and select **File \> New \> Mule Project** menu item.  

*    Type **Demo** as a project name, accept default values on this screen of project creation wizard and click **Finish**.


![Create Demo project](images/Step3-1.png)


### Step 3: Add Global Elements   



*    Double click on **src/main/app/Demo.xml** to open it, select **Global Elements** tab in view.

 

Add two Global Elements.  



*    Click on **Create** button and add **HTTP Listener Configuration** to the configuration.   



![Add HTTP Listener](images/Step3-2.png)



*    In HTTP Listener Configuration set a name for this HTTP Listener Configurator, set **localhost** on the **Host** field, and set in your **port** field the value **8081**. Finally accept the default values as you can see in the following image:



![Configure HTTP Listener](images/Step3-3.png)



*       Similarly, add **Redmine: Configuration type strategy**.



![Add Redmine: Configuration type strategy](images/Step3-4.png)



*     In the **general** tab, set the Redmine Configuration type strategy parameters according to your Redmine account configuration:

*           **Name:** Enter a name you prefer.
*           **Username (Optional):** Enter your Redmine username.
*           **Password (Optional):** Enter your Redmine password.
*           **Uri:** Enter the URL of your Redmine instance.
*           **Api Access Key:** Enter the access key of your Redmine.instance.



*       Click on the **Test Connection** button to confirm that Mule can connect with the Redmine instance. If the connection is successful, click OK to save the configurations. If unsuccessful, revise or correct any incorrect parameters, then test again.



### Step 4. Create a new flow.



*       Add **HTTP Endpoint** to your flow by dragging it from the palette. 
This action drops an HTTP Listener in a new flow. You can change the name of this flow by right-clicking on flow's header and selecting **Rename** from context menu.  



![New Flow](images/Step4-1.png)



*       Set the **HTTP Endpoint** ***REMOVED*** configuration with the global property previously configured and write a path for the URL of this endpoint and accept the default values of the other settings: 

![HTTP Endpoint](images/Step4-2.png)



*       Add **Redmine Connector** to the flow by dragging it from the palette. 

![Redmine Connector](images/Step4-3.png)



*       Click it to show ***REMOVED*** properties and select **Redmine_Configuration_type_strategy** in **Connector Configuration** drop-down.

![Redmine Connector Configuration](images/Step4-4.png)



*       We need to select an operation for this ***REMOVED***, we start showing you an example of each operation of this ***REMOVED*** using the configuration defined before.

### Step 4.1. Get available properties flow.



*       Select **Get Available Projects** in the **Operation** configuration. This operation will get a collection of all the project of the Redmine instance configured previously.

![Get Available Projects](images/Step4-1-1.png)

The Follow the [Step 5](#step5) and [Step 6](#step6) to show the data in XML format and run the project.



### Step 5: Add an Object to XML transformer



*       Add **Object to XML** transformer to the flow by dragging it from the palette. It will show the payload of the flow in XML format.

![Object to XML](images/Step5-1.png)

### Step 6: Run Demo project



*     In **Package Explorer** window, right Click on your mule project **demo \> Run As/Mule Application**.

![Run Demo project](images/Step6-1.png)



*     Check the console to see when the application starts. If the application starts succesfully, you will see that the application was deployed as you can see in this image, else check the flow configuration again following the previously steps:

![Console](images/Step6-2.png)



*     Finally check the results in your favorite browser, opening an URL according to the path defined in the HTTP Endpoints of the operations defined previously: 
**http://localhost:8081/<path of the operation>**. The final flow XML should look like that:

![Get Available Projects on Browser](images/Step6-3.png)



*    Stop mule server by clicking **Terminate** icon in console.



### Other Resources



For more information on:

- Mule AnyPoint™ ***REMOVED***s, please visit [http://www.mulesoft.org/***REMOVED***s](http://www.mulesoft.org/***REMOVED***s)

- Mule platform and how to build Mule apps, please visit [http://www.mulesoft.org/documentation/display/current/Home](http://www.mulesoft.org/documentation/display/current/Home)