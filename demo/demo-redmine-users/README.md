= Redmine Connector Demo - Users Flows

== Introduction

This Redmine connector demo project consists of the five flows:

. userDetails - This flow example returns an user detail especified by a user ID for the configured Redmine instance.
. users - Provides an example on how to get the all the users of a Redmine instance. 
. roles - This flow return a collection of all the roles of the Redmine instance configured previously.
. roleDetail -  For a given role ID, this flow will return an object of the role in the configured Redmine instance.

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

userDetails : Select the Redmine connector in this flow, then set an user Id to obtain their details. Run the demo project and with in the browser hit - **http://localhost:8081/user-details**, The result would be an object of the especified user of the redmine instance following the specified object in XML format.


users : Run the demo project and with in the browser hit - **http://localhost:8081/users**, The result would be an object of the project especified by the project key of the configured Redmine instance following the specified object in XML format.

roles : Run the demo project and with in the browser hit - **http://localhost:8081/roles**, the result would be a collection of the roles of the Redmine instance configured previously following the specified list in XML format.

roleDetail - First, by clicking on the Redmine connector, set the role Id to obtain the role details, you can see a valid role Id by running the previous flow example. Then run the demo project and with in the browser hit - **http://localhost:8081/project-members**, the result would be an object of the role especified by the role Id of the configured Redmine instance following the specified role in XML format.

== Summary

Congratulations! You have imported the Redmine Demo project and used the Redmine Connector to obtain an user information, the list of all the users for your redmine instance, also the roles availables and the details of a especified role. 