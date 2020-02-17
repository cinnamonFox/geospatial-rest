package com.example.geospatial_rest.ejb;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import farm.steele.geospatial_rest.jaxb.NationalPark;
import farm.steele.geospatial_rest.jaxb.ParkList;



@Startup
@Singleton
public class DataBean {

	private List<NationalPark> nationalParks;

	private static final String XML_DIR = "xml/";

	@PostConstruct
	protected void init() {
		nationalParks = parseXmlFile(ParkList.class, "national-park.xml").getNationalParks();

	}

	private <T> T parseXmlFile(Class<T> rootClass, String filename) {

		/* Find the xml file in the war */
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream in = classloader.getResourceAsStream(XML_DIR + filename);

		/* Unmarshal the xml file to the provided root class. */
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(rootClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			@SuppressWarnings("unchecked")
			T rootObject = (T) jaxbUnmarshaller.unmarshal(in);
			return rootObject;
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public List<NationalPark> getNationalParks() {
		return this.nationalParks;
	}
}
