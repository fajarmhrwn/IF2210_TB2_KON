package com.kon.bnmo.datastore;

import com.kon.bnmo.customers.*;
import com.kon.bnmo.holder.holder;

import java.io.Console;
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

import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.items.FixedBill;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.kon.bnmo.transaction.Transaction;
import com.kon.bnmo.transaction.TransactionHolder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import  javax.xml.*;

public class XMLDataAdapter implements  DataAdapter{
    @Override
    public void readData(holder dataHolder, String path) throws IOException {
        if(dataHolder.getType() == "Item") {
            dataHolder.setList(new ArrayList<Item>());
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(path+"/item.xml");
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
                throw new IOException(e);
            }

        }else if(dataHolder.getType() == "Customer") {
            dataHolder.setList(new ArrayList<Person>());
            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(path+"/customer.xml");
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("customer");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        CustomerModel customerModel = new CustomerModel(eElement.getElementsByTagName("id").item(0).getTextContent());
                        dataHolder.add(customerModel);
                    }

                }

            }catch (Exception e) {
                e.printStackTrace();
                throw new IOException(e);
            }

            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(path+"/member.xml");
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("member");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        MemberModel memberModel = new MemberModel(eElement.getElementsByTagName("id").item(0).getTextContent(),
                                eElement.getElementsByTagName("name").item(0).getTextContent(),
                                eElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
                        dataHolder.add(memberModel);
                    }

                }
            }catch (Exception e) {
                e.printStackTrace();
                throw new IOException(e);
            }

            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(path+"/VIP.xml");
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("vips");
                System.out.println("banyak vip : "+nList.getLength());
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        VIPModel vipModel = new VIPModel(eElement.getElementsByTagName("id").item(0).getTextContent(),
                                eElement.getElementsByTagName("name").item(0).getTextContent(),
                                eElement.getElementsByTagName("phoneNumber").item(0).getTextContent(),
                                Integer.parseInt(eElement.getElementsByTagName("point").item(0).getTextContent())
                               );
                        dataHolder.add(vipModel);
                    }

                }
            }catch (Exception e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        } else if (dataHolder.getType()=="Transaction") {
            dataHolder.setList(new ArrayList<Transaction>());
            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(new File(path+"/transaction.xml"));
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("transaction");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        List<Billitem> billitemList = new ArrayList<>();
                        NodeList listBillItem = eElement.getElementsByTagName("billItem");
                        for (int i = 0; i < listBillItem.getLength(); i++) {
                            Node node = listBillItem.item(i);
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) node;
                                Billitem billitem = new Billitem(element.getElementsByTagName("name").item(0).getTextContent(),
                                        Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent()),
                                        element.getElementsByTagName("category").item(0).getTextContent(),
                                        element.getElementsByTagName("imgName").item(0).getTextContent(),
                                        Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent()),
                                        Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent()));
                                billitemList.add(billitem);
                            }
                        }

                        dataHolder.add(new Transaction(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()),
                                billitemList));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
    }

    @Override
    public void writeData(holder dataHolder, String path) throws IOException {
        if(dataHolder.getType() == "Item") {
            List<Item> itemList = dataHolder.getList(); // your list of Item objects
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
                StreamResult result = new StreamResult(new File(path+"/item.xml"));
                transformer.transform(source, result);
                System.out.println("itemholder XML file saved successfully!");
            } catch (ParserConfigurationException | TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (Exception e){
                throw new IOException(e);
            }

        }else if(dataHolder.getType() == "Customer"){
            List<Person> listPerson = dataHolder.getList();
            System.out.println("List Person: "+listPerson.size());
            List<CustomerModel> customerList = new ArrayList<>();
            List<MemberModel> memberList = new ArrayList<>();
            List<VIPModel> vipList = new ArrayList<>();
            for(Person person : listPerson){
                if(person instanceof CustomerModel){
                    customerList.add((CustomerModel) person);
                }else if(person instanceof MemberModel){
                    memberList.add((MemberModel) person);
                }else if(person instanceof VIPModel){
                    vipList.add((VIPModel) person);
                }
            }
            System.out.println("Customer List: "+customerList.size());
            System.out.println("Member List: "+memberList.size());
            System.out.println("VIP List: "+vipList.size());
            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("customers");
                doc.appendChild(rootElement);
                for(CustomerModel customer : customerList){
                    Element customerElement = doc.createElement("customer");
                    rootElement.appendChild(customerElement);

                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(customer.getId()));
                    customerElement.appendChild(idElement);
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path+"/customer.xml"));
                transformer.transform(source, result);
                System.out.println("customer XML file saved successfully!");

            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }catch (Exception e){
                throw new IOException(e);
            }

            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("members");
                doc.appendChild(rootElement);
                for(MemberModel member : memberList){
                    Element memberElement = doc.createElement("member");
                    rootElement.appendChild(memberElement);

                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(member.getId()));
                    memberElement.appendChild(idElement);

                    Element nameElement = doc.createElement("name");
                    nameElement.appendChild(doc.createTextNode(member.getName()));
                    memberElement.appendChild(nameElement);

                    Element phoneElement = doc.createElement("phoneNumber");
                    phoneElement.appendChild(doc.createTextNode(member.getPhoneNumber()));
                    memberElement.appendChild(phoneElement);

                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path+"/member.xml"));
                transformer.transform(source, result);
                System.out.println("member XML file saved successfully!");
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }catch (Exception e){
                throw new IOException(e);
            }

            try{
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("vips");
                doc.appendChild(rootElement);
                for(VIPModel vip : vipList){
                    Element vipElement = doc.createElement("vip");
                    rootElement.appendChild(vipElement);

                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(vip.getId()));
                    vipElement.appendChild(idElement);

                    Element nameElement = doc.createElement("name");
                    nameElement.appendChild(doc.createTextNode(vip.getName()));
                    vipElement.appendChild(nameElement);

                    Element phoneElement = doc.createElement("phoneNumber");
                    phoneElement.appendChild(doc.createTextNode(vip.getPhoneNumber()));
                    vipElement.appendChild(phoneElement);

                    Element pointElement = doc.createElement("point");
                    pointElement.appendChild(doc.createTextNode(String.valueOf(vip.getPoint())));
                    vipElement.appendChild(pointElement);
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(path+"/VIP.xml"));
                    transformer.transform(source, result);
                    System.out.println("vip XML file saved successfully!");
                }
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            } catch (Exception e){
                throw new IOException(e);
            }
        } else if (dataHolder.getType() == "Transaction") {
            List<Transaction> transactionList = dataHolder.getList();
            System.out.println("List Transaction: " + transactionList.size());
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("transactions");
                doc.appendChild(rootElement);
                for (Transaction transaction : transactionList) {
                    Element transactionElement = doc.createElement("transaction");
                    rootElement.appendChild(transactionElement);

                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(String.valueOf(transaction.getIdCustomer())));
                    transactionElement.appendChild(idElement);

                    Element billElement = doc.createElement("bill");
                    transactionElement.appendChild(billElement);

                    for (Billitem billItem : transaction.getListBillItem()) {
                        Element billItemElement = doc.createElement("billItem");
                        billElement.appendChild(billItemElement);

                        Element nameElement = doc.createElement("name");
                        nameElement.appendChild(doc.createTextNode(billItem.getName()));
                        billItemElement.appendChild(nameElement);

                        Element priceElement = doc.createElement("price");
                        priceElement.appendChild(doc.createTextNode(String.valueOf(billItem.getPrice())));
                        billItemElement.appendChild(priceElement);

                        Element categoryElement = doc.createElement("category");
                        categoryElement.appendChild(doc.createTextNode(billItem.getCategory()));
                        billItemElement.appendChild(categoryElement);

                        Element imgNameElement = doc.createElement("imgName");
                        imgNameElement.appendChild(doc.createTextNode(billItem.getImgName()));
                        billItemElement.appendChild(imgNameElement);

                        Element stockElement = doc.createElement("stock");
                        stockElement.appendChild(doc.createTextNode(String.valueOf(billItem.getStock())));
                        billItemElement.appendChild(stockElement);

                        Element quantityElement = doc.createElement("amount");
                        quantityElement.appendChild(doc.createTextNode(String.valueOf(billItem.getAmount())));
                        billItemElement.appendChild(quantityElement);
                    }
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path+"/transaction.xml"));
                transformer.transform(source, result);
                System.out.println(" transaction XML file saved successfully!");
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }catch (Exception e){
                throw new IOException(e);
            }
        }
    }

}
