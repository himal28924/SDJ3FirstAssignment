package client;


import server.service.Order;
import server.service.Orders;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client
{
  public static void main(String[] args) throws Exception
  {
    URL url = new URL("http://localhost:9999/server.service.Orders?wsdl");

    QName qName = new QName("http://service.server/","OrderImplService");

    Service service = Service.create(url,qName);
    System.out.println("Soap service is created");

    Orders order = service.getPort(Orders.class);
   Order order1 =   new Order(1,"first order try",10,false);
    Order order2 =   new Order(2,"second order try",15,true);
    Order order3 =   new Order(3,"third order try",20,false);
    order.createOrder(order1);
    order.createOrder(order2);
    order.createOrder(order3);

    System.out.println(order.getOrder(1));

    System.out.println(order.getOrder(2));

    System.out.println(order.getOrder(3));
    Order order4 =   new Order(1,"first order try done",10,true);
    order.updateOrder(order4);

    System.out.println(order4);
    order.deleteOrder(2);

  }
}
