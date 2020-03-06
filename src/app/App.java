package app;

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

        System.out.println(stockList);
        
        for (String s: stockList.Items().keySet()) {
            System.out.println(s);
        }
        Basket tundunsBasket = new Basket("Tundun");
        sellItem(tundunsBasket, "car", 1);
        System.out.println(tundunsBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
           System.out.println("We don't sell " + item);
           return 0;
        }  
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
      }
}