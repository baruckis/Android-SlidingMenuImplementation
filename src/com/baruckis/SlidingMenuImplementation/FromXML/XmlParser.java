package com.baruckis.SlidingMenuImplementation.FromXML;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class XmlParser {
	DocumentBuilderFactory builderFactory = DocumentBuilderFactory
			.newInstance();
	Document document = null;

	public XmlParser(String xmlString) {
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			InputSource inputSource = new InputSource();
			inputSource.setEncoding("UTF-8");
			inputSource.setCharacterStream(new StringReader(xmlString));

			document = builder.parse(inputSource);

		} catch (ParserConfigurationException e) {
			System.out.println("XML parse error: " + e.getMessage());
		} catch (SAXException e) {
			System.out.println("Wrong XML file structure: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O exeption: " + e.getMessage());
		}
	}

	public XmlParser(InputStream inputStream) {
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			builder.isValidating();

			document = builder.parse(inputStream);

		} catch (ParserConfigurationException e) {
			System.out.println("XML parse error: " + e.getMessage());
		} catch (SAXException e) {
			System.out.println("Wrong XML file structure: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O exeption: " + e.getMessage());
		}
	}

	public NodeList getNodesByTagName(String tagName) {
		return document.getElementsByTagName(tagName);
	}

	public NodeList getNodesByTagName(Node node, String tagName) {
		return ((Element) node).getElementsByTagName(tagName);
	}

	public String getNodeValueByTagName(String tagName) {
		NodeList nodes = getNodesByTagName(tagName);
		for (int i = 0; i < nodes.getLength(); i++) {
			String value = getNodeValue(nodes.item(i));
			if (value != null)
				return value;
		}
		return null;
	}

	public String getNodeValueByTagName(Node node, String tagName) {
		if (node == null || tagName.length() == 0)
			return null;

		NodeList nodes = getNodesByTagName(node, tagName);
		return getNodeValue(nodes.item(0));
	}

	public String getNodeValue(Node node) {
		Node childNode;

		if (node == null || !node.hasChildNodes()) {
			return null;
		}

		for (childNode = node.getFirstChild(); childNode != null; childNode = childNode
				.getNextSibling()) {
			if (childNode.getNodeType() == Node.TEXT_NODE) {
				return childNode.getNodeValue();
			}
		}
		return null;
	}

	public String getNodeAttributeValue(Node node, String attributeName) {
		Element element = (Element) node;
		String value = null;

		if (element.hasAttribute(attributeName)) {
			value = element.getAttribute(attributeName);
		}
		return value;
	}

	public String transformToXml(Node node) {
		StringWriter buffer = new StringWriter();

		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			try {
				transformer.transform(new DOMSource(node), new StreamResult(
						buffer));
			} catch (TransformerException e) {
				return "";
			}
		} catch (TransformerConfigurationException e1) {
			return "";
		}

		return buffer.toString();
	}
}
