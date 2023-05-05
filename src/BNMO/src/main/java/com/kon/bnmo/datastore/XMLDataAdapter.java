package com.kon.bnmo.datastore;

import com.kon.bnmo.holder.holder;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.kon.bnmo.items.Item;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.List;

public class XMLDataAdapter implements  DataAdapter{
    @Override
    public void readData(holder dataHolder, String path) throws IOException {
        if(dataHolder.getType() == "Item") {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(path);
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("item");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                        System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Category : " + eElement.getElementsByTagName("category").item(0).getTextContent());
                        System.out.println("Image Name : " + eElement.getElementsByTagName("imgName").item(0).getTextContent());
                        System.out.println("Stock : " + eElement.getElementsByTagName("stock").item(0).getTextContent());
                        Item item = new Item(eElement.getElementsByTagName("name").item(0).getTextContent(),
                                Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
                                eElement.getElementsByTagName("category").item(0).getTextContent(),
                                eElement.getElementsByTagName("imgName").item(0).getTextContent(),
                                Integer.parseInt(eElement.getElementsByTagName("stock").item(0).getTextContent()));
                        dataHolder.add(item);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(dataHolder.getType() == "Customer") {

        }
    }

    @Override
    public void writeData(holder dataHolder, String path) throws IOException {
        if(dataHolder.getType() == "Item") {
            List<Item> itemList = dataHolder.getItemList(); // your list of Item objects
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("items");
                doc.appendChild(rootElement);

                for (Item item : itemList) {
                    Element itemElement = doc.createElement("item");
                    rootElement.appendChild(itemElement);

                    Element nameElement = doc.createElement("name");
                    nameElement.appendChild(doc.createTextNode(item.getName()));
                    itemElement.appendChild(nameElement);

                    Element priceElement = doc.createElement("price");
                    priceElement.appendChild(doc.createTextNode(String.valueOf(item.getPrice())));
                    itemElement.appendChild(priceElement);

                    Element categoryElement = doc.createElement("category");
                    categoryElement.appendChild(doc.createTextNode(item.getCategory()));
                    itemElement.appendChild(categoryElement);

                    Element imgNameElement = doc.createElement("imgName");
                    imgNameElement.appendChild(doc.createTextNode(item.getImgName()));
                    itemElement.appendChild(imgNameElement);

                    Element stockElement = doc.createElement("stock");
                    stockElement.appendChild(doc.createTextNode(String.valueOf(item.getStock())));
                    itemElement.appendChild(stockElement);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);
                System.out.println("XML file saved successfully!");
            } catch (ParserConfigurationException | TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        }else if(dataHolder.getType() == "Customer") {

        }
    }

    public static void main(String[] args) {

    }
}
