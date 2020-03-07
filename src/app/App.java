package app;

import java.util.Map;

public class App {
    private static StockList stockList = new StockList();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 208);
        stockList.addStock(temp);

        temp = new StockItem("door", 1.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        //System.out.println(stockList);
        
        for (String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket tundunsBasket = new Basket("Tundun");
        sellItem(tundunsBasket, "vase", 2);
        System.out.println(tundunsBasket);

        removeItem(tundunsBasket, "vase", 1);

        Basket prospersBasket = new Basket("Prosper");
        sellItem(prospersBasket, "phone", 2);
        System.out.println(prospersBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
           System.out.println("We don't sell " + item);
           return 0;
        }  
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
      }
      
    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
           System.out.println("We don't sell " + item);
           return 0;
        }  
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
      }

      public static void checkout(Basket basket) {
          for(Map.Entry<StockItem, Integer> item: basket.Items().entrySet()) {
              stockList.sellStock(item.getKey().getName(), item.getValue());
          }
          basket.clearBasket();
      }
}