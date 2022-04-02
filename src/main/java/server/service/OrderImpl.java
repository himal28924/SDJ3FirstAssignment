package server.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface ="server.service.Orders")
public class OrderImpl implements Orders
{


List<Order> orderList = new ArrayList<>();

  @Override public void createOrder(@WebParam(name = "create")Order order)
  {
    orderList.add(order);
  }

  @Override public Order getOrder(int id)
  {
    Order temp =null;

    for (Order order : orderList)
    {
      if (order.getId() == id)
      {

        temp = order;

      }

    }
    return temp;

  }


  @Override public Order updateOrder(Order order)
  {

    for (Order o : orderList)
    {
      if (order.getId() == o.getId())
      {
        o.setAmount(order.getAmount());
        o.setDescription(order.getDescription());
        o.setDelivered(order.isDelivered());

      }

    }
    return order;
  }

  @Override public void deleteOrder(int id)
  {
    orderList.removeIf(order -> order.getId() == id);

  }
}
