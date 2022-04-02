package server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Orders
{


 @WebMethod public void createOrder(@WebParam(name = "create")Order order);
  @WebMethod public Order getOrder(@WebParam(name = "read")int id)
      throws Exception;
  @WebMethod  public Order updateOrder(@WebParam(name = "update")Order order);
  @WebMethod public void deleteOrder(@WebParam(name = "delete")int id);

}
