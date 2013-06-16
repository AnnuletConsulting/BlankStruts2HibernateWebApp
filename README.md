BlankStruts2HibernateWebApp
===========================

This is a Simple Login Web app that utilizes Struts 2, Spring, Hibernate, DWR Ajax, jQuery, 
and MySQL to allow creation of user accounts, logging in, logging out, and loading current 
users via Ajax.  It is meant to be opened in Eclipse to get you started developing your
site quickly, without dealing the library conflicts getting all the tools to work together.

== Instructions ==

First create a USER table in MySQL in the WEBAPP schema.
+----------+-------------+------+-----+---------+----------------+

| Field    | Type        | Null | Key | Default | Extra          |

+----------+-------------+------+-----+---------+----------------+

| ID       | int(11)     | NO   | PRI | NULL    | auto_increment |

| USERNAME | varchar(32) | NO   | UNI | NULL    |                |

| NAME     | varchar(64) | NO   |     | NULL    |                |

| PASSWORD | varchar(64) | NO   |     | NULL    |                |

+----------+-------------+------+-----+---------+----------------+



Then create a user and password and grant SELECT, INSERT, UPDATE, DELETE to the WEBAPP
schema for that user.

Edit the spring.xml file and change YOUR_SERVER, YOUR_USERNAME, YOUR_PASSWORD to the 
appropriate values.

Fix any path issues with the references and Export a WAR file.  Deploy that to Tomcat and
then open the main page. You should see a page with login and signup tabs. 