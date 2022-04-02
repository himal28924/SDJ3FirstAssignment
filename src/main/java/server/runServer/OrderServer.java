package server.runServer;

import server.service.OrderImpl;

import javax.xml.ws.Endpoint;

public class OrderServer

{
  public static void main(String[] args)
  {
try
{
  Endpoint.publish("http://localhost:9999/server.service.Orders", new OrderImpl());
  System.out.println("server started");
}catch (Exception e){
  System.out.println(e.getMessage());
}
  }
}
