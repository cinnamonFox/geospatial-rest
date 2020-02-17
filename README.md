This is a terrible intial writeup!

## Building/Deploying
mvn clean install

The resulting artifact file will be located at .m2/repository/farm/steele/geospatial_rest/001/geospatial-rest-001.war.  This should be deployed to a JBoss/Wildfly or weblogic server. 

## URL
Assuming that the you deployed the .war locally the resulting json should be accessible via http://localhost:8080/geospatial-rest-001/api/parks/.
